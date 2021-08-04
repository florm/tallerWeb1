package ar.edu.unlam.tallerweb1.dto;


import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Socio;

public class SocioDto {

    private Long idSocio;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String mail;
    private String pase;
    private String ciudad;
    private String domicilioCalle;
    private String domicilioNumero;
    private String domicilioDepto;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
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

    public Long getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
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

    public String getPase() {
        return pase;
    }

    public void setPase(String pase) {
        this.pase = pase;
    }

    public SocioDto(Socio socio){
        this.nombre = socio.getNombre();
        this.apellido = socio.getApellido();
        this.dni = socio.getDni();
        this.telefono = socio.getTelefono();
        this.mail = socio.getMail();
        this.pase = socio.getPase().getNombre();
        this.ciudad = socio.getCiudad().getNombre();
        this.domicilioCalle = socio.getDomicilioCalle();
        this.domicilioDepto  = socio.getDomicilioDepto();
        this.domicilioNumero = socio.getDomicilioNumero();
    }
}
