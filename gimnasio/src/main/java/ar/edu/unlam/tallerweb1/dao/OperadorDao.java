package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Operador;

public interface OperadorDao {

	List<Operador> listarOperadores();

	void eliminar(Long idOperador);

	Operador getById(Long idOperador);

	void modificarOperador(Operador operador);

	void registrar(Operador operador);
		
}
