package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private DefaultTableModel modeloTablaTutores;
	private static ArrayList<String> tutoresAgregados = new ArrayList<String>();
	private static JLabel aviso;
	private static LinkedList<ControlCampo> listaCampos;
	private JLabel titulo;
	private JTable tableEstudiantes;

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
		lblNewLabel.setBounds(10, 34, 113, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel);

		tituloEventoField = new JTextField();
		tituloEventoField.setBounds(133, 33, 413, 20);
		add(tituloEventoField);
		tituloEventoField.setColumns(10);

		lblTpoDeEvento = new JLabel("Tipo de evento");
		lblTpoDeEvento.setBounds(10, 70, 113, 14);
		lblTpoDeEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTpoDeEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblTpoDeEvento);

		tipoEventocomboBox = new JComboBox<String>();
		tipoEventocomboBox.setBounds(133, 66, 227, 22);
		tipoEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloTipoEvento = new DefaultComboBoxModel<>(ListaTiposEvento.getListaString());
		tipoEventocomboBox.setModel(modeloTipoEvento);
		add(tipoEventocomboBox);

		lblFechaDelEvento = new JLabel("Fecha Inicio");
		lblFechaDelEvento.setBounds(10, 105, 113, 14);
		lblFechaDelEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFechaDelEvento);

		dateChooserInicioEvento = new JDateChooser();
		dateChooserInicioEvento.setBounds(133, 99, 121, 20);
		add(dateChooserInicioEvento);

		lblHoraInicioEvento = new JLabel("Hora");
		lblHoraInicioEvento.setBounds(251, 102, 37, 14);
		lblHoraInicioEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraInicioEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraInicioEvento);

		horaInicioSpinner = new TimeSpinner();
		horaInicioSpinner.setBounds(298, 99, 62, 20);
		SpinnerDateModel modeloHora = new SpinnerDateModel();
		JSpinner.DateEditor editorHora = new JSpinner.DateEditor(horaInicioSpinner, "HH:mm");
		horaInicioSpinner.setEditor(editorHora);
		horaInicioSpinner.setModel(modeloHora);
		add(horaInicioSpinner);

		lblFinalizacinFecha = new JLabel("Fecha Finalizaci\u00F3n ");
		lblFinalizacinFecha.setBounds(10, 136, 113, 14);
		lblFinalizacinFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFinalizacinFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFinalizacinFecha);

		dateChooserFinEvento = new JDateChooser();
		dateChooserFinEvento.setBounds(133, 130, 121, 20);
		add(dateChooserFinEvento);

		lblHoraFinEvento = new JLabel("Hora");
		lblHoraFinEvento.setBounds(251, 134, 37, 14);
		lblHoraFinEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraFinEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraFinEvento);

		horaFinSpinner = new TimeSpinner();
		horaFinSpinner.setBounds(298, 130, 62, 20);
		horaFinSpinner.setFormat("HH:mm");
		add(horaFinSpinner);

		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(10, 164, 113, 14);
		lblModalidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblModalidad);

		ModalidadEventocomboBox = new JComboBox<String>();
		ModalidadEventocomboBox.setBounds(133, 160, 121, 22);
		ModalidadEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloModalidad = new DefaultComboBoxModel<>(ListaModalidades.getListaString());
		ModalidadEventocomboBox.setModel(modeloModalidad);
		add(ModalidadEventocomboBox);

		lblEventoITR = new JLabel("ITR");
		lblEventoITR.setBounds(298, 164, 27, 14);
		lblEventoITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEventoITR.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEventoITR);

		ITREventocomboBox = new JComboBox<String>();
		ITREventocomboBox.setBounds(335, 160, 131, 22);
		ITREventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		ITREventocomboBox.setModel(modeloItr);
		add(ITREventocomboBox);

		lblLocalizacionEvento = new JLabel("Localizaci\u00F3n");
		lblLocalizacionEvento.setBounds(10, 191, 113, 14);
		lblLocalizacionEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocalizacionEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblLocalizacionEvento);

		localizacionEventoField = new JTextField();
		localizacionEventoField.setBounds(133, 190, 413, 20);
		localizacionEventoField.setColumns(10);
		add(localizacionEventoField);

		lblTutoresEvento = new JLabel("Tutor/es");
		lblTutoresEvento.setBounds(51, 216, 72, 14);
		lblTutoresEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTutoresEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblTutoresEvento);
		
		tutorField = new JTextField();
		tutorField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto = tutorField.getText();
				buscarTutor(texto);
			}
		});


		tutorField.setBounds(133, 215, 344, 19);
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
		tutoresScrollPane.setBounds(188, 265, 326, -48);
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
		tutoresTable.setBounds(133, 244, 344, 72);
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
}
