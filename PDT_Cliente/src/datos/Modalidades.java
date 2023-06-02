package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Modalidad;
import com.enums.Estado;
import com.exception.ServicesException;
import com.services.ModalidadBeanRemote;

public class Modalidades {
	
	public static void cargarDatos() throws NamingException {
		ModalidadBeanRemote tipoBean = (ModalidadBeanRemote) InitialContext.doLookup("PDT_EJB/ModalidadBean!com.services.ModalidadBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\modalidades.txt")));
			cargarTipos(lista,tipoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarTipos(ArrayList<String> lista,ModalidadBeanRemote tipoBean) {
		
		for(String s : lista) {
			
			Modalidad modalidad = new Modalidad();
			try {
				
				modalidad = tipoBean.findAll(s).get(0);
				
			}catch(Exception e){
				
				modalidad.setNombre(s);
				modalidad.setEstado(Estado.ACTIVO);
				try {
					tipoBean.create(modalidad);
				} catch (ServicesException e1) {
					System.out.println(e1.getMessage());
				}
				
			}

		}
		
	}

}
