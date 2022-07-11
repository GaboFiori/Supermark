import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException {
		
		try (Scanner teclado = new Scanner (System.in)) {
			System.out.println("*****SuperMark*****");
			System.out.println("Ingrese una opcion: ");
			System.out.println("1 - Ingresar\n2 - Registrarse");
			int opcion=teclado.nextInt();
			
			if(opcion==1) {
		
		System.out.println("Ingrese su email: ");
		Scanner entrada = new Scanner (System.in);
		String email=entrada.nextLine();
		
		System.out.println("Ingrese su contrase�a: ");
		Scanner entrada2 = new Scanner (System.in);
		String contra=entrada2.nextLine();
		
		Login login = new Login (email,contra);
		
		Usuario user = login.ingresar();
		
		if(user!=null) {
			if(user.getId_tipo_usuario()==1) { //1 para cliente y 2 para admin (segun mi bd)
				InicioUsuario iniU = new InicioUsuario();
				
				iniU.menu(user);
				}
			else {
				InicioAdmin u = new InicioAdmin();}
						
		}
		else {
			System.out.println("Algo salio mal :(");
		}	
			}
		else {
			System.out.println("Registro");
			Registro registro1 = new Registro();
			registro1.validarReg();
		}
			Principal.main(args);
			}
		
	}
}