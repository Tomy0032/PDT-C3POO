package componentes;

import java.awt.Font;

import javax.naming.NamingException;

import com.exception.ServicesException;
import com.toedter.calendar.JDateChooser;

import controladores.ControlBotonCrearEvento;
import controladores.Control_longit_min_evento;
import interfaces.ControlCampo;

import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.ModeloTabla;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.util.LinkedList;


public class PanelNuevoEvento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JComboBox<String> tipoEventocomboBox;
	private static JDateChooser dateChooserInicioEvento;
	private static JSpinner horaInicioSpinner;
	private static JSpinner horaFinSpinner;
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
	private static JList tutoresList;
	private static JScrollPane tutoresScrollPane;
	private static String[] listaTutores;
	private static ArrayList<String> arrayTutores = new ArrayList<String>();
	private static DefaultListModel modeloTutores;
	private static JTable tutoresTable;
	private static DefaultTableModel modeloTablaTutores;
	private static ArrayList<String> tutoresAgregados = new ArrayList<String>();
	private static JButton btnCrearEvento;
	private static JLabel aviso;
	private static LinkedList<ControlCampo> listaCampos;

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

	public static JSpinner getHoraFinSpinner() {
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

	public static JButton getBtnCrearEvento() {
		return btnCrearEvento;
	}
	
	public static ArrayList<String> getTutoresAgregados() {
		return tutoresAgregados;
	}

	public static void setTutoresAgregados(ArrayList<String> tutoresAgregados) {
		PanelNuevoEvento.tutoresAgregados = tutoresAgregados;
	}
	
	public static void setDateChooserInicioEvento(JDateChooser dateChooserInicioEvento) {
		PanelNuevoEvento.dateChooserInicioEvento = dateChooserInicioEvento;
	}

	public static void setHoraInicioSpinner(JSpinner horaInicioSpinner) {
		PanelNuevoEvento.horaInicioSpinner = horaInicioSpinner;
	}

	public static void setHoraFinSpinner(TimeSpinner horaFinSpinner) {
		PanelNuevoEvento.horaFinSpinner = horaFinSpinner;
	}

	public static void setDateChooserFinEvento(JDateChooser dateChooserFinEvento) {
		PanelNuevoEvento.dateChooserFinEvento = dateChooserFinEvento;
	}

	public PanelNuevoEvento() {
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tutorField.setFocusable(false);
				tutorField.setFocusable(true);
			}
		});
		setLayout(null);

		
		lblNewLabel = new JLabel("T\u00EDtulo del evento");
		lblNewLabel.setBounds(10, 37, 150, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel);

		tituloEventoField = new JTextField();
		tituloEventoField.setBounds(170, 36, 686, 20);
		add(tituloEventoField);
		tituloEventoField.setColumns(10);

		lblTpoDeEvento = new JLabel("Tipo de evento");
		lblTpoDeEvento.setBounds(10, 73, 150, 14);
		lblTpoDeEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTpoDeEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblTpoDeEvento);

		tipoEventocomboBox = new JComboBox<String>();
		tipoEventocomboBox.setBounds(170, 69, 227, 22);
		tipoEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloTipoEvento = new DefaultComboBoxModel<>(ListaTiposEvento.getListaString());
		tipoEventocomboBox.setModel(modeloTipoEvento);
		add(tipoEventocomboBox);

		lblFechaDelEvento = new JLabel("Fecha Inicio");
		lblFechaDelEvento.setBounds(10, 108, 150, 14);
		lblFechaDelEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFechaDelEvento);

		dateChooserInicioEvento = new JDateChooser();
		dateChooserInicioEvento.setBounds(170, 102, 121, 20);
		add(dateChooserInicioEvento);

		lblHoraInicioEvento = new JLabel("Hora");
		lblHoraInicioEvento.setBounds(288, 105, 37, 14);
		lblHoraInicioEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraInicioEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraInicioEvento);

		horaInicioSpinner = new TimeSpinner();
		horaInicioSpinner.setBounds(335, 102, 62, 20);
		JSpinner.DateEditor editorHoraInicio = new JSpinner.DateEditor(horaInicioSpinner, "HH:mm");
		horaInicioSpinner.setEditor(editorHoraInicio);
		SpinnerModel modeloHoraInicio = new SpinnerDateModel();
		horaInicioSpinner.setModel(modeloHoraInicio );
		add(horaInicioSpinner);

		lblFinalizacinFecha = new JLabel("Fecha Finalizaci\u00F3n ");
		lblFinalizacinFecha.setBounds(10, 139, 150, 14);
		lblFinalizacinFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFinalizacinFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFinalizacinFecha);

		dateChooserFinEvento = new JDateChooser();
		dateChooserFinEvento.setBounds(170, 133, 121, 20);
		add(dateChooserFinEvento);

		lblHoraFinEvento = new JLabel("Hora");
		lblHoraFinEvento.setBounds(288, 137, 37, 14);
		lblHoraFinEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraFinEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraFinEvento);

		horaFinSpinner = new TimeSpinner();
		horaFinSpinner.setBounds(335, 133, 62, 20);
		JSpinner.DateEditor editorHoraFin = new JSpinner.DateEditor(horaFinSpinner, "HH:mm");
		horaFinSpinner.setEditor(editorHoraFin);
		SpinnerModel modeloHoraFin = new SpinnerDateModel();
		horaFinSpinner.setModel(modeloHoraFin);
		add(horaFinSpinner);

		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(10, 167, 150, 14);
		lblModalidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblModalidad);

		ModalidadEventocomboBox = new JComboBox<String>();
		ModalidadEventocomboBox.setBounds(170, 163, 121, 22);
		ModalidadEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloModalidad = new DefaultComboBoxModel<>(ListaModalidades.getListaString());
		ModalidadEventocomboBox.setModel(modeloModalidad);
		add(ModalidadEventocomboBox);

		lblEventoITR = new JLabel("ITR");
		lblEventoITR.setBounds(651, 168, 27, 14);
		lblEventoITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEventoITR.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEventoITR);

		ITREventocomboBox = new JComboBox<String>();
		ITREventocomboBox.setBounds(688, 164, 131, 22);
		ITREventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		ITREventocomboBox.setModel(modeloItr);
		add(ITREventocomboBox);

		lblLocalizacionEvento = new JLabel("Localizaci\u00F3n");
		lblLocalizacionEvento.setBounds(10, 194, 150, 14);
		lblLocalizacionEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocalizacionEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblLocalizacionEvento);

		localizacionEventoField = new JTextField();
		localizacionEventoField.setBounds(170, 193, 686, 20);
		localizacionEventoField.setColumns(10);
		add(localizacionEventoField);

		lblTutoresEvento = new JLabel("Tutor/es");
		lblTutoresEvento.setBounds(10, 226, 150, 14);
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


		tutorField.setBounds(170, 225, 344, 19);
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
		tutoresScrollPane.setBounds(170, 243, 344, count);
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
		tutoresTable.setBounds(170, 254, 344, 140);
		add(tutoresTable);
		
		btnCrearEvento = new JButton("Crear");
		btnCrearEvento.addActionListener(new ControlBotonCrearEvento());
		btnCrearEvento.setBounds(170, 428, 110, 25);
		btnCrearEvento.setFont(new Font("Tahoma",Font.BOLD,12));
		btnCrearEvento.setEnabled(false);
		add(btnCrearEvento);
		
		aviso = new JLabel("");
		aviso.setHorizontalAlignment(SwingConstants.LEFT);
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso.setBounds(170, 404, 594, 21);
		add(aviso);
		
		
		
		listaCampos = new LinkedList<ControlCampo>();
		
		Control_longit_min_evento controlTitulo = new Control_longit_min_evento(tituloEventoField,3);
		tituloEventoField.getDocument().addDocumentListener(controlTitulo);
		
		Control_longit_min_evento controlLocalizacion = new Control_longit_min_evento(localizacionEventoField,3);
		localizacionEventoField.getDocument().addDocumentListener(controlLocalizacion);
				
		listaCampos.add(controlTitulo);
		listaCampos.add(controlLocalizacion);
	}

	public static void buscarTutor(String texto){
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
		tutoresScrollPane.setBounds(170, 243, 344, count);
		tutoresList.setVisible(true);
	}

	public static void setAviso(String aviso) {
		PanelNuevoEvento.aviso.setText(aviso);
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
