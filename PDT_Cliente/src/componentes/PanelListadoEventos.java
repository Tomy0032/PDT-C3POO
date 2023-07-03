package componentes;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.EventoBeanRemote;
import com.services.UsuarioBeanRemote;
import com.toedter.calendar.JDateChooser;

import datos.OperacionUsuario;
import interfaz.Aplicacion;
import listas.ListaAreas;
import listas.ListaEstadosEvento;
import listas.ListaEventos;
import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListadoEventos extends JPanel{

	private static JComboBox<String> tipo_comboBox;
	private static JDateChooser dateChooser;
	private static JComboBox<String> modalidad_comboBox;
	private static JComboBox<String> itr_comboBox;
	private static JComboBox<String> estado_comboBox;
	private static PanelFichaEvento fichaEvento;
	private static ModeloTabla modelo;
	private static JTable listaEventosTable;
	private static JScrollPane scrollTabla;
	private static String[] titulos = new String[] {
			"Nombre", "Fecha de inicio", "Modalidad", "ITR", "Estado"};
	private static Evento evento;
	private static HashMap<Integer,Long> ids = new HashMap<Integer,Long>();
	private static String fecha;
	
	public static JComboBox<?> getTipoComboBox() {
		return tipo_comboBox;
	}

	public static JDateChooser getDateChooser() {
		return dateChooser;
	}

	public static JComboBox<String> getModalidadComboBox() {
		return modalidad_comboBox;
	}

	public static JComboBox<?> getItrComboBox() {
		return itr_comboBox;
	}

	public static JComboBox<String> getEstadoComboBox() {
		return estado_comboBox;
	}

	private JButton limpiarBtn;

	public PanelListadoEventos() {
		setBackground(Color.WHITE);
		
		setLayout(null);
		scrollTabla = new JScrollPane();
		scrollTabla.setBounds(123, 127, 1017, 162);
		add(scrollTabla);

		listaEventosTable = new JTable();
		listaEventosTable.setBackground(Color.WHITE);
		listaEventosTable.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		listaEventosTable.addMouseListener(new java.awt.event.MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	int fila = listaEventosTable.rowAtPoint(e.getPoint());
				try {
					mostrarEvento(fila);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				fichaEvento.setVisible(true);
	        }
	        });
		listaEventosTable.setOpaque(false);
		
		scrollTabla.setViewportView(listaEventosTable);

		JLabel lblFiltros = new JLabel("Filtrar por:");
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFiltros.setBounds(33, 56, 56, 14);
		add(lblFiltros);

		JLabel lblTipoEvento = new JLabel("Tipo");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoEvento.setBounds(123, 56, 90, 14);
		add(lblTipoEvento);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(398, 56, 90, 14);
		add(lblFecha);

		JLabel lblModalidadEvento = new JLabel("Modalidad");
		lblModalidadEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblModalidadEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModalidadEvento.setBounds(608, 56, 90, 14);
		add(lblModalidadEvento);

		JLabel lblITREvento = new JLabel("ITR");
		lblITREvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblITREvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblITREvento.setBounds(809, 56, 90, 14);
		add(lblITREvento);

		JLabel lblEstadoEvento = new JLabel("Estado");
		lblEstadoEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstadoEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadoEvento.setBounds(1010, 56, 90, 14);
		add(lblEstadoEvento);

		tipo_comboBox = new JComboBox<String>();
		tipo_comboBox.setBounds(123, 81, 215, 25);
		ComboBoxModel<String> modeloTipoEvento = new DefaultComboBoxModel<>(getTipos());
		tipo_comboBox.setModel(modeloTipoEvento);
		add(tipo_comboBox);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(398, 81, 150, 25);
		add(dateChooser);

		modalidad_comboBox = new JComboBox<String>();
		modalidad_comboBox.setBounds(608, 81, 141, 25);
		ComboBoxModel<String> modeloModalidad = new DefaultComboBoxModel<>(getModalidades());
		modalidad_comboBox.setModel(modeloModalidad);
		add(modalidad_comboBox);

		itr_comboBox = new JComboBox<String>();
		itr_comboBox.setBounds(809, 81, 141, 25);
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(getItrs());
		itr_comboBox.setModel(modeloItr);
		add(itr_comboBox);

		estado_comboBox = new JComboBox<String>();
		estado_comboBox.setBounds(1010, 81, 130, 25);
		ComboBoxModel<String> modeloEstado = new DefaultComboBoxModel<>(getEstados());
		estado_comboBox.setModel(new DefaultComboBoxModel<>(getEstados()));
		add(estado_comboBox);
		
		JLabel lblTitulo = new JLabel("LISTADO DE EVENTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(494, 10, 275, 25);
		add(lblTitulo);
		
		fichaEvento = new PanelFichaEvento();
		fichaEvento.setBounds(123,300,1017,332);
		fichaEvento.setBorder(new BevelBorder(BevelBorder.LOWERED));
		fichaEvento.setBackground(new Color(192, 192, 192));
		fichaEvento.setVisible(false);
		add(fichaEvento);
		
		limpiarBtn = new JButton("Limpiar");
		limpiarBtn.setBounds(1165, 81, 87, 25);
		add(limpiarBtn);
		
		try {
			construirTabla(ListaEventos.getListaStringListado(),getTitulos());
		} catch (NamingException | ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tipo_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros();
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		modalidad_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros();
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		itr_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros();
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		estado_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros();
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) {
					try {
						filtros();
					} catch (ServicesException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		limpiarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFiltros();
			}
		});
		
	}
	
	public String[] getItrs() {

		String[] list = ListaItrs.getListaString();
		String[] lista = new String[list.length + 1];

		for (int i = 0; i < lista.length; i++) {

			if (i == 0) {
				lista[i] = "TODOS";
			} else {
				lista[i] = list[i - 1];
			}

		}

		return lista;

	}
	
	public String[] getModalidades() {

		String[] list = ListaModalidades.getListaString();
		String[] lista = new String[list.length + 1];

		for (int i = 0; i < lista.length; i++) {

			if (i == 0) {
				lista[i] = "TODAS";
			} else {
				lista[i] = list[i - 1];
			}

		}

		return lista;

	}
	
	public static String[] getEstados() {

		String[] list = ListaEstadosEvento.getListaString();
		String[] lista = new String[list.length + 1];

		for (int i = 0; i < lista.length; i++) {

			if (i == 0) {
				lista[i] = "TODOS";
			} else {
				lista[i] = list[i - 1];
			}

		}

		return lista;

	}
	
	public String[] getTipos() {

		String[] list = ListaTiposEvento.getListaString();
		String[] lista = new String[list.length + 1];

		for (int i = 0; i < lista.length; i++) {

			if (i == 0) {
				lista[i] = "TODOS";
			} else {
				lista[i] = list[i - 1];
			}

		}

		return lista;

	}
	
	public static void construirTabla(Object[][] datos, String[] titulos) {
		
		modelo = new ModeloTabla(datos,titulos);
		listaEventosTable.setModel(modelo);

		List<Evento> eventos = ListaEventos.getLista();
		
		for(int i = 0; i < eventos.size(); i++) {
			ids.put(i, eventos.get(i).getIdEvento());
		}
	
		for(int i = 0; i < titulos.length; i++) {
			listaEventosTable.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}

		listaEventosTable.getTableHeader().setReorderingAllowed(false);
		listaEventosTable.setRowHeight(25);
		
		JTableHeader header = listaEventosTable.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla());
		
		scrollTabla.setViewportView(listaEventosTable);
		
		listaEventosTable.getModel().addTableModelListener(listaEventosTable);
		
	}

	public static void mostrarEvento(int fila) throws NamingException {
		
		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext.doLookup("PDT_EJB/EventoBean!com.services.EventoBeanRemote"); 

		try {
			evento = eventoBean.find(ids.get(fila));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PanelFichaEvento.cargarDatos(evento);
		
	}
	
	public static void limpiarFiltros() {
		
		itr_comboBox.setSelectedIndex(0);
		modalidad_comboBox.setSelectedIndex(0);
		tipo_comboBox.setSelectedIndex(0);
		estado_comboBox.setSelectedIndex(0);
		dateChooser.setDate(null);
		try {
			filtros();
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void filtros() throws ServicesException, NamingException {
		
		fecha = "TODAS";
		
		if(dateChooser.getDate()!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("d MMM y");
			try {
				fecha = sdf.format(dateChooser.getDate());
			}catch(Exception e) {
				
			}
		}
		construirTabla(ListaEventos.getListaStringListado(
				tipo_comboBox.getSelectedItem().toString(),
				itr_comboBox.getSelectedItem().toString(),
				estado_comboBox.getSelectedItem().toString(),
				modalidad_comboBox.getSelectedItem().toString(),
				fecha), titulos);
		
	}

	public static String[] getTitulos() {
		return titulos;
	}

	public static void setTitulos(String[] titulos) {
		PanelListadoEventos.titulos = titulos;
	}

	public static Evento getEvento() {
		return evento;
	}
}
