package ar.edu.unlam.tallerweb1.modelo;

public enum Estado {
    APROBADO(1L),
    PENDIENTE(2L),
    RECHAZADO(3L);

    private Long numVal;

    Estado(Long numVal) {
        this.numVal = numVal;
    }

    public Long getVal() {
        return numVal;
    }
}
