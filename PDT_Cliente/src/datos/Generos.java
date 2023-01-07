package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Genero;
import com.exception.ServicesException;
import com.services.GeneroBeanRemote;

public class Generos {
	
	public static void cargarDatos() throws NamingException {
		
		GeneroBeanRemote generoBean = (GeneroBeanRemote) InitialContext.doLookup("PDT_EJB/GeneroBean!com.services.GeneroBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\generos.txt")));
			cargarTipos(lista,generoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarTipos(ArrayList<String> lista,GeneroBeanRemote generoBean) {
		
		for(String s : lista) {
			
			Genero genero = new Genero();
			try {
				
				genero = generoBean.findAll(s).get(0);
				
			}catch(Exception e){
				
				genero.setNombre(s);
				try {
					generoBean.create(genero);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		}
		
	}

}
