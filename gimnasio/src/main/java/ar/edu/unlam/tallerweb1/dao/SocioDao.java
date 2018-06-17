package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Socio;

public interface SocioDao {
	
	List<Socio> buscarSocios(Long idSucursal);
	void agregarPaseASocio(Long idSocio, Long idPase);
}
