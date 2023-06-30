package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.NamingException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.entities.ConvocatoriaAsistencia;
import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.toedter.calendar.JDateChooser;

import controladores.ControlBotonAgregarEstudiantesEvento;
import controladores.ControlBotonCrearEvento;
import controladores.ControlBotonEditarEvento;
import controladores.Control_longit_min_ficha_evento;
import interfaces.ControlCampo;
import interfaz.Aplicacion;
import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.ModeloTabla;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFichaEvento extends JPanel{

	private static final long serialVersionUID = 1L;
	private static JComboBox<String> tipoEventocomboBox;
	private static JDateChooser dateChooserInicioEvento;
	private static JSpinner horaInicioSpinner;
	private static TimeSpinner horaFinSpinner;
	private static JComboBox<String> ModalidadEventocomboBox;
	private static JComboBox<String> ITREventocomboBox;
	private static JDateChooser dateChooserFinEvento;
	private static JTextField tituloEventoField;
	private static JTextField localizacionEventoField;
	private static JTable eventoTutores_table;
	private static JTextField tutorField;
	private JLabel lblLocalizacionEvento;
	private JLabel lblModalidad;
	private JLabel lblNewLabel;
	private JLabel lblTpoDeEvento;
	private JLabel lblFechaDelEvento;
	private JLabel lblHoraInicioEvento;
	private JLabel lblFinalizacinFecha;
	private JLabel lblHoraFinEvento;
	private JLabel lblEventoITR;
	private JLabel lblTutoresEvento;
	private String[] listaTutores;
	private ArrayList<String> arrayTutores = new ArrayList<String>();
	private ArrayList<String> arrayEstudiantes = new ArrayList<String>();
	private DefaultListModel modeloTutores;
	private static JTable tutoresTable;
	private static DefaultTableModel modeloTablaTutores;
	private static ArrayList<String> tutoresAgregados = new ArrayList<String>();
	private static ArrayList<String> estudiantesAgregados = new ArrayList<String>();
	private static JLabel aviso;
	private static LinkedList<ControlCampo> listaCampos;
	private JLabel titulo;
	private static JTable tableEstudiantes;
	private static JTextField fechaFinField;
	private static DefaultComboBoxModel<String> modeloModalidad;
	private static DefaultComboBoxModel<String> modeloItr;
	private static DefaultComboBoxModel<String> modeloTipoEvento;
	private static JTextField tipoEventoField;
	private static JTextField fechaInicioField;
	private static JTextField horaInicioField;
	private static JTextField horaFinField;
	private static JTextField modalidadField;
	private static JTextField itrField;
	private static JTable tutoresTable2;
	private static DefaultTableModel modeloTablaTutores2;
	private static JButton estudiantesBtn;
	private static JButton editarBtn;
	private static JScrollPane scrollPane;
	private TableColumnModel columnModel;
	private static JButton cancelarEditarBtn;
	private JList tutoresList;
	private JScrollPane tutoresScrollPane;
	private static JButton confirmarEdicionBtn;
	private static DefaultTableModel modeloTableEstudiantes;
	private static DefaultTableModel modeloTableEstudiantes2;
	private JScrollPane scrollPaneEstudiantes;
	private JButton confirmarEstudiantesBtn;
	private JButton cancelarEstudiantesBtn;
	private JTextField estudianteField;
	private static JTable tableEstudiantes2;
	private static JScrollPane scrollPaneEstudiantes2;
	private String[] listaEstudiantes;
	private DefaultListModel modeloEstudiantes;
	private JScrollPane scrollPane_1;
	private static JList estudiantesList;
	private static JScrollPane scrollPaneEstudiantesList;

	public static LinkedList<ControlCampo> getListaCampos() {
		return listaCampos;
	}

	public static JTable getEventoTutores_table() {
		return eventoTutores_table;
	}

	public static JComboBox<?> getTipoEventocomboBox() {
		return tipoEventocomboBox;
	}

	public static JDateChooser getDateChooserInicioEvento() {
		return dateChooserInicioEvento;
	}

	public static JSpinner getHoraInicioSpinner() {
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
		return localizacionEventoField;
	}
	
	public static ArrayList<String> getTutoresAgregados() {
		return tutoresAgregados;
	}

	public static void setTutoresAgregados(ArrayList<String> tutoresAgregados) {
		PanelFichaEvento.tutoresAgregados = tutoresAgregados;
	}
	
	public static void setDateChooserInicioEvento(JDateChooser dateChooserInicioEvento) {
		PanelFichaEvento.dateChooserInicioEvento = dateChooserInicioEvento;
	}

	public JTextField getTutorField() {
		return tutorField;
	}

	public void setTutorField(JTextField tutorField) {
		this.tutorField = tutorField;
	}

	public JLabel getLblLocalizacionEvento() {
		return lblLocalizacionEvento;
	}

	public void setLblLocalizacionEvento(JLabel lblLocalizacionEvento) {
		this.lblLocalizacionEvento = lblLocalizacionEvento;
	}

	public JLabel getLblModalidad() {
		return lblModalidad;
	}

	public void setLblModalidad(JLabel lblModalidad) {
		this.lblModalidad = lblModalidad;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public JLabel getLblTpoDeEvento() {
		return lblTpoDeEvento;
	}

	public void setLblTpoDeEvento(JLabel lblTpoDeEvento) {
		this.lblTpoDeEvento = lblTpoDeEvento;
	}

	public JLabel getLblFechaDelEvento() {
		return lblFechaDelEvento;
	}

	public void setLblFechaDelEvento(JLabel lblFechaDelEvento) {
		this.lblFechaDelEvento = lblFechaDelEvento;
	}

	public JLabel getLblHoraInicioEvento() {
		return lblHoraInicioEvento;
	}

	public void setLblHoraInicioEvento(JLabel lblHoraInicioEvento) {
		this.lblHoraInicioEvento = lblHoraInicioEvento;
	}

	public JLabel getLblFinalizacinFecha() {
		return lblFinalizacinFecha;
	}

	public void setLblFinalizacinFecha(JLabel lblFinalizacinFecha) {
		this.lblFinalizacinFecha = lblFinalizacinFecha;
	}

	public ArrayList<String> getArrayEstudiantes() {
		return arrayEstudiantes;
	}

	public void setArrayEstudiantes(ArrayList<String> arrayEstudiantes) {
		this.arrayEstudiantes = arrayEstudiantes;
	}

	public static ArrayList<String> getEstudiantesAgregados() {
		return estudiantesAgregados;
	}

	public static void setEstudiantesAgregados(ArrayList<String> estudiantesAgregados) {
		PanelFichaEvento.estudiantesAgregados = estudiantesAgregados;
	}

	public static JTextField getFechaFinField() {
		return fechaFinField;
	}

	public static void setFechaFinField(JTextField fechaFinField) {
		PanelFichaEvento.fechaFinField = fechaFinField;
	}

	public static DefaultComboBoxModel<String> getModeloModalidad() {
		return modeloModalidad;
	}

	public static void setModeloModalidad(DefaultComboBoxModel<String> modeloModalidad) {
		PanelFichaEvento.modeloModalidad = modeloModalidad;
	}

	public static DefaultComboBoxModel<String> getModeloItr() {
		return modeloItr;
	}

	public static void setModeloItr(DefaultComboBoxModel<String> modeloItr) {
		PanelFichaEvento.modeloItr = modeloItr;
	}

	public static DefaultComboBoxModel<String> getModeloTipoEvento() {
		return modeloTipoEvento;
	}

	public static void setModeloTipoEvento(DefaultComboBoxModel<String> modeloTipoEvento) {
		PanelFichaEvento.modeloTipoEvento = modeloTipoEvento;
	}

	public static JTextField getTipoEventoField() {
		return tipoEventoField;
	}

	public static void setTipoEventoField(JTextField tipoEventoField) {
		PanelFichaEvento.tipoEventoField = tipoEventoField;
	}

	public static JTextField getFechaInicioField() {
		return fechaInicioField;
	}

	public static void setFechaInicioField(JTextField fechaInicioField) {
		PanelFichaEvento.fechaInicioField = fechaInicioField;
	}

	public static JTextField getHoraInicioField() {
		return horaInicioField;
	}

	public static void setHoraInicioField(JTextField horaInicioField) {
		PanelFichaEvento.horaInicioField = horaInicioField;
	}

	public static JTextField getHoraFinField() {
		return horaFinField;
	}

	public static void setHoraFinField(JTextField horaFinField) {
		PanelFichaEvento.horaFinField = horaFinField;
	}

	public static JTextField getModalidadField() {
		return modalidadField;
	}

	public static void setModalidadField(JTextField modalidadField) {
		PanelFichaEvento.modalidadField = modalidadField;
	}

	public static JTextField getItrField() {
		return itrField;
	}

	public static void setItrField(JTextField itrField) {
		PanelFichaEvento.itrField = itrField;
	}

	public static JTable getTutoresTable2() {
		return tutoresTable2;
	}

	public static void setTutoresTable2(JTable tutoresTable2) {
		PanelFichaEvento.tutoresTable2 = tutoresTable2;
	}

	public static DefaultTableModel getModeloTablaTutores2() {
		return modeloTablaTutores2;
	}

	public static void setModeloTablaTutores2(DefaultTableModel modeloTablaTutores2) {
		PanelFichaEvento.modeloTablaTutores2 = modeloTablaTutores2;
	}

	public static JButton getEstudiantesBtn() {
		return estudiantesBtn;
	}

	public static void setEstudiantesBtn(JButton estudiantesBtn) {
		PanelFichaEvento.estudiantesBtn = estudiantesBtn;
	}

	public static JButton getEditarBtn() {
		return editarBtn;
	}

	public static void setEditarBtn(JButton editarBtn) {
		PanelFichaEvento.editarBtn = editarBtn;
	}

	public static JScrollPane getScrollPane() {
		return scrollPane;
	}

	public static void setScrollPane(JScrollPane scrollPane) {
		PanelFichaEvento.scrollPane = scrollPane;
	}

	public TableColumnModel getColumnModel() {
		return columnModel;
	}

	public void setColumnModel(TableColumnModel columnModel) {
		this.columnModel = columnModel;
	}

	public static JButton getCancelarEditarBtn() {
		return cancelarEditarBtn;
	}

	public static void setCancelarEditarBtn(JButton cancelarEditarBtn) {
		PanelFichaEvento.cancelarEditarBtn = cancelarEditarBtn;
	}

	public static JButton getConfirmarEdicionBtn() {
		return confirmarEdicionBtn;
	}

	public static void setConfirmarEdicionBtn(JButton confirmarEdicionBtn) {
		PanelFichaEvento.confirmarEdicionBtn = confirmarEdicionBtn;
	}

	public static DefaultTableModel getModeloTableEstudiantes() {
		return modeloTableEstudiantes;
	}

	public static void setModeloTableEstudiantes(DefaultTableModel modeloTableEstudiantes) {
		PanelFichaEvento.modeloTableEstudiantes = modeloTableEstudiantes;
	}

	public static DefaultTableModel getModeloTableEstudiantes2() {
		return modeloTableEstudiantes2;
	}

	public static void setModeloTableEstudiantes2(DefaultTableModel modeloTableEstudiantes2) {
		PanelFichaEvento.modeloTableEstudiantes2 = modeloTableEstudiantes2;
	}

	public JScrollPane getScrollPaneEstudiantes() {
		return scrollPaneEstudiantes;
	}

	public void setScrollPaneEstudiantes(JScrollPane scrollPaneEstudiantes) {
		this.scrollPaneEstudiantes = scrollPaneEstudiantes;
	}

	public JButton getConfirmarEstudiantesBtn() {
		return confirmarEstudiantesBtn;
	}

	public void setConfirmarEstudiantesBtn(JButton confirmarEstudiantesBtn) {
		this.confirmarEstudiantesBtn = confirmarEstudiantesBtn;
	}

	public JButton getCancelarEstudiantesBtn() {
		return cancelarEstudiantesBtn;
	}

	public void setCancelarEstudiantesBtn(JButton cancelarEstudiantesBtn) {
		this.cancelarEstudiantesBtn = cancelarEstudiantesBtn;
	}

	public JTextField getEstudianteField() {
		return estudianteField;
	}

	public void setEstudianteField(JTextField estudianteField) {
		this.estudianteField = estudianteField;
	}

	public static JTable getTableEstudiantes2() {
		return tableEstudiantes2;
	}

	public static void setTableEstudiantes2(JTable tableEstudiantes2) {
		PanelFichaEvento.tableEstudiantes2 = tableEstudiantes2;
	}

	public static JScrollPane getScrollPaneEstudiantes2() {
		return scrollPaneEstudiantes2;
	}

	public static void setScrollPaneEstudiantes2(JScrollPane scrollPaneEstudiantes2) {
		PanelFichaEvento.scrollPaneEstudiantes2 = scrollPaneEstudiantes2;
	}

	public String[] getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(String[] listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public DefaultListModel getModeloEstudiantes() {
		return modeloEstudiantes;
	}

	public void setModeloEstudiantes(DefaultListModel modeloEstudiantes) {
		this.modeloEstudiantes = modeloEstudiantes;
	}

	public JScrollPane getScrollPane_1() {
		return scrollPane_1;
	}

	public void setScrollPane_1(JScrollPane scrollPane_1) {
		this.scrollPane_1 = scrollPane_1;
	}

	public static JList getEstudiantesList() {
		return estudiantesList;
	}

	public static void setEstudiantesList(JList estudiantesList) {
		PanelFichaEvento.estudiantesList = estudiantesList;
	}

	public static JScrollPane getScrollPaneEstudiantesList() {
		return scrollPaneEstudiantesList;
	}

	public static void setScrollPaneEstudiantesList(JScrollPane scrollPaneEstudiantesList) {
		PanelFichaEvento.scrollPaneEstudiantesList = scrollPaneEstudiantesList;
	}

	public JLabel getLblHoraFinEvento() {
		return lblHoraFinEvento;
	}

	public void setLblHoraFinEvento(JLabel lblHoraFinEvento) {
		this.lblHoraFinEvento = lblHoraFinEvento;
	}

	public JLabel getLblEventoITR() {
		return lblEventoITR;
	}

	public void setLblEventoITR(JLabel lblEventoITR) {
		this.lblEventoITR = lblEventoITR;
	}

	public JLabel getLblTutoresEvento() {
		return lblTutoresEvento;
	}

	public void setLblTutoresEvento(JLabel lblTutoresEvento) {
		this.lblTutoresEvento = lblTutoresEvento;
	}

	public JList getTutoresList() {
		return tutoresList;
	}

	public void setTutoresList(JList tutoresList) {
		this.tutoresList = tutoresList;
	}

	public JScrollPane getTutoresScrollPane() {
		return tutoresScrollPane;
	}

	public void setTutoresScrollPane(JScrollPane tutoresScrollPane) {
		this.tutoresScrollPane = tutoresScrollPane;
	}

	public String[] getListaTutores() {
		return listaTutores;
	}

	public void setListaTutores(String[] listaTutores) {
		this.listaTutores = listaTutores;
	}

	public ArrayList<String> getArrayTutores() {
		return arrayTutores;
	}

	public void setArrayTutores(ArrayList<String> arrayTutores) {
		this.arrayTutores = arrayTutores;
	}

	public DefaultListModel getModeloTutores() {
		return modeloTutores;
	}

	public void setModeloTutores(DefaultListModel modeloTutores) {
		this.modeloTutores = modeloTutores;
	}

	public static JTable getTutoresTable() {
		return tutoresTable;
	}

	public static void setTutoresTable(JTable tutoresTable) {
		PanelFichaEvento.tutoresTable = tutoresTable;
	}

	public DefaultTableModel getModeloTablaTutores() {
		return modeloTablaTutores;
	}

	public void setModeloTablaTutores(DefaultTableModel modeloTablaTutores) {
		this.modeloTablaTutores = modeloTablaTutores;
	}

	public static JLabel getAviso() {
		return aviso;
	}

	public static void setAviso(JLabel aviso) {
		PanelFichaEvento.aviso = aviso;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JTable getTableEstudiantes() {
		return tableEstudiantes;
	}

	public void setTableEstudiantes(JTable tableEstudiantes) {
		this.tableEstudiantes = tableEstudiantes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setTipoEventocomboBox(JComboBox<String> tipoEventocomboBox) {
		PanelFichaEvento.tipoEventocomboBox = tipoEventocomboBox;
	}

	public static void setModalidadEventocomboBox(JComboBox<String> modalidadEventocomboBox) {
		ModalidadEventocomboBox = modalidadEventocomboBox;
	}

	public static void setITREventocomboBox(JComboBox<String> iTREventocomboBox) {
		ITREventocomboBox = iTREventocomboBox;
	}

	public static void setTituloEventoField(JTextField tituloEventoField) {
		PanelFichaEvento.tituloEventoField = tituloEventoField;
	}

	public static void setLocalizacionEventoField(JTextField localizacionEventoField) {
		PanelFichaEvento.localizacionEventoField = localizacionEventoField;
	}

	public static void setEventoTutores_table(JTable eventoTutores_table) {
		PanelFichaEvento.eventoTutores_table = eventoTutores_table;
	}

	public static void setListaCampos(LinkedList<ControlCampo> listaCampos) {
		PanelFichaEvento.listaCampos = listaCampos;
	}

	public static void setHoraInicioSpinner(JSpinner horaInicioSpinner) {
		PanelFichaEvento.horaInicioSpinner = horaInicioSpinner;
	}

	public static void setHoraFinSpinner(TimeSpinner horaFinSpinner) {
		PanelFichaEvento.horaFinSpinner = horaFinSpinner;
	}

	public static void setDateChooserFinEvento(JDateChooser dateChooserFinEvento) {
		PanelFichaEvento.dateChooserFinEvento = dateChooserFinEvento;
	}

	public PanelFichaEvento() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tutorField.setFocusable(false);
				tutorField.setFocusable(true);
			}
		});
		setLayout(null);
		
		scrollPaneEstudiantesList = new JScrollPane();
		scrollPaneEstudiantesList.setVisible(false);
		scrollPaneEstudiantesList.setBounds(638, 51, 344, 1);
		add(scrollPaneEstudiantesList);
		
		estudiantesList = new JList();
		estudiantesList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPaneEstudiantesList.setVisible(false);
				estudianteField.setText("");
				if(!tutoresAgregados.contains(estudiantesList.getSelectedValue().toString())){
					estudiantesAgregados.add(estudiantesList.getSelectedValue().toString());
					Object datos[] = new Object[2];
					datos[0] = estudiantesList.getSelectedValue().toString();
					datos[1] = "ELIMINAR";
					modeloTableEstudiantes2.addRow(datos);
					estudianteField.setFocusable(true);

				}
				estudianteField.setFocusable(false);
				estudianteField.setFocusable(true);
			}
		});
		scrollPaneEstudiantesList.setViewportView(estudiantesList);
		
		tutoresScrollPane = new JScrollPane();
		tutoresScrollPane.setVisible(false);
		tutoresScrollPane.setBounds(153, 232, 344, 0);
		add(tutoresScrollPane);
		
		tutoresList = new JList();
		tutoresScrollPane.setViewportView(tutoresList);
		
		lblNewLabel = new JLabel("T\u00EDtulo del evento");
		lblNewLabel.setBounds(10, 33, 133, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel);

		tituloEventoField = new JTextField();
		tituloEventoField.setEditable(false);
		tituloEventoField.setBounds(153, 32, 344, 20);
		add(tituloEventoField);
		tituloEventoField.setColumns(10);

		lblTpoDeEvento = new JLabel("Tipo de evento");
		lblTpoDeEvento.setBounds(10, 70, 133, 14);
		lblTpoDeEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTpoDeEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblTpoDeEvento);

		tipoEventocomboBox = new JComboBox<String>();
		tipoEventocomboBox.setVisible(false);
		tipoEventocomboBox.setBounds(153, 65, 227, 22);
		tipoEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		modeloTipoEvento = new DefaultComboBoxModel<>(ListaTiposEvento.getListaString());
		tipoEventocomboBox.setModel(modeloTipoEvento);
		add(tipoEventocomboBox);

		lblFechaDelEvento = new JLabel("Fecha Inicio");
		lblFechaDelEvento.setBounds(10, 105, 133, 14);
		lblFechaDelEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFechaDelEvento);

		dateChooserInicioEvento = new JDateChooser();
		dateChooserInicioEvento.setVisible(false);
		dateChooserInicioEvento.setBounds(153, 98, 121, 20);
		add(dateChooserInicioEvento);

		lblHoraInicioEvento = new JLabel("Hora");
		lblHoraInicioEvento.setBounds(308, 100, 37, 14);
		lblHoraInicioEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraInicioEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraInicioEvento);

		horaInicioSpinner = new TimeSpinner();
		horaInicioSpinner.setVisible(false);
		horaInicioSpinner.setBounds(355, 97, 62, 20);
		SpinnerDateModel modeloHora = new SpinnerDateModel();
		JSpinner.DateEditor editorHora = new JSpinner.DateEditor(horaInicioSpinner, "HH:mm");
		horaInicioSpinner.setEditor(editorHora);
		horaInicioSpinner.setModel(modeloHora);
		add(horaInicioSpinner);

		lblFinalizacinFecha = new JLabel("Fecha Finalizaci\u00F3n ");
		lblFinalizacinFecha.setBounds(10, 136, 133, 14);
		lblFinalizacinFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFinalizacinFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFinalizacinFecha);

		dateChooserFinEvento = new JDateChooser();
		dateChooserFinEvento.setVisible(false);
		dateChooserFinEvento.setBounds(153, 129, 121, 20);
		add(dateChooserFinEvento);

		lblHoraFinEvento = new JLabel("Hora");
		lblHoraFinEvento.setBounds(308, 132, 37, 14);
		lblHoraFinEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraFinEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraFinEvento);

		horaFinSpinner = new TimeSpinner();
		horaFinSpinner.setVisible(false);
		horaFinSpinner.setBounds(355, 128, 62, 20);
		horaFinSpinner.setFormat("HH:mm");
		add(horaFinSpinner);

		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(10, 164, 133, 14);
		lblModalidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblModalidad);

		ModalidadEventocomboBox = new JComboBox<String>();
		ModalidadEventocomboBox.setVisible(false);
		ModalidadEventocomboBox.setBounds(153, 159, 121, 22);
		ModalidadEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		modeloModalidad = new DefaultComboBoxModel<>(ListaModalidades.getListaString());
		ModalidadEventocomboBox.setModel(modeloModalidad);
		add(ModalidadEventocomboBox);

		lblEventoITR = new JLabel("ITR");
		lblEventoITR.setBounds(318, 163, 27, 14);
		lblEventoITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEventoITR.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEventoITR);

		ITREventocomboBox = new JComboBox<String>();
		ITREventocomboBox.setVisible(false);
		ITREventocomboBox.setBounds(355, 159, 131, 22);
		ITREventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		ITREventocomboBox.setModel(modeloItr);
		add(ITREventocomboBox);

		lblLocalizacionEvento = new JLabel("Localizaci\u00F3n");
		lblLocalizacionEvento.setBounds(10, 191, 133, 14);
		lblLocalizacionEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocalizacionEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblLocalizacionEvento);

		localizacionEventoField = new JTextField();
		localizacionEventoField.setEditable(false);
		localizacionEventoField.setBounds(153, 189, 344, 20);
		localizacionEventoField.setColumns(10);
		add(localizacionEventoField);

		lblTutoresEvento = new JLabel("Tutor/es");
		lblTutoresEvento.setBounds(51, 216, 92, 14);
		lblTutoresEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTutoresEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblTutoresEvento);
		
		tutorField = new JTextField();
		tutorField.setVisible(false);
		tutorField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = tutorField.getText();
				buscarTutor(texto);
			}
		});


		tutorField.setBounds(153, 214, 344, 20);
		tutorField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tutoresScrollPane.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				tutoresScrollPane.setVisible(false);
			}
		});
		add(tutorField);
		tutorField.setColumns(10);
		listaTutores = ListaUsuarios.getListaTutoresEventoString();
		for(int i = 0; i < listaTutores.length; i++) {
			arrayTutores.add(listaTutores[i]);
		}
		modeloTutores = new DefaultListModel();
		int count = 0;
		for(int i = 0; i < arrayTutores.size(); i++) {
			modeloTutores.addElement(arrayTutores.get(i));
			if(i < 5) {
				count+=19;
			}					
		}
				
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(153, 238, 344, 77);
		add(scrollPane);
		
		tutoresTable = new JTable();
		scrollPane.setViewportView(tutoresTable);
		tutoresTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tutoresTable.rowAtPoint(e.getPoint());
				int columna = tutoresTable.columnAtPoint(e.getPoint());
				if(columna == 1) {
					if(fila >= 0) {
						modeloTablaTutores.removeRow(fila);
						tutoresAgregados.remove(fila);
						for(int i = fila+1; i < tutoresAgregados.size(); i++) {
							tutoresAgregados.set(i-1, tutoresAgregados.get(i));
						}
					}
				}
			}
		});
		
		aviso = new JLabel("");
		aviso.setVisible(false);
		aviso.setHorizontalAlignment(SwingConstants.LEFT);
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso.setBounds(631, 238, 351, 21);
		add(aviso);
		
		tutoresList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tutoresScrollPane.setVisible(false);
				tutorField.setText("");
				if(!tutoresAgregados.contains(tutoresList.getSelectedValue().toString())){
					tutoresAgregados.add(tutoresList.getSelectedValue().toString());
					Object datos[] = new Object[2];
					datos[0] = tutoresList.getSelectedValue().toString();
					datos[1] = "ELIMINAR";
					modeloTablaTutores.addRow(datos);
					tutorField.setFocusable(true);

				}
				estudianteField.setFocusable(false);
				estudianteField.setFocusable(true);
			}
		});
		
		tutoresList.setModel(modeloTutores);
		
		titulo = new JLabel("FICHA DEL EVENTO");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		titulo.setBounds(429, 10, 182, 13);
		add(titulo);
		
		JLabel lblEstudiantesEvento = new JLabel("Estudiantes");
		lblEstudiantesEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstudiantesEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstudiantesEvento.setBounds(556, 36, 72, 14);
		add(lblEstudiantesEvento);
		
		scrollPaneEstudiantes = new JScrollPane();
		scrollPaneEstudiantes.setBounds(638, 30, 344, 177);
		add(scrollPaneEstudiantes);
		
		tableEstudiantes = new JTable();
		scrollPaneEstudiantes.setViewportView(tableEstudiantes);
		tableEstudiantes.setRowHeight(25);
		
		tipoEventoField = new JTextField();
		tipoEventoField.setEditable(false);
		tipoEventoField.setBounds(153, 65, 227, 22);
		add(tipoEventoField);
		tipoEventoField.setColumns(10);
		
		fechaInicioField = new JTextField();
		fechaInicioField.setEditable(false);
		fechaInicioField.setBounds(153, 98, 121, 20);
		add(fechaInicioField);
		fechaInicioField.setColumns(10);
		
		fechaFinField = new JTextField();
		fechaFinField.setEditable(false);
		fechaFinField.setBounds(153, 129, 121, 20);
		add(fechaFinField);
		fechaFinField.setColumns(10);
		
		horaInicioField = new JTextField();
		horaInicioField.setEditable(false);
		horaInicioField.setBounds(355, 97, 62, 20);
		add(horaInicioField);
		horaInicioField.setColumns(10);
		
		horaFinField = new JTextField();
		horaFinField.setEditable(false);
		horaFinField.setBounds(355, 128, 62, 20);
		add(horaFinField);
		
		modalidadField = new JTextField();
		modalidadField.setEditable(false);
		modalidadField.setBounds(153, 159, 121, 22);
		add(modalidadField);
		modalidadField.setColumns(10);
		
		itrField = new JTextField();
		itrField.setEditable(false);
		itrField.setBounds(355, 159, 131, 22);
		add(itrField);
		itrField.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(153, 214, 344, 77);
		add(scrollPane_1);
		
		tutoresTable2 = new JTable();
		scrollPane_1.setViewportView(tutoresTable2);
		tutoresTable2.setRowHeight(25);
		
		estudiantesBtn = new JButton("Gestionar estudiantes");
		estudiantesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editarBtn.setVisible(false);
				cancelarEstudiantesBtn.setVisible(true);
				estudiantesBtn.setVisible(false);
				confirmarEstudiantesBtn.setVisible(true);
				
				scrollPaneEstudiantes.setVisible(false);
				scrollPaneEstudiantes2.setVisible(true);
				estudianteField.setVisible(true);
				
			}
		});
		estudiantesBtn.setBounds(812, 269, 170, 22);
		add(estudiantesBtn);
		
		editarBtn = new JButton("Editar evento");
		editarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editarBtn.setVisible(false);
				cancelarEditarBtn.setVisible(true);
				estudiantesBtn.setVisible(false);
				confirmarEdicionBtn.setVisible(true);
				aviso.setVisible(true);
				
				horaInicioField.setVisible(false);
				horaFinField.setVisible(false);
				fechaInicioField.setVisible(false);
				fechaFinField.setVisible(false);
				modalidadField.setVisible(false);
				itrField.setVisible(false);
				tipoEventoField.setVisible(false);
				tutoresTable2.setVisible(false);
				
				tituloEventoField.setEditable(true);
				ModalidadEventocomboBox.setVisible(true);
				ITREventocomboBox.setVisible(true);
				tipoEventocomboBox.setVisible(true);
				tutorField.setVisible(true);
				tutoresTable.setVisible(true);
				dateChooserFinEvento.setVisible(true);
				dateChooserInicioEvento.setVisible(true);
				horaFinSpinner.setVisible(true);
				horaInicioSpinner.setVisible(true);
				scrollPane.setVisible(true);		
				localizacionEventoField.setEditable(true);
			}
		});
		editarBtn.setBounds(631, 270, 170, 21);
		add(editarBtn);
		
		cancelarEditarBtn = new JButton("Cancelar");
		cancelarEditarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editarBtn.setVisible(true);
				cancelarEditarBtn.setVisible(false);
				estudiantesBtn.setVisible(true);
				confirmarEdicionBtn.setVisible(false);
				aviso.setVisible(false);
				
				horaInicioField.setVisible(true);
				horaFinField.setVisible(true);
				fechaInicioField.setVisible(true);
				fechaFinField.setVisible(true);
				modalidadField.setVisible(true);
				itrField.setVisible(true);
				tipoEventoField.setVisible(true);
				tutoresTable2.setVisible(true);
				
				tituloEventoField.setEditable(false);
				ModalidadEventocomboBox.setVisible(false);
				ITREventocomboBox.setVisible(false);
				tipoEventocomboBox.setVisible(false);
				tutorField.setVisible(false);
				tutoresTable.setVisible(false);
				dateChooserFinEvento.setVisible(false);
				dateChooserInicioEvento.setVisible(false);
				horaFinSpinner.setVisible(false);
				horaInicioSpinner.setVisible(false);
				scrollPane.setVisible(false);
				localizacionEventoField.setEditable(false);
			}
		});
		cancelarEditarBtn.setVisible(false);
		cancelarEditarBtn.setBounds(632, 270, 170, 21);
		add(cancelarEditarBtn);
		
		confirmarEdicionBtn = new JButton("Editar");
		confirmarEdicionBtn.setVisible(false);
		confirmarEdicionBtn.setBounds(812, 269, 170, 22);
		add(confirmarEdicionBtn);
		modeloTutores = new DefaultListModel();
		int count2 = 0;
		for(int i = 0; i < arrayTutores.size(); i++) {
			modeloTutores.addElement(arrayTutores.get(i));
			if(i < 5) {
				count2+=19;
			}					
		}
		
		confirmarEdicionBtn.addActionListener(new ControlBotonEditarEvento());
				
		listaCampos = new LinkedList<ControlCampo>();
		
		Control_longit_min_ficha_evento controlTitulo = new Control_longit_min_ficha_evento(tituloEventoField,3);
		tituloEventoField.getDocument().addDocumentListener(controlTitulo);
		
		Control_longit_min_ficha_evento controlLocalizacion = new Control_longit_min_ficha_evento(localizacionEventoField,3);
		
		confirmarEstudiantesBtn = new JButton("Editar");
		confirmarEstudiantesBtn.setVisible(false);
		confirmarEstudiantesBtn.setBounds(812, 269, 170, 22);
		confirmarEstudiantesBtn.addActionListener(new ControlBotonAgregarEstudiantesEvento());
		add(confirmarEstudiantesBtn);
		
		cancelarEstudiantesBtn = new JButton("Cancelar");
		cancelarEstudiantesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				estudiantesBtn.setVisible(true);
				cancelarEstudiantesBtn.setVisible(false);
				editarBtn.setVisible(true);
				confirmarEstudiantesBtn.setVisible(false);
				
				scrollPaneEstudiantes.setVisible(true);
				scrollPaneEstudiantes2.setVisible(false);
				estudianteField.setVisible(false);
				
			}
		});
		cancelarEstudiantesBtn.setVisible(false);
		cancelarEstudiantesBtn.setBounds(631, 270, 170, 21);
		add(cancelarEstudiantesBtn);
		
		estudianteField = new JTextField();
		estudianteField.setVisible(false);
		estudianteField.setBounds(638, 32, 344, 19);
		estudianteField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = estudianteField.getText();
				buscarEstudiante(texto);
			}
		});

		estudianteField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				scrollPaneEstudiantesList.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				scrollPaneEstudiantesList.setVisible(false);
			}
		});
		add(estudianteField);
		estudianteField.setColumns(10);
		
		scrollPaneEstudiantes2 = new JScrollPane();
		scrollPaneEstudiantes2.setBounds(638, 70, 344, 138);
		add(scrollPaneEstudiantes2);
		
		tableEstudiantes2 = new JTable();
		tableEstudiantes2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tableEstudiantes2.rowAtPoint(e.getPoint());
				int columna = tableEstudiantes2.columnAtPoint(e.getPoint());
				if(columna == 1) {
					if(fila >= 0) {
						modeloTableEstudiantes2.removeRow(fila);
						estudiantesAgregados.remove(fila);
						for(int i = fila+1; i < estudiantesAgregados.size(); i++) {
							estudiantesAgregados.set(i-1, estudiantesAgregados.get(i));
						}
					}
				}
			}
		});
		scrollPaneEstudiantes2.setViewportView(tableEstudiantes2);
		localizacionEventoField.getDocument().addDocumentListener(controlLocalizacion);
				
		listaCampos.add(controlTitulo);
		listaCampos.add(controlLocalizacion);
		
		buscarEstudiante("");
		buscarTutor("");
				
	}

	protected void buscarTutor(String texto){
		arrayTutores = null;
		arrayTutores = new ArrayList();
		tutoresList.setVisible(false);
		try {
			listaTutores = ListaUsuarios.getListaTutoresEventoFiltroString(texto);
			
			for(int i = 0; i < listaTutores.length; i++) {
				arrayTutores.add(listaTutores[i]);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (ServicesException e) {
			e.printStackTrace();
		}
		
		modeloTutores = new DefaultListModel();
		int count = 0;
		for(int i = 0; i < arrayTutores.size(); i++) {
			modeloTutores.addElement(arrayTutores.get(i));
			if(i < 5) {
				count+=19;
			}					
		}
		tutoresList.setModel(modeloTutores);
		
		if(count==19) {
			count = 25;
		}
		tutoresScrollPane.setBounds(153, 232, 344, count);
		tutoresList.setVisible(true);
	}
	
	protected void buscarEstudiante(String texto){
		arrayEstudiantes = null;
		arrayEstudiantes = new ArrayList();
		estudiantesList.setVisible(false);
		try {
			listaEstudiantes = ListaUsuarios.getListaEstudiantesEventoFiltroString(texto);
			
			for(int i = 0; i < listaEstudiantes.length; i++) {
				arrayEstudiantes.add(listaEstudiantes[i]);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (ServicesException e) {
			e.printStackTrace();
		}
		
		modeloEstudiantes = new DefaultListModel();
		int count = 0;
		for(int i = 0; i < arrayTutores.size(); i++) {
			modeloEstudiantes.addElement(arrayEstudiantes.get(i));
			if(i < 5) {
				count+=19;
			}					
		}
		estudiantesList.setModel(modeloEstudiantes);
		
		if(count==19) {
			count = 25;
		}
		scrollPaneEstudiantesList.setBounds(638, 51, 344, count);
		estudiantesList.setVisible(true);
	}

	public static void setAviso(String aviso) {
		PanelFichaEvento.aviso.setText(aviso);
	}

	public static void limpiar() {
		editarBtn.setVisible(true);
		cancelarEditarBtn.setVisible(false);
		estudiantesBtn.setVisible(true);
		confirmarEdicionBtn.setVisible(false);
		aviso.setVisible(false);
		
		horaInicioField.setVisible(true);
		horaFinField.setVisible(true);
		fechaInicioField.setVisible(true);
		fechaFinField.setVisible(true);
		modalidadField.setVisible(true);
		itrField.setVisible(true);
		tipoEventoField.setVisible(true);
		tutoresTable2.setVisible(true);
		
		tituloEventoField.setEditable(false);
		ModalidadEventocomboBox.setVisible(false);
		ITREventocomboBox.setVisible(false);
		tipoEventocomboBox.setVisible(false);
		tutorField.setVisible(false);
		tutoresTable.setVisible(false);
		dateChooserFinEvento.setVisible(false);
		dateChooserInicioEvento.setVisible(false);
		horaFinSpinner.setVisible(false);
		horaInicioSpinner.setVisible(false);
		scrollPane.setVisible(false);
		localizacionEventoField.setEditable(false);
		
	}

	public static void cargarDatos(Evento evento) {
		
		if(!evento.getEstado().getNombre().equals("FUTURO")) {
			editarBtn.setVisible(false);
			estudiantesBtn.setVisible(false);
		}
		
		tituloEventoField.setText(evento.getNombre());
		
		int select = 0;
		for(int i = 0; i < ListaTiposEvento.getListaString().length; i ++) {
			if(ListaTiposEvento.getListaString()[i].equals(evento.getTipo().getNombre())) {
				select=i;
			}
		}
		modeloTipoEvento.setSelectedItem(modeloTipoEvento.getElementAt(select));
		tipoEventoField.setText(evento.getTipo().getNombre());
		
		for(int i = 0; i < ListaModalidades.getListaString().length; i ++) {
			if(ListaModalidades.getListaString()[i].equals(evento.getModalidad().getNombre())) {
				select=i;
			}
		}
		modeloModalidad.setSelectedItem(modeloModalidad.getElementAt(select));
		
		for(int i = 0; i < ListaItrs.getListaString().length; i ++) {
			if(ListaItrs.getListaString()[i].equals(evento.getItr().getNombre())) {
				select=i;
			}
		}
		modeloItr.setSelectedItem(modeloItr.getElementAt(select));
		
		localizacionEventoField.setText(evento.getLocalizacion());
		
		dateChooserInicioEvento.setDate(evento.getFechaHoraInicio());
		dateChooserFinEvento.setDate(evento.getFechaHoraFinal());
		
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM y");
		
        String dateInicio = sdf.format(evento.getFechaHoraInicio());
        String dateFin = sdf.format(evento.getFechaHoraFinal());
        
        sdf = new SimpleDateFormat("HH:mm");
        
        String horaInicio = sdf.format(evento.getFechaHoraInicio());
        String horaFin = sdf.format(evento.getFechaHoraFinal());
        
		fechaInicioField.setText(dateInicio);
		fechaFinField.setText(dateFin);
		horaInicioField.setText(horaInicio);
		horaFinField.setText(horaFin);
		
		modalidadField.setText(evento.getModalidad().getNombre());
		itrField.setText(evento.getItr().getNombre());
		
		crearModeloTablaTutores(evento);
		crearModeloTablaEstudiantes(evento);
			
	}
	
	public static void crearModeloTablaTutores(Evento evento) {
		
		tutoresTable2.setModel(new ModeloTabla(
				new Object[][] {
				},
				new String[] {
					""
				}
			));
		modeloTablaTutores2 = (ModeloTabla) tutoresTable2.getModel();
		
		tutoresTable2.setRowHeight(25);
		for(Usuario u : evento.getTutores()) {
			String[] datos = {
					u.getDocumento().getCaracteres() + " - " + u.getNombre1() + " " + u.getApellido1() + " - " + u.getArea().getNombre()
					};
			modeloTablaTutores2.addRow(datos);
		}
		
		tutoresTable.setModel(new ModeloTabla(
				new Object[][] {
				},
				new String[] {
					"", ""
				}
			));
		modeloTablaTutores = (ModeloTabla) tutoresTable.getModel();
		tutoresTable.setRowHeight(25);
		tutoresTable.getTableHeader().setVisible(false);
		TableColumnModel columnModel = tutoresTable.getColumnModel();
		columnModel.getColumn(1).setMaxWidth(25);
		columnModel.getColumn(1).setCellRenderer(new GestionCeldas("icono"));
		for(Usuario u : evento.getTutores()) {
			tutoresAgregados.add(u.getDocumento().getCaracteres() + " - " + u.getNombre1() + " " + u.getApellido1() + " - " + u.getArea().getNombre());
			String[] datos = {
					u.getDocumento().getCaracteres() + " - " + u.getNombre1() + " " + u.getApellido1() + " - " + u.getArea().getNombre(),
					"ELIMINAR"
					};
			modeloTablaTutores.addRow(datos);
		}
		
	}
	
	public static void crearModeloTablaEstudiantes(Evento evento) {
		
		tableEstudiantes.setModel(new ModeloTabla(
				new Object[][] {
				},
				new String[] {
					""
				}
			));
		modeloTableEstudiantes = (ModeloTabla) tableEstudiantes.getModel();
		tableEstudiantes.setRowHeight(25);		
		
		try {
			for(ConvocatoriaAsistencia c : evento.getConvocatoriasAsistencias()) {
				String[] datos = {
					c.getEstudiante().getDocumento().getCaracteres() + " - " +
					c.getEstudiante().getNombre1() + " " +
					c.getEstudiante().getApellido1()
				};
				modeloTableEstudiantes.addRow(datos);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		tableEstudiantes2.setModel(new ModeloTabla(
				new Object[][] {
				},
				new String[] {
					"", ""
				}
			));
		modeloTableEstudiantes2 = (ModeloTabla) tableEstudiantes2.getModel();
		tableEstudiantes2.setRowHeight(25);
		tableEstudiantes2.getTableHeader().setVisible(false);
		TableColumnModel columnModel = tableEstudiantes2.getColumnModel();
		columnModel.getColumn(1).setMaxWidth(25);
		columnModel.getColumn(1).setCellRenderer(new GestionCeldas("icono"));
		for(ConvocatoriaAsistencia c : evento.getConvocatoriasAsistencias()) {
			estudiantesAgregados.add(
					c.getEstudiante().getDocumento().getCaracteres() + " - " +
					c.getEstudiante().getNombre1() + " " +
					c.getEstudiante().getApellido1());
					
			String[] datos = {
					c.getEstudiante().getDocumento().getCaracteres() + " - " +
					c.getEstudiante().getNombre1() + " " +
					c.getEstudiante().getApellido1()
					,
					"ELIMINAR"
					};
			modeloTableEstudiantes2.addRow(datos);
		}
		
	}
}
