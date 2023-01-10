package controladores;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import interfaces.ControlCampo;
import interfaz.Registrarse;

public class Control_edad implements ControlCampo{

	private boolean edadOk;
	private LocalDate nacimiento;
	private LocalDate minimo;
	private LocalDate maximo;
	
	  
	
	public Control_edad(Date nacimiento) {
		
		this.nacimiento = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		minimo = LocalDate.now().minusYears(100l); //fecha actual menos 100 años
		maximo = LocalDate.now().minusYears(12l);  //fecha actual menos 12 años
	}
	
	@Override
	public void controlCampo() {
		// TODO Auto-generated method stub
			
		//la persona tiene que tener minimo 12 y maximo 100 años 
		edadOk = (nacimiento.isAfter(minimo) && nacimiento.isBefore(maximo));	
	
	}

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return edadOk;
	}

}
