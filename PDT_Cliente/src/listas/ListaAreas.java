package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Area;
import com.services.AreaBeanRemote;

public class ListaAreas {
	
	private static ListaAreas listaAreas = null;
	private static List<Area> lista;
	
	private ListaAreas() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaAreas getListaAreas() {
		if(listaAreas == null) {
			listaAreas = new ListaAreas(); 
		}
		return listaAreas;
	}
	
	public static void cargarLista() throws NamingException {
		
		AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("PDT_EJB/AreaBean!com.services.AreaBeanRemote"); 
		
		try {				
			lista = areaBean.findAll();
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Area a : lista) {
			
			s.add(a.getNombre());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}

	public static List<Area> getLista() {
		return lista;
	}

	public static void setLista(List<Area> lista) {
		ListaAreas.lista = lista;
	}

}
