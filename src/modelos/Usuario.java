package modelos;

public class Usuario {
	private String usuario;
	private String password;
	private String errorUser;
	private String errorPass;
	private String errorAll;
	private boolean valido = false;
	public Usuario(String usuario, String password) {
		super();
		setUsuario(usuario);
		setPassword(password);
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		if(usuario == null) {
			throw new ModeloException("No se admiten usuarios nulos");
		}
		if(usuario.trim().length() == 0) {
			setErrorUser("No se admiten usuarios vac�os");
		}
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password == null) {
			throw new ModeloException("No se admiten contrase�as nulas");
		}
		if(password.trim().length() == 0) {
			setErrorPass("No se admiten contrase�as vac�as");
		}
		this.password = password;
	}
	public String getErrorUser() {
		return errorUser;
	}
	public void setErrorUser(String errorUser) {
		this.errorUser = errorUser;
		valido = true;
	}
	public String getErrorPass() {
		return errorPass;
	}
	public void setErrorPass(String errorPass) {
		this.errorPass = errorPass;
		valido = true;
	}
	
	public boolean isValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	public String getErrorAll() {
		return errorAll;
	}
	public void setErrorAll(String errorAll) {
		this.errorAll = errorAll;
	}
	public void setUser(Usuario usuario) {
		setUsuario(usuario.getUsuario());
		setPassword(usuario.getPassword());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + "]";
	}
	
}
