package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.LocalizacionDao;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Provincia;

@Service ("ServicioLocalizacion")
@Transactional
public class ServicioLocalizacionImpl implements ServicioLocalizacion {
	@Inject
	private LocalizacionDao localizacionDao;
	
	@Override
	public List<Provincia> listarProvincias() {
		return localizacionDao.listarProvincias();
	}

	@Override
	public List<Ciudad> listarCiudades() {
		return localizacionDao.listarCiudades();
	}

}
