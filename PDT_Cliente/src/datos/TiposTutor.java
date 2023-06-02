package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.TipoTutor;
import com.exception.ServicesException;
import com.services.TipoTutorBeanRemote;

public class TiposTutor {
	
	public static void cargarDatos() throws NamingException {
		TipoTutorBeanRemote tipoBean = (TipoTutorBeanRemote) InitialContext.doLookup("PDT_EJB/TipoTutorBean!com.services.TipoTutorBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\tiposTutor.txt")));
			cargarTipos(lista,tipoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarTipos(ArrayList<String> lista,TipoTutorBeanRemote tipoBean) {
		
		for(String s : lista) {
			
			TipoTutor tipo = new TipoTutor();
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
