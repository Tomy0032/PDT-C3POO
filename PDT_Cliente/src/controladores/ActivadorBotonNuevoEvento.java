package controladores;

import java.awt.Cursor;
import java.util.LinkedList;

import componentes.PanelNuevoEvento;
import interfaces.ControlCampo;


public class ActivadorBotonNuevoEvento extends ActivadorBoton{

	public ActivadorBotonNuevoEvento(LinkedList<ControlCampo> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	protected void habilitarBoton(Boolean habilitador,Cursor cursor) {
		PanelNuevoEvento.getBtnCrearEvento().setEnabled(habilitador);
		PanelNuevoEvento.getBtnCrearEvento().setCursor(cursor);
		
	}

}
