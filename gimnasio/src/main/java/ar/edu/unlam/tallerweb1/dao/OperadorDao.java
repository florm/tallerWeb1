package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import helpers.Paginado;

public interface OperadorDao {

	List<Operador> listarOperadores();

	void eliminar(Long idOperador);

	Operador getById(Long idOperador);

	void modificarOperador(Operador operador);

	void registrar(Operador operador, Usuario usuario);
	
	Operador buscarOperador(Usuario usuario);

    void aprobarPago(Pago pago);

	List<Pago> buscarPagos();

	List<Pago> getNovedades();

	void marcarVisto();

	Integer buscarPagosCount();
}
