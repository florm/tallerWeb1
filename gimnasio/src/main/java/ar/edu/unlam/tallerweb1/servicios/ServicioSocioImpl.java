package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SocioDao;
import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioSocio")
@Transactional
public class ServicioSocioImpl implements ServicioSocio {

	@Inject
	private SocioDao socioDao; 
	@Override
	public List<Socio> buscarSocios(Long idSucursal) {
		return socioDao.buscarSocios(idSucursal);
	}
	
	@Override
	public void agregarPaseASocio(Long idSocio, Long idPase) {
		socioDao.agregarPaseASocio(idSocio, idPase);
	}

	@Override
	public Socio buscarSocio(Usuario usuario) {
		return socioDao.buscarSocio(usuario);
	}

	@Override
	public Socio buscarSocio(Long idSocio) {
		return socioDao.buscarSocio(idSocio);
	}

	@Override
	public List<Socio> buscarSocios() {
		return socioDao.buscarSocios();
	}

	@Override
	public void modificarSocio(Socio socioUpdate, Socio socioBdd) {
		socioDao.modificarSocio(socioUpdate, socioBdd);
	}

	
	//borrar despues
	@Override
	public Boolean validarActividadSocio(Long idSocio) {
		Socio socio = socioDao.buscarSocio(idSocio);
		if (socio.getActividadesEnSucursal().size() == socio.getPase().getCantidadActividades()) {
			return true;
		} else {
			return false;
		}
	}
	
}
