package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.TipoEvento;
import com.exception.ServicesException;
import com.services.TipoEventoBeanRemote;

public class TiposEvento {
	
	public static void cargarDatos() throws NamingException {
		TipoEventoBeanRemote tipoBean = (TipoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoEventoBean!com.services.TipoEventoBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\tiposEvento.txt")));
			cargarTipos(lista,tipoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarTipos(ArrayList<String> lista,TipoEventoBeanRemote tipoBean) {
		
		for(String s : lista) {
			
			TipoEvento tipo = new TipoEvento();
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
