package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.TipoTutorBeanRemote;
import com.entities.TipoTutor;
import com.exception.ServicesException;

public class ListaTiposTutor {
	
	private static ListaTiposTutor listaTipos = null;
	private static List<TipoTutor> lista;
	
	private ListaTiposTutor() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaTiposTutor getInstance() {
		if(listaTipos == null) {
			listaTipos = new ListaTiposTutor(); 
		}
		return listaTipos;
	}
	
	public static void cargarLista() throws NamingException {
		
		TipoTutorBeanRemote tipoBean = (TipoTutorBeanRemote) InitialContext.doLookup("PDT_EJB/TipoTutorBean!com.services.TipoTutorBeanRemote"); 
		
		try {				
			lista = tipoBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(TipoTutor t : lista) {
			
			s.add(t.getNombre());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}

	public static List<TipoTutor> getLista() {
		return lista;
	}

	public static void setLista(List<TipoTutor> lista) {
		ListaTiposTutor.lista = lista;
	}
	
}
