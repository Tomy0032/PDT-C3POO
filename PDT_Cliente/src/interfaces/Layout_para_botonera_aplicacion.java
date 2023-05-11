package interfaces;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;

public class Layout_para_botonera_aplicacion implements LayoutManager {
	
	/* 
	 * EL OBJETIVO DE ESTA CLASE ES COLOCAR LOS COMPONENTES EL LA BOTONERA DE LA APLICACION DE 
	 * LA SIGUIENTE MANERA:
	 * 
	 * --SI EL COMPONENTE ES UN BOTON, SU ANCHO SERA EL 80% DEL ANCHO DE LA BOTONERA.
	 *   ESTARA A IGUAL DISTANCIA DE LA IZQIERDA Y LA DERECHA DE LOS BORDES DE LA BOTONERA (CENTRADO EN EJE X)
	 *   TENDRA 25 PIXELES DE ALTO Y ESTARA SEPARADO 20 PIXELES DE LO QUE HALLA ARRIBA (EL BORDE DE ARRIBA U OTRO COMPONENTE)
	 *   
	 * --SI EL COMPONENTE ES OTRA COSA (JLABEL EN ESTE CASO), SU ANCHO SERA EL ANCHO DE LA BOTONERA,  
	 *   TENDRA 25 PIXELES DE ALTO Y ESTARA SEPARADO 20 PIXELES DE LO QUE HALLA ARRIBA (EL BORDE DE ARRIBA U OTRO COMPONENTE)
	 */  

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
		
		int anchoContenedor = contenedor.getWidth();
		int margen;
		int anchoComponente;
		int posicion_y = 20;
		
		for(int i=0;i<contenedor.getComponentCount();i++) {
			
			Component componente = contenedor.getComponent(i);
			
			if(componente instanceof JButton) {
				
				margen = anchoContenedor / 10;
				anchoComponente = anchoContenedor - (margen * 2);
				componente.setBounds(margen,posicion_y,anchoComponente,25);
			
			}else {
				
				margen = 0;
				anchoComponente = anchoContenedor;
				componente.setBounds(margen,posicion_y,anchoContenedor,25);
			}
			
		
			posicion_y += 40;
		}
	}

}
