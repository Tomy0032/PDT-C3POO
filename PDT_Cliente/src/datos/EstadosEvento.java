package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.EstadoEvento;
import com.enums.Estado;
import com.exception.ServicesException;
import com.services.EstadoEventoBeanRemote;

public class EstadosEvento {
	
	public static void cargarDatos() throws NamingException {
		EstadoEventoBeanRemote estadoBean = (EstadoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/EstadoEventoBean!com.services.EstadoEventoBeanRemote"); 
		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\estadosEvento.txt")));
			cargarTipos(lista,estadoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void cargarTipos(ArrayList<String> lista,EstadoEventoBeanRemote tipoBean) {
		
		for(String s : lista) {
			
			EstadoEvento estado = new EstadoEvento();
			try {
				
				estado = tipoBean.findAll(s).get(0);
				
			}catch(Exception e){
				
				estado.setNombre(s);
				estado.setEstado(Estado.ACTIVO);
				try {
					tipoBean.create(estado);
				} catch (ServicesException e1) {
					System.out.println(e1.getMessage());
				}
				
			}

		}
		
	}

}
