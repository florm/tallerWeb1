package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

public interface ActividadDao {
	List<SucursalActividad> listarActividadesEnSucursal(Long id);
	public void guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad);
}
