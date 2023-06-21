package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

public class ListaUsuarios {
	
	private static ListaUsuarios listaUsuarios = null;
	private static List<Usuario> lista;
	private static List<Usuario> listaAnalistas = new LinkedList<>();
	private static List<Usuario> listaEstudiantes = new LinkedList<>();
	private static List<Usuario> listaTutores = new LinkedList<>();
	
	private ListaUsuarios() {
		try {
			cargarLista();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaUsuarios getInstance() {
		if(listaUsuarios == null) {
			listaUsuarios = new ListaUsuarios(); 
		}
		return listaUsuarios;
	}
	
	public static void cargarLista() throws NamingException {
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		
		
		try {				
			lista = usuarioBean.findAll();
								
		} catch (ServicesException e) {
			System.out.println(e.getMessage());
		}
		
		for(Usuario u : lista) {
			
			String tipo = u.getTipoUsuario().getNombre();
			
			switch(tipo) {
			case "ANALISTA":
				listaAnalistas.add(u);
				break;
			case "ESTUDIANTE":
				listaEstudiantes.add(u);
				break;
			case "TUTOR":
				listaTutores.add(u);
				break;
			}
			
		}
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Usuario u : lista) {
			
			s.add(u.getNombreUsuario());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}
	
	public static String[] getListaTutoresEventoString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Usuario t : listaTutores) {
			
			s.add(t.getDocumento().getCaracteres() + " - " + t.getNombre1() + " " + t.getApellido1() + " - " + t.getArea().getNombre());
			
		}
		
		String[] tutores = s.toArray(new String[0]);
		return tutores;
		
	}
	
	public static String[] getListaTutoresEventoFiltroString(String text) throws NamingException, ServicesException {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(String t : getListaTutoresEventoString()) {
			
			if(t.toUpperCase().contains(text.toUpperCase())) {
				s.add(t);
			}
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}
		
	public static Object[][] getListaStringListado() throws NamingException, ServicesException {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
							
		for(Usuario u : lista) {
						
			linea = new ArrayList<>();
			if(u.getEstado().toString().equals("SIN_VALIDAR")){
				linea.add("SIN VALIDAR");
			}else {
				linea.add(u.getEstado().toString());
			}			
			linea.add(u.getNombreUsuario());
			linea.add(u.getTipoUsuario().getNombre());
			linea.add(u.getItr().getNombre());
			if(u.getTipoUsuario().getNombre().equals("ESTUDIANTE")) {
				String gen = u.getGeneracion().getAno().toString();
				linea.add(gen);
			}else {
				linea.add("");
			}
			linea.add("VER");
			if(u.getEstado().toString().equals("ACTIVO")){
				linea.add("");
			}else {
				linea.add("ACTIVAR");
			}
			if(u.getEstado().toString().equals("ELIMINADO")){
				linea.add("");
			}else {
				linea.add("ELIMINAR");
			}
			contenedor.add(linea.toArray(new String[0]));
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}
	
	public static Object[][] getListaStringListado(String itr, String estado) throws NamingException, ServicesException {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
		
		if(estado.equals("SIN VALIDAR")) {
			estado = "SIN_VALIDAR";
		}
		
		for(Usuario u : lista) {
			
			if(u.getEstado().toString().equals(estado) || estado.equals("TODOS")) {
				
				if(u.getItr().getNombre().toString().equals(itr) || itr.equals("TODOS")) {
				
					linea = new ArrayList<>();
					if(u.getEstado().toString().equals("SIN_VALIDAR")){
						linea.add("SIN VALIDAR");
					}else {
						linea.add(u.getEstado().toString());
					}			
					linea.add(u.getNombreUsuario());
					linea.add(u.getTipoUsuario().getNombre());
					linea.add(u.getItr().getNombre());
					if(u.getTipoUsuario().getNombre().equals("ESTUDIANTE")) {
						String gen = u.getGeneracion().getAno().toString();
						linea.add(gen);
					}else {
						linea.add("");
					}
					linea.add("VER");
					if(u.getEstado().toString().equals("ACTIVO")){
						linea.add("");
					}else {
						linea.add("ACTIVAR");
					}
					if(u.getEstado().toString().equals("ELIMINADO")){
						linea.add("");
					}else {
						linea.add("ELIMINAR");
					}
					contenedor.add(linea.toArray(new String[0]));
					
				}
				
			}
			
			
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}
	
	public static Object[][] getListaAnalistasStringListado(String itr, String estado) {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
		
		if(estado.equals("SIN VALIDAR")) {
			estado = "SIN_VALIDAR";
		}
		
		for(Usuario u : listaAnalistas) {
			
			if(u.getEstado().toString().equals(estado) || estado.equals("TODOS")) {
				
				if(u.getItr().getNombre().toString().equals(itr) || itr.equals("TODOS")) {
				
					linea = new ArrayList<>();
					if(u.getEstado().toString().equals("SIN_VALIDAR")){
						linea.add("SIN VALIDAR");
					}else {
						linea.add(u.getEstado().toString());
					}			
					linea.add(u.getNombreUsuario());
					linea.add(u.getTipoUsuario().getNombre());
					linea.add(u.getItr().getNombre());
					linea.add("");
					linea.add("VER");
					if(u.getEstado().toString().equals("ACTIVO")){
						linea.add("");
					}else {
						linea.add("ACTIVAR");
					}
					if(u.getEstado().toString().equals("ELIMINADO")){
						linea.add("");
					}else {
						linea.add("ELIMINAR");
					}
					contenedor.add(linea.toArray(new String[0]));
					
				}
				
			}
			
			
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}
	
	public static Object[][] getListaEstudiantesStringListado(String itr, String estado, String generacion) throws ServicesException, NamingException {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
		
		if(estado.equals("SIN VALIDAR")) {
			estado = "SIN_VALIDAR";
		}
						
		for(Usuario u : listaEstudiantes) {
			
			String gen = u.getGeneracion().getAno().toString();
			
			if(u.getEstado().toString().equals(estado) || estado.equals("TODOS")) {
				
				if(u.getItr().getNombre().toString().equals(itr) || itr.equals("TODOS")) {
					
					if(gen.equals(generacion) || generacion.equals("TODAS")) {
																
						linea = new ArrayList<>();
						if(u.getEstado().toString().equals("SIN_VALIDAR")){
							linea.add("SIN VALIDAR");
						}else {
							linea.add(u.getEstado().toString());
						}			
						linea.add(u.getNombreUsuario());
						linea.add(u.getTipoUsuario().getNombre());
						linea.add(u.getItr().getNombre());
						linea.add(gen);
						linea.add("VER");
						if(u.getEstado().toString().equals("ACTIVO")){
							linea.add("");
						}else {
							linea.add("ACTIVAR");
						}
						if(u.getEstado().toString().equals("ELIMINADO")){
							linea.add("");
						}else {
							linea.add("ELIMINAR");
						}
						contenedor.add(linea.toArray(new String[0]));
					}
					
				}
			}
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}
	
	public static Object[][] getListaTutoresStringListado(String itr, String estado) {
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
		
		if(estado.equals("SIN VALIDAR")) {
			estado = "SIN_VALIDAR";
		}
		
		for(Usuario u : listaTutores) {
			
			if(u.getEstado().toString().equals(estado) || estado.equals("TODOS")) {
				
				if(u.getItr().getNombre().toString().equals(itr) || itr.equals("TODOS")) {
					
					linea = new ArrayList<>();
					if(u.getEstado().toString().equals("SIN_VALIDAR")){
						linea.add("SIN VALIDAR");
					}else {
						linea.add(u.getEstado().toString());
					}			
					linea.add(u.getNombreUsuario());
					linea.add(u.getTipoUsuario().getNombre());
					linea.add(u.getItr().getNombre());
					linea.add("");
					linea.add("VER");
					if(u.getEstado().toString().equals("ACTIVO")){
						linea.add("");
					}else {
						linea.add("ACTIVAR");
					}
					if(u.getEstado().toString().equals("ELIMINADO")){
						linea.add("");
					}else {
						linea.add("ELIMINAR");
					}
					contenedor.add(linea.toArray(new String[0]));
				}	
			}
		}
		
		String[][] usuarios = (String[][]) contenedor.toArray(new String[0][]);
				
		return usuarios;
		
	}
	

	public static List<Usuario> getLista() {
		return lista;
	}

	public static void setLista(List<Usuario> lista) {
		ListaUsuarios.lista = lista;
	}
	
	

}
