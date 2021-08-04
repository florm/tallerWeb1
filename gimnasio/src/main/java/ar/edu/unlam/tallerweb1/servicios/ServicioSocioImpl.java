package ar.edu.unlam.tallerweb1.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.*;
import helpers.Paginado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ActividadDao;
import ar.edu.unlam.tallerweb1.dao.LocalizacionDao;
import ar.edu.unlam.tallerweb1.dao.PagoDao;
import ar.edu.unlam.tallerweb1.dao.SocioDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;

@Service("servicioSocio")
@Transactional
public class ServicioSocioImpl implements ServicioSocio {

	@Inject
	private SocioDao socioDao;
	@Inject
	private UsuarioDao usuarioDao;
	@Inject
	private LocalizacionDao localizacionDao;
	@Inject
	private SucursalDao sucursalDao;
	@Inject
	private PagoDao pagoDao;
	@Inject 
	private ActividadDao actividadDao;
	
	public void setUsuarioDao(UsuarioDao dao){
		this.usuarioDao = dao;
	}
	
	@Override
	public List<Socio> buscarSocios(Long idSucursal, Paginado paginado) {
		List<Socio> todosLosSociosDeSucursal = socioDao.buscarSocios(idSucursal);
		if(paginado == null) return todosLosSociosDeSucursal;
		return  todosLosSociosDeSucursal.stream().skip(paginado.getRegistrosPorPagina() * (paginado.getNumeroPagina() - 1))
				.limit(paginado.getRegistrosPorPagina())
				.collect(Collectors.toList());
	}
	
	@Override
	public void agregarPaseASocio(Long idSocio, Long idPase) {
		socioDao.agregarPaseASocio(idSocio, idPase);
	}

	@Override
	public Socio buscarSocio(Usuario usuario) {
		return socioDao.buscarSocio(usuario);
	}

	@Override
	public Socio buscarSocio(Long idSocio) {
		return socioDao.buscarSocio(idSocio);
	}

	@Override
	public List<Socio> buscarSocios() {
		return socioDao.buscarSocios();
	}

	@Override
	public void modificarSocio(Long idSocio, Socio socio) {
		Socio socioB = socioDao.buscarSocio(idSocio);
		socioB.setTelefono(socio.getTelefono());
		socioB.setMail(socio.getMail());
		socioB.setCiudad(localizacionDao.traerCiudad(socio.getCiudad().getId()));
		socioB.setDomicilioCalle(socio.getDomicilioCalle());
		socioB.setDomicilioNumero(socio.getDomicilioNumero());
		socioB.setDomicilioDepto(socio.getDomicilioDepto());
		socioDao.actualizarSocio(socioB);
	}

	
	//borrar despues
	@Override
	public Boolean validarActividadSocio(Long idSocio) {
		Socio socio = socioDao.buscarSocio(idSocio);
		if(socio.getPase().getCantidadActividades()==null) {
			return true;
		}
		if (socio.getActividadesEnSucursal().size() < socio.getPase().getCantidadActividades()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean registrarSocio(Socio socio) {
		List<Usuario> lista = usuarioDao.verSiExisteUsuario(socio.getUsuario().getNick());
		if (lista.size() == 0) {
			
			Socio socioReferente;
			if(socio.getRecomendadoPor().getDni() != "") { //Es necesario hacerlo asi ya que pincha si se envia un referente vacio
			socioReferente = socioDao.buscarSocioPorDni(socio.getRecomendadoPor().getDni());
			}else {
			socioReferente = null;
			}
			Ciudad ciudad = localizacionDao.traerCiudad(socio.getCiudad().getId());
			Usuario usuario = new Usuario();
			usuario.setNick(socio.getUsuario().getNick());
			usuario.setPassword(socio.getUsuario().getPassword());
			usuario.setRol("socio");
			
			Usuario usuarioGuardado = usuarioDao.guardarUsuario(usuario);
			
			Sucursal sucursal = sucursalDao.getSucursal(socio.getSucursal().getId());
			socio.setUsuario(usuarioGuardado);
			socio.setCiudad(ciudad);
			socio.setSucursal(sucursal);
			
			sucursal.getListaSocios().add(socio); //les mando la sucursal y cuando guardo socio hago update a la lista de socios de sucursal
				if (socioReferente == null) {
					socio.setRecomendadoPor(null); // Si no coloco este campo como null, tira error
					socioDao.registrarSocioSinReferente(socio, sucursal);
				} else {
					socio.setRecomendadoPor(socioReferente);
					socioReferente.setDescuento(1); //En el futuro si el campo descuento es 1, la proxima cuota 
					socioDao.registrarSocio(socio, socioReferente, sucursal);
				}
			return true;
		} else {
			
			return false;
		}
	}

	@Override
	public Integer getEstadoDeSocioPorCuota(Long idSocio) {
		Socio socio = socioDao.buscarSocio(idSocio);
//		Date fecha = java.util.Calendar.getInstance().getTime();
		
		if (socio.getPase().getId() != 5) { //Pase por default del socio apenas se registra
			List<Pago> listaPagos = pagoDao.traerPagosSocio(socio);
			Pago pago = pagoDao.getUltimoPago(socio);
			if(pago.getFechaVencimiento().before(Calendar.getInstance().getTime())) {
				//fecha de vencimento es menor a la fecha actual esta vencido el pase
				List<SucursalActividad> lista = actividadDao.listaActividadesDeSocio(idSocio);
				for (SucursalActividad sucursalActividad : lista) {
					sucursalActividad.getSocios().remove(socio);
					if(sucursalActividad.getCupoActual()>0) {
						sucursalActividad.setCupoActual(sucursalActividad.getCupoActual()-1);
					}
				
					actividadDao.actualizarSucursalActividad(sucursalActividad);
				}
				socio.getActividadesEnSucursal().clear();
				socioDao.actualizarSocio(socio);
				return 0;
			} else {
				//fecha de vencimiento es mayor a la fecha actual, todavia no esta vencido el pase
				return 1;
			}
		}else {
			return 0;
		}
	}

	@Override
	public Integer buscarSociosCount(Long idSucursal) {
		return socioDao.buscarSocios(idSucursal).size();
	}

}
