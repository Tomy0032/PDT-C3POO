package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;

import datos.CrearUsuario;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonEnviar implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Control_ci ci = Control_ci.getInstance();
		ci.controlCampo();
		
		Control_formato_email email = new Control_formato_email();
		email.controlCampo();
		
		if(!ci.isOk() || !email.isOk()) {
			
			Registrarse.setAviso("Hay algo mal con tus datos!");
			
		}else {
			
			Ingrese_password p = new Ingrese_password();		
			
		}
	}

	private String valueOf(int year) {
		// TODO Auto-generated method stub
		return null;
	}

}
