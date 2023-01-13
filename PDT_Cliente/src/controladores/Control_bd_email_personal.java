package controladores;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.UsuarioBeanRemote;

import interfaces.ControlCampo;

public class Control_bd_email_personal implements ControlCampo{
	
	private String email;
	private boolean ok = false;
	
	public Control_bd_email_personal(String email) {
		this.email = email;
	}
	
	public void controlCampo() throws NamingException{
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		
		try{			
			
			usuarioBean.findAllForPersonalEmail(email).get(0);
			ok = false;
			
		}catch(Exception e) {
			ok = true;
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean isOk() {
		return ok;
	}

}
