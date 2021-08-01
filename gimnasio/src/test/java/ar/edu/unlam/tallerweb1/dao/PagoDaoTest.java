package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import com.google.j2objc.annotations.AutoreleasePool;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class PagoDaoTest extends SpringTest {

    @Autowired
    private PagoDao pagoDao;

    @Test
    @Transactional
    @Rollback
    public void buscarPagoNuevoDeberiaTraerSoloLosPagosNuevos(){
        Pago pago1 = givenExisteUnPago(true);
        Pago pago2 = givenExisteUnPago(true);
        Pago pago3 = givenExisteUnPago(false);
        Integer cantidadEsperada = 2;
        List<Pago> pagosNuevos = whenBuscoPagosNuevos();
        thenLosPagosSonNuevos(pagosNuevos, 2);
    }

    private Pago givenExisteUnPago(Boolean esNuevo) {
        Pago pago = new Pago();
        pago.setNuevo(esNuevo);
        getSession().save(pago);
        return pago;
    }

    private List<Pago> whenBuscoPagosNuevos() {
        return pagoDao.buscarPagosNuevos();
    }

    private void thenLosPagosSonNuevos(List<Pago> pagosNuevos, Integer cantidadEsperada) {
        assertThat(pagosNuevos).isNotNull();
        assertThat(pagosNuevos).hasSize(cantidadEsperada);
    }
}
