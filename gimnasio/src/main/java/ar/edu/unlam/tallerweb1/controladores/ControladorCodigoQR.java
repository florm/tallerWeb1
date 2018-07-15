package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioQr;
import helpers.CodigoQR;

@Controller
public class ControladorCodigoQR {
	@Inject
	ServicioQr servicioQr;
	
	@RequestMapping(path = "/verificarQr")
	public ModelAndView generarqr(@RequestParam(value="token") Integer numero, @RequestParam(value="idSocio") Long idSocio) {
		Boolean valido = servicioQr.validarToken(numero,idSocio);
		ModelMap modelo = new ModelMap();
		if(valido==true)
			modelo.put("mensaje", "El socio tiene un pase vigente. Acceso Permitido");
		else{
			modelo.put("mensaje", "El socio tiene vencido su pase o el código es incorrecto. Acceso Denegado");
		}
		
		return new ModelAndView("verificacionQr",modelo);
	
	}
}
