package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.dao.EstadoPagoDao;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServicioEstadoPagoImpl implements ServicioEstadoPago{

    @Autowired
    private EstadoPagoDao estadoPagoDao;

    public EstadoPago getById(Long id){

        return estadoPagoDao.getById(id);
    }
}
