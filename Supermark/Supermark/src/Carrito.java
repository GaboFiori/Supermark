
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Carrito {
	private Conexion conexion;
	private String sql;
	private ArrayList<Producto> arrayProducto;

	public Carrito() {
		
		this.arrayProducto = new ArrayList<Producto>();
	}
	
	public void agragarProducto(Producto p) {
		this.arrayProducto.add(p);
	}
	
public void recorrerCarrito() {
		
		for (int i=0;i<this.arrayProducto.size();i++) {
			
		System.out.println(arrayProducto.get(i).toString());
			
		}
		
	}
		
	
	
public String detalle() {
	
	String cadena = "";
	for (int i=0;i<this.arrayProducto.size();i++) {
		
	    cadena = cadena+arrayProducto.get(i).toString()+"\n";
		
	}
	
	return cadena;
	
}
	


public void autorizarCompra(Usuario usuario) throws SQLException {
	
	String sql;
	double total=0;
	Calendar fecha = new GregorianCalendar();
	
	int anio = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fechaActual=anio+"-"+mes+"-"+dia;
    
    for (int i=0; i<this.arrayProducto.size(); i++) {
    	total +=(arrayProducto.get(i)).getPrecio()*arrayProducto.get(i).getCantidad();
    }
    
    String detalle = detalle();
 
  //// sql = "insert into ventas values (null,"+detalle+"','"+total+"',"+usuario.getId_usuario()+");";	
    sql = "insert into ventas values (null,"+
			usuario.getId_usuario()+",'"+fechaActual+"','"+detalle+"',"+total+");";
  		
	Conexion conexion = new Conexion();
	conexion.EjecutarConsulta(sql);
	System.out.println("Compra cargada con exito!");
		
		
			
}
	



	/*public void autorizarCompra(Usuario user) throws SQLException {
	String sql;
	double total=0;
	Calendar fecha = new GregorianCalendar();
	
	int anio = fecha.get(Calendar.YEAR);
    int mes = fecha.get(Calendar.MONTH);
    int dia = fecha.get(Calendar.DAY_OF_MONTH);
    String fecha_pedido=anio+"-"+mes+"-"+dia;
    
    for (int i=0;i<this.arrayProducto.size();i++) {
    	total +=(arrayProducto.get(i)).getPrecio()*arrayProducto.get(i).getCantidad();
    }
    
    String detalle = detalle();
 
		
	
	
	sql= "INSERT INTO ventas VALUES (null,"+fecha_pedido+",'"+total+"','"+user.getId_usuario()+"',"+detalle+");";
		
	Conexion conexion = new Conexion();
	conexion.EjecutarConsulta(sql);
	System.out.println("Compra cargada con exito!");
	
} */
	
	
}