package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Socio;


public interface PagoDao {
	List<Pago> listaPagos(List<Socio> socios, Date fechaDesde, Date fechaHasta);
}
