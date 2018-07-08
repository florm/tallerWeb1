package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.criterion.BetweenExpression;
import org.hibernate.criterion.Restrictions;
import static org.mockito.Mockito.*;

public class TestMock extends SpringTest{
  
    @Test
    @Transactional @Rollback(true)
    public void pruebaControladorLogin(){
    	ControladorLogin controladorLogin = new ControladorLogin(); //Como es el que testeo no es mock
    	Usuario usuarioMock = mock (Usuario.class);
    	HttpServletRequest requestMock = mock(HttpServletRequest.class);
    	HttpSession sessionMock = mock(HttpSession.class);
    	ServicioLogin servicioLoginMock = mock (ServicioLogin.class);
    	controladorLogin.setServicioLogin(servicioLoginMock);
    	ServicioSocio servicioSocioMock = mock(ServicioSocio.class);
    	controladorLogin.setServicioSocio(servicioSocioMock);
    	Socio socioMock = mock (Socio.class);
    	
    	when(servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(usuarioMock);
    	when(requestMock.getSession()).thenReturn(sessionMock);
    	when(usuarioMock.getRol()).thenReturn(null);
    	
    	when(servicioSocioMock.buscarSocio(usuarioMock)).thenReturn(socioMock);
    	when(socioMock.getNombre()).thenReturn("test");
    	    	
    	doNothing().when(sessionMock).setAttribute("test", "test");
    	
    	ModelAndView modelAndView = controladorLogin.validarLogin(usuarioMock, requestMock);
    	assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
    	
    }
   
}