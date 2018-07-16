package ar.edu.unlam.tallerweb1.controladores;


import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.DateUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioActividad;
import ar.edu.unlam.tallerweb1.servicios.ServicioLocalizacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioPago;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;

@RestController
public class ControladorAdministrador {

	
	@Inject
	private ServicioSocio servicioSocio;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioPago servicioPago;
	@Inject
	private ServicioLocalizacion servicioLocalizacion;
	@Inject 
	private ServicioActividad servicioActividad;

	
	
	@RequestMapping(path = "/homeAdmin")
	public ModelAndView irAHomeAdministrador() {
		ModelMap modelo = new ModelMap();
		modelo.put("listaSucursales", servicioSucursal.listarSucursales());
		return new ModelAndView("homeAdministrador", modelo);
	}

	@RequestMapping(path = "socios/")
	public ModelAndView listarSocios(){
		ModelMap modelo = new ModelMap();
		modelo.put("listaSocios", servicioSocio.buscarSocios());
		return new ModelAndView("socios",modelo);
	}
	
	@RequestMapping(path = "socios")
	public ModelAndView listarSocios(@RequestParam(value="idSucursal") Long idSucursal){
		ModelMap modelo = new ModelMap();
		modelo.put("listaSocios", servicioSocio.buscarSocios(idSucursal));
		return new ModelAndView("socios",modelo);
	}
	
	@RequestMapping(path = "ganancias/")
	public ModelAndView irAGanancias(){
		ModelMap modelo = new ModelMap();
		
		modelo.put("listaSucursales", servicioSucursal.listarSucursales());
		return new ModelAndView("ganancias",modelo);
	}
	
	
	@RequestMapping(path="ganancias", method = RequestMethod.GET)
	public ModelAndView verGanancias(@RequestParam(value="sucursal") String id, @RequestParam(value="periodo") String periodo) throws ParseException{
		Long idSucursal = Long.parseLong(id);
		Date fechaDesde = new SimpleDateFormat("yyyy-MM-dd").parse(periodo);
	    
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(fechaDesde);
		cal.add(Calendar.MONTH, 1);
		Date fechaHasta = cal.getTime();
		
		List<Socio> socios = servicioSocio.buscarSocios(idSucursal);
	    List<Pago> pagos = servicioPago.listaPagos(socios, fechaDesde, fechaHasta);
		Double ganancia = servicioPago.getTotalRecaudado(pagos);
	    Sucursal sucursal = servicioSucursal.getSucursal(idSucursal);
		
		ModelMap modelo = new ModelMap();
		modelo.put("listaPagos", pagos);
		modelo.put("total", ganancia);
		modelo.put("sucursal", sucursal);
		
		return new ModelAndView("listaPagos", modelo);
	}

	
	@RequestMapping("/sucursalesadmin")
	public ModelAndView irASucursales(){
		ModelMap modelo = new ModelMap();
		modelo.put("listaSucursales", servicioSucursal.listarSucursales());
		return new ModelAndView("listaSucursales",modelo);
	}
	
	@RequestMapping("/sucursal/{id}/modificar")
	public ModelAndView irAModificarSucursal(@PathVariable Long id) {
		ModelMap modelo = new ModelMap();
		Sucursal sucursalVacia = new Sucursal();
		modelo.put("sucursal", servicioSucursal.getSucursal(id));
		modelo.put("sucursalVacia", sucursalVacia);
		return new ModelAndView("modificarSucursal", modelo);
	}
	
	@RequestMapping(path = "/sucursal/{id}/modificardatos", method = RequestMethod.POST)
	public ModelAndView modificarDatosSucursal(@ModelAttribute ("sucursalVacia") Sucursal sucursalUpdate, @PathVariable Long id) {
		Sucursal sucursalBdd = servicioSucursal.getSucursal(id);
		servicioSucursal.modificarSucursal(sucursalUpdate, sucursalBdd);
		return new ModelAndView("redirect:/sucursalesadmin");
	}

	@RequestMapping(path= "/sucursal/{id}/eliminar")
	public ModelAndView eliminarSucursal (@PathVariable Long id) {
		Sucursal sucursalEliminada = servicioSucursal.getSucursal(id);
		servicioSucursal.eliminarSucursal(sucursalEliminada);
		return new ModelAndView("redirect:/sucursalesadmin");
	}
	
	@RequestMapping(path= "/sucursal/agregarNuevaSucursal")
	public ModelAndView agregarSucursal() {
		Sucursal sucursalVacia = new Sucursal();
		ModelMap modelo = new ModelMap();
		modelo.put("sucursalVacia", sucursalVacia);
		modelo.put("listaCiudad", servicioLocalizacion.listarCiudades());
		modelo.put("listaSucursal", servicioSucursal.listarSucursales());
		return new ModelAndView("agregarSucursal",modelo);
	}
	@RequestMapping(path = "/sucursal/nuevaSucursal", method = RequestMethod.POST)
	public ModelAndView agregarNuevaSucursal(@ModelAttribute ("sucursalVacia") Sucursal sucursalNueva) throws UnsupportedEncodingException, MalformedURLException {
		servicioSucursal.agregarSucursal(sucursalNueva);
		return new ModelAndView("redirect:/sucursalesadmin");
}
}