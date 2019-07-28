package accessodatos;

import java.util.ArrayList;

import modelos.Usuario;

public class ColeccionUsuarios implements Crudable<Usuario> {
	
	public ColeccionUsuarios() {
		
	}
	private static ColeccionUsuarios instancia;
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ColeccionUsuarios getInstance() {
		if(instancia == null) {
			instancia = new ColeccionUsuarios();
			usuarios.add(new Usuario("admin","admin"));
			usuarios.add(new Usuario("admin2","admin2"));
			usuarios.add(new Usuario("admin3","admin3"));
			usuarios.add(new Usuario("admin4","admin4"));
			
		}
		
		return instancia;
	}
	
	@Override
	public Iterable<Usuario> getAll() {
		
		return usuarios;
	}

	@Override
	public Usuario getOne() {
		
		return null;
	}
	@Override
	public boolean isExiste(Usuario usuario) {
		if(usuarios.contains(usuario))
		return true;
		return false;
	}
	@Override
	public void insertar(Usuario usuario) {
		usuarios.add(usuario);
		
	}
	
	@Override
	public void eliminar(Usuario usuario) {
		
		if(usuarios.contains(usuario)) {
			
			usuarios.remove(usuario);
		}
		
	}

	@Override
	public void modificar(Usuario usuarioOld,Usuario usuario) {
		
		if(usuarios.contains(usuarioOld)) {
			
			usuarios.set(usuarios.indexOf(usuarioOld), usuario);
		}
		
	}
	public boolean isEmpty() {
		
		return usuarios.isEmpty();
	}
	
	
}
