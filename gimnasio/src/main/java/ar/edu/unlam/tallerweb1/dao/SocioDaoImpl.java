package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;

@Repository("socioDao")
public class SocioDaoImpl implements SocioDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Socio> buscarSocios(Long idSucursal) {
		final Session sesion = sessionFactory.getCurrentSession();
		List<Socio> listaDeSocios = sesion.createCriteria(Socio.class)
				.createAlias("sucursal", "buscaSucursal")
				.add(Restrictions.eq("buscaSucursal.id", idSucursal))
				.list();
		return listaDeSocios;
	}

	
}
