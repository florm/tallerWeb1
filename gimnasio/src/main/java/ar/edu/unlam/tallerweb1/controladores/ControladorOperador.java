package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorOperador {

	@Inject 
	private ServicioOperador servicioOperador;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioSocio servicioSocio;
	@Inject 
	private ServicioActividad servicioActividad;
	private ServicioPago servicioPago;

	public ControladorOperador(){}

	@Autowired
	public ControladorOperador(ServicioOperador servicioOperador, ServicioPago servicioPago){
		this.servicioPago = servicioPago;
		this.servicioOperador = servicioOperador;
	}
	
	
	@RequestMapping(path = "/homeOperador/{idSucursal}")
	public ModelAndView irAHomeOperador(@PathVariable (value="idSucursal") Long idSucursal) {
		ModelMap modelo = new ModelMap();
		modelo.put("listaSocios", servicioSocio.buscarSocios(idSucursal));
		return new ModelAndView("homeOperador", modelo);
	}
	
	@RequestMapping(path="operadores")
	public ModelAndView listaOperadores(){
		ModelMap modelo = new ModelMap();
		modelo.put("listaOperadores", servicioOperador.listarOperadores());
		return new ModelAndView("listaOperadores", modelo);
	}
	
	@RequestMapping(path="operador/modificar")
	public ModelAndView modificar(@RequestParam(value="operador") Long idOperador){
		ModelMap modelo = new ModelMap();
		Operador operador = servicioOperador.getById(idOperador);
		//Operador operadorUpdate = new Operador();
		modelo.put("operador", operador);
		List<Sucursal> listaSucursales = servicioSucursal.listarSucursales();
		modelo.put("listaSucursales", listaSucursales);
		return new ModelAndView("modificarOperador", modelo);
	}
	
	@RequestMapping(path="operador/modificarOperador", method= RequestMethod.POST)
	public ModelAndView modificarOperador(@ModelAttribute Operador operador){
		servicioOperador.modificar(operador);
		return new ModelAndView("redirect:/operadores");
	}
	
	@RequestMapping(path="operador/eliminar")
	public ModelAndView eliminar(@RequestParam(value="operador") Long idOperador){
		servicioOperador.eliminar(idOperador);
		return new ModelAndView("redirect:/operadores");
	}
	
	@RequestMapping(path="operador/alta")
	public ModelAndView irAalta(){
		ModelMap modelo = new ModelMap();
		Operador operador = new Operador();
		modelo.put("listaSucursales", servicioSucursal.listarSucursalesLibres());
		modelo.put("operador", operador);
		return new ModelAndView("altaOperador", modelo);
	}
	
	@RequestMapping(path="operador/registrar", method= RequestMethod.POST)
	public ModelAndView registrar(@ModelAttribute Operador operador){
		servicioOperador.registrar(operador);
		return new ModelAndView("redirect:/operadores");
	}
	
	@RequestMapping(path="/actividadesOp/{idSucursal}")
	public ModelAndView abmActividades(@PathVariable ("idSucursal")Long idSucursal) {
		ModelMap modelo = new ModelMap();
		modelo.put("listaSucursalActividades", servicioActividad.listarActividadesEnSucursal(idSucursal));
		return new ModelAndView("listaActividadesAbm",modelo);
	}
	
	@RequestMapping(path="/actividadesOp/{idSucursalActividad}/modificacionActividad")
	public ModelAndView modificacionActividad(@PathVariable Long idSucursalActividad) {
		ModelMap modelo = new ModelMap();
		SucursalActividad SucursalActividadVacia = new SucursalActividad();
		modelo.put("sucursalActividad",servicioActividad.traerActividadSucursal(idSucursalActividad));
		modelo.put("listaProfesores", servicioActividad.listarProfesores());
		modelo.put("sucursalActividadVacia", SucursalActividadVacia);
		return new ModelAndView("modificacionActividad",modelo);
	}	
	
	@RequestMapping(path="/actividadesOp/{idSucursalActividad}/modificacionActividadProc", method= RequestMethod.POST)
		public ModelAndView establecerModificacionActividad(@ModelAttribute ("sucursalActividadVacia") SucursalActividad sucursalActividadUpdate
				,@PathVariable Long idSucursalActividad, HttpServletRequest request) {
		
		SucursalActividad sucursalActividadBdd= servicioActividad.traerActividadSucursal(idSucursalActividad);
		servicioActividad.modificarActividad(sucursalActividadUpdate, sucursalActividadBdd);
		ModelMap modelo = new ModelMap();
		modelo.put("ok", "La actividad se guardo correctamente");
		Long idSucursal = (Long)request.getSession().getAttribute("idSucursal");
		modelo.put("listaSucursalActividades", servicioActividad.listarActividadesEnSucursal(idSucursal));
		return new ModelAndView("listaActividadesAbm", modelo); 
	}
	
	@RequestMapping(path="/actividadesOp/{idSucursal}/bajaActividad")
	public ModelAndView eliminarSucursalActividad(@PathVariable("idSucursal")Long idSucursal,@RequestParam("idSucursalActividad") Long idSucursalActividad){
		ModelMap modelo = new ModelMap();
		SucursalActividad sucursalActividad = servicioActividad.traerActividadSucursal(idSucursalActividad);
		servicioActividad.eliminarSucursalActividad(sucursalActividad);
		return new ModelAndView("redirect:/actividadesOp/{idSucursal}");
	}
	
	@RequestMapping(path="actividadesOp/{idSucursal}/nuevaActividadEnSucursal")
	public ModelAndView agregarNuevaSucursalActividad(@PathVariable Long idSucursal) {
		ModelMap modelo = new ModelMap();
		SucursalActividad sucursalActividadVacia = new SucursalActividad();
		modelo.put("listaSucursales", servicioSucursal.listarSucursales());
		modelo.put("sucursalActividadVacia", sucursalActividadVacia);
		modelo.put("listaActividades", servicioActividad.listaActividades());
		modelo.put("listaProfesores", servicioActividad.listarProfesores());
		return new ModelAndView("formNuevaActividadEnSucursal",modelo);
	}
	@RequestMapping(path="actividadesOp/{idSucursal}/nuevaActividadEnSucursalProc",method = RequestMethod.POST)
	public ModelAndView agregarNuevaSucActividad(@ModelAttribute ("sucursalActividadVacia") SucursalActividad sucursalActividadVacia,@PathVariable Long idSucursal) {
		servicioActividad.agregarSucursalActividad(sucursalActividadVacia);
		return new ModelAndView("redirect:/actividadesOp/{idSucursal}");
	}

	@RequestMapping("/ver-pagos")
    public ModelAndView verPagos() {
		ModelMap modelo = new ModelMap();
		modelo.put("pagos", servicioOperador.buscarPagos());
		return new ModelAndView("pagos", modelo);
    }

    @RequestMapping("/aprobar-pago/{idPago}")
	public ModelAndView aprobarPago(@PathVariable("idPago") Long idPago) {
		Pago pago = servicioPago.getPagoById(idPago);
		ModelMap modelo = new ModelMap();
		try {
			servicioOperador.aprobarPago(pago);
		}catch(PagoYaAprobadoException e){
			modelo.put("mensaje", e.getMessage());
		}catch(PagoYaRechazadoException e){
			modelo.put("mensaje", e.getMessage());
		}catch(NoExistePagoException e){
			modelo.put("mensaje", e.getMessage());
		}
		return new ModelAndView("redirect:/ver-pagos", modelo);
	}

}
