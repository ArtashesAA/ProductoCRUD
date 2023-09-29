<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado Productos</title>
</head>
<body>
	<h1>Listado de Productos</h1>
	<ul>
	<li><a href="CrearProducto">Nuevo</a></li>

</ul>
	<table>
		<thead>
			<th>ID</th>
			<th>Nombre</th>
			<th>Descripcion</th>
			<th>Peso</th>
			<th>Stock</th>
		</thead>
		<tbody>
			<c:forEach var="producto" items="${PERSONAS}">
				<tr>
					<td>${producto.id}</td>
					<td>${producto.nombre}</td>
					<td>${producto.descripcion}</td>
					<td><fmt:formatDate value="${producto.peso}"
							pattern="dd-MM-yyyy" /></td>
					<td>${producto.stock}</td>

					<td><jsp:include page="elementos/botonModificar.jsp">
							<jsp:param name="id" value="${producto.id}" />
						</jsp:include> <jsp:include page="elementos/botonEliminar.jsp">
							<jsp:param name="id" value="${producto.id}" />
						</jsp:include></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</body>
</html>