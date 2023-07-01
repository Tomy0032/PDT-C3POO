package utilidades;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaAsistencia extends DefaultTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] titulos;
	Object[][] datos;
	
	public ModeloTablaAsistencia(Object[][] datos, String[] titulos) {
		super();
		this.titulos = titulos;
		this.datos = datos;
		setDataVector(datos, titulos);
	}
	
	public ModeloTablaAsistencia() {
		
	}
	
	boolean[] columnEditables = new boolean[] {
		false, true, true
	};
	
	public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
	}

	Class[] columnTypes = new Class[] {
			String.class, String.class, Double.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	
}
