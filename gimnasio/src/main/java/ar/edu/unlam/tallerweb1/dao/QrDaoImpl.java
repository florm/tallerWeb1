package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Token;

@Repository("QrDao")
public class QrDaoImpl implements QrDao {

	@Inject
	SessionFactory sessionFactory;
	
	@Override
	public void guardarToken(Long idSocio, Date fechaVencimiento, Integer numero) {
		Session sesion = sessionFactory.getCurrentSession();
		Token nuevoToken = new Token();
		nuevoToken.setNumero(numero);
		nuevoToken.setFechaVencimiento(fechaVencimiento);
		Socio socio = sesion.get(Socio.class, idSocio);
		nuevoToken.setSocio(socio);
		sesion.save(nuevoToken);

	}

	@Override
	public Token buscarToken(Integer numero, Long idSocio) {
		Session sesion = sessionFactory.getCurrentSession();
		Token token = (Token) sesion.createCriteria(Token.class)
				.add(Restrictions.eqOrIsNull("socio.id", idSocio))
				.add(Restrictions.eqOrIsNull("numero", numero))
				.uniqueResult();
		return token;
	}

}
