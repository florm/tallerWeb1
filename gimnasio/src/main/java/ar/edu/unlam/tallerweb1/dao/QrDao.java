package ar.edu.unlam.tallerweb1.dao;

import java.util.Date;

import ar.edu.unlam.tallerweb1.modelo.Token;



public interface QrDao {

	void guardarToken(Long idSocio, Date fechaVencimiento, Integer token);

	Token buscarToken(Integer numero, Long idSocio);

}
