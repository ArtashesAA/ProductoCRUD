package com.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ProductoServicio;
import com.dao.ProductoServicioImpl;
import com.modelo.Producto;

/**
 * Servlet implementation class CrearProducto
 */
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoServicio servicio = ProductoServicioImpl.obtenerInstancia();

	public CrearProducto() {
		super();
	}

	// Método Get que redirige al jsp crearProducto
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("JSP/crearProducto.jsp");
	}

	// Método post
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// sysout para comprobar en consola que funciona
		System.out.println("CrearProducto.doPost");

		// Recibe parámetros del producto
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String pesoStr = request.getParameter("peso");
		String stockStr = request.getParameter("stock");

		try {
			// Pasa el string recibido en el formulario a double e integer
			Double peso = Double.parseDouble(pesoStr);
			Integer stock = Integer.parseInt(stockStr);

			// Almacena el producto del formulario en nuevoProducto
			Producto nuevoProducto = new Producto(nombre, descripcion, peso, stock);

			// Manda al servicio a que cree un producto
			servicio.createProducto(nuevoProducto);

			// Si funciona correctamente, se envía al exito.jsp
			response.sendRedirect("JSP/exito.jsp");
		} catch (NumberFormatException e) {
			// Si da error de formato de numero, se envía al error.jsp
			e.printStackTrace();
			response.sendRedirect("JSP/error/error.jsp");
		} catch (Exception e) {
			// Si da otro error cualquiera, se envía al error.jsp
			e.printStackTrace();
			response.sendRedirect("JSP/error/error.jsp");
		}
	}
}
