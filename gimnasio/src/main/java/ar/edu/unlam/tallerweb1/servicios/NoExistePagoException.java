package ar.edu.unlam.tallerweb1.servicios;

public class NoExistePagoException extends RuntimeException {
    private final String message = "Debe seleccionar una pago para aprobar";

    @Override
    public String getMessage(){
        return message;
    }
}
