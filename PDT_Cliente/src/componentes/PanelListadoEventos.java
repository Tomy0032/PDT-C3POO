package componentes;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class PanelListadoEventos extends JPanel {

	private static JComboBox comboBox;
	private static JDateChooser dateChooser;
	private static JComboBox comboBox_1;
	private static JComboBox comboBox_2;
	private static JComboBox comboBox_3;

	public static JComboBox getComboBox() {
		return comboBox;
	}

	public static JDateChooser getDateChooser() {
		return dateChooser;
	}

	public static JComboBox getComboBox_1() {
		return comboBox_1;
	}

	public static JComboBox getComboBox_2() {
		return comboBox_2;
	}

	public static JComboBox getComboBox_3() {
		return comboBox_3;
	}

	public PanelListadoEventos() {
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 430, 182);
		add(scrollPane);

		JTable listaEventosTable = new JTable();
		listaEventosTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(listaEventosTable);

		JLabel lblFiltros = new JLabel("Filtrar por:");
		lblFiltros.setBounds(10, 28, 56, 14);
		add(lblFiltros);

		JLabel lblTipoEvento = new JLabel("Tipo");
		lblTipoEvento.setBounds(76, 28, 46, 14);
		add(lblTipoEvento);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(144, 28, 46, 14);
		add(lblFecha);

		JLabel lblModalidadEvento = new JLabel("Modalidad");
		lblModalidadEvento.setBounds(233, 28, 58, 14);
		add(lblModalidadEvento);

		JLabel lblITREvento = new JLabel("ITR");
		lblITREvento.setBounds(313, 28, 54, 14);
		add(lblITREvento);

		JLabel lblEstadoEvento = new JLabel("Estado");
		lblEstadoEvento.setBounds(394, 28, 46, 14);
		add(lblEstadoEvento);

		comboBox = new JComboBox();
		comboBox.setBounds(68, 53, 66, 22);
		add(comboBox);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(144, 53, 74, 22);
		add(dateChooser);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(228, 53, 63, 22);
		add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(301, 53, 66, 22);
		add(comboBox_2);

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(377, 53, 63, 22);
		add(comboBox_3);
	}
}
