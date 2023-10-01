package com.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.ProductoServicio;
import com.dao.ProductoServicioImpl;

/**
 * Servlet implementation class EliminarProducto
 */
public class EliminarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoServicio servicio = ProductoServicioImpl.obtenerInstancia();

	// ProductoServicio servicio = ProductoServicioImpl.obtenerInstancia();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recibe el id del producto seleccionado
		String id = request.getParameter("id");

		// Comprobación en consola del producto que se va a eliminar
		System.out.println("EliminarProducto.doPost id: " + id);

		try {

			if (servicio.deleteProducto(Integer.parseInt(id))) {
				// Si se borra correctamente, se envía a exito.jsp
				response.sendRedirect("JSP/exito.jsp");
			} else {
				// Sino, se envía a error.jsp
				response.sendRedirect("JSP/error/error.jsp");
			}

		} catch (Exception e) {
			// Si da erroro, se envía al error.jsp
			System.out.println(e.toString());
			response.sendRedirect("JSP/error/error.jsp");
		}
	}

}
