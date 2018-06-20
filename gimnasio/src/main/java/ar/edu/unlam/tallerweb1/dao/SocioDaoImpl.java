package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

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

	@Override
	public void agregarPaseASocio(Long idSocio, Long idPase) {
		final Session sesion = sessionFactory.getCurrentSession();
		Socio socio = sesion.get(Socio.class, idSocio);
		Pase pase = sesion.get(Pase.class, idPase);
		socio.setPase(pase);
		sesion.save(socio);
	}

	@Override
	public Socio buscarSocio(Usuario usuario) {
		Session sesion = sessionFactory.getCurrentSession();
		Socio socio = (Socio) sesion.createCriteria(Socio.class)
				.createAlias("usuario", "buscarPorUsuario")
				.add(Restrictions.eq("buscarPorUsuario.id", usuario.getId())).uniqueResult();
		
		Hibernate.initialize(socio.getSucursal());
		Hibernate.initialize(socio.getSucursal().getListaActividades());
		Hibernate.initialize(socio.getSucursal().getListaSocios());
		return socio;
	}
	
	
}
