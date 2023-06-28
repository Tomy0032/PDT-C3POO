package controladores;

import javax.swing.JTextField;

import componentes.PanelFichaEvento;
import componentes.PanelNuevoEvento;
import interfaz.Registrarse;


public class Control_longit_min_ficha_evento extends Control_longit_min{

	public Control_longit_min_ficha_evento(JTextField campo, int min) {
		super(campo, min);
		// TODO Auto-generated constructor stub
	}
	
	protected void setAviso(String aviso) {
		PanelFichaEvento.setAviso(aviso);
	}
	
	protected void instanciarActivador() {	
		super.activador = new ActivadorBotonNuevoEvento(PanelFichaEvento.getListaCampos());
	}

}
