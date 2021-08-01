package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Estado;
import ar.edu.unlam.tallerweb1.modelo.EstadoPago;
import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.servicios.*;
import helpers.Paginado;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorOperadorTest {

    private ServicioOperador servicioOperador = mock(ServicioOperador.class);
    private ServicioPago servicioPago = mock(ServicioPago.class);
    private ControladorOperador controladorOperador = new ControladorOperador(servicioOperador, servicioPago);
    private final String REDIRECT = "redirect:/ver-pagos";

    private ModelAndView mav = new ModelAndView();

    @Test
    public void elOperadorDeLaSucursalPuedeVerPagosDeSocios(){
        givenExisteSocioEnLaSucursalDelOperador();
        whenElOperadorIngresaAVerPagos(null);
        thenSeMuestranPagos();

    }

    @Test
    public void siExisteUnPaginadoSePuedePaginar(){
        Paginado paginado = givenExisteUnPaginado();
        whenElOperadorIngresaAVerPagos(paginado);
        thenSeDevuelveUnPaginado(paginado);
    }

    private void thenSeDevuelveUnPaginado(Paginado paginado) {
        assertThat(mav.getModel().get("paginado")).isNotNull();
        Paginado paginadoModel = (Paginado )mav.getModel().get("paginado");
        assertThat(paginadoModel.getRegistrosPorPagina()).isEqualTo(paginado.getRegistrosPorPagina());
        assertThat(paginadoModel.getNumeroPagina()).isEqualTo(paginado.getNumeroPagina());
        assertThat(paginadoModel.getRegistrosTotales()).isNotNull();
        assertThat(paginadoModel.getRegistrosTotales()).isEqualTo(paginado.getRegistrosTotales());

    }

    private Paginado givenExisteUnPaginado() {
        Paginado paginado = new Paginado();
        paginado.setNumeroPagina(2);
        paginado.setRegistrosPorPagina(10);
        return paginado;
    }

    @Test
    public void elOperadorPuedeAprobarUnPagoPendiente(){
        givenExisteSocioEnLaSucursalDelOperador();
        Pago pago = givenExisteUnPagoPendiente();
        whenElOperadorApruebaUnPago(pago);
        thenElPagoSeEncuentraAprobado();
    }

    @Test
    public void aprobarUnPagoQueNoExisteDeberiaDarmeError(){
        givenNoExistePago();
        whenAprueboUnPagoQueNoExiste();
        thenObtengoUnError();

    }

    @Test
    public void elOperadorNoPuedeAprobarUnPagoYaAprobado(){
        givenExisteSocioEnLaSucursalDelOperador();
        Pago pago = givenExisteUnPagoAprobado();
        whenElOperadorApruebaUnPago(pago);
        thenNoSePuedeAprobarUnAprobado();
    }

    @Test
    public void elOperadorNoPuedeAprobarUnPagoRechazado(){
        givenExisteSocioEnLaSucursalDelOperador();
        Pago pago = givenExisteUnPagoRechazado();
        whenElOperadorApruebaUnPago(pago);
        thenNoSePuedeAprobarUnRechazado();
    }

    @Test
    public void cuandoElOperadorPideNovedadesDePagoSeDevuelveUnaListaDePagos(){
        givenExisteUnOperador();
        givenExistePagosDeLosUltimosCincoMinutos();
        ResponseEntity response = whenBuscoNovedades();
        thenEncuentroPagosDeLosUltimosMinutos(response);
    }


    @Test
    public void cuandoNoHaySesionDeOperadorSePideNovedadesDePagoYNoSeDevuelveNada(){
        givenNoExisteUnOperador();
        givenExistePagosDeLosUltimosCincoMinutos();
        ResponseEntity response = whenBuscoNovedades();
        thenNoEncuentroPagos(response);
    }

    @Test
    public void cuandoNoHayNovedadesElStatusEsNoContent(){
        givenNoExistePagosDeLosUltimosCincoMinutos();
        ResponseEntity response = whenBuscoNovedades();
        thenNoEncuentroPagos(response);
    }

    @Test
    public void cuandoElOperadorEntraAPagosLosPagosDejanDeSerNuevos(){
        givenExisteUnPagoNuevo();
        whenIngresaAVerPagos();
        thenLosPagosDejanDeSerNuevos();
    }

    private void thenLosPagosDejanDeSerNuevos() {
        verify(servicioOperador, times(1)).marcarVisto();
    }

    private void givenExisteUnPagoNuevo() {
    }

    private void whenIngresaAVerPagos() {
        controladorOperador.verPagos(null);
    }

    private void givenNoExistePagosDeLosUltimosCincoMinutos() {
        Pago pago = new Pago();
        pago.setFecha(new Date(Calendar.getInstance().getTimeInMillis()- 360000));

    }

    private void thenNoEncuentroPagos(ResponseEntity response) {
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    private void givenNoExisteUnOperador() {
    }

    private void givenExisteUnOperador() {
        Operador op = new Operador();
    }

    private void givenExistePagosDeLosUltimosCincoMinutos() {
        Pago pago = new Pago();
        pago.setFecha(new Date(Calendar.getInstance().getTimeInMillis()- 120000));

    }

    private ResponseEntity whenBuscoNovedades() {
        HttpServletRequest http = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        when(http.getSession()).thenReturn(session);
        when(http.getSession().getAttribute(anyString())).thenReturn("otro");
        return controladorOperador.getNovedades(http);
    }

    private void thenEncuentroPagosDeLosUltimosMinutos(ResponseEntity response) {
        assertThat(response).isNotNull();
    }

    private void thenNoSePuedeAprobarUnRechazado() {
        assertThat(mav.getViewName()).isEqualTo(REDIRECT);
        assertThat(mav.getModel().get("mensaje")).isEqualTo("El pago ya se encuentra rechazado");
    }

    private Pago givenExisteUnPagoRechazado() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.RECHAZADO.getVal()));
        pago.setId(1L);
        when(servicioPago.getPagoById(pago.getId())).thenReturn(pago);
        doThrow(PagoYaRechazadoException.class)
                .when(servicioOperador).aprobarPago(pago);
        return pago;
    }

    private void givenExisteSocioEnLaSucursalDelOperador() {
    }

    private void whenElOperadorIngresaAVerPagos(Paginado paginado) {
        mav = controladorOperador.verPagos(paginado);
    }

    private void thenSeMuestranPagos() {
        assertThat(mav).isNotNull();
        assertThat(mav.getViewName()).isEqualTo("pagos");
        assertThat(mav.getModel().get("pagos")).isNotNull();

    }

    private Pago givenExisteUnPagoPendiente() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.PENDIENTE.getVal()));
        pago.setId(1L);
        when(servicioPago.getPagoById(pago.getId())).thenReturn(pago);
        return pago;
    }

    private void whenElOperadorApruebaUnPago(Pago pago) {
        mav = controladorOperador.aprobarPago(pago.getId());
    }

    private void thenElPagoSeEncuentraAprobado() {
        assertThat(mav.getViewName()).isEqualTo(REDIRECT);
    }


    private void thenObtengoUnError() {
        assertThat(mav.getViewName()).isEqualTo(REDIRECT);
        assertThat(mav.getModel().get("mensaje")).isEqualTo("Debe seleccionar una pago para aprobar");
    }

    private void whenAprueboUnPagoQueNoExiste() {
        mav = controladorOperador.aprobarPago(null);
    }

    private void givenNoExistePago() {
        doThrow(NoExistePagoException.class)
                .when(servicioOperador).aprobarPago(null);
    }

    private void thenNoSePuedeAprobarUnAprobado() {
        assertThat(mav.getViewName()).isEqualTo(REDIRECT);
        assertThat(mav.getModel().get("mensaje")).isEqualTo("El pago ya se encuentra aprobado");
    }

    private Pago givenExisteUnPagoAprobado() {
        Pago pago = new Pago();
        pago.setEstado(new EstadoPago(Estado.APROBADO.getVal()));
        pago.setId(1L);
        when(servicioPago.getPagoById(pago.getId())).thenReturn(pago);
        doThrow(PagoYaAprobadoException.class)
                .when(servicioOperador).aprobarPago(pago);
        return pago;
    }

}
