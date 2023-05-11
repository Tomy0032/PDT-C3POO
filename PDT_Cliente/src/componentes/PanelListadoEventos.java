package componentes;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class PanelListadoEventos extends JPanel {

	private static JComboBox<?> comboBox;
	private static JDateChooser dateChooser;
	private static JComboBox<String> comboBox_modalidad;
	private static JComboBox<?> comboBox_2;
	private static JComboBox<?> comboBox_3;

	public static JComboBox<?> getComboBox() {
		return comboBox;
	}

	public static JDateChooser getDateChooser() {
		return dateChooser;
	}

	public static JComboBox<String> getComboBox_1() {
		return comboBox_modalidad;
	}

	public static JComboBox<?> getComboBox_2() {
		return comboBox_2;
	}

	public static JComboBox<?> getComboBox_3() {
		return comboBox_3;
	}

	public PanelListadoEventos() {
		setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 1062, 607);
		add(scrollPane);

		JTable listaEventosTable = new JTable();
		listaEventosTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listaEventosTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null },
				{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(listaEventosTable);

		JLabel lblFiltros = new JLabel("Filtrar por:");
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFiltros.setBounds(10, 28, 56, 14);
		add(lblFiltros);

		JLabel lblTipoEvento = new JLabel("Tipo");
		lblTipoEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoEvento.setBounds(121, 29, 46, 14);
		add(lblTipoEvento);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(238, 29, 46, 14);
		add(lblFecha);

		JLabel lblModalidadEvento = new JLabel("Modalidad");
		lblModalidadEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModalidadEvento.setBounds(377, 29, 58, 14);
		add(lblModalidadEvento);

		JLabel lblITREvento = new JLabel("ITR");
		lblITREvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblITREvento.setBounds(505, 28, 54, 14);
		add(lblITREvento);

		JLabel lblEstadoEvento = new JLabel("Estado");
		lblEstadoEvento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoEvento.setBounds(636, 29, 46, 14);
		add(lblEstadoEvento);

		comboBox = new JComboBox<Object>();
		comboBox.setBounds(113, 54, 66, 22);
		add(comboBox);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(238, 54, 74, 22);
		add(dateChooser);

		comboBox_modalidad = new JComboBox<String>();
		comboBox_modalidad.setBounds(361, 54, 74, 22);
		comboBox_modalidad.addItem("PRESENCIAL");
		comboBox_modalidad.addItem("VIRTUAL");
		add(comboBox_modalidad);

		comboBox_2 = new JComboBox<Object>();
		comboBox_2.setBounds(493, 53, 66, 22);
		add(comboBox_2);

		comboBox_3 = new JComboBox<Object>();
		comboBox_3.setBounds(619, 54, 63, 22);
		add(comboBox_3);
		
		
	}
}
