package componentes;

import java.awt.Color;
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

import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.toedter.calendar.JDateChooser;

import controladores.Control_longit_min_evento;
import interfaces.ControlCampo;
import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.ModeloTabla;

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
	private JTextField tutorField;
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
	private JList tutoresList;
	private JScrollPane tutoresScrollPane;
	private String[] listaTutores;
	private ArrayList<String> arrayTutores = new ArrayList<String>();
	private DefaultListModel modeloTutores;
	private static JTable tutoresTable;
	private static DefaultTableModel modeloTablaTutores;
	private static ArrayList<String> tutoresAgregados = new ArrayList<String>();
	private static JLabel aviso;
	private static LinkedList<ControlCampo> listaCampos;
	private JLabel titulo;
	private JTable tableEstudiantes;
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
		
		tutoresScrollPane = new JScrollPane();
		tutoresScrollPane.setBounds(153, 288, 344, -54);
		add(tutoresScrollPane);
		tutoresScrollPane.setVisible(false);
		
		tutoresList = new JList();
		tutoresScrollPane.setViewportView(tutoresList);
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
				tutorField.setFocusable(false);
				tutorField.setFocusable(true);
			}
		});
		tutoresList.setModel(modeloTutores);
		
		tutoresTable = new JTable();
		tutoresTable.setVisible(false);
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
		tutoresTable.setModel(new ModeloTabla(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		modeloTablaTutores = (ModeloTabla) tutoresTable.getModel();
		tutoresTable.setRowHeight(25);
		TableColumnModel columnModel = tutoresTable.getColumnModel();
		columnModel.getColumn(1).setMaxWidth(25);
		columnModel.getColumn(1).setCellRenderer(new GestionCeldas("icono"));
		tutoresTable.setBounds(153, 213, 344, 20);
		add(tutoresTable);
		
		aviso = new JLabel("");
		aviso.setHorizontalAlignment(SwingConstants.LEFT);
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso.setBounds(170, 378, 594, 21);
		add(aviso);
		
		
		
		listaCampos = new LinkedList<ControlCampo>();
		
		Control_longit_min_evento controlTitulo = new Control_longit_min_evento(tituloEventoField,3);
		tituloEventoField.getDocument().addDocumentListener(controlTitulo);
		
		Control_longit_min_evento controlLocalizacion = new Control_longit_min_evento(localizacionEventoField,3);
		
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
		
		tableEstudiantes = new JTable();
		tableEstudiantes.setRowHeight(25);
		tableEstudiantes.setBounds(638, 30, 344, 177);
		add(tableEstudiantes);
		
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
		
		tutoresTable2 = new JTable();
		tutoresTable2.setRowHeight(25);
		tutoresTable2.setBounds(153, 214, 344, 77);
		add(tutoresTable2);
		
		localizacionEventoField.getDocument().addDocumentListener(controlLocalizacion);
				
		listaCampos.add(controlTitulo);
		listaCampos.add(controlLocalizacion);
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
		tutoresScrollPane.setBounds(170, 217, 344, count);
		tutoresList.setVisible(true);
	}

	public static void setAviso(String aviso) {
		PanelFichaEvento.aviso.setText(aviso);
	}

	public static void limpiar() {
		tituloEventoField.setText("");
		ITREventocomboBox.setSelectedIndex(0);
		ModalidadEventocomboBox.setSelectedIndex(0);
		tipoEventocomboBox.setSelectedIndex(0);
		
		tutoresTable.setModel(new ModeloTabla(
				new Object[][] {
				},
				new String[] {
					"New column", "New column"
				}
			));
		tutoresAgregados.clear();
		dateChooserFinEvento.setDate(null);
		dateChooserInicioEvento.setDate(null);
		localizacionEventoField.setText("");
	}

	public static void cargarDatos(Evento evento) {
		
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
		
	}
	
	public static void crearModeloTablaTutores(Evento evento) {
		
		tutoresTable2.setModel(new ModeloTabla(
				new Object[][] {
				},
				new String[] {
					"New column"
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
		
		
		
	}
}
