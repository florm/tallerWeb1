package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.*;

public interface ServicioPago {

	public List<Pago> listaPagos(List<Socio> socios, Date fechaDesde, Date fechaHasta);
	public Double getTotalRecaudado(List<Pago> pagos);
	public List<Descuento> listarDescuentos();
	public List<Descuento> listarDescuentosConImporte(Double importe, Socio socio);
	public Pago abonarPase(Long idSocio, Long idPase, Long idDescuento, EstadoPago estado);

    Pago getUltimoPago(Socio socio);

    Pago getPagoById(Long idPago);
}
