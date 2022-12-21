package controladores;

import java.util.LinkedList;

import interfaces.ControlCampo;
import interfaz.Registrarse;

public class ActivadorBoton {

	private LinkedList<ControlCampo> listaControladores;
	
	
	public ActivadorBoton(LinkedList<ControlCampo> c) {
		
		listaControladores = new LinkedList<ControlCampo>();
		
		for(int i=0; i<c.size(); i++) {
			
			listaControladores.add(c.get(i));
		}
	}
	
	
	public void activarBoton() {
		
		
		Registrarse.getBtn_enviar().setEnabled(true);

		Control_longit_min campo = null;
		
		for (ControlCampo campoAVerificar : listaControladores) {
			
			if(campoAVerificar instanceof Control_longit_min) {
				
				campo = (Control_longit_min)campoAVerificar;
					
				}
			if(!campo.isOk()) {
				
				Registrarse.getBtn_enviar().setEnabled(false);
				break;
			}else {
				
				Registrarse.getBtn_enviar().setEnabled(true);

			}
			
		}
		
	}

	
}
