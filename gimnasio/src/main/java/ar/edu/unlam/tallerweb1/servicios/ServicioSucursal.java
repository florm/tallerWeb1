package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Sucursal;



public interface ServicioSucursal {

	List<Sucursal> listarSucursales(); 
	Sucursal getSucursal(Long id);
	
}