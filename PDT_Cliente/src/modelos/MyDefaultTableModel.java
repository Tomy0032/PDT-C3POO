package modelos;

import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {
    protected boolean[][] editable_cells; // 2d array to represent rows and columns

    public MyDefaultTableModel(Object[][] data, Object[] columnNames) {
        setDataVector(data, columnNames);
        this.editable_cells = new boolean[7][10];
    }

	@Override
    public boolean isCellEditable(int row, int column) { // custom isCellEditable function
        return this.editable_cells[row][column];
    }

    public void setCellEditable(int row, int col, boolean value) {
        this.editable_cells[row][col] = value; // set cell true/false
        this.fireTableCellUpdated(row, col);
    }
}
