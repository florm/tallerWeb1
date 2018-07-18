package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.Profesor;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

public interface ActividadDao {
	List<SucursalActividad> listarActividadesEnSucursal(Long id);
	public void guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad);
	List<Actividad> listaActividades();
	SucursalActividad traerActividadDeSucursal(Long idSucursalActividad);
	public void modificarCupoDeActividadEnSucursal(SucursalActividad sucursalActividad);
	List<SucursalActividad> listaActividadesDeSocio(Long idSocio);
	public Actividad buscarActividad(Long idActividad);
	public void modificarActividad(SucursalActividad sucursalActividadUpdate,SucursalActividad sucursalActividadBdd);
	public void eliminarSucursalActividad(SucursalActividad sucursalActividad);
	public void agregarSucursalActividad(SucursalActividad sucursalActividadVacia);
	public void agregarNuevaActividad(Actividad actividad);
	public void modificarActividad(Actividad actividadUpdate,Actividad actividad);
	public void eliminarActividad(Actividad actividad);
	public void actualizarSucursalActividad(SucursalActividad sucursalActividad);
	List<Profesor> listarProfesores();
}
