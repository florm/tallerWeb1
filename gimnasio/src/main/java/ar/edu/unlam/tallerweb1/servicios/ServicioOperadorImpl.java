package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.OperadorDao;
import ar.edu.unlam.tallerweb1.modelo.Operador;

@Service("servicioOperador")
@Transactional
public class ServicioOperadorImpl implements ServicioOperador {

	@Inject
	private OperadorDao operadorDao;
	
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

}
