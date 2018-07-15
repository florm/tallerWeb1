package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.OperadorDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioOperador")
@Transactional
public class ServicioOperadorImpl implements ServicioOperador {

	@Inject
	private OperadorDao operadorDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
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

}
