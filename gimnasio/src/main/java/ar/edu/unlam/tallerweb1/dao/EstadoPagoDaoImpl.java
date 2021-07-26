package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoPagoDaoImpl implements EstadoPagoDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public EstadoPago getById(Long id) {
        return (EstadoPago) sessionFactory.getCurrentSession().createCriteria(EstadoPago.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
}
