package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.servicios.ServicioOperador;
import ar.edu.unlam.tallerweb1.servicios.ServicioSucursal;

@Controller
public class ControladorOperador {

	@Inject 
	private ServicioOperador servicioOperador;
	@Inject
	private ServicioSucursal servicioSucursal;
	
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
		Operador operadorUpdate = new Operador();
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
	public void eliminar(@RequestParam(value="operador") Long idOperador){
		servicioOperador.eliminar(idOperador);
	}
}
