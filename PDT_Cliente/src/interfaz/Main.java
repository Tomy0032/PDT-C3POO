
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
				
		new Login();
		
	}

}
