package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Itr;
import com.services.ItrBeanRemote;

public class ListaItrs {
	private static ListaItrs listaItrs = null;
	private static List<Itr> lista;
	
	private ListaItrs() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaItrs getListaItrs() {
		if(listaItrs == null) {
			listaItrs = new ListaItrs(); 
		}
		return listaItrs;
	}
	
	public static void cargarLista() throws NamingException {
		
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		
		try {				
			lista = itrBean.findAll();
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Itr i : lista) {
			
			s.add(i.getNombre());
			
		}
		
		String[] itrs = s.toArray(new String[0]);
		return itrs;
		
	}

	public static List<Itr> getLista() {
		return lista;
	}

	public static void setLista(List<Itr> lista) {
		ListaItrs.lista = lista;
	}
}
