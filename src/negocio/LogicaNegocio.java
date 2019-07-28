package negocio;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import accessodatos.ColeccionUsuarios;
import modelos.JsonErrorException;
import modelos.Producto;
import modelos.Usuario;

public class LogicaNegocio {
	public static boolean isAutenticado(Usuario usuario) {
		return ColeccionUsuarios.getInstance().isExiste(usuario);
	}
	
	public static Usuario transformJsonToUsuario(String string) {
		Gson gson = new Gson();
		Usuario usuario = null;
		try {
				usuario = gson.fromJson(string,Usuario.class);
			}
			catch (JsonParseException e) {
				throw new JsonErrorException("El dato recibido no es un json");
			}catch(JsonErrorException ev) {
				
			}
		return usuario;
	}
	
	public static Producto transformJsonToProducto(String string) {
		Gson gson = new Gson(); 
		Producto producto = null;
		try {
				producto = gson.fromJson(string,Producto.class);
			}
			catch (JsonParseException e) {
				throw new JsonErrorException("El dato recibido no es un json");
			}catch(JsonErrorException ev) {
				
			}
		return producto;
	}
	public static boolean ExportarColecciones() {
		return false;
	}
}
