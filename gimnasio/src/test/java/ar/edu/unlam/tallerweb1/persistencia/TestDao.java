package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.dao.ActividadDao;
import ar.edu.unlam.tallerweb1.dao.SocioDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioSocio;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;




public class TestDao extends SpringTest{
  
	@Inject
	private ActividadDao actividadDao;
	
	@Inject
	private SocioDao socioDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
    @Test
    @Transactional @Rollback(true)
    public void testGuardarSocioActividadSucursal(){
    	    	
    	Long idSocio= 2L;
    	Long idSucursalActividad = 5L;
    	
    	actividadDao.guardarSocioActividadSucursal(idSocio, idSucursalActividad);
    	assertThat(getSession().get(Socio.class, idSocio).getActividadesEnSucursal().contains(idSucursalActividad));
    }
    
    @Test
    @Transactional @Rollback(true)
    public void testRegistrarSocio(){
    	Socio socio = new Socio();
    	
    	Socio socioReferente =new Socio();
    	socioReferente.setIdSocio(2L);
    	Sucursal sucursal = new Sucursal();
    	sucursal.setId(4L);
    	
    	socioDao.registrarSocio(socio, socioReferente, sucursal);
    	assertThat(getSession().get(Socio.class, socio.getIdSocio())).isNotNull();
    	
    }
    
    @Test
    @Transactional @Rollback(true)
    public void testGuardarUsuario(){
    	
    	Usuario usuario = usuarioDao.guardarUsuario("pepe", "pepepass");
    	assertThat(getSession().get(Usuario.class, usuario.getId())).isNotNull();
    	assertEquals("pepe",getSession().get(Usuario.class, usuario.getId()).getNick());
    	
    }
    
   
}