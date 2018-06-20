package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface SocioDao {
	
	List<Socio> buscarSocios(Long idSucursal);
	Socio buscarSocio(Usuario usuario); 
	void agregarPaseASocio(Long idSocio, Long idPase);
	Socio buscarSocio(Long idSocio);
}
