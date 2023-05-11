package componentes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelNuevoEvento extends JPanel {

	private static JComboBox<String> tipoEventocomboBox;
	private static JDateChooser dateChooserInicioEvento;
	private static TimeSpinner horaInicioSpinner;
	private static TimeSpinner horaFinSpinner;
	private static JComboBox<String> ModalidadEventocomboBox;
	private static JComboBox<String> ITREventocomboBox;
	private static JDateChooser dateChooserFinEvento;
	private static JTextField tituloEventoField;
	private static JTextField LocalizacionEventoField;
	private static JTable eventoTutores_table;

	public static JTable getEventoTutores_table() {
		return eventoTutores_table;
	}

	public static JComboBox<?> getTipoEventocomboBox() {
		return tipoEventocomboBox;
	}

	public static JDateChooser getDateChooserInicioEvento() {
		return dateChooserInicioEvento;
	}

	public static TimeSpinner getHoraInicioSpinner() {
		return horaInicioSpinner;
	}

	public static TimeSpinner getHoraFinSpinner() {
		return horaFinSpinner;
	}

	public static JComboBox<String> getModalidadEventocomboBox() {
		return ModalidadEventocomboBox;
	}

	public static JComboBox<String> getITREventocomboBox() {
		return ITREventocomboBox;
	}

	public static JDateChooser getDateChooserFinEvento() {
		return dateChooserFinEvento;
	}

	public static JTextField getTituloEventoField() {
		return tituloEventoField;
	}

	public static JTextField getLocalizacionEventoField() {
		return LocalizacionEventoField;
	}

	public PanelNuevoEvento() {
		setLayout(null);

		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo del evento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 150, 14);
		add(lblNewLabel);

		tituloEventoField = new JTextField();
		tituloEventoField.setBounds(170, 10, 686, 20);
		add(tituloEventoField);
		tituloEventoField.setColumns(10);

		JLabel lblTpoDeEvento = new JLabel("T\u00EDpo de evento");
		lblTpoDeEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTpoDeEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTpoDeEvento.setBounds(10, 47, 150, 14);
		add(lblTpoDeEvento);

		tipoEventocomboBox = new JComboBox<String>();
		tipoEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipoEventocomboBox.setBounds(170, 43, 227, 22);
		ComboBoxModel<String> modeloTipoEvento = new DefaultComboBoxModel<>(ListaTiposEvento.getListaString());
		tipoEventocomboBox.setModel(modeloTipoEvento);
		add(tipoEventocomboBox);

		JLabel lblFechaDelEvento = new JLabel("Fecha Inicio");
		lblFechaDelEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaDelEvento.setBounds(10, 82, 150, 14);
		add(lblFechaDelEvento);

		dateChooserInicioEvento = new JDateChooser();
		dateChooserInicioEvento.setBounds(170, 76, 121, 20);
		add(dateChooserInicioEvento);

		JLabel lblHoraInicioEvento = new JLabel("Hora");
		lblHoraInicioEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraInicioEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHoraInicioEvento.setBounds(288, 79, 37, 14);
		add(lblHoraInicioEvento);

		horaInicioSpinner = new TimeSpinner();
		horaInicioSpinner.setFormat("HH:mm");
		horaInicioSpinner.setBounds(335, 76, 62, 20);
		add(horaInicioSpinner);

		JLabel lblFinalizacinFecha = new JLabel("Fecha Finalizaci\u00F3n ");
		lblFinalizacinFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFinalizacinFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFinalizacinFecha.setBounds(10, 113, 150, 14);
		add(lblFinalizacinFecha);

		dateChooserFinEvento = new JDateChooser();
		dateChooserFinEvento.setBounds(170, 107, 121, 20);
		add(dateChooserFinEvento);

		JLabel lblHoraFinEvento = new JLabel("Hora");
		lblHoraFinEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraFinEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHoraFinEvento.setBounds(288, 111, 37, 14);
		add(lblHoraFinEvento);

		horaFinSpinner = new TimeSpinner();
		horaFinSpinner.setFormat("HH:mm");
		horaFinSpinner.setBounds(335, 107, 62, 20);
		add(horaFinSpinner);

		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModalidad.setBounds(10, 141, 150, 14);
		add(lblModalidad);

		ModalidadEventocomboBox = new JComboBox<String>();
		ModalidadEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ModalidadEventocomboBox.setBounds(170, 137, 121, 22);
		ComboBoxModel<String> modeloModalidad = new DefaultComboBoxModel<>(ListaModalidades.getListaString());
		ModalidadEventocomboBox.setModel(modeloModalidad);
		add(ModalidadEventocomboBox);

		JLabel lblEventoITR = new JLabel("ITR");
		lblEventoITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEventoITR.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEventoITR.setBounds(651, 142, 27, 14);
		add(lblEventoITR);

		ITREventocomboBox = new JComboBox<String>();
		ITREventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ITREventocomboBox.setBounds(688, 138, 131, 22);
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		ITREventocomboBox.setModel(modeloItr);
		add(ITREventocomboBox);

		JLabel lblLocalizacionEvento = new JLabel("Localizaci\u00F3n");
		lblLocalizacionEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocalizacionEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalizacionEvento.setBounds(10, 168, 150, 14);
		add(lblLocalizacionEvento);

		LocalizacionEventoField = new JTextField();
		LocalizacionEventoField.setColumns(10);
		LocalizacionEventoField.setBounds(170, 167, 686, 20);
		add(LocalizacionEventoField);

		JLabel lblTutoresEvento = new JLabel("Tutor/es");
		lblTutoresEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTutoresEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTutoresEvento.setBounds(10, 200, 150, 14);
		add(lblTutoresEvento);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 200, 1003, 558);
		add(scrollPane);

		eventoTutores_table = new JTable();
		eventoTutores_table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		eventoTutores_table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		scrollPane.setViewportView(eventoTutores_table);
	}
}
