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
	public void modificarSucursal(Sucursal sucursalUpdate, Sucursal sucursalBdd) {
		Session sesion = sessionFactory.getCurrentSession();
		sucursalBdd.setNombre(sucursalUpdate.getNombre());
		sucursalBdd.setOperador(sucursalUpdate.getOperador());
		sucursalBdd.setPais(sucursalUpdate.getPais());
		sucursalBdd.setProvincia(sucursalUpdate.getProvincia());
		sucursalBdd.setCiudad(sucursalUpdate.getCiudad());
		sucursalBdd.setCodPostal(sucursalUpdate.getCodPostal());
		sucursalBdd.setCalle(sucursalUpdate.getCalle());
		sucursalBdd.setNumcalle(sucursalUpdate.getNumcalle());		
		sesion.update(sucursalBdd);
	}
}
