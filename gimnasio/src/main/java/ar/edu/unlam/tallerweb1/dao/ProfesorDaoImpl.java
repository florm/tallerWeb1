package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Profesor;
import ar.edu.unlam.tallerweb1.modelo.Socio;

@Repository("ProfesorDao")
public class ProfesorDaoImpl implements ProfesorDao {

	@Inject
	SessionFactory sessionFactory;
	
	
	
	@Override
	public Profesor buscarProfesor(Long idProfesor) {
		Session sesion = sessionFactory.getCurrentSession();
		Profesor profesor= sesion.get(Profesor.class, idProfesor);
				
		return profesor;
	}

}
