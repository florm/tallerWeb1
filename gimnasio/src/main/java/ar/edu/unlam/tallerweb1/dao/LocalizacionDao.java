package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;

public interface LocalizacionDao {
	List<Provincia> listarProvincias();
	List<Ciudad> listarCiudades();
}
