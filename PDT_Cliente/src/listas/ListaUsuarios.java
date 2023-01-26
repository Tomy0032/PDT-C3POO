package listas;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import datos.ComprobarTipoUsuario;

public class ListaUsuarios {
	
	private static ListaUsuarios listaUsuarios = null;
	private static List<Usuario> lista;
	
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
		
	}
	
	public static String[] getListaString() {
		
		ArrayList<String> s = new ArrayList<>();
		
		for(Usuario u : lista) {
			
			s.add(u.getNombreUsuario());
			
		}
		
		String[] tipos = s.toArray(new String[0]);
		return tipos;
		
	}
	
	public static Object[][] getListaStringListado() {
		
//		ArrayList<String> s = new ArrayList<>();
//		Object[][] list = {
//				{"Activo","tomas.gonzalez","Analista","Tomas","Gonzalez","ITR Centro-Sur"},
//				{"Activo","tomas.gonzalez","Analista","Tomas","Gonzalez","ITR Centro-Sur"}
//				};
//		for(Usuario u : lista) {
//			
//			s.add(u.getNombreUsuario());
//			
//		}
//		
//		String[] usuarios = s.toArray(new String[0]);
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
		
		for(Usuario u : lista) {
			linea = new ArrayList<>();
			if(u.getEliminado()) {
				linea.add("Eliminado");
			}else if(u.getActivo()) {
				linea.add("Activo");
			}else{
				linea.add("Sin validar");
			}
			linea.add(u.getNombreUsuario());
			try {
				linea.add(ComprobarTipoUsuario.is(u));
			} catch (NamingException e) {
				e.printStackTrace();
			}
			linea.add(u.getNombre1());
			linea.add(u.getApellido1());
			linea.add(u.getItr().getNombre());
			contenedor.add(linea.toArray(new String[0]));
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
