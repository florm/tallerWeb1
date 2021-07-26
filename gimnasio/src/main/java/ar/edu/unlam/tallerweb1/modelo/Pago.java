package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Pago {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha;
	private Double importe;
	
	
	@ManyToOne
	private Socio socio;

	@ManyToOne
	private Pase pase;

	public Pase getPase() {
		return pase;
	}

	public void setPase(Pase pase) {
		this.pase = pase;
	}

	private Date fechaVencimiento;

	@ManyToOne
	private EstadoPago estado;

	public EstadoPago getEstado() {
		return estado;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}


    public void setEstado(EstadoPago estado) {
		this.estado = estado;
    }
}
