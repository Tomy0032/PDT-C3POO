package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			Registrarse.setAviso("Los campos marcados con (*) son obligatorios.");
		}
	}

}
