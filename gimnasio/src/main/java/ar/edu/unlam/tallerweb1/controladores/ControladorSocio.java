package ar.edu.unlam.tallerweb1.controladores;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.servicios.ServicioLocalizacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPago;
import ar.edu.unlam.tallerweb1.servicios.ServicioPase;
import ar.edu.unlam.tallerweb1.servicios.ServicioQr;
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
	@Inject
	private ServicioPago servicioPago;
	@Inject
	private ServicioQr servicioQr;
	
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
		modelo.put("socio", servicioSocio.buscarSocio(id));
		modelo.put("listaCiudad", servicioLocalizacion.listarCiudades());
		return new ModelAndView("modificarDatosPersonales", modelo);
	}
	
	@RequestMapping(path = "/socio/{id}/modificardatossocio", method = RequestMethod.POST)
	public ModelAndView modificarDatosPersonales(@ModelAttribute ("socio") Socio socio, @PathVariable Long id) {
		servicioSocio.modificarSocio(id, socio);
		return new ModelAndView("redirect:/home");
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
	
		
	@RequestMapping (path = "/registrosocio", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String registrarSocioCompleto(@RequestBody Socio socio) {

		Boolean resultado = servicioSocio.registrarSocio(socio);
		if (resultado == true) {
			String rta = "{\"mensaje\":\"El registro fue exitoso\", \"estado\":\"1\"}";
			return rta;
		}else {
			String rta = "{\"mensaje\":\"El nombre de usuario ya existe\", \"estado\":\"0\"}";
			return rta;
		}
		

	}
	
	
	@RequestMapping (path="socio/{idSocio}/pases")
	public ModelAndView verPases (@PathVariable(value="idSocio") Long idSocio){
		ModelMap modelo = new ModelMap();
		List<Pase> listaPases = servicioPase.listarPases();
		modelo.put("listaPases", listaPases);
		return new ModelAndView("listaPases", modelo);
	}
	
	//Utilizo un helper formulario, falta ver el caso de mercadopago
	@RequestMapping (path="pago/socio/{idSocio}/pase/{idPase}")
	public ModelAndView irAPagar (@PathVariable(value="idSocio") Long idSocio, @PathVariable(value="idPase") Long idPase){
		Formulario formulario = new Formulario();
		ModelMap modelo = new ModelMap();
		Pase pase = servicioPase.buscarPase(idPase); //lo hago de esta manera porque necesito usarlo dos veces
		Socio socio = servicioSocio.buscarSocio(idSocio); //lo hago de esta manera porque necesito usarlo dos veces
		modelo.put("socio", socio);
		modelo.put("pase", pase);
		modelo.put("listaDescuentos", servicioPago.listarDescuentosConImporte(pase.getPrecio(), socio));
		modelo.put("formulario", formulario);
		return new ModelAndView("formulariopago", modelo );
	}
	
	@RequestMapping(path = "pago/socio/{idSocio}/abonarpase", method = RequestMethod.POST)
	public ModelAndView abonarPase(@ModelAttribute ("formulario") Formulario formulario){
		Date fechaVencimiento = servicioPago.abonarPase(formulario.getIdSocio(), formulario.getIdPase(), formulario.getIdDescuento());
		servicioQr.generarQr(formulario.getIdSocio(),fechaVencimiento);
		return new ModelAndView("qrConfirmacion");
	}
	
	@RequestMapping (path="socio/{idSocio}/paseactual")
	public ModelAndView irAPaseActual (@PathVariable(value="idSocio") Long idSocio){
		ModelMap modelo = new ModelMap();
		Socio socio = servicioSocio.buscarSocio(idSocio);
		modelo.put("pase", socio.getPase());
		return new ModelAndView("paseActual", modelo);
	}
}
