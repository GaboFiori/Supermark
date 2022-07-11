import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class InicioAdmin {

	Scanner t=new Scanner(System.in);
	Conexion conn=new Conexion();
	private String[][] matrizResultado;
	int fila;
	int columna;
	public InicioAdmin() throws SQLException{
		
		System.out.println();
		System.out.println("\t\t==============================");
		System.out.println("\t\t===== Menu Administrador =====");
		System.out.println("");
		System.out.println("\t\t 1 - Ver listado productos");
		System.out.println("\t\t 2 - Cargar productos a la aplicacion");
		System.out.println("\t\t 3 - Modificar los datos de los productos cargados");
		System.out.println("\t\t 4 - Ver todos los usuarios que realizaron una compra");
		System.out.println("\t\t 5 - Ver listado de productos seleccionados por el usuario");
		
		int op=t.nextInt();
		switch(op) {
		
		case 1:
			VerProductos();
			break;
		case 2:
			addProducto();
			break;
		case 3:
			ModificarProducto();
			break;
		case 4:
			VerUsuariosCompras();
			break;
		}
	
	}


	public void VerUsuariosCompras() throws SQLException {
		String sql = "select c.id_venta,u.nombre_usuario as Usuario from ventas as c "
				+ "inner join Usuario as u using(id_usuario);"
													;
				
		
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("Usuarios que realizaron una compra");
		System.out.println("Nombre usuario|\t");
		while(r.next()) {
			System.out.print(r.getString("Usuario")+"\t");
			System.out.print("\n");
		}
		return; 
				
	}
	
	public void ModificarProducto() throws SQLException {
		
		
		String stock = null,precio = null;
		int decision;
		String sql;
		
		System.out.println("producto");
		sql="select id_producto,nombre_producto,stock_producto,precio_unit_producto	,id_categoria from producto inner join categoria using(id_categoria);";
		
		ResultSet r=conn.devolverConsulta(sql);
		System.out.println("idProducto|\t\tNombre|\t\t\t Stock|\t\t\tPrecio|\t\t\tidCategoria");
		while(r.next()) {
			
			System.out.print(r.getString("id_producto")+"\t\t\t");
			System.out.print(r.getString("nombre_producto")+"\t\t\t");
			System.out.print(r.getString("stock_producto")+"\t\t\t");
			System.out.print(r.getString("precio_unit_producto")+"\t\t\t");
			System.out.print(r.getString("id_categoria")+"\t\t\t");
			System.out.print("\n");
		}
		System.out.println("Ingrese el codigo del producto a modificar");
		String codigo=t.next();
		
		System.out.println("Desea modificar el stock 1-SI 0-NO");
		decision=t.nextInt();
		if(decision ==1) {
			System.out.println("Ingrese el nuevo stock");
			stock=t.next();
		}
		System.out.println("Desea modificar el precio 1-SI 0-NO");
		
		decision=t.nextInt();
		if(decision ==1) {
			System.out.println("Ingrese el nuevo precio");
			precio=t.next();
		}
		// tenga en cuenta que si no quiere modificar nada no tendria que hacer el update
		sql="UPDATE `supermark`.`producto` SET `stock_producto` =" +"'"+stock+"'"+","+" `precio_unit_producto` = "+"'"+precio+"'"+" WHERE (`id_producto` = "+"'"+codigo+"');";
		conn.EjecutarConsulta(sql);
		System.out.println(" Producto Actualizado");
		
		Usuario u = null;
		InicioAdmin iniA = new InicioAdmin();
	
			
		}
	
	public void addProducto() throws SQLException {
		
		Conexion conn=new Conexion();
		System.out.println("Esta por agregar un producto");
		System.out.println();
		System.out.println("ingrese id");
		String i=t.next();
		System.out.println("Ingrese el nombre del producto");
		String n=t.next();
		System.out.println("Ingrese el Stock");
		String s=t.next();
		System.out.println("Ingrese la categoria :");
		ResultSet r= conn.devolverConsulta("select * from categoria;");
		while(r.next()) {
			System.out.println(r.getInt("id_categoria")+": "+r.getString("nombre_categoria"));
		}
		
		String cat=t.next();
		System.out.println("Ingrese el precio");
		
		String d=t.next();
		
		ArrayList<String >e=new ArrayList<>();
		e.add(i);
		e.add(n);
		e.add(s);
		e.add(d);
		e.add(cat);
		
		
		conn.AgregarProducto(e);
		System.out.println("Producto agregado con exito!");
		
		
		Usuario u = null;
		InicioAdmin iniA = new InicioAdmin();
	}
	
	
	
	public void VerProductos() throws SQLException {
		
		String sql="select * from producto;";
		ResultSet r=conn.devolverConsulta(sql);
		
		r.last();//se posiciona en la ultima
		
		fila=r.getRow()+1;
		columna=6;
		this.matrizResultado=new String[fila][columna];
		
		this.matrizResultado[0][0]="id_producto";
		this.matrizResultado[0][1]="nombre_producto";
		this.matrizResultado[0][2]="stock_producto";
		this.matrizResultado[0][3]="precio_unit_producto";
		this.matrizResultado[0][4]="id_categoria";
		
		r.beforeFirst();
		//int fila=1;
		System.out.println("\t================== PRODUCTOS =================== ");
		System.out.println("\t~~idProducto - Nombre - Stock - Precio - idCat ~~");
		System.out.println("\t================================================ ");
		
		while(r.next()) {
			
		System.out.println("\t" + r.getInt("id_producto")+ " - " +r.getString("nombre_producto")+ "  - " + r.getString("stock_producto")+" - "+ "$" +r.getString("precio_unit_producto")
							+" - " +r.getString("id_categoria"));
		
	
		}
		
		System.out.println();
		System.out.println();
		
		Usuario u = null;
		InicioAdmin iniA = new InicioAdmin();
		//this.Mostrar_matriz(matrizResultado, this.fila, columna);
	
	
	}
	
	public void Mostrar_matriz(String[][] m, int f, int c) {
		
		for(int i=0;i<f;i++) {
			System.out.print("\n");
			for(int j=0;j<c;j++) {
				System.out.print("\t"+m[i][j]);
			}
		}
		
		
	}
	
}