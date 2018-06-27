package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ActividadDao;
import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Service ("ServicioActividad")
@Transactional
public class ServicioActividadImp implements ServicioActividad {
	
	@Inject
	private ActividadDao servicioActividadDao;
	@Override
	public List<SucursalActividad> listarActividadesEnSucursal(Long id) {
		return servicioActividadDao.listarActividadesEnSucursal(id);
	}
	@Override
	public void guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad) {
		SucursalActividad actividad = servicioActividadDao.traerActividadDeSucursal(idSucursalActividad);
		if (actividad.getCupoActual()<=actividad.getCupo()) {
			servicioActividadDao.guardarSocioActividadSucursal(idSocio, idSucursalActividad);
			
		}
		
	}
	@Override
	public List<Actividad> listaActividades() {
		return servicioActividadDao.listaActividades();
	}

}
