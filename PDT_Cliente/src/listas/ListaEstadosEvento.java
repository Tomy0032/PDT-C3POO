package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.EstadoEventoBeanRemote;
import com.entities.EstadoEvento;
import com.entities.Usuario;
import com.exception.ServicesException;

public class ListaEstadosEvento {
	
	private static ListaEstadosEvento listaEstados = null;
	private static List<EstadoEvento> lista;
	
	private ListaEstadosEvento() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaEstadosEvento getInstance() {
		if(listaEstados == null) {
			listaEstados = new ListaEstadosEvento(); 
		}
		return listaEstados;
	}
	
	public static void cargarLista() throws NamingException {
		
		EstadoEventoBeanRemote tipoBean = (EstadoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/EstadoEventoBean!com.services.EstadoEventoBeanRemote"); 
		
		try {				
			lista = tipoBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(EstadoEvento e : lista) {
			
			s.add(e.getNombre());
			
		}
		
		String[] estados = s.toArray(new String[0]);
		return estados;
		
	}

	public static List<EstadoEvento> getLista() {
		return lista;
	}

	public static void setLista(List<EstadoEvento> lista) {
		ListaEstadosEvento.lista = lista;
	}

	public static Object[][] getListaStringListado() {
		ArrayList<Object> linea = null;
		ArrayList<Object[]> contenedor = new ArrayList<>();
		
		for(EstadoEvento e : lista) {
			
			linea = new ArrayList<>();
			linea.add(e.getNombre());	
			if(e.getEstado().toString().equals("ACTIVO")) {
				linea.add(true);
			}else {
				linea.add(false);
			}
			linea.add(e.getEstado().toString());
			contenedor.add(linea.toArray(new Object[0]));
		}
		
		Object[][] estados = (Object[][]) contenedor.toArray(new Object[0][]);
				
		return estados;

	}
	
}
