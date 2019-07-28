package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accessodatos.ColeccionProductos;
import accessodatos.ColeccionUsuarios;
import modelos.JsonErrorException;
import modelos.Producto;
import modelos.Usuario;
import negocio.LogicaNegocio;

@WebServlet("/admin/editarregistro")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if(request.getParameter("data") != null && request.getParameter("dataold")!=null) {
			
			if(request.getParameter("opcion").equals("usuarios")) {
				ColeccionUsuarios usuarios = ColeccionUsuarios.getInstance();
				Usuario usuarioEdit = LogicaNegocio.transformJsonToUsuario(request.getParameter("data"));
				Usuario usuarioOld = LogicaNegocio.transformJsonToUsuario(request.getParameter("dataold"));
				if(usuarioEdit!=null && usuarioOld!=null) {
					usuarios.modificar(usuarioOld,usuarioEdit);
				}else {
					
					throw new JsonErrorException("El json del usuario a editar o los datos nuevos no es correcto");
				}
				
			}else if(request.getParameter("opcion").equals("productos")) {
				ColeccionProductos productos = ColeccionProductos.getInstance();
				Producto productoEdit = LogicaNegocio.transformJsonToProducto(request.getParameter("data"));
				Producto productoOld = LogicaNegocio.transformJsonToProducto(request.getParameter("dataold"));			
				if(productoEdit!=null && productoOld!=null) {
					productos.modificar(productoOld,productoEdit);
				}else {
					throw new JsonErrorException("El json del producto a editar o los datos nuevos no es correcto");
				}
			}else {
				
				response.setStatus(404);
				return;
			}
			pw.println(request.getParameter("data"));
		}else {
			response.setStatus(404);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
			
}
