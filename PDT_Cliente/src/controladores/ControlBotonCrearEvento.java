package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.NamingException;

import componentes.PanelNuevoEvento;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonCrearEvento implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		Control_fecha_inicio_evento inicio = new Control_fecha_inicio_evento(
				PanelNuevoEvento.getDateChooserInicioEvento().getDate(),
				PanelNuevoEvento.getHoraInicioSpinner());
		inicio.controlCampo();
		
		Control_fecha_fin_evento fin = new Control_fecha_fin_evento(
				PanelNuevoEvento.getDateChooserInicioEvento().getDate(),
				PanelNuevoEvento.getDateChooserFinEvento().getDate(),
				PanelNuevoEvento.getHoraInicioSpinner(),
				PanelNuevoEvento.getHoraFinSpinner());
		fin.controlCampo();

		
//		Control_formato_email email = new Control_formato_email(Registrarse.getMail_pers_field().getText());
//		email.controlCampo();
//		
//		Control_email_institucional email_instit = new Control_email_institucional(Registrarse.getMail_instit_field().getText());
//		email_instit.controlCampo();
//		
//		Control_fecha_nac edad = new Control_fecha_nac(Registrarse.getDateChooser().getDate());
//		edad.controlCampo();
//		
//		Control_anio_ingreso ingreso = new Control_anio_ingreso(Registrarse.getYearChooser().getYear());
//		ingreso.controlCampo();
//		
		if(!inicio.isOk()) {
			
			PanelNuevoEvento.setAviso("La hora y fecha de inicio debe ser posterior a la actual");
			
		}else if(!fin.isOk()) {
			
			PanelNuevoEvento.setAviso("La hora y fecha de finalizacion debe ser posterior a la de inicio");
			
		}else {
			
			PanelNuevoEvento.setAviso("");

			
		}
//		else if(!email.isOk()) {
//			
//			Registrarse.setAviso("Formato de correo personal incorrecto");
//			
//		}else if(!email_instit.isOk()) {
//			
//			Registrarse.setAviso("Formato de correo institucional incorrecto");
//			
//		}else if(!edad.isOk()) {
//			
//			Registrarse.setAviso("Debe ser mayor de edad");
//			
//		}else if(!ingreso.isOk()) {
//			
//			Registrarse.setAviso("El año de ingreso no puede ser menor de 2014 o mayor al año actual");
//			
//		}else {
//			
//			String nombreUsuario;
//			if(Registrarse.getTipo_usu_comboBox().getSelectedItem().toString().equals("ESTUDIANTE")) {
//				nombreUsuario = Registrarse.getMail_instit_field().getText().replaceAll("@estudiantes.utec.edu.uy", "");
//			}
//			else {
//				nombreUsuario = Registrarse.getMail_instit_field().getText().replaceAll("@utec.edu.uy", "");
//			}
//			
//			System.out.println(nombreUsuario);
//			
//			Control_bd_nombreUsuario bd_nombreUsuario = new Control_bd_nombreUsuario(nombreUsuario);
//			try {
//				bd_nombreUsuario.controlCampo();
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//			
//			Control_bd_email_personal bd_email = new Control_bd_email_personal(Registrarse.getMail_pers_field().getText());
//			try {
//				bd_email.controlCampo();
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//			
//			Control_bd_email_institucional bd_email_institucional = new Control_bd_email_institucional(Registrarse.getMail_instit_field().getText());
//			try {
//				bd_email_institucional.controlCampo();
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//			
//			Control_bd_documento bd_documento = new Control_bd_documento(Registrarse.getCedu_field().getText());
//			try {
//				bd_documento.controlCampo();
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//			
//			Control_bd_telefono bd_telefono = new Control_bd_telefono(Registrarse.getTelef_field().getText());
//			try {
//				bd_telefono.controlCampo();
//			} catch (NamingException e) {
//				e.printStackTrace();
//			}
//			if(!bd_nombreUsuario.isOk()) {
//				
//				Registrarse.setAviso("Ya existe un usuario registrado con ese nombre de usuario!");
//				
//			}
//			else if(!bd_email.isOk()) {
//				
//				Registrarse.setAviso("Ya existe un usuario registrado con ese correo personal!");
//				
//			}
//			else if(!bd_email_institucional.isOk()) {
//				
//				Registrarse.setAviso("Ya existe un usuario registrado con ese correo institucional!");
//				
//			}
//			else if(!bd_documento.isOk()) {
//				
//				Registrarse.setAviso("Ya existe un usuario registrado con ese documento!");
//				
//			}
//			else if(!bd_telefono.isOk()) {
//				
//				Registrarse.setAviso("Ya existe un usuario registrado con ese telefono!");
//				
//			}else {
//				
//				new Ingrese_password();
//				
//			}
//		}
	}

}
