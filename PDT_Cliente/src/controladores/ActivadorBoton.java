package controladores;
import java.awt.Cursor;
import java.util.LinkedList;

import componentes.PanelEditarMisDatos;
import componentes.PanelEditarUsuario;
import interfaces.ControlCampo;
import interfaz.Registrarse;

public class ActivadorBoton {

	private LinkedList<ControlCampo> listaControladores;	
	
	public ActivadorBoton(LinkedList<ControlCampo> c) {
		
		listaControladores = c;
	}
	
	protected void habilitarBoton(Boolean habilitador,Cursor cursor) {
		try{
			Registrarse.getBtn_enviar().setEnabled(habilitador);
			Registrarse.getBtn_enviar().setCursor(cursor);
		}catch(Exception e) {
			
		}
		try{
			PanelEditarMisDatos.getBtn_reg_siguiente().setEnabled(habilitador);
			PanelEditarMisDatos.getBtn_reg_siguiente().setCursor(cursor);
		}catch(Exception e) {
			
		}
		try{
			PanelEditarUsuario.getBtn_reg_siguiente().setEnabled(habilitador);
			PanelEditarUsuario.getBtn_reg_siguiente().setCursor(cursor);
		}catch(Exception e) {
			
		}
	}
	
	
	
	public void activarBoton() {
		
		
		habilitarBoton(true,new Cursor(Cursor.HAND_CURSOR));
		
		for (ControlCampo campoAVerificar : listaControladores) {
								
			if(! campoAVerificar.isOk()) {
				
				habilitarBoton(false,new Cursor(Cursor.DEFAULT_CURSOR));
				
				break;
			}else {
				
				habilitarBoton(true,new Cursor(Cursor.HAND_CURSOR));
			

			}
			
		}
		
	}

	
}
