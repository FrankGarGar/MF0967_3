<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/admin/includes/cabecera.jsp"%>
<div class="fondo">
	<div class="form-log">
		<div class="contenedor-contact">
			<form id="form-log" action="login" method="POST" autocomplete="off">
				<i class="fas fa-user-secret"></i> <input type="text" name="usuario"
					id="usuario" placeholder="Usuario" 
					onfocus="this.placeholder = ''"
					onblur="this.placeholder = 'Usuario'" />
					<span class="error">${usuario.errorUser}</span>
				<div class="clearfix"></div>
				<i class="fas fa-key"></i> <input type="password" name="password"
					id="password" placeholder="Contraseña" 
					onfocus="this.placeholder = ''"
					onblur="this.placeholder = 'Contaseña'">
					<span class="error">${usuario.errorPass}</span>
				<div class="clearfix"></div>
				<input type="submit" value="Ingresar">
				<span class="error">${usuario.errorAll}</span>
			</form>
		</div>
	</div>
</div>
