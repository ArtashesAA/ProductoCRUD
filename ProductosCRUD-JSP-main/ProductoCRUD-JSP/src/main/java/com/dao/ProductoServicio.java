package com.dao;

import java.util.List;

import com.modelo.Producto;

public interface ProductoServicio {
	Boolean createProducto(Producto producto);

	Producto readProducto(Integer id);

	Boolean updateProducto(Producto producto);

	Boolean deleteProducto(Integer id);

	List<Producto> getAllProductos();
}
