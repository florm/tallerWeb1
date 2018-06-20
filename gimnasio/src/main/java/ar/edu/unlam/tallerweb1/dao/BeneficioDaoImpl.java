package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Beneficio;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import ar.edu.unlam.tallerweb1.modelo.SucursalActividad;

@Repository ("BeneficioDao")
public class BeneficioDaoImpl implements BeneficioDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficio> listarBeneficios(Long idPase) {
		final Session session = sessionFactory.getCurrentSession();
		List <Beneficio> lista = 
				session.createCriteria(Beneficio.class)
				.createAlias("pase", "buscarPase")
				.add(Restrictions.eq("buscarPase.id", idPase))
				.list();
		return lista;
	}
	
	

}
