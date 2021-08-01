package helpers;

import javax.persistence.criteria.CriteriaBuilder;

public class Paginado {

    private Integer numeroPagina;
    private Integer registrosPorPagina;
    private Integer registrosTotales;
    private final Integer NUMERO_PAGINA_DEFAULT = 1;
    private final Integer REGISTROS_POR_PAGINA_DEFAULT = 5;



    public void setNumeroPagina(Integer numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    public Integer getRegistrosPorPagina() {
        return registrosPorPagina;
    }

    public void setRegistrosPorPagina(Integer registrosPorPagina) {
        this.registrosPorPagina = registrosPorPagina;
    }

    public Integer getRegistrosTotales() {
        return registrosTotales;
    }

    public void setRegistrosTotales(Integer registrosTotales) {
        this.registrosTotales = registrosTotales;
    }

    public static Paginado getPaginado(Paginado paginado, Integer totalRegistros) {
        paginado.setRegistrosTotales(totalRegistros);
        if(paginado.getRegistrosPorPagina() == null){
            paginado.setRegistrosPorPagina(paginado.REGISTROS_POR_PAGINA_DEFAULT);
        }
        if(paginado.getNumeroPagina() == null){
            paginado.setNumeroPagina(paginado.NUMERO_PAGINA_DEFAULT);
        }
        return paginado;
    }
}
