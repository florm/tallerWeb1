package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Repository ("SucursalDao")
public class SucursalDaoImpl implements SucursalDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sucursal> listaSucursales() {
		Session sesion = sessionFactory.getCurrentSession();
		List<Sucursal> lista = sesion.createCriteria(Sucursal.class)
				.list();
		return lista;
	}

	@Override
	public Sucursal getSucursal(Long id) {
		Session sesion = sessionFactory.getCurrentSession();
		Sucursal sucursal = sesion.get(Sucursal.class, id);
				
		return sucursal;
	}
	
	@Override
	public void modificarSucursal(Sucursal sucursal) {
		Session sesion = sessionFactory.getCurrentSession();	
		sesion.update(sucursal);
	}
	
	@Override
	public void eliminarSucursal(Sucursal sucursalEliminada) {
		Session sesion = sessionFactory.getCurrentSession();
		// listaSucursales().remove(sucursalEliminada);
		sesion.delete(sucursalEliminada);
	}
	
	@Override
	public void agregarSucursal(Sucursal sucursalNueva) {
		Session sesion = sessionFactory.getCurrentSession();
		//listaSucursales().add(sucursalNueva);
		sesion.save(sucursalNueva);
	}

	@Override
	public List<Sucursal> listarSucursalesLibres() {
		Session sesion = sessionFactory.getCurrentSession();
		List<Sucursal> listaSucursalesLibres = sesion.createCriteria(Sucursal.class)
				.add(Restrictions.isNull("operador"))
				.list();
		return listaSucursalesLibres;
	}

	@Override
	public void modificarSucursal(Operador operador) {
		Session sesion = sessionFactory.getCurrentSession();
		Sucursal sucursal = sesion.get(Sucursal.class, operador.getSucursal().getId());
		sucursal.setOperador(operador);
		sesion.update(sucursal);
		
	}
}
