package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.modelo.Producto;

public class ProductoServicioImplMock implements ProductoServicio {

	private static ProductoServicioImplMock instancia;
	private final Map<Integer, Producto> productos = new HashMap<>();

	public static synchronized ProductoServicioImplMock obtenerInstancia() {
		if (instancia == null) {
			instancia = new ProductoServicioImplMock();
		}
		return instancia;
	}

	public ProductoServicioImplMock() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		productos.put(1, new Producto(1, "p1", "d1", 12.0, 543));
		productos.put(2, new Producto(2, "p2", "d2", 234.0, 543));
		productos.put(3, new Producto(3, "p3", "d3", 33.0, 64));
		productos.put(4, new Producto(4, "p4", "d4", 22.0, 234));
		productos.put(5, new Producto(5, "p5", "d5", 11.0, 12));
		productos.put(6, new Producto(6, "p6", "d6", 16.8, 234));
	}

	@Override
	public Boolean createProducto(Producto producto) {
		try {
			Integer newId = null;

			if (!productos.keySet().isEmpty()) {
				newId = productos.keySet().stream().max(Integer::compare).orElse(0) + 1;

			}

			producto.setId(newId);
			System.out.println(producto.toString());
			productos.put(newId, producto);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Producto readProducto(Integer id) {
		return productos.get(id);
	}

	@Override
	public Boolean updateProducto(Producto producto) {
		if (!productos.containsKey(producto.getId())) {
			return false;
		}
		productos.put(producto.getId(), producto);
		return true;
	}

	@Override
	public Boolean deleteProducto(Integer id) {
		if (productos.remove(id) == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<Producto> getAllProductos() {
		return new ArrayList<Producto>(productos.values());

	}

}
