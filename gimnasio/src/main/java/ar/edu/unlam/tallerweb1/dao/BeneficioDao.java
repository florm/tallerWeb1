package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Beneficio;

public interface BeneficioDao {
	List<Beneficio> listarBeneficios(Long idPase);
	
}
