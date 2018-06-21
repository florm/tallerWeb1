package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.BeneficioDao;
import ar.edu.unlam.tallerweb1.modelo.Beneficio;


@Service ("ServicioBeneficio")
@Transactional
public class ServicioBeneficioImpl implements ServicioBeneficio {
	
	@Inject
	private BeneficioDao beneficioDao;

	@Override
	public List<Beneficio> listarBeneficios(Long idPase) {
		return beneficioDao.listarBeneficios(idPase);
	}
	
	

}
