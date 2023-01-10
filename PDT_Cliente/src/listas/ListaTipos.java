package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.TipoBeanRemote;
import com.entities.Departamento;
import com.entities.Tipo;

public class ListaTipos {
	
	private static ListaTipos listaTipos = null;
	private static List<Tipo> lista;
	
	private ListaTipos() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaTipos getInstance() {
		if(listaTipos == null) {
			listaTipos = new ListaTipos(); 
		}
		return listaTipos;
	}
	
	public static void cargarLista() throws NamingException {
		
		TipoBeanRemote tipoBean = (TipoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoBean!com.services.TipoBeanRemote"); 
		
		try {				
			lista = tipoBean.findAll();
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Tipo t : lista) {
			
			s.add(t.getNombre());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}

	public static List<Tipo> getLista() {
		return lista;
	}

	public static void setLista(List<Tipo> lista) {
		ListaTipos.lista = lista;
	}
	
}
