package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PaseDao;
import ar.edu.unlam.tallerweb1.modelo.Pase;

@Service("servicioPase")
@Transactional
public class ServicioPaseImpl implements ServicioPase {

	@Inject
	PaseDao paseDao;
	
	@Override
	public List<Pase> listarPases() {
		return paseDao.listarPases();
		
	}

	@Override
	public Pase buscarPase(Long idPase) {
		return paseDao.buscarPase(idPase);
	}

}
