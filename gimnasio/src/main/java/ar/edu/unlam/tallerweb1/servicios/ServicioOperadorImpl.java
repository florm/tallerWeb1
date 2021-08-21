package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unlam.tallerweb1.dao.PagoDao;
import ar.edu.unlam.tallerweb1.modelo.*;
import helpers.Paginado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.OperadorDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;

@Service("servicioOperador")
@Transactional
public class ServicioOperadorImpl implements ServicioOperador {

	private OperadorDao operadorDao;
	
	private UsuarioDao usuarioDao;
	
	private SucursalDao sucursalDao;
	private PagoDao pagoDao;

	@Autowired
	public ServicioOperadorImpl(OperadorDao operadorDao, UsuarioDao usuarioDao,SucursalDao sucursalDao, PagoDao pagoDao){
		this.operadorDao = operadorDao;
		this.usuarioDao = usuarioDao;
		this.sucursalDao = sucursalDao;
		this.pagoDao = pagoDao;
	}

	@Override
	public List<Operador> listarOperadores(Paginado paginado) {
		List<Operador> todosOperadores = operadorDao.listarOperadores();
		if(paginado == null) return todosOperadores;
		return  todosOperadores.stream().skip(paginado.getRegistrosPorPagina() * (paginado.getNumeroPagina() - 1))
				.limit(paginado.getRegistrosPorPagina())
				.collect(Collectors.toList());
	}

	@Override
	public void eliminar(Long idOperador) {
		operadorDao.eliminar(idOperador);
		
	}

	@Override
	public Operador getById(Long idOperador) {
		return operadorDao.getById(idOperador);
		
	}

	@Override
	public void modificar(Operador operador) {
		operadorDao.modificarOperador(operador);
		sucursalDao.modificarSucursal(operador);
		
	}

	@Override
	public void registrar(Operador operador) {
		Usuario usuario = new Usuario();
		usuario.setNick(operador.getUsuario().getNick());
		usuario.setPassword(operador.getUsuario().getPassword());
		usuario.setRol("operador");
		Usuario usuarioGuardado = usuarioDao.guardarUsuario(usuario);
		operadorDao.registrar(operador, usuarioGuardado);
		
	}

	@Override
	public Operador buscarOperador(Usuario usuario) {
		return operadorDao.buscarOperador(usuario);
	}

	@Override
	public void notificarPago() {

	}

	@Override
	public void aprobarPago(Pago pago) {
		if(pago == null) throw new NoExistePagoException();
		if(pagoEstaAprobado(pago)) throw new PagoYaAprobadoException();
		if(pagoEstaRechazado(pago)) throw new PagoYaRechazadoException();
		operadorDao.aprobarPago(pago);
	}

	@Override
	public List<Pago> buscarPagos(Paginado paginado) {
		List<Pago> todosLosPagos = operadorDao.buscarPagos();
		if(paginado == null) return todosLosPagos;
		return  todosLosPagos.stream().skip(paginado.getRegistrosPorPagina() * (paginado.getNumeroPagina() - 1))
				.limit(paginado.getRegistrosPorPagina())
				.collect(Collectors.toList());
	}

	@Override
	public List<Pago> getNovedades() {
		return operadorDao.getNovedades();
	}

	@Override
	public void marcarVisto() {
		List<Pago> nuevosPagos = pagoDao.buscarPagosNuevos();
		nuevosPagos.forEach(p->{
			p.setNuevo(false);
			pagoDao.actualizarPago(p);
		});
	}

	@Override
	public Integer buscarPagosCount() {
		return operadorDao.buscarPagosCount();
	}

	@Override
	public Integer listarOperadoresCount() {
		return operadorDao.listarOperadores().size();
	}

	private boolean pagoEstaRechazado(Pago pago) {
		if(pago.getEstado().getId() == Estado.RECHAZADO.getVal())
			return true;
		return false;
	}
	private boolean pagoEstaAprobado(Pago pago) {
		if(pago.getEstado().getId() == Estado.APROBADO.getVal()){
			return true;
		}
		return false;
	}

}
