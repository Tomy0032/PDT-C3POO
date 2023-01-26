package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import interfaz.Login;

public class ControlBotonIniciar{

	@SuppressWarnings("deprecation")
	public static List<String> comprobarUsuario() throws NamingException{
		
		Login.getLblAviso().setVisible(false);
		Login.getLblAviso2().setVisible(false);
		
		List<String> verificacion = new ArrayList<>();
		verificacion.add("no");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote");
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext.doLookup("PDT_EJB/AnalistaBean!com.services.AnalistaBeanRemote"); 
		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext.doLookup("PDT_EJB/TutorBean!com.services.TutorBeanRemote"); 
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext.doLookup("PDT_EJB/EstudianteBean!com.services.EstudianteBeanRemote"); 
		
		String nombreUsuario = Login.getNom_usuario_login().getText();
		String contrasena = Login.getPassw_usuario_login().getText();
	
		Control_campos_login control_login = new Control_campos_login(nombreUsuario, contrasena);
		control_login.controlCampo();
		
		if(control_login.isOk()) {
			
			Usuario usuario = new Usuario();
			
			try {
				
				usuario = usuarioBean.inicioSesion(nombreUsuario, contrasena);
				verificacion.set(0,"si");
				
			}
			catch(Exception e) {
				Login.getLblAviso().setVisible(true);
				System.out.println(e.getMessage());
				return verificacion; 
			}
			
			try {
				analistaBean.findForUser(usuario);
				verificacion.add("ANALISTA");
				verificacion.add(Long.toString(usuario.getIdUsuario()));
				return verificacion;
			}catch(Exception e){
				
			}
			try {
				estudianteBean.findForUser(usuario);
				verificacion.add("ESTUDIANTE");
				verificacion.add(Long.toString(usuario.getIdUsuario()));
				return verificacion;
			}catch(Exception e){
				
			}
			
			try {
				tutorBean.findForUser(usuario);
				verificacion.add("TUTOR");
				verificacion.add(Long.toString(usuario.getIdUsuario()));
				return verificacion;
			}catch(Exception e){
				
			}
			
		}else {
			Login.getLblAviso2().setVisible(true);
		}
		
		return verificacion;
				
	}

}
