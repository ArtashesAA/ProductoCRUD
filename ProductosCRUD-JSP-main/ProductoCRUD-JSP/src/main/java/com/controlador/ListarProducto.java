package com.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.dao.ProductoServicio;
import com.dao.ProductoServicioImpl;
import com.modelo.Producto;

/**
 * Servlet implementation class ListarProducto
 */
public class ListarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Obtiene la instancia del servicio
	ProductoServicio servicio = ProductoServicioImpl.obtenerInstancia();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Comprobación de que se realiza el get
		System.out.println("ListarProducto.doGET");

		// Se guarda en una lista todos los productos que recibe el servicio
		List<Producto> productos = servicio.getAllProductos();
		request.setAttribute("PRODUCTOS", productos);

		// Se envía a listarProductos
		RequestDispatcher dispatcher = request.getRequestDispatcher("JSP/listarProducto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Comprobación de que se realiza el post
		System.out.println("ListarProducto.doPost");

		// Se guarda en una lista todos los productos que recibe el servicio
		List<Producto> productos = servicio.getAllProductos();

		// Request de los atributos producto
		request.setAttribute("PRODUCTOS", productos);
		RequestDispatcher dispacher = request.getRequestDispatcher("JSP/listarProducto.jsp");
		dispacher.forward(request, response);
	}

}
