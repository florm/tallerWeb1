package ar.edu.unlam.tallerweb1.servicios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PagoDao;
import ar.edu.unlam.tallerweb1.dao.PaseDao;
import ar.edu.unlam.tallerweb1.dao.SocioDao;
import ar.edu.unlam.tallerweb1.modelo.Descuento;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;

@Service("servicioPago")
@Transactional
public class ServicioPagoImpl implements ServicioPago {

	@Inject
	PagoDao pagoDao;
	
	@Inject
	PaseDao paseDao;
	
	@Inject
	SocioDao socioDao;

	@Override
	public List<Pago> listaPagos(List<Socio> socios, Date fechaDesde, Date fechaHasta) {
		return pagoDao.listaPagos(socios, fechaDesde, fechaHasta);
	}
	
	public Double getTotalRecaudado(List<Pago> pagos){
		Double total = 0.0;
		for (Pago pago : pagos) {
			total += pago.getImporte();
		}
		return total;
	}

	@Override
	public List<Descuento> listarDescuentos() {
		return pagoDao.listarDescuentos();
	}

	@Override
	public List<Descuento> listarDescuentosConImporte(Double importe, Socio socio) {
		List<Descuento> listaDescuentos = pagoDao.listarDescuentos();
		for (Descuento descuento : listaDescuentos) {
			if(descuento.getMeses()== 1) {
				descuento.setImporte(importe);
			}else {
				descuento.setImporte(importe*descuento.getPorcentaje());
			}
			
			if(socio.getDescuento() != null) {
				descuento.setImporte(descuento.getImporte()*0.95);
			}
		}
		return listaDescuentos;
	}

	@Override
	public void abonarPase(Long idSocio, Long idPase, Long idDescuento) {
		Descuento descuento = pagoDao.buscarDescuento(idDescuento);
		Pase pase = paseDao.buscarPase(idPase);
		Socio socio = socioDao.buscarSocio(idSocio);
		Pago pago = new Pago();
		
		if (descuento.getMeses() != 1) {
			pago.setImporte((pase.getPrecio()*descuento.getPorcentaje())*descuento.getMeses());			
		}else {
			pago.setImporte(pase.getPrecio());
		}
		
		if (socio.getDescuento() != null) {
			pago.setImporte(pago.getImporte()*0.95);
			socio.setDescuento(null);
		}
		
		if (socio.getRecomendadoPor() != null) {
			Socio socioRecomendador = socioDao.buscarSocio(socio.getRecomendadoPor().getIdSocio());
			socioRecomendador.setDescuento(1);
			socioDao.actualizarSocio(socioRecomendador);
		}
		
		socio.setPase(pase);
		socioDao.actualizarSocio(socio);
		
		pago.setSocio(socio);
		
		Date fecha = new java.util.Date();
//		SimpleDateFormat fechaFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String fechaString = fechaFormat.format(fecha);
//		Date fechaPago = fechaFormat.parse(fechaString);
		
		pago.setFecha(fecha);
		pagoDao.abonarPase(pago);
	}
	
	
	

}
