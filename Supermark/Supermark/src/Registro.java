import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
////Funciona el registro
public class Registro {
	
	private String nombre_usuario;
	private String apellido_usuario;
	private String email_usuario;
	private String telefono_usuario;
	private String contrasenia_usuario;
	
	
	
	public Registro() { //pido los datos aqui!!
		Scanner entrada = new Scanner(System.in);
	
		
		System.out.println("Ingrese nombre: ");
		this.nombre_usuario=entrada.next();
		
		System.out.println("Ingrese apellido: ");
		this.apellido_usuario=entrada.next();
		
		System.out.println("Ingrese email: ");
		this.email_usuario=entrada.next();
		
		System.out.println("Ingrese telefono: ");
		this.telefono_usuario=entrada.next();
		
		System.out.println("Ingrese password: ");
		this.contrasenia_usuario=entrada.next();
		
	}
	
	public Usuario validarReg() throws SQLException {
		
		if(this.nombre_usuario!=""&&this.apellido_usuario!=""&&
		   this.email_usuario!=""&&this.contrasenia_usuario!="") { //podriamos buscar si el email esta en la bdd
			
			String sql = "insert into usuario values(null,"+"'"+this.nombre_usuario+"',"+
			"'"+this.apellido_usuario+"',"+"'"+this.email_usuario+"',"+"'"+this.telefono_usuario+"',"+"'"+this.contrasenia_usuario+"',"+"1,true);";
			
			Conexion conexion = new Conexion();
			conexion.EjecutarConsulta(sql);
			System.out.println("Usuario cargado");
		}
		
		else {
			System.out.println("DATOS MAL INGRESADOS");
		}
		return null;
		
}
	

}