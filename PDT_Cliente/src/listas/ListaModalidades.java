package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.ModalidadBeanRemote;
import com.entities.Modalidad;
import com.exception.ServicesException;

public class ListaModalidades {
	
	private static ListaModalidades listaModalidades = null;
	private static List<Modalidad> lista;
	
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
		
		ModalidadBeanRemote modalidadBean = (ModalidadBeanRemote) InitialContext.doLookup("PDT_EJB/ModalidadBean!com.services.ModalidadBeanRemote"); 
		
		try {				
			lista = modalidadBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Modalidad m : lista) {
			
			s.add(m.getNombre());
			
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
