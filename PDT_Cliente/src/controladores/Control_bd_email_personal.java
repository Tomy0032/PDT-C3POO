package controladores;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import interfaces.ControlCampo;

public class Control_bd_email_personal implements ControlCampo{
	
	private String email;
	private boolean ok = false;
	
	public Control_bd_email_personal(String email) {
		this.email = email;
	}
	
	public void controlCampo(){
		
		try{
			
			UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
			
			Usuario usuario = new Usuario();
			usuario = usuarioBean.findAllForPersonalEmail(email).get(0);
			ok = false;
			
		}catch(Exception e) {
			ok = true;
		}
		
	}
	
	public boolean isOk() {
		return ok;
	}

}
