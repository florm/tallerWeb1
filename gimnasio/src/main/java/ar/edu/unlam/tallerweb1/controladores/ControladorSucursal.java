package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;

@Controller
public class ControladorSucursal {
	
	@Inject
	private ServicioSocio servicioSocio;
	
	@RequestMapping("/sucursal/{id}/socios")
	public ModelAndView verListaSocios(@PathVariable Long id) {

		ModelMap modelo = new ModelMap();
		List<Socio> socios = servicioSocio.buscarSocios(id);
		modelo.put("listaSocios", socios);
		
		return new ModelAndView("listaSocios", modelo);
	}

}
