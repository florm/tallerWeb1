package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;
import ar.edu.unlam.tallerweb1.modelo.Socio;

@Repository("LocalizacionDao")
public class LocalizacionDaoImpl implements LocalizacionDao {
	
	@Inject
	SessionFactory sessionFactory;
	
	@Override
	public List<Provincia> listarProvincias() {
		Session sesion = sessionFactory.getCurrentSession();
		List<Provincia> listaProvincias = sesion.createCriteria(Provincia.class).list();
		return listaProvincias;
	}

	@Override
	public List<Ciudad> listarCiudades() {
		Session sesion = sessionFactory.getCurrentSession();
		List<Ciudad> listaCiudades = sesion.createCriteria(Ciudad.class).list();
		return listaCiudades;
	}

	@Override
	public Ciudad traerCiudad(Long idCiudad) {
		Session sesion = sessionFactory.getCurrentSession();
		Ciudad ciudad = (Ciudad) sesion.createCriteria(Ciudad.class)
				.add(Restrictions.eq("id", idCiudad))
				.uniqueResult();
		return ciudad;
	}
	

}
