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
import javax.swing.SpinnerDateModel;

import componentes.PanelNuevoEvento;
import datos.CrearEvento;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonCrearEvento implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(PanelNuevoEvento.getDateChooserInicioEvento().getDate() == null) {
			
			PanelNuevoEvento.setAviso("Debe ingresar fecha de inicio");
		
		}else if(PanelNuevoEvento.getDateChooserFinEvento().getDate() == null) {
			
			PanelNuevoEvento.setAviso("Debe ingresar fecha de finalización");
		
		}else {
		
			try {
				
				PanelNuevoEvento.getTutoresAgregados().get(0);
				
				
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
		
				if(!inicio.isOk()) {
					
					PanelNuevoEvento.setAviso("La hora y fecha de inicio debe ser posterior a la actual");
					
				}else if(!fin.isOk()) {
					
					PanelNuevoEvento.setAviso("La hora y fecha de finalizacion debe ser posterior a la de inicio");
					
				}else {
					
					Date fechaInicio = PanelNuevoEvento.getDateChooserInicioEvento().getDate();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			        String dateInicio = sdf.format(fechaInicio);
					
					Date fechaFin = PanelNuevoEvento.getDateChooserFinEvento().getDate();
			        String dateFin = sdf.format(fechaFin);
					
					LocalTime hora_inicio = LocalTime.ofInstant(((SpinnerDateModel) PanelNuevoEvento.getHoraInicioSpinner().getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId());
					String horaInicioString = hora_inicio.toString();
					horaInicioString = horaInicioString.substring(0,5);
					
					LocalTime hora_fin = LocalTime.ofInstant(((SpinnerDateModel) PanelNuevoEvento.getHoraFinSpinner().getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId());
					String horaFinString = hora_fin.toString();
					horaFinString = horaFinString.substring(0,5);
					
					ArrayList<String> tutores = PanelNuevoEvento.getTutoresAgregados();
					
					PanelNuevoEvento.setAviso("");			
					String[] datos = {
							PanelNuevoEvento.getTituloEventoField().getText(),
							PanelNuevoEvento.getTipoEventocomboBox().getSelectedItem().toString(),
							dateInicio,
							horaInicioString,
							dateFin,
							horaFinString,
							PanelNuevoEvento.getModalidadEventocomboBox().getSelectedItem().toString(),
							PanelNuevoEvento.getITREventocomboBox().getSelectedItem().toString()
					};
					
					if(CrearEvento.crear(datos,tutores)) {
						PanelNuevoEvento.limpiar();
					}
					
					
				}
				
			}catch(Exception e) {
				PanelNuevoEvento.setAviso("Debe seleccionar al menos un tutor");
				System.out.println(e.getMessage());
			}

		}
	}

}
