package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import datos.CrearUsuario;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonPassword implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		String campo1 = Ingrese_password.getPassword().getText().toString();
		@SuppressWarnings("deprecation")
		String campo2 = Ingrese_password.getRep_password().getText().toString();
		
		System.out.println(campo1);
		System.out.println(campo2);
		
		if(campo1.equals(campo2)) {
			
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
				CrearUsuario.crear(datos);
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else {
			
			Ingrese_password.getLblAviso().setVisible(true);
			
		}
				
	}

}
