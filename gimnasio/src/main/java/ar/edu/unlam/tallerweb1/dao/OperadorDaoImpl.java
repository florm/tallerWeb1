package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.Sucursal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("operadorDao")
public class OperadorDaoImpl implements OperadorDao {

	@Inject
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Operador> listarOperadores() {
		Session sesion = sessionFactory.getCurrentSession();
		return sesion.createCriteria(Operador.class).list();
	}
	@Override
	public void modificarOperador(Operador operador) {
		Session sesion = sessionFactory.getCurrentSession();
		Sucursal sucursal = sesion.get(Sucursal.class,operador.getSucursal().getId());
		sucursal.setOperador(operador);
		sesion.update(sucursal);
		sesion.update(operador);
		
	}
	@Override
	public void eliminar(Long idOperador) {
		Session sesion = sessionFactory.getCurrentSession();
		List<Sucursal> sucursales = sesion.createCriteria(Sucursal.class)
				.createAlias("operador", "buscarOperador")
				.add(Restrictions.eq("buscarOperador.id", idOperador))
				.list();
		for (Sucursal sucursal : sucursales) {
			sucursal.setOperador(null);
			sesion.update(sucursal);
		}
				
		sesion.delete(this.getById(idOperador));
		
	}
	@Override
	public Operador getById(Long idOperador) {
		Session sesion = sessionFactory.getCurrentSession();
		return sesion.get(Operador.class, idOperador);
	}
	@Override
	public void registrar(Operador operador, Usuario usuario) {
		Session sesion = sessionFactory.getCurrentSession();
		Sucursal sucursal = sesion.get(Sucursal.class,operador.getSucursal().getId());
		sucursal.setOperador(operador);
		operador.setUsuario(usuario);
		sesion.save(operador);
		sesion.save(sucursal);
		
	}
	@Override
	public Operador buscarOperador(Usuario usuario) {
		Session sesion = sessionFactory.getCurrentSession();
		Operador operador = (Operador) sesion.createCriteria(Operador.class)
				.createAlias("usuario", "buscarPorUsuario")
				.add(Restrictions.eq("buscarPorUsuario.id", usuario.getId()))
				.uniqueResult();
		return operador;
	}

	
}
