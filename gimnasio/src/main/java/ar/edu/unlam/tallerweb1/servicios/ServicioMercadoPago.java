package ar.edu.unlam.tallerweb1.servicios;


import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import helpers.MercadoPago;
import helpers.MercadoPagoMetadata;

public interface ServicioMercadoPago {

	String createPayPreference(String titulo, String descripcion, int cantidad, double precio, Long idSocio, Long idPase, Long idDescuento) throws MPException;

    MercadoPagoMetadata getMetadata(String collectionId);
}
