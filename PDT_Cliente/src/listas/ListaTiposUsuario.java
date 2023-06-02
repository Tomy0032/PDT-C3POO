package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.TipoUsuarioBeanRemote;
import com.entities.TipoUsuario;
import com.exception.ServicesException;

public class ListaTiposUsuario {
	
	private static ListaTiposUsuario listaTipos = null;
	private static List<TipoUsuario> lista;
	
	private ListaTiposUsuario() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaTiposUsuario getInstance() {
		if(listaTipos == null) {
			listaTipos = new ListaTiposUsuario(); 
		}
		return listaTipos;
	}
	
	public static void cargarLista() throws NamingException {
		
		TipoUsuarioBeanRemote tipoBean = (TipoUsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/TipoUsuarioBean!com.services.TipoUsuarioBeanRemote"); 
		
		try {				
			lista = tipoBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(TipoUsuario t : lista) {
			
			s.add(t.getNombre());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}

	public static List<TipoUsuario> getLista() {
		return lista;
	}

	public static void setLista(List<TipoUsuario> lista) {
		ListaTiposUsuario.lista = lista;
	}
	
}
