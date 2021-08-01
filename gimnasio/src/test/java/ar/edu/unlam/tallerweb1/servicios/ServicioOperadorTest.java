package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.OperadorDao;
import ar.edu.unlam.tallerweb1.dao.PagoDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import helpers.Paginado;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.*;

public class ServicioOperadorTest {

    private ServicioOperadorImpl servicioOperador;
    private UsuarioDao usuarioDao;
    private SucursalDao sucursalDao;
    private PagoDao pagoDao;

    private OperadorDao operadorDao;

    @Before
    public void init(){
        operadorDao = mock(OperadorDao.class);
        usuarioDao = mock(UsuarioDao.class);
        sucursalDao = mock(SucursalDao.class);
        pagoDao = mock(PagoDao.class);
        servicioOperador = new ServicioOperadorImpl(operadorDao, usuarioDao, sucursalDao, pagoDao);
    }

    @Test
    public void elOperadorPuedeBuscarTodosLosPagos(){
        Pago pago1 = givenExistePago();
        Pago pago2 = givenExistePago();
        Pago pago3 = givenExistePago();
        List<Pago> pagosBuscados = whenElOperadorBuscaPagos();
        thenSeBuscanLosPagos();
    }

    @Test @Transactional
    @Rollback
    public void cuandoSeIndicaNumeroDePaginaLosPagosSonLosDeEsaPagina(){
        Pago pago1 = givenExistenPago();
        Pago pago2 = givenExistenPago();
        Pago pago3 = givenExistenPago();
        Pago pago4 = givenExistenPago();
        Pago pago5 = givenExistenPago();
        Pago pago6 = givenExistenPago();
        Pago pago7 = givenExistenPago();
        Pago pago8 = givenExistenPago();
        Pago pago9 = givenExistenPago();
        Pago pago10 = givenExistenPago();
        Pago pago11 = givenExistenPago();
        Pago pago12 = givenExistenPago();
        List<Pago> pagos = new ArrayList<>();
        pagos.add(pago1);
        pagos.add(pago2);
        pagos.add(pago3);
        pagos.add(pago4);
        pagos.add(pago5);
        pagos.add(pago6);
        pagos.add(pago7);
        pagos.add(pago8);
        pagos.add(pago9);
        pagos.add(pago10);
        pagos.add(pago11);
        pagos.add(pago12);
        Paginado paginado = new Paginado();
        paginado.setNumeroPagina(2);
        paginado.setRegistrosPorPagina(5);
        List<Pago> pagosBuscados = whenElOperadorBuscaPagos(paginado, pagos);
        List<Pago> pagosEsperados = new ArrayList<>();
        pagosEsperados.add(pago6);
        pagosEsperados.add(pago7);
        pagosEsperados.add(pago8);
        pagosEsperados.add(pago9);
        pagosEsperados.add(pago10);
        thenSeBuscanLosPagosDeLaPagina(pagosBuscados,pagosEsperados, pago1, pago11);
    }



    @Test
    @Transactional
    @Rollback
    public void sePuedeObtenerLaCantidadDePagosTotales(){
        Pago pago1 = givenExistenPago();
        Pago pago2 = givenExistenPago();
        Pago pago3 = givenExistenPago();
        Pago pago4 = givenExistenPago();
        Pago pago5 = givenExistenPago();
        Pago pago6 = givenExistenPago();
        Pago pago7 = givenExistenPago();
        Pago pago8 = givenExistenPago();
        Pago pago9 = givenExistenPago();
        Pago pago10 = givenExistenPago();
        Pago pago11 = givenExistenPago();
        Pago pago12 = givenExistenPago();
        Integer cantidadEsperada = 12;
        Integer cantidadDePagos = whenElOperadorBuscaCantidadDePagos(cantidadEsperada);
        thenSeObtieneLaCantidadDePagos(cantidadDePagos, cantidadEsperada);

    }

    private void thenSeObtieneLaCantidadDePagos(Integer cantidadDePagos, Integer cantidadEsperada) {
        assertThat(cantidadDePagos).isEqualTo(cantidadEsperada);
    }

    private Integer whenElOperadorBuscaCantidadDePagos(Integer cantidadEsperada) {
        when(operadorDao.buscarPagosCount()).thenReturn(cantidadEsperada);
        return servicioOperador.buscarPagosCount();
    }


    private Pago givenExistenPago() {
        Pago pago = new Pago();
        return pago;
    }

    private void thenSeBuscanLosPagosDeLaPagina(List<Pago> pagosBuscados, List<Pago> pagosEsperados, Pago pago1, Pago pago11) {
        assertThat(pagosBuscados.size()).isEqualTo(pagosEsperados.size());
        assertThat(pagosBuscados).containsExactlyElementsOf(pagosEsperados);
        assertThat(pagosBuscados).doesNotContain(pago1);
        assertThat(pagosBuscados).doesNotContain(pago11);
    }

    private List<Pago> whenElOperadorBuscaPagos(Paginado paginado, List<Pago> pagos) {
        when(operadorDao.buscarPagos()).thenReturn(pagos);
        return servicioOperador.buscarPagos(paginado);
    }

    private void thenSeBuscanLosPagos() {
        verify(operadorDao, times(1)).buscarPagos();
    }

    private List<Pago> whenElOperadorBuscaPagos() {
        return servicioOperador.buscarPagos(null);
    }

    private Pago givenExistePago() {
        Pago pago = new Pago();
        return pago;
    }

    @Test
    public void sePuedeAprobarUnPagoPendiente(){
        Pago pago = givenExisteUnPagoPendiente();
        whenAprueboUnPagoPendiente(pago);
        thenElPagoSeAprueba(pago);
    }

    @Test(expected = PagoYaAprobadoException.class)
    public void noSePuedeAprobarUnPagoAprobado(){
        Pago pago = givenExisteUnPagoAprobado();
        whenAprueboElPago(pago);
        thenNoSePuedeAprobar(pago);
    }

    @Test(expected = PagoYaRechazadoException.class)
    public void noSePuedeAprobarUnPagoRechazado(){
        Pago pago = givenExisteUnPagorechazado();
        whenAprueboElPago(pago);
        thenNoSePuedeAprobar(pago);
    }

    @Test(expected = NoExistePagoException.class)
    public void noSePuedeAprobarUnPagoQueNoExiste(){
        givenNoExisteUnPago();
        whenAprueboElPago(null);
        thenNoSePuedeAprobar(null);
    }


    @Test
    public void cuandoElOperadorPideNovedadesDePagoSeDevuelveUnaListaDePagos(){
        givenExisteUnOperador();
        givenExisteUnPagoDeLosUltimosCincoMinutos();
        List<Pago> novedadesDePagos = whenBuscoNovedades();
        thenEncuentroPagosDeLosUltimosMinutos(novedadesDePagos);
    }

    @Test
    public void cuandoElOperadorVeLosPagosSeMarcanComoVistos(){
        Pago pago1 = givenExistenPago(true);
        Pago pago2 = givenExistenPago(true);
        Pago pago3 = givenExistenPago(false);
        List<Pago> pagos = new ArrayList<>();
        pagos.add(pago1);
        pagos.add(pago2);
        givenTengoListaDePagosNuevos(pagos);
        whenSeMarcanVistos();
        thenLosPagosNoSonNuevos(pagos);

    }

    private void givenTengoListaDePagosNuevos(List<Pago> pagos) {
        when(pagoDao.buscarPagosNuevos()).thenReturn(pagos);
    }

    private void thenLosPagosNoSonNuevos(List<Pago> pagos) {
        pagos.forEach(p-> assertThat(p.getNuevo()).isFalse());
        for (Pago pago: pagos
             ) {
            verify(pagoDao, times(1)).actualizarPago(pago);
        }

    }

    private void whenSeMarcanVistos() {
        servicioOperador.marcarVisto();
    }

    private Pago givenExistenPago(Boolean esNuevo) {
        Pago pago = new Pago();
        pago.setNuevo(esNuevo);
        return pago;
    }

    private void givenExisteUnOperador() {
    }

    private void givenExisteUnPagoDeLosUltimosCincoMinutos() {
        Pago pago = new Pago();
        pago.setFecha(new Date(Calendar.getInstance().getTimeInMillis() - 120000));
    }

    private List<Pago> whenBuscoNovedades() {
        return servicioOperador.getNovedades();
    }

    private void thenEncuentroPagosDeLosUltimosMinutos(List<Pago> pagos) {
        verify(operadorDao, times(1)).getNovedades();
    }

    private void givenNoExisteUnPago() {
    }

    private Pago givenExisteUnPagorechazado() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.RECHAZADO.getVal()));
        return pago;
    }

    private void thenNoSePuedeAprobar(Pago pago) {
        verify(operadorDao, times(0)).aprobarPago(pago);
    }

    private void whenAprueboElPago(Pago pago) {
        servicioOperador.aprobarPago(pago);
    }

    private Pago givenExisteUnPagoAprobado() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.APROBADO.getVal()));
        return pago;
    }

    private Pago givenExisteUnPagoPendiente() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.PENDIENTE.getVal()));
        return pago;
    }

    private void whenAprueboUnPagoPendiente(Pago pago) {
        servicioOperador.aprobarPago(pago);
    }

    private void thenElPagoSeAprueba(Pago pago) {
        verify(operadorDao, times(1)).aprobarPago(pago);
    }

}
