package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.OperadorDao;
import ar.edu.unlam.tallerweb1.dao.SucursalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

import static org.mockito.Mockito.*;

public class ServicioOperadorTest {

    private ServicioOperadorImpl servicioOperador;
    private UsuarioDao usuarioDao;
    private SucursalDao sucursalDao;

    private OperadorDao operadorDao;

    @Before
    public void init(){
        operadorDao = mock(OperadorDao.class);
        usuarioDao = mock(UsuarioDao.class);
        sucursalDao = mock(SucursalDao.class);
        servicioOperador = new ServicioOperadorImpl(operadorDao, usuarioDao, sucursalDao);
    }

    @Test
    public void elOperadorPuedeBuscarTodosLosPagos(){
        Pago pago1 = givenExistePago();
        Pago pago2 = givenExistePago();
        Pago pago3 = givenExistePago();
        List<Pago> pagosBuscados = whenElOperadorBuscaPagos();
        thenSeBuscanLosPagos();
    }

    private void thenSeBuscanLosPagos() {
        verify(operadorDao, times(1)).buscarPagos();
    }

    private List<Pago> whenElOperadorBuscaPagos() {
        return servicioOperador.buscarPagos();
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
