package ar.edu.unlam.tallerweb1.servicios;

public class PasswordIncorrectaException extends RuntimeException {
    private String mensaje = "La contraseña es incorrecta";

    @Override
    public String getMessage() {
        return mensaje;
    }

}
