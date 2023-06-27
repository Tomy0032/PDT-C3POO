package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;
import javax.swing.JOptionPane;

import componentes.PanelEditarMisDatos;
import componentes.PanelEditarUsuario;
import datos.CrearUsuario;
import interfaz.Aplicacion;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonEditarUsuario implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		String info="EDITAR USUARIO\n";
		info+="¿Desea editar los datos del usuario " + PanelEditarUsuario.getUsuario().getNombreUsuario() + "?";	
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {
				
			Control_formato_email email = new Control_formato_email(PanelEditarUsuario.getPersonalField().getText());
			email.controlCampo();
					
			Control_fecha_nac edad = new Control_fecha_nac(PanelEditarUsuario.getNacimientoDateChooser().getDate());
			edad.controlCampo();
			
			Control_anio_ingreso ingreso = new Control_anio_ingreso(PanelEditarUsuario.getYearChooser().getYear());
			ingreso.controlCampo();
			
			if(!email.isOk()) {
				
				PanelEditarUsuario.setAviso("Formato de correo personal incorrecto");
				
			}else if(!edad.isOk()) {
				
				PanelEditarUsuario.setAviso("Debe ser mayor de edad");
				
			}else if(!ingreso.isOk()) {
				
				PanelEditarUsuario.setAviso("El año de ingreso no puede ser menor de 2014 o mayor al año actual");
				
			}else {
				
				boolean continuar = true;
				
				if(!(PanelEditarUsuario.getPersonalField().getText().equals(PanelEditarUsuario.getUsuario().getCorreoPersonal()))) {
					Control_bd_email_personal bd_email = new Control_bd_email_personal(PanelEditarUsuario.getPersonalField().getText());
					try {
						bd_email.controlCampo();
						if(!bd_email.isOk()) {
							
							PanelEditarUsuario.setAviso("Ya existe un usuario registrado con ese correo personal!");
							continuar = false;
						}
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
				
				if(!(PanelEditarUsuario.getTelefonoField().getText().equals(PanelEditarUsuario.getUsuario().getTelefono()))) {
					Control_bd_telefono bd_telefono = new Control_bd_telefono(PanelEditarUsuario.getTelefonoField().getText());
					try {
						bd_telefono.controlCampo();
						if(!bd_telefono.isOk()) {
							
							PanelEditarUsuario.setAviso("Ya existe un usuario registrado con ese telefono!");
							continuar = false;
						}
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
					
				if(continuar) {
					
					Date fecha = PanelEditarUsuario.getNacimientoDateChooser().getDate();
					long f = fecha.getTime();
					java.sql.Date date = new java.sql.Date(f);
					
					String[] datos = {
							PanelEditarUsuario.getApellido1Field().getText(),
							PanelEditarUsuario.getApellido2Field().getText(),
							PanelEditarUsuario.getPersonalField().getText(),
							date.toString(),
							PanelEditarUsuario.getNombre1Field().getText(),
							PanelEditarUsuario.getNombre2Field().getText(),
							PanelEditarUsuario.getTelefonoField().getText(),
							PanelEditarUsuario.getItr_comboBox().getSelectedItem().toString(),
							PanelEditarUsuario.getDepartam_comboBox().getSelectedItem().toString(),
							PanelEditarUsuario.getLocalidad_comboBox().getSelectedItem().toString(),
							Integer.toString(PanelEditarUsuario.getYearChooser().getYear()),
							PanelEditarUsuario.getRol_comboBox().getSelectedItem().toString(),
							PanelEditarUsuario.getArea_comboBox().getSelectedItem().toString(),
							PanelEditarUsuario.getTipo_usu_comboBox().getSelectedItem().toString()
					};
					
					try {
						CrearUsuario.editar(PanelEditarUsuario.getUsuario(), datos);
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
	}

}
