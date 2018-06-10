package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Repository ("SucursalActividadDao")
public class SucursalActividadDaoImpl implements SucursalActividadDao {
	
	@Inject
    private SessionFactory sessionFactory;
	@Override
	public List<SucursalActividad> listarActividadesEnSucursal(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		List <SucursalActividad> lista = 
				session.createCriteria(SucursalActividad.class)
				.createAlias("sucursal", "buscaSucursal")
				.add(Restrictions.eq("buscaSucursal.idSucursal", id))
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
		
		session.save(socio);
		session.save(sucursalActividad);
		
//		Socio socio = 
//				(Socio) session.createCriteria(Socio.class)
//				.add(Restrictions.eq("idSocio", idSocio))
//				.uniqueResult();
		
//		SucursalActividad sucursalActividad = 
//				(SucursalActividad) session.createCriteria(SucursalActividad.class)
//				.add(Restrictions.eq("idSucursalActividad", idSucursalActividad))
//				.uniqueResult();
				
				

		
	}

}
