package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;

import com.enums.Modalidad;


public class ListaModalidades {
	
	private static ListaModalidades listaModalidades = null;
	private static List<Modalidad> lista = new LinkedList<>();
	
	private ListaModalidades() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaModalidades getInstance() {
		if(listaModalidades == null) {
			listaModalidades = new ListaModalidades(); 
		}
		return listaModalidades;
	}
	
	public static void cargarLista() throws NamingException {
		
		for(Modalidad m : Modalidad.values()) {
			
			System.out.println(m);
			lista.add(m);
			
		}
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Modalidad m : lista) {
			
			s.add(m.toString());
			
		}
		
		String[] modalidades = s.toArray(new String[0]);
		return modalidades;
		
	}

	public static List<Modalidad> getLista() {
		return lista;
	}

	public static void setLista(List<Modalidad> lista) {
		ListaModalidades.lista = lista;
	}

}
