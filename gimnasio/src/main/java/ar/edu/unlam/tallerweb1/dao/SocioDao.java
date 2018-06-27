package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface SocioDao {
	
	List<Socio> buscarSocios(Long idSucursal);
	List<Socio> buscarSocios();
	Socio buscarSocio(Usuario usuario); 
	void agregarPaseASocio(Long idSocio, Long idPase);
	Socio buscarSocio(Long idSocio);
	void modificarSocio(Socio socioUpdate, Socio socioBdd);
}
