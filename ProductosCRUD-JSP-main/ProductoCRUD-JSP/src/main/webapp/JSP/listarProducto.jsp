<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Productos</title>
</head>
<body>
    <h2>Lista de Productos</h2>
    
    <form  action="/ProductoCRUD-JSP/ListarProducto" method="get">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Peso</th>
					<th>Stock</th>
					<th>Acciones</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="producto" items="${PRODUCTOS}">
					<tr>
						<td>${producto.id}</td>
						<td>${producto.nombre}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.peso}</td>
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
		
		<a href="index.jsp">volver</a>
		
	</form>
</body>
</html>
