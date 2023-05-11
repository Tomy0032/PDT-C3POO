package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.NamingException;
import javax.swing.JLabel;

import interfaz.Aplicacion;
import interfaz.Registrarse;

public class Control_username_aplicacion implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			Registrarse abreRegistrarse = new Registrarse();
		
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		JLabel etiqueta = (JLabel) e.getComponent();
		etiqueta.setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

		JLabel etiqueta = (JLabel) e.getComponent();
		etiqueta.setBackground(Aplicacion.getBtn_container_panel().getBackground());
	}

}
