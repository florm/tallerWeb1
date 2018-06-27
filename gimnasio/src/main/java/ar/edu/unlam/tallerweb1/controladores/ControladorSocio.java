package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;
import helpers.Formulario;

@Controller
public class ControladorSocio {
	@Inject
	private ServicioSocio servicioSocio;
	
	@RequestMapping (path = "/inscribirpase", method = RequestMethod.POST)
	public ModelAndView agregarPaseASocio(@ModelAttribute ("formulario") Formulario formulario) {
		Formulario formularioVacio = new Formulario();
		ModelMap model = new ModelMap();
		model.put("formulario", formularioVacio);
		return new ModelAndView("inscribirpase", model);
	}
	
	@RequestMapping (path = "seleccionarpase", method = RequestMethod.POST)
	public ModelAndView insertarPaseEnSocio(@ModelAttribute ("formulario") Formulario formulario) {
		servicioSocio.agregarPaseASocio(formulario.getIdSocio(), formulario.getIdPase());
		return new ModelAndView("cargacompleta");
	}
	
	@RequestMapping("/socio/{id}/datospersonales")
	public ModelAndView irADatosSocio(@PathVariable Long id) {
		ModelMap modelo = new ModelMap();
		modelo.put("socio", servicioSocio.buscarSocio(id));
		return new ModelAndView("datosPersonales", modelo);
	}
	
	@RequestMapping("/socio/{id}/modificardatospersonales")
	public ModelAndView irAModificarDatosSocio(@PathVariable Long id) {
		ModelMap modelo = new ModelMap();
		Socio socioVacio = new Socio();
		modelo.put("socio", servicioSocio.buscarSocio(id));
		modelo.put("socioVacio", socioVacio);
		return new ModelAndView("modificarDatosPersonales", modelo);
	}
	
	@RequestMapping(path = "/socio/{id}/modificardatossocio", method = RequestMethod.POST)
	public ModelAndView modificarDatosPersonales(@ModelAttribute ("socioVacio") Socio socioUpdate, @PathVariable Long id) {
		Socio socioBdd = servicioSocio.buscarSocio(id);
		servicioSocio.modificarSocio(socioUpdate, socioBdd);
		return new ModelAndView("modificarDatosPersonales");
	}
	
}
