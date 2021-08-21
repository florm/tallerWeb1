package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import helpers.Paginado;

public interface ServicioOperador {
	
	List<Operador> listarOperadores(Paginado paginado);
	void eliminar(Long idOperador);
	Operador getById(Long idOperador);
	void modificar(Operador operador);
	void registrar(Operador operador);
	Operador buscarOperador(Usuario usuario);
	void notificarPago();
    void aprobarPago(Pago pago);
	List<Pago> buscarPagos(Paginado paginado);

    List<Pago> getNovedades();

    void marcarVisto();

    Integer buscarPagosCount();

    Integer listarOperadoresCount();
}
