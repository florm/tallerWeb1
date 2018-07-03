package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class SucursalActividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSucursalActividad;
	private String dia;
	private String horaDesde;
	private String horaHasta;
	private Integer cupoActual=0;
	private Integer cupo=0;

	@ManyToOne
	private Actividad actividad;

	@ManyToOne
	private Sucursal sucursal;

	@ManyToOne
	private Profesor profesor;

	public Integer getCupoActual() {
		return cupoActual;
	}

	public void setCupoActual(Integer cupoActual) {
		this.cupoActual = cupoActual;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	// ManyToMany con Socio
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "SocioSucursalActividad", joinColumns = @JoinColumn(name = "idSucursalActividad"), // idActividadSucursal
			inverseJoinColumns = @JoinColumn(name = "idSocio") // idSocio
	)
	private Set<Socio> socios = new HashSet<>();
	//

	public Long getIdSucursalActividad() {
		return idSucursalActividad;
	}

	public void setIdSucursalActividad(Long id) {
		this.idSucursalActividad = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHoraDesde() {
		return horaDesde;
	}

	public String getHoraHasta() {
		return horaHasta;
	}

	public void setHoraDesde(String horaDesde) {
		this.horaDesde = horaDesde;
	}

	public void setHoraHasta(String horaHasta) {
		this.horaHasta = horaHasta;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Set<Socio> getSocios() {
		return socios;
	}

	public void setSocios(Set<Socio> socios) {
		this.socios = socios;
	}

}