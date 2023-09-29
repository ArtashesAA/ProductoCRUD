<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Crear Producto</title>
</head>
<body>
    <h2>Crear Producto</h2>
    <!-- 
    Aquí ${pageContext.request.contextPath} obtendrá el contexto de tu aplicación web 
    (usualmente el nombre de tu proyecto). 
    Por lo tanto, si tu Servlet está en el contexto de tu aplicación,
     debería encontrarlo correctamente con esta ruta. -->
    
    <form  action="${pageContext.request.contextPath}/CrearProducto" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>

        <label for="descripcion">Descripcion:</label>
        <input type="text" id="descripcion" name="descripcion" required><br>
        
        <label for="peso">Peso:</label>
        <input type="date" id="peso" name="peso" required><br>
        
        <label for="stock">Stock:</label>
        <input type="text" id="stock" name="stock" required><br>
        
        <input type="submit" value="Crear">
    </form>
</body>
</html>
