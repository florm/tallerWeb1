package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Socio;

public interface ServicioSocio {

	List<Socio> buscarSocios(Long idSucursal); 
}
