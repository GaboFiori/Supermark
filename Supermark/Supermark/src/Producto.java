
public class Producto {
	private int id_producto;
	private String nombre_producto;
	private int stock_producto;
	private double precio_unit_producto;
	int id_categoria;
	
	
	

	public Producto(int id, String nombre, int cantidad, double precio, int categoria) {
		this.id_producto = id;
		this.nombre_producto = nombre;
		this.stock_producto = cantidad;
		this.precio_unit_producto = precio;
		this.id_categoria = categoria;
	}

	

	public int getId() {
		return id_producto;
	}

	public void setId(int id) {
		this.id_producto = id;
	}

	public String getNombre() {
		return nombre_producto;
	}

	public void setNombre(String nombre) {
		this.nombre_producto = nombre;
	}

	public int getCantidad() {
		return stock_producto;
	}

	public void setCantidad(int cantidad) {
		this.stock_producto = cantidad;
	}
	public double getPrecio() {
		return precio_unit_producto;
	}

	public void setPrecio(double precio) {
		this.precio_unit_producto = precio;
	}
	public double getCategoria() {
		return id_categoria;
	}

	public void setCategoria(int categoria) {
		this.id_categoria= categoria;
	}
	



	@Override
	public String toString() {
		return "- Nombre del producto: " + nombre_producto + " \n  Cantidad=" + getCantidad() + " \n  Precio=" + getPrecio() + "]";
	}
	

}