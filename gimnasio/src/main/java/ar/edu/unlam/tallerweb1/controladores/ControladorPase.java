package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.servicios.ServicioPago;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ServicioPago servicioPago;

	@RequestMapping("/pases")
	public ModelAndView listarPases(){
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("listaPases", servicioPase.listarPases());
		modelo.put("usuario", usuario);
		modelo.put("estadoPago", servicioPago.getUltimoPago(usuario.getSocio()).getEstado().getId());
		return new ModelAndView ("listaPases", modelo);
		
	}
}
