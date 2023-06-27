package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.naming.NamingException;
import javax.swing.JOptionPane;

import componentes.PanelEditarMisDatos;
import datos.CrearUsuario;
import interfaz.Aplicacion;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonEditarPassword implements ActionListener {
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		String info="EDITAR CONTRASEÑA\n";
		info+="¿Desea editar su contraseña?";	
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {
		
			if(PanelEditarMisDatos.getPasswordField().getText().equals("")|| PanelEditarMisDatos.getNewPasswordField().getText().equals("") || PanelEditarMisDatos.getRepNewPasswordField().getText().equals("")) {
				
				PanelEditarMisDatos.setAviso2("Debe llenar todos los campos");
				
			}else if(PanelEditarMisDatos.getPasswordField().getText() == null || PanelEditarMisDatos.getNewPasswordField().getText() == null || PanelEditarMisDatos.getRepNewPasswordField().getText() == null) {
				
				PanelEditarMisDatos.setAviso2("Debe llenar todos los campos");
				
			}else if(!(Aplicacion.getUsuario().getContrasena().equals(PanelEditarMisDatos.getPasswordField().getText()))) {
	
				
				PanelEditarMisDatos.setAviso2("La contraseña ingresada no es correcta");
				
			}else if(!(PanelEditarMisDatos.getNewPasswordField().getText().equals(PanelEditarMisDatos.getRepNewPasswordField().getText()))) {
				
				PanelEditarMisDatos.setAviso2("Las constraseñas no coinciden");
				
			}else if(PanelEditarMisDatos.getPasswordField().getText().equals(PanelEditarMisDatos.getNewPasswordField().getText())) {
				
				PanelEditarMisDatos.setAviso2("La nueva contraseña no puede ser igual que la anterior");
				
			}else {
								
					try {
						if(CrearUsuario.editarPassword(PanelEditarMisDatos.getNewPasswordField().getText())) {
							PanelEditarMisDatos.getPasswordField().setText("");
							PanelEditarMisDatos.getNewPasswordField().setText("");
							PanelEditarMisDatos.getRepNewPasswordField().setText("");
						}
						
						
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
		}
	}

}
