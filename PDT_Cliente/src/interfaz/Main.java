
package interfaz;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import controladores.Control_ci;

//import javax.naming.InitialContext;
//import javax.naming.NamingException;

//import com.services.PaisBeanRemote;
//import com.entities.Pais;
//import com.exception.ServicesException;

import com.entities.*;
import com.services.*;
import com.exception.*;

import datos.*;
import listas.Listas;

public class Main {

	public static void main(String[] args) throws NamingException, ServicesException{
		// TODO Auto-generated method stub

		//Bienvenida b = new Bienvenida();
		
		//Login l = new Login();
		
		Datos.cargar();		
		Listas.cargar();
		
	    Registrarse r = new Registrarse();
		
		//Aplicacion a = new Aplicacion();
		
		//Ingrese_password p = new Ingrese_password();
		
				
//		Control_ci control = Control_ci.getInstance();
//		System.out.println(control.verificarCi("31784968"));
								    
	}

}
