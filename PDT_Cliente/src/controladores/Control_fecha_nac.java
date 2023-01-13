package controladores;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import interfaces.ControlCampo;

public class Control_fecha_nac implements ControlCampo{

	private boolean edadOk;
	private LocalDate nacimiento;
	private LocalDate minimo;
	private LocalDate maximo;
	
	  
	
	public Control_fecha_nac(Date nacimiento) {
		
		this.nacimiento = nacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		minimo = LocalDate.now().minusYears(100l); //fecha actual menos 100 años
		maximo = LocalDate.now().minusYears(17l);  //fecha actual menos 17 años
	}
	
	@Override
	public void controlCampo() {
		// TODO Auto-generated method stub
			
		//la persona tiene que tener minimo 17 y maximo 100 años 
		edadOk = (nacimiento.isAfter(minimo) && nacimiento.isBefore(maximo));	
	
	}

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return edadOk;
	}

}
