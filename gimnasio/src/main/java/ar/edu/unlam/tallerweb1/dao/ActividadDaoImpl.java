package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Repository ("ActividadDao")
public class ActividadDaoImpl implements ActividadDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SucursalActividad> listarActividadesEnSucursal(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		List <SucursalActividad> lista = 
				session.createCriteria(SucursalActividad.class)
				.createAlias("sucursal", "buscaSucursal")
				.add(Restrictions.eq("buscaSucursal.id", id))
				.setFetchMode("socios", FetchMode.EAGER)
				.list();
		return lista;
	}
	
	@Override
	public void guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad) {
		final Session session = sessionFactory.getCurrentSession();
		
		Socio socio = session.get(Socio.class, idSocio);
		SucursalActividad sucursalActividad = session.get(SucursalActividad.class, idSucursalActividad);
		
		socio.getActividadesEnSucursal().add(sucursalActividad);
		sucursalActividad.getSocios().add(socio);
		
		session.update(socio);
		session.update(sucursalActividad);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Actividad> listaActividades() {
		final Session session = sessionFactory.getCurrentSession();
		List<Actividad> listaActividades = session.createCriteria(Actividad.class).list();
		return listaActividades;
	}

	@Override
	public SucursalActividad traerActividadDeSucursal(Long idSucursalActividad) {
		Session sesion = sessionFactory.getCurrentSession();
		SucursalActividad sucursalActividad = (SucursalActividad) sesion.createCriteria(SucursalActividad.class)
				.add(Restrictions.eq("idSucursalActividad", idSucursalActividad))
				.uniqueResult();
		return sucursalActividad;
	}

	@Override
	public void modificarCupoDeActividadEnSucursal(SucursalActividad sucursalActividad) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.update(sucursalActividad);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SucursalActividad> listaActividadesDeSocio(Long idSocio) {
		Session sesion = sessionFactory.getCurrentSession();
		List<SucursalActividad> lista = sesion.createCriteria(SucursalActividad.class)
				.createAlias("socios", "listaSocios")
				.add(Restrictions.eq("listaSocios.idSocio", idSocio))
				.list();
		
		return lista;
	}
	@Override
	public Actividad buscarActividad(Long idActividad) {
		Session sesion = sessionFactory.getCurrentSession();
		Actividad actividad = (Actividad) sesion.createCriteria(Actividad.class)
				.add(Restrictions.eq("id",idActividad))
				.uniqueResult();
		return actividad;
	}
	
	@Override
	public void modificarActividad(SucursalActividad sucursalActividadUpdate, SucursalActividad sucursalActividadBdd) {
		Session sesion = sessionFactory.getCurrentSession();
		sucursalActividadBdd.setDia(sucursalActividadUpdate.getDia());
		sucursalActividadBdd.setHoraDesde(sucursalActividadUpdate.getHoraDesde());
		sucursalActividadBdd.setHoraHasta(sucursalActividadUpdate.getHoraHasta());
		sucursalActividadBdd.setCupo(sucursalActividadUpdate.getCupo());
		sesion.update(sucursalActividadBdd);
	}

	@Override
	public void eliminarSucursalActividad(SucursalActividad sucursalActividad) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.delete(sucursalActividad);
	}

	@Override
	public void agregarSucursalActividad(SucursalActividad sucursalActividadVacia) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.save(sucursalActividadVacia);
	}
}
