import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

	private int id_usuario;
	private String nombre_usuario;
	private String apellido_usuario;
	private String email_usuario;
	private String contrasenia_usuario;
	private int id_tipo_usuario;
	private boolean tiene_tarjeta_usuario;
	private Carrito carritoCompraU;
	
	
	
	public Usuario(int id_usuario, String nombre_usuario, String apellido_usuario, String email_usuario,
			String contrasenia_usuario, int id_tipo_usuario, boolean tiene_tarjeta_usuario, Carrito carrito) {
		super();
		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellido_usuario = apellido_usuario;
		this.email_usuario = email_usuario;
		this.contrasenia_usuario = contrasenia_usuario;
		this.id_tipo_usuario = id_tipo_usuario;
		this.tiene_tarjeta_usuario = tiene_tarjeta_usuario;
		this.carritoCompraU = new Carrito();
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getApellido_usuario() {
		return apellido_usuario;
	}
	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getContrasenia_usuario() {
		return contrasenia_usuario;
	}
	public void setContrasenia_usuario(String contrasenia_usuario) {
		this.contrasenia_usuario = contrasenia_usuario;
	}
	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}
	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}
	public boolean isTiene_tarjeta_usuario() {
		return tiene_tarjeta_usuario;
	}
	public void setTiene_tarjeta_usuario(boolean tiene_tarjeta_usuario) {
		this.tiene_tarjeta_usuario = tiene_tarjeta_usuario;
	}
	public Carrito getCarritoCompraU() {
		return carritoCompraU;
	}

	public void setCarritoCompraU(Carrito carritoCompraU) {
		this.carritoCompraU = carritoCompraU;
	}
	
	public void agregaCarritoU(Producto prod) {
		this.carritoCompraU.agragarProducto(prod);
	}

	
	
	public void crearPersona (Connection conexion)
	{
			Scanner sc = new Scanner(System.in);
			System.out.println("Datos de Persona");
			System.out.println("Nº de Documento: ");
			String Documento = sc.nextLine();
			System.out.println("Tipo de Documento (DNI, LE, etc): ");
			String TipoDocumento = sc.nextLine();
			System.out.println("Nombre: ");
			String Nombre = sc.nextLine();
			System.out.println("Apellido: ");
			String Apellido = sc.nextLine();
			System.out.println("Direccion: ");
			String Direccion = sc.nextLine();
			System.out.println("Numero de Telefono: ");
			String Telefono = sc.nextLine();
			System.out.println("Ingrese un Password de 8 caracteres:");
			String Pass = sc.nextLine();
			
			String Categoria="Cliente";
			
			Statement statement = null;
			String sql;
			ResultSet rs;
			PreparedStatement stmt;
			
			try 
				{
				//busca el ultimo registro en la tabla
				statement = conexion.createStatement();
				sql = "SELECT id_usuario FROM usuario order by id_usuario DESC LIMIT 1;";
				rs = statement.executeQuery(sql);
				int id_usuario = 0;
				while (rs.next()) 
				{
					id_usuario = rs.getInt("id_usuario");
					
				}
				
				stmt = conexion.prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?,?,?,?,?)");
					stmt.setInt(1,id_usuario + 1);
					stmt.setString(2,Nombre);
					stmt.setString(3,Apellido);
					stmt.setString(4,Direccion);
					stmt.setString(5,Telefono);
					stmt.setString(6,Categoria);
					stmt.setString(7,Pass);
					
				int response = stmt.executeUpdate();
					if (response > 0) 
					{
						System.out.println("Se dio de alta correctamente");
						sc.close();
					}
				}catch (SQLException sqle){
		            System.out.println("SQLState: "+ sqle.getSQLState());
		            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
		            sqle.printStackTrace();
								 
		        }catch (Exception e){
		            e.printStackTrace();
			
		        	}
	
}
	
	
	
	
	
	
	
	
	
	

}