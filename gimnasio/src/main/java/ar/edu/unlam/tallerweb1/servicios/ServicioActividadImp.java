package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ActividadDao;
import ar.edu.unlam.tallerweb1.dao.SocioDao;
import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Service ("ServicioActividad")
@Transactional
public class ServicioActividadImp implements ServicioActividad {
	
	@Inject
	private ActividadDao servicioActividadDao;
	@Inject
	private SocioDao servicioSocioDao;
	@Override
	public List<SucursalActividad> listarActividadesEnSucursal(Long id) {
		return servicioActividadDao.listarActividadesEnSucursal(id);
	}
	@Override
	public boolean guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad) {
		Socio socio = servicioSocioDao.buscarSocio(idSocio);
		if (socio.getActividadesEnSucursal().size() < socio.getPase().getCantidadActividades()) {
			//agregar dao para actualizar actividades actuales de socio
			// ver como validar ya que una cosa es para inscribir socio en actividad llena
			// y otra es que el socio no se pueda inscribir ya que tiene limite de actividades
		}
		SucursalActividad sucursalActividad = servicioActividadDao.traerActividadDeSucursal(idSucursalActividad);
		if (sucursalActividad.getCupoActual()<sucursalActividad.getCupo()) {
			Integer cupoActual = sucursalActividad.getCupoActual()+1;
			sucursalActividad.setCupoActual(cupoActual);
			servicioActividadDao.modificarCupoDeActividadEnSucursal(sucursalActividad);
			servicioActividadDao.guardarSocioActividadSucursal(idSocio, idSucursalActividad);
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public List<Actividad> listaActividades() {
		return servicioActividadDao.listaActividades();
	}

}
