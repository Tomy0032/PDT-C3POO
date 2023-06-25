package controladores;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import componentes.PanelEditarUsuario;
import interfaces.ControlCampo;
import interfaz.Registrarse;

public class Control_longit_min implements DocumentListener,ControlCampo{

	private int min;
	private JTextField campo;
	private boolean ok = false;
	protected ActivadorBoton activador;
	private final String AVISO_ERROR = "Longitud de la entrada o caracter no permitido.",
			                AVISO_OK = "Los campos marcados con (*) son obligatorios";
	
	
	
	
	public Control_longit_min(JTextField campo,int min) {
		
		this.min = min;
		this.campo = campo;
	}
	
	protected void setAviso(String aviso) {
		try{
			Registrarse.setAviso(aviso);
		}catch(Exception e) {
			PanelEditarUsuario.setAviso(aviso);
		}
		
	}
	
	
	protected void instanciarActivador() {	
		if(!(Registrarse.getListaCampos()==null)) {
			activador = new ActivadorBoton(Registrarse.getListaCampos());
		}else {
			activador = new ActivadorBoton(PanelEditarUsuario.getListaCampos());
		}
	}
	
	//
	
	public void controlCampo() {
		
		if(campo.getText().length() < min) {
			
			campo.setForeground(Color.RED);
			setAviso(AVISO_ERROR);
			ok = false;
	
		}else {
			
			campo.setForeground(Color.BLACK);
			setAviso(AVISO_OK);
			ok = true;
			
		}
		
	}
	
	public boolean isOk() {
		return ok;
	}



	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		instanciarActivador();

		controlCampo();
		activador.activarBoton();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		instanciarActivador();

		controlCampo();
		activador.activarBoton();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
