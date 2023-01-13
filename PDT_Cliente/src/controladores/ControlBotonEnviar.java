package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.NamingException;

import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonEnviar implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		Control_ci ci = Control_ci.getInstance();
		ci.controlCampo();
		
		Control_formato_email email = new Control_formato_email(Registrarse.getMail_pers_field().getText());
		email.controlCampo();
		
		Control_email_institucional email_instit = new Control_email_institucional(Registrarse.getMail_instit_field().getText());
		email_instit.controlCampo();
		
		Control_fecha_nac edad = new Control_fecha_nac(Registrarse.getDateChooser().getDate());
		edad.controlCampo();
		
		Control_anio_ingreso ingreso = new Control_anio_ingreso(Registrarse.getYearChooser().getYear());
		ingreso.controlCampo();
		
		if(!ci.isOk() || !email.isOk() || !email_instit.isOk() || !edad.isOk() || !ingreso.isOk()) {
			
			Registrarse.setAviso("Hay algo mal con tus datos!");
			
		}else {
			
			Control_bd_email_personal bd_email = new Control_bd_email_personal(Registrarse.getMail_pers_field().getText());
			try {
				bd_email.controlCampo();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			Control_bd_email_institucional bd_email_institucional = new Control_bd_email_institucional(Registrarse.getMail_instit_field().getText());
			try {
				bd_email_institucional.controlCampo();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			Control_bd_documento bd_documento = new Control_bd_documento(Registrarse.getCedu_field().getText());
			try {
				bd_documento.controlCampo();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			Control_bd_telefono bd_telefono = new Control_bd_telefono(Registrarse.getTelef_field().getText());
			try {
				bd_telefono.controlCampo();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			if(!bd_email.isOk()) {
				
				Registrarse.setAviso("Ya existe un usuario registrado con ese correo personal!");
				
			}
			else if(!bd_email_institucional.isOk()) {
				
				Registrarse.setAviso("Ya existe un usuario registrado con ese correo institucional!");
				
			}
			else if(!bd_documento.isOk()) {
				
				Registrarse.setAviso("Ya existe un usuario registrado con ese documento!");
				
			}
			else if(!bd_telefono.isOk()) {
				
				Registrarse.setAviso("Ya existe un usuario registrado con ese telefono!");
				
			}else {
				
				new Ingrese_password();
				
			}
		}
	}

}
