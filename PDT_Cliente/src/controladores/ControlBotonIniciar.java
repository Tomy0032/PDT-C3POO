package controladores;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.services.UsuarioBeanRemote;

import interfaz.Login;

public class ControlBotonIniciar{

	@SuppressWarnings("deprecation")
	public static List<String> comprobarUsuario() throws NamingException{
		
		Login.getLblAviso().setVisible(false);
		Login.getLblAviso2().setVisible(false);
		Login.getLblAviso3().setVisible(false);
		
		List<String> verificacion = new ArrayList<>();
		verificacion.add("no");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote");
	
		String nombreUsuario = Login.getNom_usuario_login().getText();
		String contrasena = Login.getPassw_usuario_login().getText();
	
		Control_campos_login control_login = new Control_campos_login(nombreUsuario, contrasena);
		control_login.controlCampo();
		
		if(control_login.isOk()) {
			
			Usuario usuario = new Usuario();
			
			try {
				
				usuario = usuarioBean.inicioSesion(nombreUsuario, contrasena);
				if(usuario.getEstado()==EstadoUsuario.ACTIVO) {
					verificacion.set(0,"si");
				}else {
					verificacion.set(0,"no_activo");
					Login.getLblAviso3().setVisible(true);
					return verificacion; 
				}
					
				
			}
			catch(Exception e) {
				Login.getLblAviso().setVisible(true);
				System.out.println(e.getMessage());
				return verificacion; 
			}
			
			try {
				
				verificacion.add(usuario.getTipoUsuario().getNombre());
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
