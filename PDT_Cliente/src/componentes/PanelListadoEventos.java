package componentes;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.naming.NamingException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.exception.ServicesException;
import com.toedter.calendar.JDateChooser;

import datos.OperacionUsuario;
import interfaz.Aplicacion;
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

public class PanelListadoEventos extends JPanel implements MouseListener{

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
	
	public static JComboBox<?> getComboBox() {
		return tipo_comboBox;
	}

	public static JDateChooser getDateChooser() {
		return dateChooser;
	}

	public static JComboBox<String> getComboBox_1() {
		return modalidad_comboBox;
	}

	public static JComboBox<?> getComboBox_2() {
		return itr_comboBox;
	}

	public static JComboBox<?> getComboBox_3() {
		return estado_comboBox;
	}

	public PanelListadoEventos() {
		
		setLayout(null);
		scrollTabla = new JScrollPane();
		scrollTabla.setBounds(123, 156, 1017, 162);
		add(scrollTabla);

		listaEventosTable = new JTable();
		listaEventosTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listaEventosTable.addMouseListener(this);
		listaEventosTable.setOpaque(false);
		
		scrollTabla.setViewportView(listaEventosTable);

		JLabel lblFiltros = new JLabel("Filtrar por:");
		lblFiltros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFiltros.setBounds(33, 85, 56, 14);
		add(lblFiltros);

		JLabel lblTipoEvento = new JLabel("Tipo");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoEvento.setBounds(123, 85, 90, 14);
		add(lblTipoEvento);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(398, 85, 90, 14);
		add(lblFecha);

		JLabel lblModalidadEvento = new JLabel("Modalidad");
		lblModalidadEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblModalidadEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModalidadEvento.setBounds(608, 85, 90, 14);
		add(lblModalidadEvento);

		JLabel lblITREvento = new JLabel("ITR");
		lblITREvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblITREvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblITREvento.setBounds(809, 85, 90, 14);
		add(lblITREvento);

		JLabel lblEstadoEvento = new JLabel("Estado");
		lblEstadoEvento.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstadoEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadoEvento.setBounds(1010, 85, 90, 14);
		add(lblEstadoEvento);

		tipo_comboBox = new JComboBox<String>();
		tipo_comboBox.setBounds(123, 110, 215, 25);
		ComboBoxModel<String> modeloTipoEvento = new DefaultComboBoxModel<>(getTipos());
		tipo_comboBox.setModel(modeloTipoEvento);
		add(tipo_comboBox);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(398, 110, 150, 25);
		add(dateChooser);

		modalidad_comboBox = new JComboBox<String>();
		modalidad_comboBox.setBounds(608, 110, 141, 25);
		ComboBoxModel<String> modeloModalidad = new DefaultComboBoxModel<>(getModalidades());
		modalidad_comboBox.setModel(modeloModalidad);
		add(modalidad_comboBox);

		itr_comboBox = new JComboBox<String>();
		itr_comboBox.setBounds(809, 110, 141, 25);
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(getItrs());
		itr_comboBox.setModel(modeloItr);
		add(itr_comboBox);

		estado_comboBox = new JComboBox<String>();
		estado_comboBox.setBounds(1010, 110, 130, 25);
		estado_comboBox.addItem("TODOS");
		estado_comboBox.addItem("FINALIZADO");
		estado_comboBox.addItem("CORRIENTE");
		estado_comboBox.addItem("FUTURO");
		add(estado_comboBox);
		
		JLabel lblTitulo = new JLabel("LISTADO DE EVENTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(494, 30, 275, 25);
		add(lblTitulo);
		
		fichaEvento = new PanelFichaEvento();
		fichaEvento.setBounds(123,329,1017,332);
		fichaEvento.setBorder(new BevelBorder(BevelBorder.LOWERED));
		fichaEvento.setBackground(Color.LIGHT_GRAY);
		fichaEvento.setVisible(false);
		add(fichaEvento);
		
		try {
			construirTabla(ListaEventos.getListaStringListado(),titulos);
		} catch (NamingException | ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		scrollTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = listaEventosTable.rowAtPoint(e.getPoint());
				int columna = listaEventosTable.columnAtPoint(e.getPoint());
				
				System.out.println(fila);
				
				fichaEvento.setVisible(true);
			}
		});
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
