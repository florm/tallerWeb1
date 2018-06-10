package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SucursalActividadDao;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Service ("ServicioActividad")
@Transactional
public class ServicioActividadImp implements ServicioActividad {
	
	@Inject
	private SucursalActividadDao servicioSucursalActividadDao;
	@Override
	public List<SucursalActividad> listarActividadesEnSucursal(Long id) {
		return servicioSucursalActividadDao.listarActividadesEnSucursal(id);
	}
	@Override
	public void guardarSocioActividadSucursal(Long idSocio, Long idSucursalActividad) {
		// TODO Auto-generated method stub
		
	}

}
