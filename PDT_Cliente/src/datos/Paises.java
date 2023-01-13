package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Pais;
import com.exception.ServicesException;
import com.services.PaisBeanRemote;

public class Paises {
	
	public static void cargarDatos() throws NamingException {
		PaisBeanRemote paisBean = (PaisBeanRemote) InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\paises.txt")));
			cargarPaises(lista,paisBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarPaises(ArrayList<String> lista,PaisBeanRemote paisBean) {
		
		for(String s : lista) {
			
			Pais pais = new Pais();
			try {
				
				pais = paisBean.findAll(s).get(0);
				
			}catch(Exception e){
				
				pais.setNombre(s);
				try {
					paisBean.create(pais);
				} catch (ServicesException e1) {
					System.out.println(e1.getMessage());
				}
				
			}

		}
		
	}

}
