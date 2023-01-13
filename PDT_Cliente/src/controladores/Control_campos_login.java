package controladores;

import javax.naming.NamingException;

import interfaces.ControlCampo;

public class Control_campos_login implements ControlCampo{
	
	private String nombreUsuario;
	private String constrasena;
	private boolean ok;
	
	public Control_campos_login(String nombreUsuario, String constrasena) {
		this.nombreUsuario = nombreUsuario;
		this.constrasena = constrasena;
	}

	@Override
	public void controlCampo() throws NamingException {
		if(nombreUsuario.equals("") || constrasena.equals("")) {
			ok = false;
		}else {
			ok = true;
		}
	}

	@Override
	public boolean isOk() {		
		return ok;
	}
	
	

}
