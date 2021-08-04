package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.Profesor;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import helpers.Paginado;

public interface ServicioActividad {

	List<SucursalActividad> listarActividadesEnSucursal(Long id, Paginado paginado); //Recibe el id de sucursal de usuario
	List<Actividad> listaActividades();
	public boolean guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad);
	List<SucursalActividad> listaActividadesNoDisponibles(Long idSocio, List<SucursalActividad> actividadesEnSucursal);
	public Actividad buscarActividad(Long idActividad);
	public void modificarActividad(SucursalActividad sucursalActividadUpdate, SucursalActividad sucursalActividadBdd);
	public SucursalActividad traerActividadSucursal(Long idSucursalActividad);
	public void eliminarSucursalActividad(SucursalActividad sucursalActividad);
	public void agregarSucursalActividad(SucursalActividad sucursalActividad);
	public void agregarNuevaActividad(Actividad actividad);
	public void modificarActividad(Actividad actividadUpdate,Actividad actividad);
	public void eliminarActividad(Actividad actividad);
	List<Profesor> listarProfesores();
    Integer listarActividadesEnSucursalCount(Long idSucursal);
}
