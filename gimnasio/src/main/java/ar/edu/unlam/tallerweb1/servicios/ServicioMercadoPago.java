package ar.edu.unlam.tallerweb1.servicios;



public interface ServicioMercadoPago {

	String createPayPreference (String titulo, String descripcion, int cantidad, double precio);

}
