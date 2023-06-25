package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;

import componentes.PanelEditarUsuario;
import datos.CrearUsuario;
import interfaz.Aplicacion;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonEditarPassword implements ActionListener {
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(PanelEditarUsuario.getPasswordField().getText().equals("")|| PanelEditarUsuario.getNewPasswordField().getText().equals("") || PanelEditarUsuario.getRepNewPasswordField().getText().equals("")) {
			
			PanelEditarUsuario.setAviso2("Debe llenar todos los campos");
			
		}else if(PanelEditarUsuario.getPasswordField().getText() == null || PanelEditarUsuario.getNewPasswordField().getText() == null || PanelEditarUsuario.getRepNewPasswordField().getText() == null) {
			
			PanelEditarUsuario.setAviso2("Debe llenar todos los campos");
			
		}else if(!(Aplicacion.getUsuario().getContrasena().equals(PanelEditarUsuario.getPasswordField().getText()))) {

			
			PanelEditarUsuario.setAviso2("La contraseña ingresada no es correcta");
			
		}else if(!(PanelEditarUsuario.getNewPasswordField().getText().equals(PanelEditarUsuario.getRepNewPasswordField().getText()))) {
			
			PanelEditarUsuario.setAviso2("Las constraseñas no coinciden");
			
		}else if(PanelEditarUsuario.getPasswordField().getText().equals(PanelEditarUsuario.getNewPasswordField().getText())) {
			
			PanelEditarUsuario.setAviso2("La nueva contraseña no puede ser igual que la anterior");
			
		}else {
							
				try {
					if(CrearUsuario.editarPassword(PanelEditarUsuario.getNewPasswordField().getText())) {
						PanelEditarUsuario.getPasswordField().setText("");
						PanelEditarUsuario.getNewPasswordField().setText("");
						PanelEditarUsuario.getRepNewPasswordField().setText("");
					}
					
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
	}

}
