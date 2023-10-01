<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Producto</title>
</head>
<body>
    <h2>Crear Producto</h2>
    
    <form  action="/ProductoCRUD-JSP/CrearProducto" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>

        <label for="descripcion">Descripcion:</label>
        <input type="text" id="descripcion" name="descripcion" required><br>
        
        <label for="peso">Peso:</label>
        <input type="text" id="peso" name="peso" required><br>
        
        <label for="stock">Stock:</label>
        <input type="text" id="stock" name="stock" required><br>
        
        <input type="submit" value="Crear">
        
        <br><br>
        
        <a href="../index.jsp">volver</a>
    </form>
</body>
</html>
