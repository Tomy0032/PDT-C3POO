package interfaces;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class Layout_para_aplicacion implements LayoutManager {

	@Override
	public void addLayoutComponent(String name, Component comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLayoutComponent(Component comp) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void layoutContainer(Container contenedor) {
		// TODO Auto-generated method stub

		int width = contenedor.getWidth();
		int height = contenedor.getHeight();
		
		Component arriba = contenedor.getComponent(2);
		Component botonera = contenedor.getComponent(0);
		Component panel = contenedor.getComponent(1);
		
		botonera.setBounds(0, height/8, width/6, (height/8)*7);
		
		panel.setBounds(width/6,height/8,(width/6)*5,(height/8)*7);
		
		arriba.setBounds(0,0,width,height/8);
	}

}
