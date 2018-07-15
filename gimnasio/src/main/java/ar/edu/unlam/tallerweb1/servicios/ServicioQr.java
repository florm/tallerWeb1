package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;

public interface ServicioQr {

	void generarQr(Long idSocio, Date fechaVencimiento);

	Boolean validarToken(Integer numero, Long idSocio);

}
