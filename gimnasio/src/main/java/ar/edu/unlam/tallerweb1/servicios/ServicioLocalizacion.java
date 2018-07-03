package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;

public interface ServicioLocalizacion {
	List<Provincia> listarProvincias();
	List<Ciudad> listarCiudades();
}
