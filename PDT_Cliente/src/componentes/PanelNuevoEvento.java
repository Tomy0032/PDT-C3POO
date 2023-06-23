package componentes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.naming.NamingException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

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

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JList;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

import javax.swing.*;
import java.util.LinkedList;

//CREAR LA LISTA DE CONTROLADORES
public class PanelNuevoEvento extends JPanel {

	/**
	 * 
	 */
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
	private JTable tutoresTable;
	private DefaultTableModel modeloTablaTutores;
	private ArrayList<String> tutoresAgregados = new ArrayList<String>();
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

	public static JButton getBtnCrearEvento() {
		return btnCrearEvento;
	}

	public PanelNuevoEvento() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tutorField.setFocusable(false);
				tutorField.setFocusable(true);
			}
		});
		setLayout(null);

		
		lblNewLabel = new JLabel("T\u00EDtulo del evento");
		lblNewLabel.setBounds(10, 11, 150, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblNewLabel);

		tituloEventoField = new JTextField();
		tituloEventoField.setBounds(170, 10, 686, 20);
		add(tituloEventoField);
		tituloEventoField.setColumns(10);

		lblTpoDeEvento = new JLabel("Tipo de evento");
		lblTpoDeEvento.setBounds(10, 47, 150, 14);
		lblTpoDeEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTpoDeEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblTpoDeEvento);

		tipoEventocomboBox = new JComboBox<String>();
		tipoEventocomboBox.setBounds(170, 43, 227, 22);
		tipoEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloTipoEvento = new DefaultComboBoxModel<>(ListaTiposEvento.getListaString());
		tipoEventocomboBox.setModel(modeloTipoEvento);
		add(tipoEventocomboBox);

		lblFechaDelEvento = new JLabel("Fecha Inicio");
		lblFechaDelEvento.setBounds(10, 82, 150, 14);
		lblFechaDelEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFechaDelEvento);

		dateChooserInicioEvento = new JDateChooser();
		dateChooserInicioEvento.setBounds(170, 76, 121, 20);
		add(dateChooserInicioEvento);

		lblHoraInicioEvento = new JLabel("Hora");
		lblHoraInicioEvento.setBounds(288, 79, 37, 14);
		lblHoraInicioEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraInicioEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraInicioEvento);

		horaInicioSpinner = new TimeSpinner();
		horaInicioSpinner.setBounds(335, 76, 62, 20);
		SpinnerDateModel modeloHora = new SpinnerDateModel();
		JSpinner.DateEditor editorHora = new JSpinner.DateEditor(horaInicioSpinner, "HH:mm");
		horaInicioSpinner.setEditor(editorHora);
		horaInicioSpinner.setModel(modeloHora);
		add(horaInicioSpinner);

		lblFinalizacinFecha = new JLabel("Fecha Finalizaci\u00F3n ");
		lblFinalizacinFecha.setBounds(10, 113, 150, 14);
		lblFinalizacinFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFinalizacinFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblFinalizacinFecha);

		dateChooserFinEvento = new JDateChooser();
		dateChooserFinEvento.setBounds(170, 107, 121, 20);
		add(dateChooserFinEvento);

		lblHoraFinEvento = new JLabel("Hora");
		lblHoraFinEvento.setBounds(288, 111, 37, 14);
		lblHoraFinEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHoraFinEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblHoraFinEvento);

		horaFinSpinner = new TimeSpinner();
		horaFinSpinner.setBounds(335, 107, 62, 20);
		horaFinSpinner.setFormat("HH:mm");
		add(horaFinSpinner);

		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setBounds(10, 141, 150, 14);
		lblModalidad.setHorizontalAlignment(SwingConstants.TRAILING);
		lblModalidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblModalidad);

		ModalidadEventocomboBox = new JComboBox<String>();
		ModalidadEventocomboBox.setBounds(170, 137, 121, 22);
		ModalidadEventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloModalidad = new DefaultComboBoxModel<>(ListaModalidades.getListaString());
		ModalidadEventocomboBox.setModel(modeloModalidad);
		add(ModalidadEventocomboBox);

		lblEventoITR = new JLabel("ITR");
		lblEventoITR.setBounds(651, 142, 27, 14);
		lblEventoITR.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEventoITR.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEventoITR);

		ITREventocomboBox = new JComboBox<String>();
		ITREventocomboBox.setBounds(688, 138, 131, 22);
		ITREventocomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		ITREventocomboBox.setModel(modeloItr);
		add(ITREventocomboBox);

		lblLocalizacionEvento = new JLabel("Localizaci\u00F3n");
		lblLocalizacionEvento.setBounds(10, 168, 150, 14);
		lblLocalizacionEvento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLocalizacionEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblLocalizacionEvento);

		localizacionEventoField = new JTextField();
		localizacionEventoField.setBounds(170, 167, 686, 20);
		localizacionEventoField.setColumns(10);
		add(localizacionEventoField);

		lblTutoresEvento = new JLabel("Tutor/es");
		lblTutoresEvento.setBounds(10, 200, 150, 14);
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


		tutorField.setBounds(170, 199, 344, 19);
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
		tutoresScrollPane.setBounds(170, 217, 344, count);
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
		tutoresTable.setBounds(170, 228, 344, 140);
		add(tutoresTable);
		
		btnCrearEvento = new JButton("Crear");
		btnCrearEvento.addActionListener(new ControlBotonCrearEvento());
		btnCrearEvento.setBounds(170, 402, 85, 21);
		btnCrearEvento.setEnabled(false);
		add(btnCrearEvento);
		
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
		PanelNuevoEvento.aviso.setText(aviso);
	}
}
