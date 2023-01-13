package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Tipo;
import com.exception.ServicesException;
import com.services.TipoBeanRemote;

public class Tipos {
	
	public static void cargarDatos() throws NamingException {
		TipoBeanRemote tipoBean = (TipoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoBean!com.services.TipoBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\tipos.txt")));
			cargarTipos(lista,tipoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarTipos(ArrayList<String> lista,TipoBeanRemote tipoBean) {
		
		for(String s : lista) {
			
			Tipo tipo = new Tipo();
			try {
				
				tipo = tipoBean.findAll(s).get(0);
				
			}catch(Exception e){
				
				tipo.setNombre(s);
				try {
					tipoBean.create(tipo);
				} catch (ServicesException e1) {
					System.out.println(e1.getMessage());
				}
				
			}

		}
		
	}

}
