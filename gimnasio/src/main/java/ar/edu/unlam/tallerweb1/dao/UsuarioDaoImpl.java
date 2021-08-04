package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import ar.edu.unlam.tallerweb1.servicios.PasswordIncorrectaException;
import ar.edu.unlam.tallerweb1.servicios.UsuarioInexistenteException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		final Session session = sessionFactory.getCurrentSession();
		Usuario nickBuscado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nick", usuario.getNick()))
				.uniqueResult();
		if(nickBuscado == null) throw new UsuarioInexistenteException();
		Usuario usuarioBuscado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nick", usuario.getNick()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
		if(usuarioBuscado == null) throw new PasswordIncorrectaException();
		return usuarioBuscado;
	}

	@Override
	public List<Usuario> verSiExisteUsuario(String nick) {
		final Session session = sessionFactory.getCurrentSession();
		List<Usuario> existeUsuario = session.createCriteria(Usuario.class)
				.add(Restrictions.eq("nick", nick))
				.list();
		return existeUsuario;
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(usuario);
		return usuario;
	}


}
