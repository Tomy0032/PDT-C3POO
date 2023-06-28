package datos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import componentes.PanelEditarUsuario;
import componentes.PanelNuevoEvento;
import interfaz.Aplicacion;
import listas.ListaUsuarios;
import mail.EmailSenderService;
import utilidades.Utilidades;

public class OperacionUsuario {
	
	public static void mostrar(int fila) throws ServicesException, NamingException {
		Utilidades.filaSeleccionada=fila;
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		Usuario usuario = usuarioBean.findAllForUsername(Aplicacion.getTablaUsuarios().getValueAt(fila, Utilidades.USUARIO).toString()).get(0);
		
		String info="INFO USUARIO\n";
		info+="Documento: "+usuario.getDocumento().getCaracteres()+"\n";
		info+="Tipo de usuario: "+Aplicacion.getTablaUsuarios().getValueAt(fila, Utilidades.TIPO).toString()+"\n";
		info+="Nombre de usuario: "+usuario.getNombreUsuario()+"\n";
		info+="Nombre completo: "+usuario.getNombre1();
		if(!(usuario.getNombre2() == null)) {
			info+=" "+usuario.getNombre2();
		}
		info+=" "+usuario.getApellido1();
		if(!(usuario.getApellido2() == null)) {
			info+=" "+usuario.getApellido2()+"\n";
		}else {
			info+="\n";
		}
		info+="Correo institucional: "+usuario.getCorreoInstitucional()+"\n";
		info+="ITR: "+usuario.getItr().getNombre()+"\n";
		info+="Fecha de nacimiento: "+usuario.getFechaNacimiento()+"\n";
		
		JOptionPane.showMessageDialog(null, info);
	}
	
	public static void activar(int fila) throws ServicesException, NamingException {
		Utilidades.filaSeleccionada=fila;
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		Usuario usuario = usuarioBean.findAllForUsername(Aplicacion.getTablaUsuarios().getValueAt(fila, Utilidades.USUARIO).toString()).get(0);
		
		String info="ACTIVAR USUARIO\n";
		info+="¿Activar usuario "+usuario.getNombreUsuario()+"?";		
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {
			ExecutorService exec = Executors.newSingleThreadExecutor();
			exec.submit(() ->{
				EmailSenderService.correoActivacion(usuario.getCorreoInstitucional());
			});
			usuario.setEstado(EstadoUsuario.ACTIVO);
			usuarioBean.update(usuario);
			ListaUsuarios.cargarLista();
			PanelNuevoEvento.buscarTutor("");
			Aplicacion.filtros();			
		}
	}
	
	public static void eliminar(int fila) throws ServicesException, NamingException {
		Utilidades.filaSeleccionada=fila;
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		Usuario usuario = usuarioBean.findAllForUsername(Aplicacion.getTablaUsuarios().getValueAt(fila, Utilidades.USUARIO).toString()).get(0);
		
		String info="ELIMINAR USUARIO\n";
		info+="¿Eliminar usuario "+usuario.getNombreUsuario()+"?";	
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {
			ExecutorService exec = Executors.newSingleThreadExecutor();
			exec.submit(() ->{
				EmailSenderService.correoEliminacion(usuario.getCorreoInstitucional());
			});
			usuario.setEstado(EstadoUsuario.ELIMINADO);
			usuarioBean.update(usuario);
			ListaUsuarios.cargarLista();
			PanelNuevoEvento.buscarTutor("");
			Aplicacion.filtros();
		}			

	}

	public static void editar(int fila) throws ServicesException, NamingException {
		Utilidades.filaSeleccionada=fila;
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		Usuario usuario = usuarioBean.findAllForUsername(Aplicacion.getTablaUsuarios().getValueAt(fila, Utilidades.USUARIO).toString()).get(0);
		PanelEditarUsuario.setUsuario(usuario);
		PanelEditarUsuario.estasblecerDadtos();
		
	}

}
