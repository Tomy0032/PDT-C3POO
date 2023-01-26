package controladores;
import java.awt.Cursor;
import java.util.LinkedList;
import interfaces.ControlCampo;
import interfaz.Registrarse;

public class ActivadorBoton {

	private LinkedList<ControlCampo> listaControladores;	
	
	public ActivadorBoton(LinkedList<ControlCampo> c) {
		
		listaControladores = c;
	}	
	
	public void activarBoton() {
		
		
		Registrarse.getBtn_enviar().setEnabled(true);
		
		for (ControlCampo campoAVerificar : listaControladores) {
								
			if(! campoAVerificar.isOk()) {
				
				Registrarse.getBtn_enviar().setEnabled(false);
				Registrarse.getBtn_enviar().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				break;
			}else {
				
				Registrarse.getBtn_enviar().setEnabled(true);
				Registrarse.getBtn_enviar().setCursor(new Cursor(Cursor.HAND_CURSOR));

			}
			
		}
		
	}

	
}
