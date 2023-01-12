package controladores;

import javax.naming.InitialContext;

import com.entities.Usuario;
import com.services.UsuarioBeanRemote;

import interfaces.ControlCampo;

public class Control_bd_telefono implements ControlCampo{

	private String telefono;
	private boolean ok = false;
	
	public Control_bd_telefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void controlCampo(){
		
		try{
			
			UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
			
			Usuario usuario = new Usuario();
			usuario = usuarioBean.findAllForTelephone(telefono).get(0);
			ok = false;
			
		}catch(Exception e) {
			ok = true;
		}
		
	}
	
	public boolean isOk() {
		return ok;
	}
	
}
