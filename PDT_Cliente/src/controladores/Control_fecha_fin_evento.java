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

public class Control_fecha_fin_evento implements ControlCampo{

	private boolean ok;
	private LocalDate fecha_inicio;
	private LocalDate fecha_fin;
	private int hora_inicio;
	private int minuto_inicio;
	private int hora_fin;
	private int minuto_fin;
	
	public Control_fecha_fin_evento(Date fecha_inicio, Date fecha_fin, JSpinner hora_inicio, JSpinner hora_fin) {
		
		this.fecha_inicio = fecha_inicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		this.fecha_fin = fecha_fin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		
		String hora_inicio_string = LocalTime.ofInstant(((SpinnerDateModel) hora_inicio.getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId()).toString();
		String hora_fin_string = LocalTime.ofInstant(((SpinnerDateModel) hora_fin.getModel()).getDate().toInstant(), TimeZone.getDefault().toZoneId()).toString();
		
		this.hora_inicio = Integer.parseInt(hora_inicio_string.substring(0, 2));
		this.minuto_inicio = Integer.parseInt(hora_inicio_string.substring(3, 5));
		
		this.hora_fin = Integer.parseInt(hora_fin_string.substring(0, 2));
		this.minuto_fin = Integer.parseInt(hora_fin_string.substring(3, 5));
		
	}
	
	@Override
	public void controlCampo() {
		// TODO Auto-generated method stub
				
		ok = (fecha_fin.isAfter(fecha_inicio));
		if(!ok) {
			ok = (hora_fin > hora_inicio);
			if(!ok) {
				ok = (minuto_fin > minuto_inicio);
			}
		}
			
	}

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return ok;
	}

	

}
