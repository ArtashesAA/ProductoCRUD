package com.dao;

import java.util.List;

import com.modelo.Producto;

public interface ProductoServicio {
	//Método crear producto devuelve boolean
	Boolean createProducto(Producto producto);

	//Método leer producto según id
	Producto readProducto(Integer id);

	//Método actualizar producto según producto
	Boolean updateProducto(Producto producto);

	//Método borrar producto según id
	Boolean deleteProducto(Integer id);

	//Método devolver todos los productos
	List<Producto> getAllProductos();
}
