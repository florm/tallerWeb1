package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.LocalizacionDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;


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
	public void modificarSucursal(Sucursal sucursalUpdate, Sucursal sucursalBdd) {
		sucursalDao.modificarSucursal(sucursalUpdate, sucursalBdd);
	}
	
	@Override
	public void eliminarSucursal(Sucursal sucursalEliminada) {
		sucursalDao.eliminarSucursal(sucursalEliminada);
	}
	
	@Override
	public void agregarSucursal(Sucursal sucursalNueva) {
		Ciudad ciudad = localizacionDao.traerCiudad(sucursalNueva.getCiudad().getId());
		sucursalNueva.setCiudad(ciudad);
		sucursalNueva.setPais("Argentina");
		sucursalDao.agregarSucursal(sucursalNueva);
		sucursalDao.agregarSucursal(sucursalNueva);
	}

	@Override
	public List<Sucursal> listarSucursalesLibres() {
		return sucursalDao.listarSucursalesLibres();
	}

}
