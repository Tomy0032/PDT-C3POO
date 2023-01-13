package datos;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Generacion;
import com.exception.ServicesException;
import com.services.GeneracionBeanRemote;

public class Generaciones {
	
	public static void cargarDatos() throws NamingException {
		GeneracionBeanRemote generacionBean = (GeneracionBeanRemote) InitialContext.doLookup("PDT_EJB/GeneracionBean!com.services.GeneracionBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\generaciones.txt")));
			cargarGeneraciones(lista,generacionBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarGeneraciones(ArrayList<String> lista,GeneracionBeanRemote generacionBean) {
		
		for(String s : lista) {
			
			int ind =s.indexOf(",");
			BigDecimal ano = new BigDecimal(s.substring(0,ind));
			
			int ultimo = s.length();
			s = s.substring(ind+1,ultimo);
			String nombre = s;
			
			Generacion generacion = new Generacion();
			try {
				
				generacion = generacionBean.findAllForName(nombre).get(0);
				
			}catch(Exception e){
				
				generacion.setNombre(nombre);
				generacion.setAno(ano);
				try {
					generacionBean.create(generacion);
				} catch (ServicesException e1) {
					System.out.println(e.getMessage());
				}
				
			}

		}
		
	}

}
