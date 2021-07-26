package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Operador;
import ar.edu.unlam.tallerweb1.modelo.Pago;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioOperador {
	
	List<Operador> listarOperadores();
	void eliminar(Long idOperador);
	Operador getById(Long idOperador);
	void modificar(Operador operador);
	void registrar(Operador operador);
	Operador buscarOperador(Usuario usuario);
	void notificarPago();
    void aprobarPago(Pago pago);
	List<Pago> buscarPagos();
}
