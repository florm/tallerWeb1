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

import helpers.Pager;
import helpers.Paginado;
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
	public ModelAndView irAHomeAdministrador(Paginado paginado) {
		Paginado.getPaginado(paginado, servicioSucursal.listarSucursalesCount());
		ModelMap modelo = new ModelMap();
		modelo.put("listaSucursales", servicioSucursal.listarSucursales(paginado));
		Pager pager = new Pager(paginado.getRegistrosTotales(), paginado.getNumeroPagina(), paginado.getRegistrosPorPagina());
		modelo.put("paginado", pager);
		return new ModelAndView("homeAdministrador", modelo);
	}

	@RequestMapping(path = "socios/")
	public ModelAndView listarSocios(){
		ModelMap modelo = new ModelMap();
		modelo.put("listaSocios", servicioSocio.buscarSocios());
		return new ModelAndView("socios",modelo);
	}
	
	@RequestMapping(path = "socios")
	public ModelAndView listarSocios(@RequestParam(value="idSucursal") Long idSucursal, Paginado paginado){
		Paginado.getPaginado(paginado, servicioSocio.buscarSociosCount(idSucursal));
		ModelMap modelo = new ModelMap();
		modelo.put("listaSocios", servicioSocio.buscarSocios(idSucursal, paginado));
		Pager pager = new Pager(paginado.getRegistrosTotales(), paginado.getNumeroPagina(), paginado.getRegistrosPorPagina());
		modelo.put("paginado", pager);
		return new ModelAndView("socios",modelo);
	}
	
	@RequestMapping(path = "ganancias/")
	public ModelAndView irAGanancias(){
		ModelMap modelo = new ModelMap();
		
		modelo.put("listaSucursales", servicioSucursal.listarSucursales(null));
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
		
		List<Socio> socios = servicioSocio.buscarSocios(idSucursal, null);
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
	public ModelAndView irASucursales(Paginado paginado){
		Paginado.getPaginado(paginado, servicioSucursal.listarSucursalesCount());
		ModelMap modelo = new ModelMap();
		modelo.put("listaSucursales", servicioSucursal.listarSucursales(paginado));
		Pager pager = new Pager(paginado.getRegistrosTotales(), paginado.getNumeroPagina(), paginado.getRegistrosPorPagina());
		modelo.put("paginado", pager);
		return new ModelAndView("listaSucursales",modelo);
	}
	
	@RequestMapping("/sucursal/{id}/modificar")
	public ModelAndView irAModificarSucursal(@PathVariable Long id) {
		ModelMap modelo = new ModelMap();
		Sucursal sucursalVacia = new Sucursal();
		modelo.put("listaCiudades", servicioLocalizacion.listarCiudades());
		modelo.put("sucursal", servicioSucursal.getSucursal(id));
		modelo.put("sucursalVacia", sucursalVacia);
		return new ModelAndView("modificarSucursal", modelo);
	}
	
	@RequestMapping(path = "/sucursal/{id}/modificardatos", method = RequestMethod.POST)
	public ModelAndView modificarDatosSucursal(@ModelAttribute ("sucursalVacia") Sucursal sucursalUpdate) throws UnsupportedEncodingException, MalformedURLException{
		servicioSucursal.modificarSucursal(sucursalUpdate);
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
		modelo.put("listaSucursal", servicioSucursal.listarSucursales(null));
		return new ModelAndView("agregarSucursal",modelo);
	}
	@RequestMapping(path = "/sucursal/nuevaSucursal", method = RequestMethod.POST)
	public ModelAndView agregarNuevaSucursal(@ModelAttribute ("sucursalVacia") Sucursal sucursalNueva) throws UnsupportedEncodingException, MalformedURLException {
		servicioSucursal.agregarSucursal(sucursalNueva);
		return new ModelAndView("redirect:/sucursalesadmin");
	}
	@RequestMapping(path="/actividadesAdmin")
	public ModelAndView listaActividades() {
		ModelMap modelo = new ModelMap();
		modelo.put("listaActividades", servicioActividad.listaActividades());
		return new ModelAndView("actividadesAdmin",modelo);
	}
	@RequestMapping(path="/actividadesAdmin/nuevaActividad")
	public ModelAndView nuevaActividad() {
		ModelMap modelo = new ModelMap();
		Actividad actividad = new Actividad();
		modelo.put("actividad", actividad);
		return new ModelAndView("formNuevaActividad",modelo);
	}
	@RequestMapping(path="/actividadesAdmin/nuevaActividadProc")
	public ModelAndView nuevaActividadProc(@ModelAttribute ("actividad") Actividad actividad) {
		servicioActividad.agregarNuevaActividad(actividad);
		return new ModelAndView("redirect:/actividadesAdmin");
	}
	@RequestMapping(path="/actividadesAdmin/{idActividad}/modificarActividad")
	public ModelAndView modificarActividad(@PathVariable Long idActividad) {
		ModelMap modelo = new ModelMap();
		Actividad actividad = new Actividad();
		modelo.put("actividad", actividad);
		modelo.put("actividadBdd", servicioActividad.buscarActividad(idActividad));
		return new ModelAndView("modificacionActividadAdmin",modelo);
	}
	@RequestMapping(path="/actividadesAdmin/{idActividad}/modificarActividadProc",method = RequestMethod.POST)
	public ModelAndView modificarActividadProc(@ModelAttribute ("actividad") Actividad actividad,@PathVariable Long idActividad) {
		servicioActividad.modificarActividad(actividad, servicioActividad.buscarActividad(idActividad));
		return new ModelAndView("redirect:/actividadesAdmin");
	}
	@RequestMapping(path="/actividadesAdmin/{idActividad}/eliminarActividad")
	public ModelAndView eliminarActividad(@PathVariable Long idActividad) {
		servicioActividad.eliminarActividad(servicioActividad.buscarActividad(idActividad));
		return new ModelAndView("redirect:/actividadesAdmin");
	}
}