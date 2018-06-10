package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSocio;
	private String dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String mail;
	private String pais;
	
	@ManyToOne
	private Provincia provincia;
	
	@ManyToOne
	private Ciudad ciudad;
	
	private String domicilioCalle;
	private String domicilioNumero;
	private String domicilioDepto;
	
	@ManyToOne
	private Sucursal sucursal;
	
	@ManyToOne
	private Pase pase;
	
	//ManyToMany con SucursalActividad
	@ManyToMany(mappedBy = "socios")
    private Set<SucursalActividad> actividadesEnSucursal = new HashSet<>();
	//
	
	public Long getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(Long id) {
		this.idSocio = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getDomicilioCalle() {
		return domicilioCalle;
	}

	public void setDomicilioCalle(String domicilioCalle) {
		this.domicilioCalle = domicilioCalle;
	}

	public String getDomicilioNumero() {
		return domicilioNumero;
	}

	public void setDomicilioNumero(String domicilioNumero) {
		this.domicilioNumero = domicilioNumero;
	}

	public String getDomicilioDepto() {
		return domicilioDepto;
	}

	public void setDomicilioDepto(String domicilioDepto) {
		this.domicilioDepto = domicilioDepto;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Pase getPase() {
		return pase;
	}

	public void setPase(Pase pase) {
		this.pase = pase;
	}

	public Set<SucursalActividad> getActividadesEnSucursal() {
		return actividadesEnSucursal;
	}

	public void setActividadesEnSucursal(Set<SucursalActividad> actividadesEnSucursal) {
		this.actividadesEnSucursal = actividadesEnSucursal;
	}
	
	
	
}