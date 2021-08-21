package ar.edu.unlam.tallerweb1.servicios;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import helpers.Paginado;


public interface ServicioSucursal {

	List<Sucursal> listarSucursales(Paginado paginado);
	Sucursal getSucursal(Long id);
	void modificarSucursal(Sucursal sucursal) throws UnsupportedEncodingException, MalformedURLException;
	void eliminarSucursal(Sucursal sucursalEliminada);
	void agregarSucursal(Sucursal sucursalNueva) throws UnsupportedEncodingException, MalformedURLException;
	List<Sucursal> listarSucursalesLibres();
	Integer listarSucursalesCount();
}

