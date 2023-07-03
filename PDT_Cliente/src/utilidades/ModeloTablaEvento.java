package utilidades;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaEvento extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] titulos;
	Object[][] datos;
	
	public ModeloTablaEvento(Object[][] datos, String[] titulos) {
		super();
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}
	
	public ModeloTablaEvento() {
		
	}
	
	boolean[] columnEditables = new boolean[] {
		true, true
	};
	
	public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
	}

	Class[] columnTypes = new Class[] {
			String.class, Boolean.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	
}
