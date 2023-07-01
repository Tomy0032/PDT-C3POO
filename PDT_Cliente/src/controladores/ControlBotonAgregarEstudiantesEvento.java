package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.SimpleDateFormat;


import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;

import componentes.PanelEditarUsuario;
import componentes.PanelFichaEvento;
import componentes.PanelListadoEventos;
import componentes.PanelNuevoEvento;
import datos.CrearEvento;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonAgregarEstudiantesEvento implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		String info="EDITAR EVENTO\n";
		info+="¿Desea editar la lista de estudiantes del evento?";	
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {
		
			if(PanelFichaEvento.getDateChooserInicioEvento().getDate() == null) {
				
				PanelFichaEvento.setAviso("Debe ingresar fecha de inicio");
			
			}else if(PanelFichaEvento.getDateChooserFinEvento().getDate() == null) {
				
				PanelFichaEvento.setAviso("Debe ingresar fecha de finalización");
			
			}else {
			
				try {
					
					PanelFichaEvento.getEstudiantesAgregados().get(0);					
					ArrayList<String> estudiantes = PanelFichaEvento.getEstudiantesAgregados();
						
					PanelNuevoEvento.setAviso("");			

					if(CrearEvento.editarEstudiantes(PanelListadoEventos.getEvento(),estudiantes)) {
//						PanelFichaEvento.limpiar();
					}		
					
				}catch(Exception e) {
					PanelFichaEvento.getAviso().setVisible(true);
					PanelFichaEvento.setAviso("Debe seleccionar al menos un estudiante");
					System.out.println(e.getMessage());
				}
	
			}
		}
	}

}
