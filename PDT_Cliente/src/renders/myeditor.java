package renders;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import interfaz.Aplicacion;

public class myeditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    Boolean currentValue;
    JButton button;
    protected static final String EDIT = "edit";
    private JTable jTable1;

    public myeditor(JTable jTable1) {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);
        this.jTable1 = jTable1;
    }

    public void actionPerformed(ActionEvent e) {
        // mymodel t = (mymodel) jTable1.getModel();
        // t.addNewRecord();
        fireEditingStopped();
    }

    //Implement the one CellEditor method that AbstractCellEditor doesn't.
    public Object getCellEditorValue() {
        return currentValue;
    }

    //Implement the one method defined by TableCellEditor.
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    	currentValue = (Boolean) value;
    	return button;
    }
}