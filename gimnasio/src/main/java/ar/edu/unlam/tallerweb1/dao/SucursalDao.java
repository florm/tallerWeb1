package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;


public interface SucursalDao {
	List<Sucursal> listaSucursales();
	Sucursal getSucursal(Long id);
	void modificarSucursal(Sucursal sucursalUpdate, Sucursal sucursalBdd);
	void eliminarSucursal(Sucursal sucursalEliminada);
	void agregarSucursal(Sucursal sucursalNueva);
}

