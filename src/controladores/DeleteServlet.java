package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accessodatos.ColeccionProductos;
import accessodatos.ColeccionUsuarios;
import modelos.Producto;
import modelos.Usuario;
import negocio.LogicaNegocio;


@WebServlet("/admin/deleteregistro")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("data") != null) {
			
			if(request.getParameter("opcion").equals("usuarios")) {
				
				ColeccionUsuarios usuarios = ColeccionUsuarios.getInstance();
				Usuario usuarioDel = LogicaNegocio.transformJsonToUsuario(request.getParameter("data"));
				usuarios.eliminar(usuarioDel);
			
			}else if(request.getParameter("opcion").equals("productos")) {
				
				ColeccionProductos productos = ColeccionProductos.getInstance();
				Producto productoDel = LogicaNegocio.transformJsonToProducto(request.getParameter("data"));
				productos.eliminar(productoDel);
			
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
