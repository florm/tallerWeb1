package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import helpers.Paginado;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Actividad;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioActividad;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;
import helpers.Formulario;

@Controller
public class ControladorActividad {
	@Inject
	private ServicioActividad servicioActividad;
	@Inject
	private ServicioSocio servicioSocio;
	
	public void setServicioActividad(ServicioActividad servicio){
		this.servicioActividad = servicio;
	}
	
	public void setServicioSocio(ServicioSocio servicio){
		this.servicioSocio = servicio;
	}
	
	@RequestMapping("/sucursal/{id}/actividades")
	public ModelAndView irAListaActividades(@PathVariable (value="id") Long id, @RequestParam(value="socio") Long idSocio, Paginado paginado) {
		ModelMap modelo = new ModelMap();
		Formulario formulario = new Formulario();
		List<SucursalActividad> lista = servicioActividad.listarActividadesEnSucursal(id, paginado);
		Boolean validarPase = servicioSocio.validarActividadSocio(idSocio);
				
		modelo.put("listaActividades", lista);
		modelo.put("formularioInscripcion", formulario);
		modelo.put("validarPase", validarPase);
		return new ModelAndView("listaActividades",modelo);
	}
	
//	@RequestMapping(path = "/registrarActividad", method = RequestMethod.POST)
//	public ModelAndView irARegistroCompleto(@ModelAttribute("formulario") Formulario formulario) {
//		boolean resultado = servicioActividad.guardarSocioActividadSucursal(formulario.getIdSocio(), formulario.getIdSucursalActividad());
//		ModelMap modelo = new ModelMap();
//		if (resultado == true) {
//			modelo.put("exito", "La inscripcion se realiz� correctamente");
//			return new ModelAndView("listaActividades", modelo);
//		}else {
//			modelo.put("exito", "Ya se encuentra inscripto en esta actividad");
//			return new ModelAndView("listaActividades", modelo);
//		}
//	}
	
	@RequestMapping(path = "/registrarActividad", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String irARegistroCompleto(@RequestBody Formulario formulario) {
		Boolean validarPase = servicioSocio.validarActividadSocio(formulario.getIdSocio());
		if(validarPase == false){
			String rta = "{\"mensaje\":\"Alcanzo el maximo de actividades que tiene su pase\", \"estado\":\"0\"}";
			return rta;
		}
		Boolean resultado = servicioActividad.guardarSocioActividadSucursal(formulario.getIdSocio(), formulario.getIdSucursalActividad());
		if (resultado == true) {
			
			String rta = "{\"mensaje\":\"La inscripcion se realizo correctamente\", \"estado\":\"1\"}";
			return rta;
		}else {
			
			String rta = "{\"mensaje\":\"Ya se encuentra inscripto en esta actividad\", \"estado\":\"0\"}";
			return rta;
		}
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