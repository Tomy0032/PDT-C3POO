package controladores;

import java.time.LocalDate;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import interfaces.ControlCampo;
import interfaz.Registrarse;

public class Control_anio_ingreso implements ControlCampo{

	private boolean ok;
	private int anio;
	private LocalDate fecha_hoy;
	
	public Control_anio_ingreso(int anio) {
		
		this.anio = anio;
		fecha_hoy = LocalDate.now();
	}
	
	@Override
	public void controlCampo() {
		// TODO Auto-generated method stub
		
		int anio_minimo = 2014;
		int este_anio = fecha_hoy.getYear();
		
		ok = (anio >= anio_minimo && anio <= este_anio);
			
	}

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return ok;
	}

	

}
