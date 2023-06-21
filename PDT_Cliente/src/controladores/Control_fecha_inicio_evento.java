package controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import componentes.TimeSpinner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import interfaces.ControlCampo;

public class Control_fecha_inicio_evento implements ControlCampo{

	private boolean ok;
	private LocalDate fecha;
	private LocalDate fecha_hoy;
	private int hora;
	private int minuto;
	private int hora_hoy;
	private int minuto_hoy;
	
	public Control_fecha_inicio_evento(Date fecha, JSpinner jSpinner) {
		
		this.fecha = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		fecha_hoy = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		
		String hora_ahora = dateFormat.format(Calendar.getInstance().getTime());
		LocalTime hora_seleccionada = LocalTime.ofInstant(((SpinnerDateModel) jSpinner.getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId());
		String horaS = hora_seleccionada.toString();
		
		hora_hoy = Integer.parseInt(hora_ahora.substring(0, 2));
		minuto_hoy = Integer.parseInt(hora_ahora.substring(3, 5));
		
		hora = Integer.parseInt(horaS.substring(0, 2));
		minuto = Integer.parseInt(horaS.substring(3, 5));
		
	}
	
	@Override
	public void controlCampo() {
		// TODO Auto-generated method stub
				
		ok = (fecha.isAfter(fecha_hoy));
		if(!ok) {
			ok = (hora > hora_hoy);
			if(!ok) {
				ok = (minuto > minuto_hoy);
			}
		}
			
	}

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return ok;
	}

	

}
