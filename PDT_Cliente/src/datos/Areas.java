package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Area;
import com.exception.ServicesException;
import com.services.AreaBeanRemote;

public class Areas {
	
	public static void cargarDatos() throws NamingException {
		AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("PDT_EJB/AreaBean!com.services.AreaBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\areas.txt")));
			cargarAreas(lista,areaBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarAreas(ArrayList<String> lista,AreaBeanRemote areaBean) {
		
		for(String s : lista) {
			
			Area area = new Area();
			try {
				
				area = areaBean.findAll(s).get(0);
				
			}catch(Exception e){
				
				area.setNombre(s);
				try {
					areaBean.create(area);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		}
		
	}

}
