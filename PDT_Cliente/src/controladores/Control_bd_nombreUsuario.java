package controladores;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.UsuarioBeanRemote;

import interfaces.ControlCampo;

public class Control_bd_nombreUsuario implements ControlCampo{
	
	private String nombreUsuario;
	private boolean ok = false;
	
	public Control_bd_nombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public void controlCampo() throws NamingException{		
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		try{
			
			usuarioBean.findAllForUsername(nombreUsuario).get(0);			
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
