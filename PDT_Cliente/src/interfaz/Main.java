
package interfaz;

import javax.naming.NamingException;

import com.exception.*;

import datos.*;
import listas.Listas;

public class Main {

	public static void main(String[] args) throws NamingException, ServicesException{
				
		Datos.cargar();		
		Listas.cargar();
		
		MensajeConsola.Iniciar();
		
		Login l = new Login();
		
//	    Registrarse r = new Registrarse();
		
//		Ingrese_password p = new Ingrese_password();
								    
	}

}
