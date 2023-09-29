<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Producto</title>
</head>
<body>
    <h2>Editar Producto</h2>
    
    <!-- 
    El valor de action ahora está directamente relacionado con el Servlet ModificarProducto.
    Además, estoy asumiendo que tienes algunos atributos disponibles, como producto y fechaNacimiento,
    que podrías haber establecido en un Servlet o Controlador antes de enviar a este JSP.
    -->
    <form action="${pageContext.request.contextPath}/ModificarProducto" method="post">
        
        <!-- Campo oculto para almacenar el id de la producto en modo editar. -->
        <c:if test="${not empty producto}">
            <input type="hidden" name="id" value="${producto.id}" />
        </c:if>
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${producto.nombre}" required><br>

        <label for="descripcion">Descripcion:</label>
        <input type="text" id="descripcion" name="descripcion" value="${producto.descripcion}" required><br>
        
        <label for="peso">Peso:</label>
        <input type="text" id="peso" name="peso" value="${producto.peso}" required><br>
        
        <label for="stock">Stock:</label>
        <input type="text" id="stock" name="stock" value="${producto.stock}" required><br>
        
        <input type="submit" value="Guardar">
    </form>
</body>
</html>
