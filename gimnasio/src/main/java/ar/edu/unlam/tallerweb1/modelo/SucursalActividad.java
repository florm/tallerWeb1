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
	private Date dia;
	private Date horaDesde;
	private Date horaHasta;
	private Integer cupo;
	
	@ManyToOne
	private Actividad actividad;
	
	@ManyToOne 
	private Sucursal sucursal;
	
	//Falta Relacion a Profesor
	
	//ManyToMany con Socio
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "SocioSucursalActividad", 
        joinColumns = @JoinColumn(name = "idSucursalActividad") , //idActividadSucursal
        inverseJoinColumns = @JoinColumn(name = "idSocio") //idSocio
    )
	private Set<Socio> socios = new HashSet<>();
	//
	
	public Long getId() {
		return idSucursalActividad;
	}
	public void setId(Long id) {
		this.idSucursalActividad = id;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getHoraDesde() {
		return horaDesde;
	}
	public Date getHoraHasta() {
		return horaHasta;
	}
	public void setHoraDesde(Date horaDesde) {
		this.horaDesde = horaDesde;
	}
	public void setHoraHasta(Date horaHasta) {
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
	
	

}