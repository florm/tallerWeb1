package helpers;

import java.util.Date;

public class MercadoPago {
	private String titulo;
	private String descripcion;
	private Integer cantidad;
	private Double precio;
	private Long idPase;
	private Long idSocio;
	private Long idDescuento;

	public Long getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(Long idDescuento) {
		this.idDescuento = idDescuento;
	}

	public Long getIdPase() {
		return idPase;
	}

	public void setIdPase(Long idPase) {
		this.idPase = idPase;
	}

	public Long getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Long idSocio) {
		this.idSocio = idSocio;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "{" +
				"titulo='" + titulo + '\'' +
				", descripcion='" + descripcion + '\'' +
				", cantidad=" + cantidad +
				", precio=" + precio +
				", idPase=" + idPase +
				", idSocio=" + idSocio +
				", idDescuento=" + idDescuento +
				'}';
	}
}