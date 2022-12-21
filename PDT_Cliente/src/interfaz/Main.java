
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

public class Main {

	public static void main(String[] args) throws NamingException, ServicesException{
		// TODO Auto-generated method stub

		//Bienvenida b = new Bienvenida();
		
		//Login l = new Login();
		
//		PaisBeanRemote paisBean = (PaisBeanRemote) InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote"); 
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 

		
//		System.out.println("Inicio");
		
//		List<String> paises = new LinkedList<>();
//		List<Pais> listaPaises = paisBean.findAll();
		
//		Departamento depa = new Departamento();
//		depa.setNombre("MONTEVIDEO");
//		departamentoBean.create(depa);
//		depa.setNombre("DURAZNO");
//		departamentoBean.create(depa);
//		depa.setNombre("CANELONES");
//		departamentoBean.create(depa);
//		depa.setNombre("ARTIGAS");
//		departamentoBean.create(depa);
//		depa.setNombre("TACUEREMBO");
//		departamentoBean.create(depa);
//		
//		Localidad local = new Localidad();
//		local.setNombre("BELLA UNION");
//		local.setDepartamento(departamentoBean.find(4L));
//		localidadBean.create(local);
//		local.setNombre("DURAZNO");
//		local.setDepartamento(departamentoBean.find(2L));
//		localidadBean.create(local);
		
		
	    Registrarse r = new Registrarse();
		
		//Aplicacion a = new Aplicacion();
		
		//Ingrese_password p = new Ingrese_password();
		
				
//		Control_ci control = Control_ci.getInstance();
//		System.out.println(control.verificarCi("31784968"));
					
//		PaisBeanRemote pais = (PaisBeanRemote)InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote");
//		
//		
//		Pais p = new Pais();
//		p.setNombre("URUGUAY");
//		
//		try {
//			pais.create(p);
//			
//		}catch(ServicesException e) {
//			
//			System.out.println(e);
//		}
		
		System.out.println("Fin");
	    
	}

}
