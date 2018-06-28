package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

public interface ServicioActividad {

	List<SucursalActividad> listarActividadesEnSucursal(Long id); //Recibe el id de sucursal de usuario
	List<Actividad> listaActividades();
	public boolean guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad);
}
