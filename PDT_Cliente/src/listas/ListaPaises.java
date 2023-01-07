package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Pais;
import com.services.PaisBeanRemote;

public class ListaPaises {

	private static ListaPaises listaPaises = null;
	private static List<Pais> lista;
	
	private ListaPaises() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaPaises getListaTipos() {
		if(listaPaises == null) {
			listaPaises = new ListaPaises(); 
		}
		return listaPaises;
	}
	
	public static void cargarLista() throws NamingException {
		
		PaisBeanRemote paisBean = (PaisBeanRemote) InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote"); 
		
		try {				
			lista = paisBean.findAll();
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Pais p : lista) {
			
			s.add(p.getNombre());
			
		}
		
		String[] paises = s.toArray(new String[0]);
		return paises;
		
	}

	public static List<Pais> getLista() {
		return lista;
	}

	public static void setLista(List<Pais> lista) {
		ListaPaises.lista = lista;
	}
	
}
