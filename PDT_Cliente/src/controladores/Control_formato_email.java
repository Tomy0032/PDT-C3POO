package controladores;

import java.util.regex.Pattern;

import interfaces.ControlCampo;
import interfaz.Registrarse;

public class Control_formato_email implements ControlCampo{

	private final String REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern patron = Pattern.compile(REGEX_PATTERN); 
	protected boolean match = false;		
	protected String email;
	
	public Control_formato_email(String email) {
		
		this.email = email;
	}
	
	@Override
	public void controlCampo() {
		// TODO Auto-generated method stub
		
		if(patron.matcher(email).matches()) {
			
			match = true;
			Registrarse.setAviso("Los campos marcados con (*) son obligatorios.");
		}else {
			
			match = false;
			Registrarse.setAviso("Hay algo mal con tus datos!");
		}
		
	}

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return match;
	}

}
