<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/admin/includes/cabecera.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/vistas/admin/includes/menu.jsp"%>

<div class="contenedor">
	<c:if test="${opcion != null}">
	<h1>listado de ${opcion}</h1>
		<h3>
			<a href="#" data-toggle="modal" data-target="#myModal" id="sfa"><i
				class="fas fa-plus fa-2x"></i></a>
		</h3>
	</c:if>
	<c:choose>
		<c:when test="${opcion == 'usuarios'}">
			<table class="usuarios-table">
				<thead>
					<tr>
						<th>Usuario</th>
						<th>Password</th>
						<th>Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarios}" var="item">
						<tr>
							<td name2="usuario">${item.usuario}</td>
							<td name2="password">${item.password}</td>
							<td><a href="#" class="btn btn-warning" onclick="editRegistro(event,this)"
								data-toggle="modal" data-target="#myModalEdit"><i
									class="fas fa-edit"></i></a> <a href="#" class="btn btn-danger"
								onclick="deleteregistro(event,this);"> <i
									class="fas fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="modal" id="myModal">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Agregar Usuario</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form class="form-add" id="formadd">
								<div>
									<label for="usuario">Usuario</label> <input type="text"
										name="usuario" id="usuario" required />
								</div>
								<div>
									<label for="password">Password</label> <input type="password"
										name="password" id="password" required />
								</div>
								

								<input type="submit" class="btn btn-primary" value="Guardar" />

							</form>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>
			<div class="modal" id="myModalEdit">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Agregar Usuario</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form class="form-edit" id="formedit">

								<div>
									<label for="usuario">Usuario</label> <input type="text"
										name="usuario" id="usuario2" required />
								</div>
								<div>
									<label for="password">Password</label> <input type="password"
										name="password" id="password2" required />
								</div>
								
									<input type="submit" class="btn btn-primary" value="Guardar" />
								
							</form>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${opcion == 'productos'}">
			<table class="usuarios-table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Codigo</th>
						<th>Precio</th>
						<th>Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productos}" var="item">
						<tr>
							<td name2="id">${item.id}</td>
							<td name2="nombre">${item.nombre}</td>
							<td name2="codigo">${item.codigo}</td>
							<td name2="precio">${item.precio}</td>
							<td><a href="#" class="btn btn-warning" onclick="editRegistro(event,this)"
								data-toggle="modal" data-target="#myModalEdit"><i
									class="fas fa-edit"></i></a> <a href="#" class="btn btn-danger"
								onclick="deleteregistro(event,this);"> <i
									class="fas fa-trash"></i></a></td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
			<div class="modal" id="myModal">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Agregar Producto</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form class="form-add" id="formadd">

								<div>
									<label for="nombre">Nombre</label> <input type="text"
										name="nombre" id="nombre" required />
								</div>
								<div>
									<label for="codigo">Código</label> <input type="text"
										name="codigo" id="codigo" required />
								</div>
								<div>
									<label for="precio">Precio</label> <input type="number"
										placeholder="100,25" step=0.01 name="precio" id="precio"
										required />
								</div>
								
									<input type="submit" class="btn btn-primary" value="Guardar" />

							</form>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>
			<div class="modal" id="myModalEdit">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Editar Producto</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<form class="form-add" id="formedit">
								<div>
									<input type="hidden" id="id2" name="id">
								</div>
								<div>
									<label for="nombre">Nombre</label> <input type="text"
										name="nombre" id="nombre2" required />
								</div>
								<div>
									<label for="codigo">Código</label> <input type="text"
										name="codigo" id="codigo2" required />
								</div>
								<div>
									<label for="precio">Precio</label> <input type="number"
										placeholder="100,25" step=0.01 name="precio" id="precio2"
										required />
								</div>
								

								<input type="submit" class="btn btn-primary" value="Editar" />

							</form>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
						</div>

					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="opciones">
				<ul>
					<li class="opcion"><a href="admin/inicio?opcion=usuarios"><i class="fas fa-users"></i> Listar Usuarios</a></li>
					<li class="opcion"><a href="admin/inicio?opcion=productos"><i class="fas fa-boxes"></i> Listar Productos</a></li>
					
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<!-- The Modal -->
<div id="opcion" data-op="${opcion}"></div>


<%@ include file="/WEB-INF/vistas/admin/includes/pie.jsp"%>
</body>
</html>