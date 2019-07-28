package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accessodatos.ColeccionProductos;
import accessodatos.ColeccionUsuarios;
import modelos.Usuario;


@WebServlet("/admin/inicio")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VISTAS_PRINCIPAL_JSP = "/WEB-INF/vistas/admin/inicio.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		final RequestDispatcher requestDispatcherPrincipal = request.getRequestDispatcher(VISTAS_PRINCIPAL_JSP);
		
		String opcion = request.getParameter("opcion");
		
		//Empaquetar en objeto del modelo
		
		if(opcion!=null && opcion.equals("usuarios")) {
			ColeccionUsuarios usuarios = ColeccionUsuarios.getInstance(); 
			
			
			request.setAttribute("usuarios", usuarios.getAll());
			request.setAttribute("opcion", opcion);
			
		}else if(opcion!=null && opcion.equals("productos")) {
			ColeccionProductos productos = ColeccionProductos.getInstance(); 
			
			
			request.setAttribute("productos", productos.getAll());
			request.setAttribute("opcion", opcion);
			
		}else {
			
		}
		requestDispatcherPrincipal.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
