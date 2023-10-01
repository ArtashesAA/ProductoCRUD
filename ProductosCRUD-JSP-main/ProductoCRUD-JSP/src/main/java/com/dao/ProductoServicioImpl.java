package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Producto;

public class ProductoServicioImpl implements ProductoServicio {
	//Invoca a la clase servicio
	private static ProductoServicioImpl instancia;
	
	// Establece la URL de la base de datos, nombre de usuario y contraseña
    private final String url = "jdbc:mysql://localhost:3306/producto";
    private final String user = "root";
    private final String password = "root";

    public ProductoServicioImpl() {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener una instancia única de ProductoServicioImpl
    public static synchronized ProductoServicioImpl obtenerInstancia() {
        if (instancia == null) {
            instancia = new ProductoServicioImpl();
        }
        return instancia;
    }

    // Recupera todos los productos de la base de datos y los devuelve en una lista
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        
        //Conexión y SQL para devolver todos los productos de la tabla producto
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM producto";
            try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Producto producto = new Producto(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("descripcion"),
                            resultSet.getDouble("peso"),
                            resultSet.getInt("stock")
                        );
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    // Lee un producto de la base de datos según su ID
    public Producto readProducto(Integer productoId) {
    	
    	//Conexión y SQL para devolver todos los productos de la tabla producto que tengan un id específico
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM producto WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, productoId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String descripcion = resultSet.getString("descripcion");
                        Double peso = resultSet.getDouble("peso");
                        Integer stock = resultSet.getInt("stock");
                        return new Producto(productoId, nombre, descripcion, peso, stock);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Crea un nuevo producto en la base de datos
    public Boolean createProducto(Producto producto) {
    	
    	//Conexión y SQL para insertar el producto
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO producto (nombre, descripcion, peso, stock) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setDouble(3, producto.getPeso());
                statement.setInt(4, producto.getStock());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualiza un producto existente en la base de datos
    public Boolean updateProducto(Producto producto) {
    	
    	//Conexión y SQL para actualizar según id
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE producto SET nombre = ?, descripcion = ?, peso = ?, stock = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setDouble(3, producto.getPeso());
                statement.setInt(4, producto.getStock());
                statement.setInt(5, producto.getId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Elimina un producto de la base de datos según su ID
    public Boolean deleteProducto(Integer productoId) {
    	
    	//Conexión y SQL para borrar producto segun id
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM producto WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, productoId);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}