package renders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

import interfaz.Aplicacion;
import modelos.MyDefaultTableModel;

public class rendererButton extends JLabel implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
		
		((MyDefaultTableModel) table.getModel()).setCellEditable(row, column, true);		
        return new JButton("button");

    }
}