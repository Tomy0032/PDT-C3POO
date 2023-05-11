package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;

import com.enums.TipoEvento;


public class ListaTiposEvento {
	
	private static ListaTiposEvento listaTiposEvento = null;
	private static List<TipoEvento> lista = new LinkedList<>();
	
	private ListaTiposEvento() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaTiposEvento getInstance() {
		if(listaTiposEvento == null) {
			listaTiposEvento = new ListaTiposEvento(); 
		}
		return listaTiposEvento;
	}
	
	public static void cargarLista() throws NamingException {
		
		for(TipoEvento t : TipoEvento.values()) {
			
			lista.add(t);
			
		}
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(TipoEvento t : lista) {
			
			s.add(t.getNombre());
			
		}
		
		String[] tiposEventos = s.toArray(new String[0]);
		return tiposEventos;
		
	}

	public static List<TipoEvento> getLista() {
		return lista;
	}

	public static void setLista(List<TipoEvento> lista) {
		ListaTiposEvento.lista = lista;
	}

}
