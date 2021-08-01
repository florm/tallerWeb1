package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Descuento;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Socio;


public interface PagoDao {
	List<Pago> listaPagos(List<Socio> socios, Date fechaDesde, Date fechaHasta);
	public List<Descuento> listarDescuentos();
	public Descuento buscarDescuento(Long idDescuento);
	public void abonarPase(Pago pago);
	List<Pago> traerPagosSocio(Socio socio);
    Pago getUltimoPago(Socio socio);
    Pago getPagoById(Long idPago);
    List<Pago> buscarPagosNuevos();
	void actualizarPago(Pago pago);
}
