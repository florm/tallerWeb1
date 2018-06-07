package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String pais;
	private String provincia;
	private String ciudad;
	private String calle;
	private String numcalle;
	
	@OneToMany
	private List<Actividad> listaActividades;
	
	@OneToMany
	private List<Socio> listaSocios;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumcalle() {
		return numcalle;
	}
	public void setNumcalle(String numcalle) {
		this.numcalle = numcalle;
	}
	public List<Actividad> getListaActividades() {
		return listaActividades;
	}
	public void setListaActividades(List<Actividad> listaAtividades) {
		this.listaActividades = listaAtividades;
	}
	public List<Socio> getListaSocios() {
		return listaSocios;
	}
	public void setListaSocios(List<Socio> listaSocios) {
		this.listaSocios = listaSocios;
	}
	
	
	
}