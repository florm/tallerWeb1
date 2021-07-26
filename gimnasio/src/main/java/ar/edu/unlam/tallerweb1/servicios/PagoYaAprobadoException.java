package ar.edu.unlam.tallerweb1.servicios;

public class PagoYaAprobadoException extends RuntimeException {

    private final String message = "El pago ya se encuentra aprobado";

    @Override
    public String getMessage(){
        return message;
    }
}
