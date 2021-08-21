<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <%@include file="menuAdministrador.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-4 text-center animate-box fadeInUp animated-fast mx-auto">

                <div class="modal-body p-5">

                    <form:form class="text-center" method="post" action="modificarActividadProc"
                               modelAttribute="actividad">
                        <div class="form-group input-size">
                            <form:input path="nombre" type="text" class="form-control"
                                        value="${actividadBdd.getNombre()}"></form:input>
                        </div>
                        <div class="form-group input-size">
                            <textarea id="descripcion" name="descripcion" rows="10" class="form-control">${actividadBdd.getDescripcion()}</textarea>
                        </div>
                        <button type="submit" id="btn-modificar" value="modificar" class="btn btn-primary">Modificar
                        </button>

                    </form:form>
                </div>

            </div>
        </div>
    </div>

</div>
<%@include file="archivosjs.jsp"%>
</body>

</html>

<body>

</body>
</html>