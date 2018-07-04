package helpers;

import java.util.ArrayList;

import antlr.collections.List;

public class Coordenadas {
	
	private String nombre;
	private Double lat;
	private Double lng;
	
	public Coordenadas(String nombre, Double lat, Double lng){
		this.nombre = nombre;
		this.lat = lat;
		this.lng = lng;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
	public static String getJson(ArrayList<Coordenadas> coord){
		String resp = new String();
		for (Coordenadas coordenadas : coord) {
			resp += "{ \"nombre\":\"" + coordenadas.nombre + "," + "\"lat\":\"" + coordenadas.lat + "," + "\"nombre\":\"" + coordenadas.lng + "}";
		}
		return resp;
	}
	
	
	
	
}
