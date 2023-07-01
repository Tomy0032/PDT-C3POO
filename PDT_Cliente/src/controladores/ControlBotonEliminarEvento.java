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

import com.entities.ConvocatoriaAsistencia;

import componentes.PanelEditarUsuario;
import componentes.PanelFichaEvento;
import componentes.PanelListadoEventos;
import componentes.PanelNuevoEvento;
import datos.CrearEvento;
import interfaz.Ingrese_password;
import interfaz.Registrarse;

public class ControlBotonEliminarEvento implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		String info="ELIMINAR EVENTO\n";
		info+="¿Desea ELIMINAR el evento?";	
		
		int confirmado = JOptionPane.showConfirmDialog(null, info, "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

		if (JOptionPane.OK_OPTION == confirmado) {
			
			boolean salida = false;
			
			for(ConvocatoriaAsistencia c : PanelListadoEventos.getEvento().getConvocatoriasAsistencias()) {
				
				if(c.getAsistencia()!=null) {
					salida = true;					
				}
				
			}
			
			if(salida) {
				JOptionPane.showMessageDialog(null,"No se puede eliminar un evento al cual se registro asistencia");
			}
			else if(!PanelListadoEventos.getEvento().getEstado().getNombre().equals("FINALIZADO")) {
				
				salida = true;
				JOptionPane.showMessageDialog(null,"No se puede eliminar un evento corriente o futuro");
			
			}
			if(!salida) {
			
				try {
					
					PanelFichaEvento.getTutoresAgregados().get(0);
					
					
					Control_fecha_inicio_evento inicio = new Control_fecha_inicio_evento(
							PanelFichaEvento.getDateChooserInicioEvento().getDate(),
							PanelFichaEvento.getHoraInicioSpinner());
					inicio.controlCampo();
					
					Control_fecha_fin_evento fin = new Control_fecha_fin_evento(
							PanelFichaEvento.getDateChooserInicioEvento().getDate(),
							PanelFichaEvento.getDateChooserFinEvento().getDate(),
							PanelFichaEvento.getHoraInicioSpinner(),
							PanelFichaEvento.getHoraFinSpinner());
					fin.controlCampo();
			
					if(!inicio.isOk()) {
						
						PanelFichaEvento.setAviso("La hora y fecha de inicio debe ser posterior a la actual");
						
					}else if(!fin.isOk()) {
						
						PanelFichaEvento.setAviso("La hora y fecha de finalizacion debe ser posterior a la de inicio");
						
					}else {
						
						Date fechaInicio = PanelFichaEvento.getDateChooserInicioEvento().getDate();
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				        String dateInicio = sdf.format(fechaInicio);
						
						Date fechaFin = PanelFichaEvento.getDateChooserFinEvento().getDate();
				        String dateFin = sdf.format(fechaFin);
						
						LocalTime hora_inicio = LocalTime.ofInstant(((SpinnerDateModel) PanelFichaEvento.getHoraInicioSpinner().getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId());
						String horaInicioString = hora_inicio.toString();
						horaInicioString = horaInicioString.substring(0,5);
						
						LocalTime hora_fin = LocalTime.ofInstant(((SpinnerDateModel) PanelFichaEvento.getHoraFinSpinner().getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId());
						String horaFinString = hora_fin.toString();
						horaFinString = horaFinString.substring(0,5);
						
						ArrayList<String> tutores = PanelFichaEvento.getTutoresAgregados();
						
						PanelNuevoEvento.setAviso("");			
						String[] datos = {
								PanelFichaEvento.getTituloEventoField().getText(),
								PanelFichaEvento.getTipoEventocomboBox().getSelectedItem().toString(),
								dateInicio,
								horaInicioString,
								dateFin,
								horaFinString,
								PanelFichaEvento.getModalidadEventocomboBox().getSelectedItem().toString(),
								PanelFichaEvento.getITREventocomboBox().getSelectedItem().toString(),
								PanelFichaEvento.getLocalizacionEventoField().getText()
						};
						
						if(CrearEvento.editar(PanelListadoEventos.getEvento(), datos,tutores)) {
//							PanelFichaEvento.limpiar();
						}
						
						
					}
					
				}catch(Exception e) {
					PanelFichaEvento.setAviso("Debe seleccionar al menos un tutor");
					System.out.println(e.getMessage());
				}
	
			}
		}
	}

}
