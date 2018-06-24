package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPase;

@Controller
public class ControladorPase {

	@Inject
	ServicioPase servicioPase;
	
	@RequestMapping("/pases")
	public ModelAndView listarPases(){
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("listaPases", servicioPase.listarPases());
		modelo.put("usuario", usuario);		
		return new ModelAndView ("listaPases", modelo);
		
	}
}
