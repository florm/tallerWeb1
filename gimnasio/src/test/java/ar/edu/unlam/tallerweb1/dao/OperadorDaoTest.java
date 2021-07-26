package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OperadorDaoTest extends SpringTest {

    @Autowired
    private OperadorDao operadorDao;

    @Test
    @Transactional
    @Rollback
    public void sePuedenAprobarPagosPendientes(){
        Pago pago = givenPagoPendiente();
        whenAprueboUnPago(pago);
        thenElPagoEstaAprobado(pago);
    }

    @Test
    @Transactional
    @Rollback
    public void cuandoElOperadorBuscaPagosObtieneLosPagos(){
        Pago pago1 = givenExisteUnPago();
        Pago pago2 = givenExisteUnPago();
        Pago pago3 = givenExisteUnPago();
        List<Pago> pagosBuscados = whenBuscaPagos();
        Integer cantidadEsperada = 3;
        thenObtieneLosPagos(pagosBuscados, cantidadEsperada);
    }

    private void thenObtieneLosPagos(List<Pago> pagosBuscados, Integer cantidadEsperada) {
        assertThat(pagosBuscados).isNotNull();
        assertThat(pagosBuscados).hasSize(cantidadEsperada);
    }

    private List<Pago> whenBuscaPagos() {
        return operadorDao.buscarPagos();
    }

    private Pago givenExisteUnPago() {
        Pago pago = new Pago();
        getSession().save(pago);
        return pago;
    }

    private void thenElPagoEstaAprobado(Pago pago) {
        assertThat(pago).isNotNull();
        assertThat(pago.getEstado().getId()).isEqualTo(Estado.APROBADO.getVal());
    }

    private void whenAprueboUnPago(Pago pago) {
        operadorDao.aprobarPago(pago);
    }

    private Pago givenPagoPendiente() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.PENDIENTE.getVal()));
        getSession().save(pago);
        return pago;
    }
}
