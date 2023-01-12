package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import datos.CrearUsuario;
import interfaz.Ingrese_password;
import interfaz.Login;
import interfaz.Registrarse;

public class ControlBotonPassword {

	public ControlBotonPassword() {
	}
	
	public boolean controlar() {
		// TODO Auto-generated method stub
		
		boolean continuar = true;
		
		Ingrese_password.getLblAviso().setVisible(false);
		Ingrese_password.getLblAviso2().setVisible(false);
		Ingrese_password.getLblAviso3().setVisible(false);
		Ingrese_password.getLblAviso4().setVisible(false);
		
		@SuppressWarnings("deprecation")
		String campo1 = Ingrese_password.getPassword().getText().toString();
		@SuppressWarnings("deprecation")
		String campo2 = Ingrese_password.getRep_password().getText().toString();
		
		if(campo1.length() < 8) {
			
			continuar = false;
			Ingrese_password.getLblAviso4().setVisible(true);
			
		}else {
		
			try {
				
				int p = Integer.parseInt(campo1);
				continuar = false;
				Ingrese_password.getLblAviso3().setVisible(true);
				
			}catch(Exception ex) {	
				
				if(!campo1.matches(".*[0-9].*")){
					continuar = false;
					Ingrese_password.getLblAviso2().setVisible(true);
				}
				else if(!campo1.equals(campo2)) { 
					continuar = false;
					Ingrese_password.getLblAviso().setVisible(true);
				}
				
			}
		}
		
		
		
		if(continuar) {
			
			Date fecha = Registrarse.getDateChooser().getDate();
			long f = fecha.getTime();
			java.sql.Date date = new java.sql.Date(f);
			
			String[] datos = {
					Registrarse.getTipo_usu_comboBox().getSelectedItem().toString(),
					Registrarse.getApe1_field().getText(),
					Registrarse.getApe2_field().getText(),
					Registrarse.getMail_instit_field().getText(),
					Registrarse.getMail_pers_field().getText(),
					date.toString(),
					Registrarse.getNom1_field().getText(),
					Registrarse.getNom2_field().getText(),
					Registrarse.getTelef_field().getText(),
					Registrarse.getCedu_field().getText(),
					Registrarse.getItr_comboBox().getSelectedItem().toString(),
					Registrarse.getDepartam_comboBox().getSelectedItem().toString(),
					Registrarse.getLocalidad_comboBox().getSelectedItem().toString(),
					Integer.toString(Registrarse.getYearChooser().getYear()),
					Registrarse.getRol_comboBox().getSelectedItem().toString(),
					Registrarse.getArea_comboBox().getSelectedItem().toString(),
					campo1
					};
			
			try {
				if(CrearUsuario.crear(datos)) {
					return true;
				}
				return false;
			} catch (NamingException e1) {
				e1.printStackTrace();
			}
			
		}
		return false;
				
	}

}
