package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.Beneficio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioBeneficio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioBeneficio;


@Controller
public class ControladorBeneficios {
	
	@Inject
	private ServicioBeneficio servicoBeneficio;
	
	@RequestMapping(path="/beneficios")
	public ModelAndView beneficiosGenerales(){
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("beneficiosGenerales", modelo);
	}

	@RequestMapping("/beneficios/pase/{id}")
	public ModelAndView irABeneficios(@PathVariable(value="id") Long idPase) {
		ModelMap modelo = new ModelMap();
		List<Beneficio> lista = servicoBeneficio.listarBeneficios(idPase);
		modelo.put("listaBeneficios", lista);
		
		return new ModelAndView("beneficios",modelo);
	}

}