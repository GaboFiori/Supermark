import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Conexion {

	
	public Connection conn;
	public Statement stmt;
	
	public Conexion() {
		 final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
		 final String DB_URL="jdbc:mysql://localhost:3306/supermark";
		 
		 info f=new info();
		 final String USER= f.getUser();//usuario
		 final String PASS=f.getPass();//pass
		 
		 	conn=null;
			stmt =null;
			try {
				//paso 2
				Class.forName(JDBC_DRIVER);
				
				//paso3 
				System.out.println("Conectando a la base de Datos...");
				conn= DriverManager.getConnection(DB_URL,USER,PASS);
				System.out.println("Conexion exitosa!");
				
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			//System.out.print("LIsto");
		}

		public ResultSet devolverConsulta(String query) throws SQLException {
			//System.out.println("creando declaracion");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql=query;
			
			ResultSet rs =stmt.executeQuery(sql);
			 return rs;
		}
		
		
		public void EjecutarConsulta(String sql) throws SQLException {
			stmt= conn.createStatement();
			stmt.executeUpdate(sql);
		}
	   
		
		public void AgregarProducto(ArrayList<String>elementos) throws SQLException {
			System.out.println("Creando Statement");
			stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql;
			sql="insert into producto (id_producto,nombre_producto,stock_producto,precio_unit_producto,id_categoria) "+
			" values (?,?,?,?,?)";
			
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			  preparedStmt.setString (1,elementos.get(0) );;  
			  preparedStmt.setString (2,elementos.get(1) );
		      preparedStmt.setString (3,elementos.get(2) );
		      preparedStmt . setInt ( 4 , Integer . parseInt ( elementos . get (3)));
		      preparedStmt . setInt ( 5 , Integer . parseInt ( elementos . get (4)));
		      
		      preparedStmt.execute();
		      
		}
		

	public static void main(String[] args) {

	}
}