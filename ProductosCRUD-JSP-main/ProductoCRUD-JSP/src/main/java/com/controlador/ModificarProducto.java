package com.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ProductoServicio;
import com.dao.ProductoServicioImpl;
import com.modelo.Producto;

/**
 * Servlet implementation class ActualizarProducto
 */
public class ModificarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoServicio productoServicio = ProductoServicioImpl.obtenerInstancia();

	// private ProductoServicio productoServicio =
	// ProductoServicioImpl.obtenerInstancia();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/***
	 * Método post
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Comprobación de que se realiza el post
		System.out.println("ModificarProducto.doPost");

		try {
			// Recibe parámetros del producto
			Integer id = Integer.parseInt(request.getParameter("id"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			Double peso = Double.parseDouble(request.getParameter("peso"));
			Integer stock = Integer.parseInt(request.getParameter("stock"));

			// Se crea un producto para posteriormente almacenar los datos en ella
			Producto nuevoProducto;
			nuevoProducto = new Producto(id, nombre, descripcion, peso, stock);

			// Escribe en consola el producto
			System.out.println(nuevoProducto.toString());

			// Proceso de actualización y comprobación de esta
			boolean actualizado = productoServicio.updateProducto(nuevoProducto);
			if (!actualizado) {
				// Error al actualizar; manejar error
				response.sendRedirect("JSP/error/error.jsp"); // Cambiar a tu página de error
				return;
			}

			response.sendRedirect("JSP/exito.jsp"); // Cambiar a tu página de éxito o listado

		} catch (NumberFormatException e) {
			// ID inválido; manejar error
			response.sendRedirect("JSP/error/error.jsp"); // Cambiar a tu página de error
		}
	}

	/***
	 * Método get
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Escribe en consola que se realiza la modificación get
		System.out.println("ModificarProducto.doGet");

		try {
			// Recoge el id del producto para recoger los datos de este
			Integer id = Integer.parseInt(request.getParameter("id"));
			Producto producto = productoServicio.readProducto(id);

			// Si el producto esta nulo, envía a página de error
			if (producto == null) {
				response.sendRedirect("error.jsp");
				return;
			}

			// Request de producto
			request.setAttribute("producto", producto);
			RequestDispatcher dispacher = request.getRequestDispatcher("JSP/editarProducto.jsp");
			dispacher.forward(request, response);

		} catch (NumberFormatException e) {
			// Si hay error por introducir un numero en formato no valido, envía a error.jsp
			response.sendRedirect("error.jsp");
		}
	}

}