package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pase;

@Repository("PaseDao")
public class PaseDaoImpl implements PaseDao {

	@Inject
	SessionFactory sessionFactory;
	
	@Override
	public List<Pase> listarPases() {
		Session sesion = sessionFactory.getCurrentSession();
		List<Pase> listaPases = sesion.createCriteria(Pase.class).list();
		return listaPases;
		
	}

}
