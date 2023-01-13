package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Departamento;
import com.exception.ServicesException;
import com.services.DepartamentoBeanRemote;

public class ListaDepartamentos {
	
	private static ListaDepartamentos listaDepartamentos = null;
	private static List<Departamento> lista;	

	private ListaDepartamentos() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaDepartamentos getInstance() {
		
		if(listaDepartamentos == null) {
			listaDepartamentos = new ListaDepartamentos();
		}
		return listaDepartamentos;
	}
	
	public static void cargarLista() throws NamingException {
		
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 
		
		try {				
			lista = departamentoBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Departamento d : lista) {
			
			s.add(d.getNombre());
			
		}
		
		String[] departamentos = s.toArray(new String[0]);
		return departamentos;
		
	}

	public static List<Departamento> getLista() {
		return lista;
	}

	public static void setLista(List<Departamento> lista) {
		ListaDepartamentos.lista = lista;
	}
	
}
