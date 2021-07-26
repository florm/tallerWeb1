package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.OperadorDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioOperador")
@Transactional
public class ServicioOperadorImpl implements ServicioOperador {

	private OperadorDao operadorDao;
	
	private UsuarioDao usuarioDao;
	
	private SucursalDao sucursalDao;

	@Autowired
	public ServicioOperadorImpl(OperadorDao operadorDao, UsuarioDao usuarioDao,SucursalDao sucursalDao){
		this.operadorDao = operadorDao;
		this.usuarioDao = usuarioDao;
		this.sucursalDao = sucursalDao;
	}

	@Override
	public List<Operador> listarOperadores() {
		return operadorDao.listarOperadores();
		
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
	public List<Pago> buscarPagos() {
		return operadorDao.buscarPagos();
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
