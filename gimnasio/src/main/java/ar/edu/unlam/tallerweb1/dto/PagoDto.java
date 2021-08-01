package ar.edu.unlam.tallerweb1.dto;

import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Pase;
import ar.edu.unlam.tallerweb1.modelo.Socio;
import helpers.UtilidadesFecha;

import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Locale;

public class PagoDto {

    private Long id;
    private String fecha;
    private Double importe;
    private String socio;
    private String estado;
    private Long estadoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public PagoDto(){}
    public PagoDto(Pago pago){
        this.id = pago.getId();
        this.fecha = UtilidadesFecha.parsearFecha(pago.getFecha());
        this.importe = pago.getImporte();
        this.socio = pago.getSocio().getNombre();
        this.estado = pago.getEstado().getNombre().toLowerCase(Locale.ROOT);
        this.estadoId = pago.getEstado().getId();
    }
}
