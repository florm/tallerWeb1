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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioActividad;
import helpers.Formulario;

@Controller
public class ControladorActividad {
	@Inject
	private ServicioActividad servicioActividad;

	@RequestMapping(path = "/registrarActividad", method = RequestMethod.POST)
	public ModelAndView irARegistroCompleto(@ModelAttribute("formulario") Formulario formulario) {
		servicioActividad.guardarSocioActividadSucursal(formulario.getIdSocio(), formulario.getIdSucursalActividad());
		ModelMap modelo = new ModelMap();
		modelo.put("exito", "La inscripcion se realizó correctamente");
		return new ModelAndView("listaActividades", modelo);
	}
	
	@RequestMapping(path = "/actividad/{idSucursalActividad}", method = RequestMethod.GET)
	public ModelAndView irARegistroCompleto(@PathVariable Long idSucursalActividad, @RequestParam(value="socio") Long idSocio) {
		servicioActividad.guardarSocioActividadSucursal(idSocio, idSucursalActividad);
		return new ModelAndView("listaActividades");
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
		Formulario formulario = new Formulario();
		List<SucursalActividad> lista = servicioActividad.listarActividadesEnSucursal(id);
		modelo.put("listaActividades", lista);
		modelo.put("formularioInscripcion", formulario);
		return new ModelAndView("listaActividades",modelo);
	}
	
	@RequestMapping("/actividades")
	public ModelAndView verActividades() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		
		List<Actividad> listaActividades = servicioActividad.listaActividades();
		modelo.put("listaActividades", listaActividades);
		modelo.put("usuario", usuario);
		return new ModelAndView("actividadesGenerales",modelo);
	}

}