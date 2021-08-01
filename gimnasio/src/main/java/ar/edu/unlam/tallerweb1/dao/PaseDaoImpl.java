package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;

@Repository
public class PaseDaoImpl implements PaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Pase> listarPases() {
		Session sesion = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Pase> listaPases = sesion.createCriteria(Pase.class).list();
		for (Pase pase : listaPases) {
			Hibernate.initialize(pase.getListaBeneficios());
		}
		
		return listaPases;
		
	}
	
	@Override
	public Pase buscarPase(Long idPase) {
		Session sesion = sessionFactory.getCurrentSession();
		Pase pase = (Pase) sesion.createCriteria(Pase.class)
				.add(Restrictions.eq("id", idPase))
				.uniqueResult();
		return pase;
	}

}
