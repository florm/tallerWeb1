package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CodigoQR;

@Controller
public class ControladorCodigoQR {

	@RequestMapping(path = "/generarqr")
	public ModelAndView generarqr() {
		ModelMap modelo = new ModelMap();
		CodigoQR codigo = new CodigoQR();
		modelo.put("codigo",codigo);
		return new ModelAndView("generarqr", modelo);
	
	}
}
