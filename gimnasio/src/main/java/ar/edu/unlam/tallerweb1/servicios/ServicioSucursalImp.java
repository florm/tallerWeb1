package ar.edu.unlam.tallerweb1.servicios;

import java.awt.geom.Point2D;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.LocalizacionDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import maps.java.Geocoding;


@Service ("servicioSucursal")
@Transactional
public class ServicioSucursalImp implements ServicioSucursal {
	
	@Inject
	private SucursalDao sucursalDao;
	
	@Inject
	private LocalizacionDao localizacionDao;

	@Override
	public List<Sucursal> listarSucursales() {
		return sucursalDao.listaSucursales();
	}

	@Override
	public Sucursal getSucursal(Long id) {
		return sucursalDao.getSucursal(id);
	}
	
	@Override
	public void modificarSucursal(Sucursal sucursalUpdate) throws UnsupportedEncodingException, MalformedURLException {
		Sucursal sucursal = sucursalDao.getSucursal(sucursalUpdate.getId());
		Ciudad ciudad = localizacionDao.traerCiudad(sucursalUpdate.getCiudad().getId());
		sucursal.setCiudad(ciudad);
		sucursal.setNombre(sucursalUpdate.getNombre());
		sucursal.setCalle(sucursalUpdate.getCalle());
		sucursal.setNumcalle(sucursalUpdate.getNumcalle());
		sucursal.setCodPostal(sucursalUpdate.getCodPostal());
		Geocoding ObjGeocod=new Geocoding();
		Point2D.Double resultadoCD=ObjGeocod.getCoordinates(sucursal.getCalle()+","+sucursal.getNumcalle()+","+sucursal.getCiudad().getNombre());
		sucursal.setLat(resultadoCD.getX());
		sucursal.setLng(resultadoCD.getY());
		
		sucursalDao.modificarSucursal(sucursal);
	}
	
	@Override
	public void eliminarSucursal(Sucursal sucursalEliminada) {
		sucursalDao.eliminarSucursal(sucursalEliminada);
	}
	
	@Override
	public void agregarSucursal(Sucursal sucursalNueva) throws UnsupportedEncodingException, MalformedURLException {
		Ciudad ciudad = localizacionDao.traerCiudad(sucursalNueva.getCiudad().getId());
		sucursalNueva.setCiudad(ciudad);
		sucursalNueva.setPais("Argentina");
		Geocoding ObjGeocod=new Geocoding();
		Point2D.Double resultadoCD=ObjGeocod.getCoordinates(sucursalNueva.getCalle()+","+sucursalNueva.getNumcalle()+","+sucursalNueva.getCiudad().getNombre());
		sucursalNueva.setLat(resultadoCD.getX());
		sucursalNueva.setLng(resultadoCD.getY());
		sucursalDao.agregarSucursal(sucursalNueva);
	}

	@Override
	public List<Sucursal> listarSucursalesLibres() {
		return sucursalDao.listarSucursalesLibres();
	}

}
