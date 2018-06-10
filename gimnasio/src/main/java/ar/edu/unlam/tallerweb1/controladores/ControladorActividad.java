package ar.edu.unlam.tallerweb1.controladores;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;
import ar.edu.unlam.tallerweb1.servicios.ServicioActividad;
import helpers.Formulario;

public class ControladorActividad {
@Inject
private ServicioActividad servicioActividad;

@RequestMapping(path = "/inscripcion-actividad", method = RequestMethod.POST) //Formulario clase auxiliar
public ModelAndView irAFormularioDeInscripcionActividad(@ModelAttribute ("formulario") Formulario formulario) {
	//Long idSucursal = formulario.getIdSucursal();
	Formulario formularioVacio = new Formulario();
	ModelMap model = new ModelMap();
	List<SucursalActividad> lista = servicioActividad.listarActividadesEnSucursal(formulario.getIdSucursal());
	model.put("listaActividades", lista);
	model.put("formulario", formularioVacio); //el ModelAttribute se va a llamar formulario en el form
	return new ModelAndView("inscripcion-actividad", model);
	}

@RequestMapping(path = "/registrar-actividad-socio", method = RequestMethod.POST)
public ModelAndView irARegistroCompleto(@ModelAttribute("formulario") Formulario formulario) { //suponiendo que recibe idSocio y idSucursalActividad
	//Long idSocio = formulario.getIdSocio();
	//Long idSucursalActividad = formulario.getIdSucursal();
	servicioActividad.guardarSocioActividadSucursal(formulario.getIdSocio(), formulario.getIdSucursalActividad());
	//servicioActividad.guardarSocioActividadSucursal(idSocio, idSucursalActividad);
	
	return new ModelAndView("/");
	}


}