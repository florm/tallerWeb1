package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Descuento;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;

public interface ServicioPago {

	public List<Pago> listaPagos(List<Socio> socios, Date fechaDesde, Date fechaHasta);
	public Double getTotalRecaudado(List<Pago> pagos);
	public List<Descuento> listarDescuentos();
}
