package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.TipoEventoBeanRemote;
import com.entities.TipoEvento;
import com.exception.ServicesException;

public class ListaTiposEvento {
	
	private static ListaTiposEvento listaTipos = null;
	private static List<TipoEvento> lista;
	
	private ListaTiposEvento() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaTiposEvento getInstance() {
		if(listaTipos == null) {
			listaTipos = new ListaTiposEvento(); 
		}
		return listaTipos;
	}
	
	public static void cargarLista() throws NamingException {
		
		TipoEventoBeanRemote tipoBean = (TipoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoEventoBean!com.services.TipoEventoBeanRemote"); 
		
		try {				
			lista = tipoBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(TipoEvento t : lista) {
			
			s.add(t.getNombre());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}

	public static List<TipoEvento> getLista() {
		return lista;
	}

	public static void setLista(List<TipoEvento> lista) {
		ListaTiposEvento.lista = lista;
	}
	
}
