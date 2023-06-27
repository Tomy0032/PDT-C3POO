package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.enums.EstadoUsuario;

import componentes.PanelEditarMisDatos;
import datos.CrearUsuario;
import interfaz.Aplicacion;
import interfaz.Ingrese_password;
import interfaz.Registrarse;
import listas.ListaUsuarios;
import mail.EmailSenderService;

public class ControlBotonEditarMisDatos implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		String info="EDITAR USUARIO\n";
		info+="¿Desea editar sus datos?";	
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {

			Control_formato_email email = new Control_formato_email(PanelEditarMisDatos.getPersonalField().getText());
			email.controlCampo();
					
			Control_fecha_nac edad = new Control_fecha_nac(PanelEditarMisDatos.getNacimientoDateChooser().getDate());
			edad.controlCampo();
			
			Control_anio_ingreso ingreso = new Control_anio_ingreso(PanelEditarMisDatos.getYearChooser().getYear());
			ingreso.controlCampo();
			
			if(!email.isOk()) {
				
				PanelEditarMisDatos.setAviso("Formato de correo personal incorrecto");
				
			}else if(!edad.isOk()) {
				
				PanelEditarMisDatos.setAviso("Debe ser mayor de edad");
				
			}else if(!ingreso.isOk()) {
				
				PanelEditarMisDatos.setAviso("El año de ingreso no puede ser menor de 2014 o mayor al año actual");
				
			}else {
				
				boolean continuar = true;
				
				if(!(PanelEditarMisDatos.getPersonalField().getText().equals(Aplicacion.getUsuario().getCorreoPersonal()))) {
					Control_bd_email_personal bd_email = new Control_bd_email_personal(PanelEditarMisDatos.getPersonalField().getText());
					try {
						bd_email.controlCampo();
						if(!bd_email.isOk()) {
							
							PanelEditarMisDatos.setAviso("Ya existe un usuario registrado con ese correo personal!");
							continuar = false;
						}
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
				
				if(!(PanelEditarMisDatos.getTelefonoField().getText().equals(Aplicacion.getUsuario().getTelefono()))) {
					Control_bd_telefono bd_telefono = new Control_bd_telefono(PanelEditarMisDatos.getTelefonoField().getText());
					try {
						bd_telefono.controlCampo();
						if(!bd_telefono.isOk()) {
							
							PanelEditarMisDatos.setAviso("Ya existe un usuario registrado con ese telefono!");
							continuar = false;
						}
					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
					
				if(continuar) {
					
					Date fecha = PanelEditarMisDatos.getNacimientoDateChooser().getDate();
					long f = fecha.getTime();
					java.sql.Date date = new java.sql.Date(f);
					
					String[] datos = {
							PanelEditarMisDatos.getApellido1Field().getText(),
							PanelEditarMisDatos.getApellido2Field().getText(),
							PanelEditarMisDatos.getPersonalField().getText(),
							date.toString(),
							PanelEditarMisDatos.getNombre1Field().getText(),
							PanelEditarMisDatos.getNombre2Field().getText(),
							PanelEditarMisDatos.getTelefonoField().getText(),
							PanelEditarMisDatos.getItr_comboBox().getSelectedItem().toString(),
							PanelEditarMisDatos.getDepartam_comboBox().getSelectedItem().toString(),
							PanelEditarMisDatos.getLocalidad_comboBox().getSelectedItem().toString(),
							Integer.toString(PanelEditarMisDatos.getYearChooser().getYear()),
							PanelEditarMisDatos.getRol_comboBox().getSelectedItem().toString(),
							PanelEditarMisDatos.getArea_comboBox().getSelectedItem().toString(),
							Aplicacion.getTipoUsuario()
					};
					
					try {
						CrearUsuario.editar(Aplicacion.getUsuario(), datos);
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		}		
				
		
	}

}
