<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="pagination pull-right">
    <c:choose>
        <c:when test="${paginado.paginaActual == 1}">
            <li><a class="page-link prev isDisabled" href="#"><i class="fa fa-chevron-left"></i></a></li>
        </c:when>
        <c:otherwise>
            <li><a class="page-link prev" href="#"><i class="fa fa-chevron-left"></i></a></li>
        </c:otherwise>
    </c:choose>

    <c:forEach begin="1" step="1" end="${paginado.paginasTotales}" varStatus="loop">
        <c:choose>
            <c:when test="${paginado.paginaActual == loop.index}">
                <li class="paginate_button page-item active">
                    <a numeroDePagina="${loop.index}" class= "page-link" href="<c:url value='?numeroPagina=${loop.index}'/>">${loop.index}</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="paginate_button page-item">
                    <a class= "page-link" href="<c:url value='?numeroPagina=${loop.index}'/>">${loop.index}</a>
                </li>
            </c:otherwise>
        </c:choose>

    </c:forEach>
    <c:choose>
        <c:when test="${paginado.paginaActual == paginado.paginasTotales}">
            <li><a class="page-link next isDisabled" href="#"><i class="fa fa-chevron-right"></i></a></li>
        </c:when>
        <c:otherwise>
            <li><a class="page-link next" href="#"><i class="fa fa-chevron-right"></i></a></li>
        </c:otherwise>
    </c:choose>

</ul>
