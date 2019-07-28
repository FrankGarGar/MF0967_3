package controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.ModeloException;
import modelos.Usuario;
import negocio.LogicaNegocio;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final String VISTAS_LOGIN_JSP = "/WEB-INF/vistas/admin/login.jsp";
	private static final String VISTAS_PRINCIPAL_JSP = "/WEB-INF/vistas/admin/inicio.jsp";
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		final RequestDispatcher requestDispatcherLogin = request.getRequestDispatcher(VISTAS_LOGIN_JSP);
		final RequestDispatcher requestDispatcherPrincipal = request.getRequestDispatcher(VISTAS_PRINCIPAL_JSP);
		//Recoger información de la petición
		String nick = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		//Empaquetar en objeto del modelo
		
		if(usuario == null) {
			try {
				usuario = new Usuario(nick,password);
			} catch (ModeloException e) {
				requestDispatcherLogin.forward(request, response);
				return;
			}
		}
		
		if(usuario.isValido()) {
			request.setAttribute("usuario", usuario);
			requestDispatcherLogin.forward(request, response);
			return;
		}
		//Ejecutar lógica de negocio
		if(LogicaNegocio.isAutenticado(usuario)) {
			//Redireccionar a un controlador
			request.getSession().setAttribute("usuario", usuario);
			requestDispatcherPrincipal.forward(request, response);
			
			return;
		}else {
			//Redireccionar a una vista
			usuario.setErrorAll("Las credenciales no son correctas");
			request.setAttribute("usuario", usuario);
			requestDispatcherLogin.forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
