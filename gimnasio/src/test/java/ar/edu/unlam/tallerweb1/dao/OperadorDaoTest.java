package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import helpers.Paginado;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @Test
    @Transactional
    @Rollback
    public void losPagosDebenMostrarseConOrdenamientoDecrecientePorFecha() throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Pago pago1 = givenExistenPagoConFecha(format.parse("26/10/2021"));
        Pago pago2 = givenExistenPagoConFecha(format.parse("26/10/2020"));
        Pago pago3 = givenExistenPagoConFecha(format.parse("26/10/2022"));
        Pago pago4 = givenExistenPagoConFecha(format.parse("26/09/2022"));
        List<Pago> pagosBuscados = whenElOperadorBuscaPagos();
        thenSeObtienenPagosDecrecientesPorFecha(pagosBuscados, pago3);

    }

    private List<Pago> whenElOperadorBuscaPagos() {
        return operadorDao.buscarPagos();
    }

    private void thenSeObtienenPagosDecrecientesPorFecha(List<Pago> pagosBuscados, Pago primerPago) {
        assertThat(pagosBuscados.size()).isGreaterThan(0);
        assertThat(pagosBuscados.get(0)).isEqualTo(primerPago);

    }

    private Pago givenExistenPagoConFecha(Date fecha) {
        Pago pago = new Pago();
        pago.setFecha(fecha);
        getSession().save(pago);
        return pago;

    }



    @Test
    @Transactional @Rollback
    public void cuandoElOperadorBuscaNovedadesSeDevuelvenPagosNoVistos(){
        givenExisteUnPago(true);
        givenExisteUnPago(true);
        givenExisteUnPago(false);
        List<Pago> pagos = whenBuscaNovedades();
        Integer cantidadEsperada = 2;
        thenObtienePagosDeHaceMenosDeCincoMinutos(pagos, cantidadEsperada);
    }

    private void givenExisteUnPago(boolean esNuevo) {
        Pago pago = new Pago();
        pago.setNuevo(esNuevo);
        getSession().save(pago);

    }

    private void thenObtienePagosDeHaceMenosDeCincoMinutos(List<Pago> pagos, Integer cantidadEsperada) {
        assertThat(pagos).isNotNull();
        assertThat(pagos).hasSize(cantidadEsperada);
    }

    private List<Pago> whenBuscaNovedades() {
        return operadorDao.getNovedades();
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
