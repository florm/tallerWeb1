package helpers;

public class Pager {

    private final Integer itemsTotales;
    private final Integer paginaActual;
    private final Integer paginasTotales;
    private final Integer primeraPagina;
    private final Integer ultimaPagina;

    public Pager(Integer itemsTotales, Integer numeroPagina, Integer registrosPorPagina) {
        Integer paginasTotales = (int)Math.ceil((double) itemsTotales / registrosPorPagina);
        Integer paginaActual = (paginasTotales <= numeroPagina ? paginasTotales : numeroPagina);
        Integer primeraPagina = 1;
        Integer ultimaPagina = paginasTotales;
        
        this.itemsTotales = itemsTotales;
        this.paginaActual = paginaActual;
        this.paginasTotales = paginasTotales;
        this.primeraPagina = primeraPagina;
        this.ultimaPagina = paginasTotales;

    }

    public Integer getItemsTotales() {
        return itemsTotales;
    }

    public Integer getPaginaActual() {
        return paginaActual;
    }

    public Integer getPaginasTotales() {
        return paginasTotales;
    }

    public Integer getPrimeraPagina() {
        return primeraPagina;
    }

    public Integer getUltimaPagina() {
        return ultimaPagina;
    }
}
