package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;

@Repository("operadorDao")
public class OperadorDaoImpl implements OperadorDao {

	@Inject
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Operador> listarOperadores() {
		Session sesion = sessionFactory.getCurrentSession();
		return sesion.createCriteria(Operador.class).list();
	}
	@Override
	public void modificarOperador(Operador operador) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.update(operador);
		
	}
	@Override
	public void eliminar(Long idOperador) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Operador getById(Long idOperador) {
		Session sesion = sessionFactory.getCurrentSession();
		return sesion.get(Operador.class, idOperador);
	}

	
}
