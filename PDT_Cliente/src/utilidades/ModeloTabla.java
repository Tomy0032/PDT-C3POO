package utilidades;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] titulos;
	Object[][] datos;
	
	public ModeloTabla(Object[][] datos, String[] titulos) {
		super();
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}
	
	public ModeloTabla() {
		
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
