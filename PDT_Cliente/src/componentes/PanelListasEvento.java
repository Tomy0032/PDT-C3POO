package componentes;

import java.awt.Font;

import javax.naming.NamingException;

import com.exception.ServicesException;
import com.toedter.calendar.JDateChooser;

import controladores.ControlBotonCrearEvento;
import controladores.Control_longit_min_evento;
import datos.CrearEstadoEvento;
import interfaces.ControlCampo;
import listas.ListaEstadosEvento;
import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.ModeloTablaEvento;
import utilidades.Utilidades;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelListasEvento extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ModeloTablaEvento modelo;
	private JTextField txtEstadoEvento;
	private JButton btnEstadoEvento;
	private static JTable tableEstadoEvento;
	private JTextField textModalidadEvento;
	private Object[][] estados;
	private Object[][] modalidades;
	private static JTable tableModalidadEvento;
	private static JScrollPane scrollPaneEstadoEvento;
	private static JScrollPane scrollPaneModalidadEvento;
	private final static String[] TITULOS_ESTADO = {"Nombre","Activo"};
	private static JLabel lblAvisoEstado;

	public PanelListasEvento() {
		setLayout(null);
		
		JLabel lblTituloEstadoEvento = new JLabel("Estado de Evento");
		lblTituloEstadoEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTituloEstadoEvento.setBounds(243, 69, 150, 13);
		add(lblTituloEstadoEvento);
		
		txtEstadoEvento = new JTextField();
		txtEstadoEvento.setBounds(243, 100, 220, 22);
		add(txtEstadoEvento);
		txtEstadoEvento.setColumns(10);
		
		btnEstadoEvento = new JButton("Agregar");
		btnEstadoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEstadoEvento.getText() == null || txtEstadoEvento.getText().isEmpty()) {
					lblAvisoEstado.setText("Debe ingresar un valor");
				}else {
					try {
						CrearEstadoEvento.crear(txtEstadoEvento.getText());
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnEstadoEvento.setBounds(479, 99, 85, 22);
		add(btnEstadoEvento);
		
		scrollPaneEstadoEvento = new JScrollPane();
		scrollPaneEstadoEvento.setBounds(623, 97, 370, 208);
		add(scrollPaneEstadoEvento);
		
		tableEstadoEvento = new JTable();
		scrollPaneEstadoEvento.setViewportView(tableEstadoEvento);
		
		JLabel lblTituloModalidadEvento = new JLabel("Estado de Evento");
		lblTituloModalidadEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTituloModalidadEvento.setBounds(243, 349, 150, 13);
		add(lblTituloModalidadEvento);
		
		textModalidadEvento = new JTextField();
		textModalidadEvento.setColumns(10);
		textModalidadEvento.setBounds(243, 380, 220, 22);
		add(textModalidadEvento);
		
		JButton btnModalidadEvento = new JButton("Agregar");
		btnModalidadEvento.setBounds(479, 379, 85, 22);
		add(btnModalidadEvento);
		
		scrollPaneModalidadEvento = new JScrollPane();
		scrollPaneModalidadEvento.setBounds(623, 377, 370, 208);
		add(scrollPaneModalidadEvento);
		
		tableModalidadEvento = new JTable();
		scrollPaneModalidadEvento.setViewportView(tableModalidadEvento);
		
		lblAvisoEstado = new JLabel("");
		lblAvisoEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvisoEstado.setForeground(Color.RED);
		lblAvisoEstado.setBounds(243, 166, 314, 13);
		add(lblAvisoEstado);
				
		estados = ListaEstadosEvento.getListaStringListado();
		modalidades = ListaModalidades.getListaStringListado();
		
		construirTablaEstado(estados,TITULOS_ESTADO);
		construirTablaModalidad(modalidades,TITULOS_ESTADO);
	}
	
	public static void construirTablaModalidad(Object[][] datos, String[] titulos) {
		
		modelo = new ModeloTablaEvento(datos,titulos);
		tableModalidadEvento.setModel(modelo);
		
		
		tableModalidadEvento.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));		
		tableModalidadEvento.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("check"));

		tableModalidadEvento.getTableHeader().setReorderingAllowed(false);
		tableModalidadEvento.setRowHeight(25);
		
		tableModalidadEvento.getColumnModel().getColumn(0).setPreferredWidth(800);
		
		tableModalidadEvento.getColumnModel().getColumn(0).setResizable(false);
		tableModalidadEvento.getColumnModel().getColumn(1).setResizable(false);
		
		JCheckBox check = new JCheckBox();
		
		DefaultCellEditor cellEditor = new DefaultCellEditor(check);
		tableModalidadEvento.getColumnModel().getColumn(1).setCellEditor(cellEditor);
		
		JTableHeader header = tableModalidadEvento.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla());
		
		scrollPaneModalidadEvento.setViewportView(tableModalidadEvento);
		
	}
	
	public static void construirTablaEstado(Object[][] datos, String[] titulos) {
		
		modelo = new ModeloTablaEvento(datos,titulos);
		tableEstadoEvento.setModel(modelo);
		
		
		tableEstadoEvento.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));		
		tableEstadoEvento.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("check"));

		tableEstadoEvento.getTableHeader().setReorderingAllowed(false);
		tableEstadoEvento.setRowHeight(25);
		
		tableEstadoEvento.getColumnModel().getColumn(0).setPreferredWidth(800);
		
		tableEstadoEvento.getColumnModel().getColumn(0).setResizable(false);
		tableEstadoEvento.getColumnModel().getColumn(1).setResizable(false);
		
		JCheckBox check = new JCheckBox();
		
		DefaultCellEditor cellEditor = new DefaultCellEditor(check);
		tableEstadoEvento.getColumnModel().getColumn(1).setCellEditor(cellEditor);
		
		JTableHeader header = tableEstadoEvento.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla());
		
		scrollPaneEstadoEvento.setViewportView(tableEstadoEvento);
		
	}

	public static String[] getTitulosEstado() {
		return TITULOS_ESTADO;
	}

	public static void setAviso(String string) {
		lblAvisoEstado.setText(string);		
	}
	
	
}