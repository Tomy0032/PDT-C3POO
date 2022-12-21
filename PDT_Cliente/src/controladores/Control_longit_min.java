package controladores;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interfaces.ControlCampo;
import interfaz.Registrarse;

public class Control_longit_min implements DocumentListener,ControlCampo{

	private int min;
	private JTextField campo;
	private boolean ok = false;
	private ActivadorBoton activador; 
	
	
	public Control_longit_min(JTextField campo,int min) {
		
		this.min = min;
		this.campo = campo;
		//
	}
	
	
	
	public void controlCampo() {
		
		if(campo.getText().length() < min) {
			
			campo.setForeground(Color.RED);
			Registrarse.setAviso("Longitud de la entrada o caracter no permitido.");
			ok = false;
	
		}else {
			
			campo.setForeground(Color.BLACK);
			Registrarse.setAviso("Los campos marcados con (*) son obligatorios");
			ok = true;
			
		}
		
	}
	
	public boolean isOk() {
		return ok;
	}



	@Override
	public void insertUpdate(DocumentEvent e) {
		
		activador = new ActivadorBoton(Registrarse.getListaCampos());
		
		controlCampo();
		activador.activarBoton();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
			
		activador = new ActivadorBoton(Registrarse.getListaCampos());
		
		controlCampo();
		activador.activarBoton();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
