package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioSocio {

	List<Socio> buscarSocios(Long idSucursal);
	List<Socio> buscarSocios();
	Socio buscarSocio(Usuario usuario);
	Socio buscarSocio(Long idSocio);
	void agregarPaseASocio(Long idSocio, Long idPase);
	void modificarSocio(Long idSocio, Socio socio);
	Boolean validarActividadSocio(Long idSocio);
	Boolean registrarSocio(Socio socio);
	Integer getEstadoDeSocioPorCuota(Long idSocio);
}
