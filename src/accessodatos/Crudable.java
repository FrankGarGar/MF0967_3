package accessodatos;

public interface Crudable<T> {
	
	public Iterable<T> getAll();
	public T getOne();
	public void insertar(T objeto);
	public void eliminar(T objeto);
	public void modificar(T objeto1,T objeto);
	public boolean isExiste(T objeto);
	public boolean isEmpty();
}
