package controladores;

import java.awt.CardLayout;
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
		CardLayout c = (CardLayout)Aplicacion.getCard_container_panel().getLayout();
		c.show(Aplicacion.getCard_container_panel(), "Panel Editar mis datos");
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
