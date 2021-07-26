package ar.edu.unlam.tallerweb1.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PagoDao;
import ar.edu.unlam.tallerweb1.dao.PaseDao;
import ar.edu.unlam.tallerweb1.dao.SocioDao;

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
	public Pago abonarPase(Long idSocio, Long idPase, Long idDescuento, EstadoPago estado){
		Descuento descuento = pagoDao.buscarDescuento(idDescuento);
		Pase pase = paseDao.buscarPase(idPase);
		Socio socio = socioDao.buscarSocio(idSocio);
		Pago pago = new Pago();
		
		if (descuento.getMeses() != 1) {
			pago.setImporte((pase.getPrecio()*descuento.getPorcentaje())*descuento.getMeses());			
		}else {
			pago.setImporte(pase.getPrecio());
		}
		pago.setPase(pase);
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
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, descuento.getMeses());
        Date fechaVencimiento = cal.getTime();
		
		pago.setFechaVencimiento(fechaVencimiento);
		pago.setEstado(estado);
		pagoDao.abonarPase(pago);
		
		return pago;
	}

	@Override
	public Pago getUltimoPago(Socio socio) {
		return pagoDao.getUltimoPago(socio);
	}

	@Override
	public Pago getPagoById(Long idPago) {
		return pagoDao.getPagoById(idPago);
	}


}
