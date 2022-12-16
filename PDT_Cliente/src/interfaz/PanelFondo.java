package interfaz;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
	
	private Image imagen;
	private String rutaImagen;
	
	public PanelFondo(String ruta) {
		
		rutaImagen = ruta;
	}
	
	public void paint(Graphics g) {
		
		imagen = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
		setOpaque(false);
		super.paint(g);
	}

}
