package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


@RestController
public class ControladorLogin {

	
	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioSocio servicioSocio;
	@Inject
	private ServicioSucursal servicioSucursal;
	@Inject
	private ServicioLocalizacion servicioLocalizacion;
	@Inject
	private ServicioOperador servicioOperador;
	
	//mocking
		public void setServicioLogin(ServicioLogin servicioLogin) {
			this.servicioLogin = servicioLogin;
		}
		public void setServicioSocio(ServicioSocio servicioSocio) {
			this.servicioSocio = servicioSocio;
		}
		
		public ServicioOperador getServicioOperador() {
			return servicioOperador;
		}
		public void setServicioOperador(ServicioOperador servicioOperador) {
			this.servicioOperador = servicioOperador;
		}
		
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView irALogin() {
		Usuario usuario = new Usuario();
		ModelMap modelo = new ModelMap();
		modelo.put("usuario", usuario);
		return new ModelAndView("login",modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)

	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		try{
			Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
			switch (usuarioBuscado.getRol()) {
				case "admin":
					request.getSession().setAttribute("rol", usuarioBuscado.getRol());
					request.getSession().setAttribute("nombre", "Admin");
					return new ModelAndView("redirect:/homeAdmin");
				case "operador":
					Long idSucursal = servicioOperador.buscarOperador(usuarioBuscado).getSucursal().getId();
					request.getSession().setAttribute("rol", usuarioBuscado.getRol());
					request.getSession().setAttribute("idSucursal", idSucursal);
					request.getSession().setAttribute("nombre", "Operador");
					return new ModelAndView("redirect:/homeOperador/"+idSucursal);
				default: //caso socio
					request.getSession().setAttribute("idSucursal", servicioSocio.buscarSocio(usuarioBuscado).getSucursal().getId());
					request.getSession().setAttribute("nombre", servicioSocio.buscarSocio(usuarioBuscado).getNombre());
					request.getSession().setAttribute("idSocio", servicioSocio.buscarSocio(usuarioBuscado).getIdSocio());
					request.getSession().setAttribute("idPase", servicioSocio.buscarSocio(usuarioBuscado).getPase().getId());
					request.getSession().setAttribute("estado", servicioSocio.getEstadoDeSocioPorCuota(servicioSocio.buscarSocio(usuarioBuscado).getIdSocio()));
					return new ModelAndView("redirect:/home");
			}
		}catch(UsuarioInexistenteException e){
			model.put("error", e.getMessage());
		}catch(PasswordIncorrectaException e){
			model.put("error", e.getMessage());
		}
		return new ModelAndView("login", model);

	}

	@RequestMapping(path = "/home")
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}
	
	

	@RequestMapping("/inscripcion")
	public ModelAndView irAInscripcion() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para
		// que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve
		// utilizando el view resolver definido en el archivo
		// spring-servlet.xml)
		// y se envian los datos a la misma dentro del modelo
		return new ModelAndView("inscripcion", modelo);
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se
	// invoca la url /login directamente.
	// @RequestMapping(path = "/", method = RequestMethod.GET)
	// public ModelAndView inicio() {
	// return new ModelAndView("redirect:/login");
	// }
	
	@RequestMapping(path = "/salir")
	public ModelAndView salir(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
	
	
	
}
