package controladores;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import accessodatos.ColeccionProductos;
import accessodatos.ColeccionUsuarios;
import modelos.Producto;
import modelos.Usuario;
import negocio.LogicaNegocio;
@WebServlet("/admin/guardarregistro")
public class GuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Gson gson = new Gson(); 
		if(request.getParameter("data") != null) {
			
				System.out.println(request.getParameter("opcion"));
			if(request.getParameter("opcion").equals("usuarios")) {
				ColeccionUsuarios usuarios = ColeccionUsuarios.getInstance();
				Usuario usuarioNew = LogicaNegocio.transformJsonToUsuario(request.getParameter("data"));
				if(usuarioNew!=null) {
					usuarios.insertar(usuarioNew);
				}
				response.getWriter().print(request.getParameter("data"));
			}else if(request.getParameter("opcion").equals("productos")) {
				ColeccionProductos productos = ColeccionProductos.getInstance();
				Producto productoNew = LogicaNegocio.transformJsonToProducto(request.getParameter("data"));
				productoNew.setId(productos.getLast().getId()+1L);
				
				if(productoNew!=null) {
					productos.insertar(productoNew);
				}
				response.getWriter().print(gson.toJson(productoNew));
				
			}else {
				
				response.setStatus(404);
				return;
			}
			
			
		}	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
