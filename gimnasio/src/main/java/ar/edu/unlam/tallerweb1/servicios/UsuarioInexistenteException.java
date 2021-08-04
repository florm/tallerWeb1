package ar.edu.unlam.tallerweb1.servicios;

public class UsuarioInexistenteException extends RuntimeException {

    private String mensaje = "No existe el usuario";

    @Override
    public String getMessage() {
        return mensaje;
    }
}
