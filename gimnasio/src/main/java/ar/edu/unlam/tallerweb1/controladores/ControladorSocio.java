package ar.edu.unlam.tallerweb1.controladores;

import java.text.ParseException;
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

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalizacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPase;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;
import helpers.Formulario;

@Controller
public class ControladorSocio {
	@Inject
	private ServicioSocio servicioSocio;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioLocalizacion servicioLocalizacion;
	@Inject
	private ServicioPase servicioPase;
	
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
	
	
	//Controladores del registro
	
		@RequestMapping(path = "/registrar", method = RequestMethod.GET)
		public ModelAndView irARegistrar() {
			Usuario usuario = new Usuario();
			Socio socio = new Socio();
			ModelMap modelo = new ModelMap();
			modelo.put("usuario", usuario);
			modelo.put("socio", socio);
			//modelo.put("listaProvincia", servicioLocalizacion.listarProvincias());
			modelo.put("listaCiudad", servicioLocalizacion.listarCiudades());
			modelo.put("listaSucursal", servicioSucursal.listarSucursales());
			return new ModelAndView("registrar", modelo);
		}
	
	@RequestMapping (path = "/registrosocio", method = RequestMethod.POST)
	public ModelAndView registrarSocio(@ModelAttribute ("socio") Socio socio) {
		boolean resultado = servicioSocio.registrarSocio(socio);
		ModelMap modelo = new ModelMap();
		if (resultado == true) {
			modelo.put("msj", "Registro correcto");
			return new ModelAndView("pruebasocio", modelo);
		}else {
			modelo.put("msj", "El nombre de usuario ya existe");
			return new ModelAndView("pruebasocio", modelo);
		}
	}
	
	@RequestMapping (path="socio/{idSocio}/pases")
	public ModelAndView verPases (@PathVariable(value="idSocio") Long idSocio){
		ModelMap modelo = new ModelMap();
		List<Pase> listaPases = servicioPase.listarPases();
		modelo.put("listaPases", listaPases);
		return new ModelAndView("listaPases", modelo);
	}
	
}
