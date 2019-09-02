package filtros;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import modelos.Usuario;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

	private static final String VISTAS_LOGIN_JSP = "/WEB-INF/vistas/admin/login.jsp";
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		//System.out.println(httpRequest.getHeader("referer");
		//String url = httpRequest.getRequestURL().substring(0); 
		final RequestDispatcher requestDispatcherLogin = httpRequest.getRequestDispatcher(VISTAS_LOGIN_JSP);
		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
		System.out.println("SS");
		if(usuario == null) {
			requestDispatcherLogin.forward(request, response);
			
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	public void destroy() {
		
	}

}
