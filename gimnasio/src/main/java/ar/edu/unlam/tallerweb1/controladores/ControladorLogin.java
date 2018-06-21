package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;

@RestController
public class ControladorLogin {

	// La anotacion @Inject indica a Spring que en este atributo se debe setear
	// (inyeccion de dependencias)
	// un objeto de una clase que implemente la interface ServicioLogin, dicha
	// clase debe estar anotada como
	// @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	@Inject
	private ServicioLogin servicioLogin;
	@Inject
	private ServicioSocio servicioSocio;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView irALogin() {
		Usuario usuario = new Usuario();
		ModelMap modelo = new ModelMap();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)

	public ModelAndView validarLogin(@ModelAttribute Usuario usuario, HttpServletRequest request) {

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			if(usuarioBuscado.getRol() != null){
				request.getSession().setAttribute("rol", usuarioBuscado.getRol());
				request.getSession().setAttribute("nombre", "admin");
			}
			else{
				request.getSession().setAttribute("idSucursal",
						servicioSocio.buscarSocio(usuarioBuscado).getSucursal().getId());
				request.getSession().setAttribute("nombre", servicioSocio.buscarSocio(usuarioBuscado).getNombre());
				request.getSession().setAttribute("idSocio", servicioSocio.buscarSocio(usuarioBuscado).getIdSocio());
				request.getSession().setAttribute("idPase", servicioSocio.buscarSocio(usuarioBuscado).getPase().getId());
			}
						
			return new ModelAndView("redirect:/home");
		
		} else {
			ModelMap model = new ModelMap();
			model.put("error", "Usuario o clave incorrecta");
			return new ModelAndView("login", model);
		}

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
