package accessodatos;

import java.math.BigDecimal;
import java.util.ArrayList;

import modelos.Producto;

public class ColeccionProductos implements Crudable<Producto>{
	public ColeccionProductos() {}
	private static ColeccionProductos instancia;
	private static ArrayList<Producto> productos = new ArrayList<Producto>();
	public static ColeccionProductos getInstance() {
		if(instancia == null) {
			instancia = new ColeccionProductos();
			productos.add(new Producto(1L,"Samsung A40","ASDC",new BigDecimal("120.20")));
			productos.add(new Producto(2L,"Samsung S10","QWED",new BigDecimal("700.00")));
			productos.add(new Producto(3L,"Samsung S10+","AASC",new BigDecimal("810.00")));
			productos.add(new Producto(4L,"Samsung S9","AAZX",new BigDecimal("670.90")));
		}
		
		return instancia;
	}
	@Override
	public Iterable<Producto> getAll() {
		return productos;
	}

	@Override
	public Producto getOne() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isExiste(Producto producto) {
		if(productos.contains(producto))
		return true;
		return false;
	}
	public Producto getLast() {
		return productos.get(productos.size()-1);
		
	}
	@Override
	public void insertar(Producto producto) {
		productos.add(producto);
		
	}

	@Override
	public void eliminar(Producto producto) {
		if(productos.contains(producto)) {
			
			productos.remove(producto);
		}
		
	}

	@Override
	public void modificar(Producto productoOld, Producto producto) {
		if(productos.contains(productoOld)) {
			productos.set(productos.indexOf(productoOld), producto);
		}
		
	}
	
	public boolean isEmpty() {
		
		return productos.isEmpty();
	}
}
