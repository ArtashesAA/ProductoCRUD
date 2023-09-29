<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.modelo.Producto"%>

<html>
<head>
<title>Productos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>

	<h1>Productos</h1>
	<div class="container mt-5">
		<div class="row">

			<!-- Formulario para Crear Producto -->
			<form action="ProductoDAO" method="post">
				<h2>Crear Producto</h2>
				<label for="nombre">Nombre:</label> <input type="text" id="nombre"
					name="nombre" required /><br /> <label for="descripcion">Descripción:</label>
				<input type="text" id="descripcion" name="descripcion" required /><br />
				<label for="peso">Peso:</label> <input type="number" id="peso"
					name="peso" required /><br /> <label for="stock">Stock:</label> <input
					type="number" id="stock" name="stock" required /><br />
				<button type="submit">Crear</button>
			</form>

			<br> <br>

			<!-- Formulario para Actualizar Producto -->
			<c:if test="${producto != null}">
				<form action="ProductoDAO" method="post">
					<h2>Actualizar Producto</h2>
					<input type="hidden" name="productoId" value="${producto.getId()}" />
					<label for="id">Id:</label> <input type="text" id="id" name="id"
						value="${producto.getId()}" required /> <label for="nombre">Nombre:</label>
					<input type="text" id="nombre" name="nombre"
						value="${producto.getNombre()}" required /><br /> <label
						for="descripcion">Descripción:</label> <input type="text"
						id="descripcion" name="descripcion"
						value="${producto.getDescripcion()}" required /><br /> <label
						for="peso">Peso:</label> <input type="number" id="peso"
						name="peso" value="${producto.getPeso()}" required /><br /> <label
						for="stock">Stock:</label> <input type="number" id="stock"
						name="stock" value="${producto.getStock()}" required /><br />
					<button type="submit">Actualizar</button>
				</form>
			</c:if>

			<br> <br>

			<!-- Formulario para Eliminar Producto -->
			<c:if test="${producto != null}">
				<form action="ProductoDAO" method="post">
					<h2>Eliminar Producto</h2>
					<input type="hidden" name="productoId" value="${producto.getId()}" />
					<p>¿Estás seguro de que deseas eliminar este producto?</p>
					<button type="submit">Eliminar</button>
				</form>
			</c:if>
		</div>
	</div>
	</div>
</body>
</html>
