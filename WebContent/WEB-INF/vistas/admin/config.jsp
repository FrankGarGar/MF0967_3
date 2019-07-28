<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/admin/includes/cabecera.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/vistas/admin/includes/menu.jsp"%>
<main>
	<div class="contenedor">
		<h1>Configuración</h1>
		<c:if test="${error!=null }">
			<div class="alert-box failure">${error}</div>
		</c:if>
		<c:if test="${success!=null }">
			<div class="alert-box success">${success}</div>
		</c:if>
		<div class="opciones config">
		<ul>
			<li class="opcion"><a href="admin/config?opcion=exportar" id="exportar">Exportar Colecciones</a></li>
			<li class="opcion"><a href="admin/config?opcion=borrar" id="borrar">Borrar todos los datos</a></li>
			<li class="opcion imp">
				<h2>Importar Colecciones</h2>
				<form  id="form-import" method="POST" enctype="multipart/form-data">
				<form method="post" action="admin/config" enctype="multipart/form-data">
					<div>
						<label for="archivo"></label>
						<input type="file" name="archivo" id="archivo" multiple required>
					</div>
					<input type="hidden" name="opcion" value="importar">
					<input type="submit" class="btn btn-success" value="Importar">
				</form>
			</li>
		</ul>
		</div>
		
	</div>
</main>
<script type="text/javascript">
	  $( "div.failure" ).fadeIn( 300 ).delay( 1500 ).fadeOut( 400 );
</script>
<%@ include file="/WEB-INF/vistas/admin/includes/pie.jsp"%>