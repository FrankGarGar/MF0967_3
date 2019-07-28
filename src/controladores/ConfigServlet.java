package controladores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import accessodatos.ColeccionProductos;
import accessodatos.ColeccionUsuarios;
import modelos.Producto;
import modelos.Usuario;
import negocio.LogicaNegocio;

/**
 * Servlet implementation class ConfigServlet
 */
@WebServlet("/admin/config")
@MultipartConfig(location="D:/uploads")
public class ConfigServlet extends HttpServlet {
	private static final String CARPETA_DESTINO = "D:\\uploads\\";
	private static final long serialVersionUID = 1L;
	private static final String VISTAS_CONFIG_JSP = "/WEB-INF/vistas/admin/config.jsp";
	private static final String RUTA_FILE_EXP = "C:\\trabajos\\Colecciones.txt";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher requestDispatcherConfig = request.getRequestDispatcher(VISTAS_CONFIG_JSP);
		response.setContentType("text/html;charset=UTF-8");
		if(request.getParameter("opcion")!=null) {
			ColeccionProductos productos = ColeccionProductos.getInstance();
			ColeccionUsuarios usuarios = ColeccionUsuarios.getInstance();
			if(request.getParameter("opcion").equals("importar")) {
				Collection<Part> parts = request.getParts();
				String namearch="";
				FileReader fr = null;
				BufferedReader br = null;
				try {
					for(Part part : parts) {
				        	
			                part.write(getFileName(part));
			                namearch =getFileName(part);
			              break;
			        }
					if(namearch!="") {
						fr = new FileReader(CARPETA_DESTINO + namearch);
						br = new BufferedReader(fr);
						int n = 1;
						String linea;

						int numero =1;
						String[] split;
						String modelo= "";
						while((linea = br.readLine()) !=null) {
							if(n%2!=0) {
							
								modelo = linea;
							
							}else {
								if(modelo.equals("Usuario")) {
									Usuario usuario = LogicaNegocio.transformJsonToUsuario(linea);
									usuarios.insertar(usuario);
								}else if(modelo.equals("Producto")) {
									Producto producto = LogicaNegocio.transformJsonToProducto(linea);
									productos.insertar(producto);
								}
							}
							n++;
						}
					}
				}catch(NullPointerException e) {
					
				}
				
		        
			
			}else if(request.getParameter("opcion").equals("exportar")){
				FileWriter fw = null;
//				ServletContext context = (ServletContext) this.getServletContext();
//				String ruta = context.getRealPath("/") + "C";
				final String NEXT_LINE = "\n";
				try {
					fw = new FileWriter(RUTA_FILE_EXP);
					if(productos.isEmpty() && usuarios.isEmpty()) {
						request.setAttribute("error", "Librerias vacías");
						throw new LibEmpException("Librerías vacías");
					}else {
						if(!productos.isEmpty()) {
							for(Producto prod : productos.getAll()){
								fw.append("Producto").append(NEXT_LINE);
								fw.append("{\"id\":\"" + prod.getId() + "\"," + "{\"nombre\":\"" + prod.getNombre() + "\"," + "{\"codigo\":\"" + prod.getCodigo() + "\"," + "{\"precio\":\"" + prod.getPrecio() + "\"}").append(NEXT_LINE);
							}
						}
						if(!usuarios.isEmpty()) {
							for(Usuario user : usuarios.getAll()){
								fw.append("Usuario").append(NEXT_LINE);
								fw.append("{\"usuario\":\"" + user.getUsuario() + "\""+ ",\"password\":\"" + user.getPassword() + "\"}").append(NEXT_LINE);
							}
						}
					}
					
					request.setAttribute("success", "Librerias exportadas exitosamente");
					
				}catch(FileNotFoundException e) {
					System.out.println("Archivo actualmente utilizado no se puede modificar");
					request.setAttribute("error", "Archivo actualmente utilizado no se puede modificar");
				}catch (LibEmpException ev) {
				
				}catch (IOException e) {
				}
				fw.close();
				
			}
		}else {
			
			
		}
		requestDispatcherConfig.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public String getFileName(Part part) {
        String contentHeader = part.getHeader("content-disposition");
        String[] subHeaders = contentHeader.split(";");
        for(String current : subHeaders) {
            if(current.trim().startsWith("filename")) {
                int pos = current.indexOf('=');
                String fileName = current.substring(pos+1);
                return fileName.replace("\"", "");
            }
        }
        return null;
    }
}
