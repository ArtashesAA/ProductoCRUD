package com.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.ProductoServicio;
import com.modelo.Producto;

/**
 * Servlet implementation class CrearProducto
 */
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoServicio servicio = new ProductoServicioImplMock.obtenerInstancia();

	public CrearProducto() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("JSP/crearPersona.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CrearProducto.doPost");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String pesoStr = request.getParameter("peso");
		String stockStr = request.getParameter("stock");

		try {
			Double peso = Double.parseDouble(pesoStr);
			Integer stock = Integer.parseInt(stockStr);

			Producto nuevoProducto = new Producto(nombre, descripcion, peso, stock);

			servicio.createProducto(nuevoProducto);

			response.sendRedirect("JSP/exito.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendRedirect("JSP/error.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("JSP/error.jsp");
		}
	}
}
