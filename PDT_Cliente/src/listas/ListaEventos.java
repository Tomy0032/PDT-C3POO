package listas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Evento;
import com.exception.ServicesException;
import com.services.EventoBeanRemote;

public class ListaEventos {
	
	private static ListaEventos listaEventos = null;
	private static List<Evento> lista;

	
	private ListaEventos() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaEventos getInstance() {
		if(listaEventos == null) {
			listaEventos = new ListaEventos(); 
		}
		return listaEventos;
	}
	
	public static void cargarLista() throws NamingException {
		
		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext.doLookup("PDT_EJB/EventoBean!com.services.EventoBeanRemote"); 	
		
		lista = eventoBean.findAll();

	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Evento e : lista) {
			
			s.add(e.getNombre());
			
		}
		
		String[] eventos = s.toArray(new String[0]);
		return eventos;
		
	}
	
		
	public static Object[][] getListaStringListado() throws NamingException, ServicesException {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
							
		for(Evento e : lista) {
						
			linea = new ArrayList<>();
			linea.add(e.getNombre());
			linea.add(e.getFechaHoraInicio().toString());
			linea.add(e.getModalidad().getNombre());
			linea.add(e.getItr().getNombre());
			linea.add(e.getEstado().getNombre());
			linea.add(Long.toString(e.getIdEvento()));
			
			contenedor.add(linea.toArray(new String[0]));
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}
	
	public static Object[][] getListaStringListado(String tipo, String itr, String estado, String modalidad, String fecha) throws NamingException, ServicesException {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM y");
		String fecha2;
				
		for(Evento e : lista) {
			
			fecha2 = sdf.format(e.getFechaHoraInicio());
			
			if(e.getEstado().getNombre().equals(estado) || estado.equals("TODOS")) {
				
				if(e.getItr().getNombre().toString().equals(itr) || itr.equals("TODOS")) {
					
					if(e.getTipo().getNombre().equals(tipo) || tipo.equals("TODOS")) {
						
						if(fecha.equals(fecha2) || fecha.equals("TODAS")) {
							
							if(e.getModalidad().getNombre().equals(modalidad) || modalidad.equals("TODAS")) {
										
								linea = new ArrayList<>();
								linea.add(e.getNombre());
								linea.add(e.getFechaHoraInicio().toString());
								linea.add(e.getModalidad().getNombre());
								linea.add(e.getItr().getNombre());
								linea.add(e.getEstado().getNombre());
					
								contenedor.add(linea.toArray(new String[0]));
								
							}
						
						}
					
					}
					
				}
				
			}
			
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}

	public static List<Evento> getLista() {
		return lista;
	}

	public static void setLista(List<Evento> lista) {
		ListaEventos.lista = lista;
	}
	
	

}
