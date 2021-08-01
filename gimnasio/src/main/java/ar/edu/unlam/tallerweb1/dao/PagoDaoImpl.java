package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Descuento;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Socio;

@Repository
public class PagoDaoImpl implements PagoDao {

	@Inject
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> listaPagos(List<Socio> socios, Date fechaDesde, Date fechaHasta) {
		Session sesion = sessionFactory.getCurrentSession();
		List<Pago> listaPagos = sesion.createCriteria(Pago.class)
				.add(Restrictions.in("socio", socios))
				.add(Restrictions.between("fecha", fechaDesde, fechaHasta))
				.list();
		
		return listaPagos;
	}

	@Override
	public List<Descuento> listarDescuentos() {
		final Session session = sessionFactory.getCurrentSession();
		List<Descuento> listaDescuentos = session.createCriteria(Descuento.class)
				.list();
		return listaDescuentos;
	}
	
	@Override
	public Descuento buscarDescuento(Long idDescuento) {
		Session sesion = sessionFactory.getCurrentSession();
		Descuento descuento = (Descuento) sesion.createCriteria(Descuento.class)
				.add(Restrictions.eq("id", idDescuento))
				.uniqueResult();
		return descuento;
	}

	@Override
	public void abonarPase(Pago pago) {
		Session sesion = sessionFactory.getCurrentSession();
		sesion.save(pago);
		
	}

	@Override
	public List<Pago> traerPagosSocio(Socio socio) {
		Session sesion = sessionFactory.getCurrentSession();
		List<Pago> listaPagos = sesion.createCriteria(Pago.class)
				.add(Restrictions.eq("socio",socio))
				.list();
		
		return listaPagos;
	}

	@Override
	public Pago getUltimoPago(Socio socio) {
		Session sesion = sessionFactory.getCurrentSession();
		return (Pago) sesion.createCriteria(Pago.class)
				.add(Restrictions.eq("socio", socio))
				.addOrder(Order.desc("fecha"))
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();

	}

	@Override
	public Pago getPagoById(Long idPago) {
		return (Pago) sessionFactory.getCurrentSession()
				.createCriteria(Pago.class)
				.add(Restrictions.eq("id", idPago))
				.uniqueResult();
	}

	@Override
	public List<Pago> buscarPagosNuevos() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Pago.class)
				.add(Restrictions.eq("nuevo", true))
				.list();
	}

	@Override
	public void actualizarPago(Pago pago) {
		sessionFactory.getCurrentSession().update(pago);
	}


}
