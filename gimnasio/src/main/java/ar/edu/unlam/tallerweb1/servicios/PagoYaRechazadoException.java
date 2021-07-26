package ar.edu.unlam.tallerweb1.servicios;

public class PagoYaRechazadoException extends RuntimeException {

    private final String message = "El pago ya se encuentra rechazado";

    @Override
    public String getMessage() {
        return message;
    }
}
