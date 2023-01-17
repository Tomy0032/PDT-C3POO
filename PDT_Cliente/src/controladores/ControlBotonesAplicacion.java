package controladores;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import interfaz.Aplicacion;

public class ControlBotonesAplicacion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		CardLayout c = (CardLayout)Aplicacion.getCard_container_panel().getLayout();
		
		
		if(e.getSource() == Aplicacion.getBtn_usuarios()) {
			
			c.show(Aplicacion.getCard_container_panel(), "Panel de Usuarios");
		
		}else if(e.getSource() == Aplicacion.getBtn_eventos()) {
			
			c.show(Aplicacion.getCard_container_panel(), "Panel de Eventos");

		}else if(e.getSource() == Aplicacion.getBtnConstancias()) {
			
			c.show(Aplicacion.getCard_container_panel(), "Panel de Constancias");

		}else if(e.getSource() == Aplicacion.getBtnReclamos()) {
			
			c.show(Aplicacion.getCard_container_panel(), "Panel de Reclamos");

		}
	}

}
