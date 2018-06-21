package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ActividadDao;
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
		servicioActividadDao.guardarSocioActividadSucursal(idSocio, idSucursalActividad);
	}
	@Override
	public Boolean validarInscripcionActividad(Long idSocio) {
		Integer cantActividades = 0;
		cantActividades=servicioActividadDao.obtenerCantidadDeActividades(idSocio);
		if(cantActividades>=0||cantActividades==null) {
			return true;
		}
		else 
			return false;
	}
}
