package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Pase;

public interface PaseDao {
	List<Pase> listarPases();
	public Pase buscarPase(Long idPase);
}
