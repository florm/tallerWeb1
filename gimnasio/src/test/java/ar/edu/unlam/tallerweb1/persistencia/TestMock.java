//package ar.edu.unlam.tallerweb1.persistencia;
//
//import ar.edu.unlam.tallerweb1.SpringTest;
//import ar.edu.unlam.tallerweb1.controladores.ControladorActividad;
//import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
//import ar.edu.unlam.tallerweb1.modelo.Pase;
//import ar.edu.unlam.tallerweb1.modelo.Socio;
//import ar.edu.unlam.tallerweb1.modelo.Sucursal;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//import ar.edu.unlam.tallerweb1.servicios.ServicioActividad;
//import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
//import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;
//import helpers.Formulario;
//
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import static org.assertj.core.api.Assertions.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//
//import static org.mockito.Mockito.*;
//
//public class TestMock extends SpringTest{
//  
//   
//    @Test
//    @Transactional @Rollback(true)
//    public void pruebaControladorAlLogin(){
//    	ControladorLogin controladorLogin = new ControladorLogin(); //Como es el que testeo no es mock
//    	Usuario usuarioMock = mock (Usuario.class);
//    	HttpServletRequest requestMock = mock(HttpServletRequest.class);
//    	
//    	ServicioLogin servicioLoginMock = mock (ServicioLogin.class);
//    	controladorLogin.setServicioLogin(servicioLoginMock);
//    	ServicioSocio servicioSocioMock = mock(ServicioSocio.class);
//    	controladorLogin.setServicioSocio(servicioSocioMock);
//    	
//    	when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
//    	ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
//    	assertThat(modelAndView.getViewName()).isEqualTo("login");
//    }
//    
//    @Test
//    @Transactional @Rollback(true)
//    public void pruebaControladorAlHomeAdmin(){
//    	ControladorLogin controladorLogin = new ControladorLogin();
//    	HttpServletRequest requestMock = mock(HttpServletRequest.class);
//    	Usuario usuarioMock = mock(Usuario.class);
//    	ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
//    	controladorLogin.setServicioLogin(servicioLoginMock);
//    	
//    	when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
//    	when(usuarioMock.getRol()).thenReturn("test");
//
//    	HttpSession sesionMock = mock(HttpSession.class);
//    	when(requestMock.getSession()).thenReturn(sesionMock);
//    	//doNothing().when(sesionMock).setAttribute("test","test"); //va una sola vez aunque se llame varias veces
//    	    	    	
//    	ModelAndView vista = controladorLogin.validarLogin(usuarioMock, requestMock);
//    	assertThat(vista.getViewName()).isEqualTo("redirect:/homeAdmin");
//    	
//		
//    }
//    
//    @Test
//    @Transactional @Rollback(true)
//    public void pruebaControladorAlHome(){
//    	ControladorLogin controladorLogin = new ControladorLogin();
//    	HttpServletRequest requestMock = mock(HttpServletRequest.class);
//    	Usuario usuarioMock = mock(Usuario.class);
//    	ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
//    	ServicioSocio servicioSocioMock = mock(ServicioSocio.class);
//    	controladorLogin.setServicioLogin(servicioLoginMock);
//    	controladorLogin.setServicioSocio(servicioSocioMock);
//    	
//    	when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
//    	when(usuarioMock.getRol()).thenReturn(null);
//
//    	
//    	
//    	Socio socioMock = mock(Socio.class);
//    	when(servicioSocioMock.buscarSocio(usuarioMock)).thenReturn(socioMock);
//    	Sucursal sucursalMock = mock(Sucursal.class);
//    	when(socioMock.getSucursal()).thenReturn(sucursalMock);
//    	when(sucursalMock.getId()).thenReturn(100L);
//    	
//    	when(servicioSocioMock.buscarSocio(usuarioMock).getNombre()).thenReturn("test");
//    	when(servicioSocioMock.buscarSocio(usuarioMock).getIdSocio()).thenReturn(1L);
//    	
//    	Pase paseMock = mock(Pase.class);
//    	when(socioMock.getPase()).thenReturn(paseMock);
//    	when(paseMock.getId()).thenReturn(1L);
//    	
//    	HttpSession sesionMock = mock(HttpSession.class);
//    	when(requestMock.getSession()).thenReturn(sesionMock);
//    	
//    	    	    	
//    	ModelAndView vista = controladorLogin.validarLogin(usuarioMock, requestMock);
//    	assertThat(vista.getViewName()).isEqualTo("redirect:/home");
//    	verify(sesionMock, times(1)).setAttribute("idSucursal", 100L);
//		
//    }
//
//    @Test
//    @Transactional @Rollback(true)
//    public void testRegistrarActividad(){
//    	ControladorActividad controladorActividad = new ControladorActividad();
//    	ServicioActividad servicioActividad = mock(ServicioActividad.class);
//    	controladorActividad.setServicioActividad(servicioActividad);
//    	Formulario formularioMock = mock(Formulario.class);
//    	when(formularioMock.getIdSocio()).thenReturn(1L);
//    	when(formularioMock.getIdSucursalActividad()).thenReturn(1L);
//    	when(servicioActividad.guardarSocioActividadSucursal(1L,1L)).thenReturn(true);
//    	
//    	String rta = controladorActividad.irARegistroCompleto(formularioMock);
//    	assertThat(rta).contains("La inscripcion se realizo correctamente");
//    }
//    
//    
//   
//}