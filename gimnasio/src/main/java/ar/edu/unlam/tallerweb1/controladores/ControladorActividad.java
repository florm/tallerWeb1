package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.servicios.ServicioActividad;
import helpers.Formulario;

@Controller
public class ControladorActividad {
	@Inject
	private ServicioActividad servicioActividad;

	@RequestMapping(path = "/registrarsocio", method = RequestMethod.POST)
	public ModelAndView irARegistroCompleto(@ModelAttribute("formulario") Formulario formulario) {
		servicioActividad.guardarSocioActividadSucursal(formulario.getIdSocio(), formulario.getIdSucursalActividad());
		return new ModelAndView("registrocompleto");
	}

	// INSCRIBIR SOCIO EN ACTIVIDAD

	// ORIGINAL, falta persistir
	// @RequestMapping(path = "/inscribiractividad", method =
	// RequestMethod.POST) //Formulario clase auxiliar
	// public ModelAndView irAFormularioDeInscripcionActividad(@ModelAttribute
	// ("formulario") Formulario formulario) {
	// Formulario formularioVacio = new Formulario();
	// ModelMap model = new ModelMap();
	// List<SucursalActividad> lista =
	// servicioActividad.listarActividadesEnSucursal(formulario.getIdSucursal());
	// model.put("listaActividades", lista);
	// model.put("formulario", formularioVacio);
	// return new ModelAndView("inscribiractividad", model);
	// }

	// PRUEBA PARA TRAER SELECT - inscribiractividad e inscribiractividad2 son
	// ejemplos
	@RequestMapping(path = "/inscribiractividad", method = RequestMethod.GET) // Formulario
																				// clase
																				// auxiliar
	public ModelAndView irAFormularioDeInscripcionActividad() {
		Formulario formularioVacio = new Formulario();
		ModelMap model = new ModelMap();
		List<SucursalActividad> lista = servicioActividad.listarActividadesEnSucursal(2L);
		model.put("listaActividades", lista);
		model.put("formulario", formularioVacio);
		return new ModelAndView("inscribiractividad", model);
	}

	// pasar por pathvariable
	@RequestMapping(path = "/lala", method = RequestMethod.GET)
	public ModelAndView lala(@ModelAttribute("formulario") Formulario formulario) {
		ModelMap model = new ModelMap();
		model.put("idSucursalActividad", formulario.getIdSucursalActividad());
		model.put("prueba", formulario.getPrueba());
		return new ModelAndView("inscribiractividad2", model);
	}
	
	@RequestMapping("/sucursal/{id}/actividades")
	public ModelAndView irAListaActividades(@PathVariable Long id) {
		ModelMap modelo = new ModelMap();
		List<SucursalActividad> lista = servicioActividad.listarActividadesEnSucursal(id);
		modelo.put("listaActividades", lista);
		return new ModelAndView("listaActividades",modelo);
	}

}