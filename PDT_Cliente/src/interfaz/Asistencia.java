package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import java.util.ArrayList;
import java.util.List;

import com.entities.ConvocatoriaAsistencia;
import com.entities.Departamento;
import com.entities.Evento;

import controladores.ControlBotonAsistencia;
import listas.ListaDepartamentos;
import listas.ListaLocalidades;
import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTablaAsistencia;
import utilidades.Utilidades;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Asistencia extends JFrame {

	private static ModeloTablaAsistencia modeloTablaEstudiantes;
	private JPanel contentPane;
	private JTextField txtTituloEvento;
	private JLabel lblTituloEvento;
	private static JTable tableEstudiantes;
	private static JScrollPane scrollPaneTableEstudiantes;
	private JButton btnGuardar;
	private static final String[] TITULOS = {"Estudiante","Asistencia","Nota"}; 
	private static Evento evento;
	
	public static void setEvento(Evento evento) {
		Asistencia.evento = evento;
	}
	
	public static Evento getEvento() {
		return Asistencia.evento;
	}

	public static JTable getTabla() {
		return Asistencia.tableEstudiantes;
	}
	
	public Asistencia(Evento evento) {
		
		cerrar();
		
		setEvento(evento);
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Asistencia.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    setBounds(new Rectangle((width-777)/2, (height-500)/2, 777, 500));
		setResizable(false);
		setTitle("Asistencia a evento");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Asistencia a evento");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setFocusable(false);
		lblTitulo.setBackground(new Color(0, 178, 240));
		lblTitulo.setBounds(0, 24, 296, 32);
		contentPane.add(lblTitulo);
		
		JPanel panelArriba = new JPanel();
		panelArriba.setLayout(null);
		panelArriba.setBounds(new Rectangle(0, 0, 600, 100));
		panelArriba.setBackground(Color.BLACK);
		panelArriba.setBounds(0, 0, 763, 24);
		contentPane.add(panelArriba);
		
		JLabel lblTitulo2 = new JLabel("");
		lblTitulo2.setOpaque(true);
		lblTitulo2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo2.setForeground(Color.WHITE);
		lblTitulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo2.setFocusable(false);
		lblTitulo2.setBackground(new Color(192, 192, 192));
		lblTitulo2.setBounds(293, 24, 470, 32);
		contentPane.add(lblTitulo2);
		
		lblTituloEvento = new JLabel("Evento:");
		lblTituloEvento.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTituloEvento.setBackground(new Color(192, 192, 192));
		lblTituloEvento.setBounds(44, 80, 45, 13);
		contentPane.add(lblTituloEvento);
		
		txtTituloEvento = new JTextField();
		txtTituloEvento.setEditable(false);
		txtTituloEvento.setBounds(99, 77, 599, 19);
		contentPane.add(txtTituloEvento);
		txtTituloEvento.setColumns(10);
		txtTituloEvento.setText(evento.getNombre());
		
		scrollPaneTableEstudiantes = new JScrollPane();
		scrollPaneTableEstudiantes.setBounds(44, 122, 654, 277);
		contentPane.add(scrollPaneTableEstudiantes);
		
		tableEstudiantes = new JTable();
		tableEstudiantes.setCellSelectionEnabled(true);
		scrollPaneTableEstudiantes.setViewportView(tableEstudiantes);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(596, 420, 102, 21);
		btnGuardar.addActionListener(new ControlBotonAsistencia());
		contentPane.add(btnGuardar);
		setVisible(true);
		
		construirTablaEstudiantes(listarConvocatoria(), TITULOS);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public static void construirTablaEstudiantes(Object[][] datos, String[] titulos) {
		
		modeloTablaEstudiantes = new ModeloTablaAsistencia(datos,titulos);
		tableEstudiantes.setModel(modeloTablaEstudiantes);
		
		tableEstudiantes.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldas("texto"));		
		tableEstudiantes.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas("asistencia"));
		tableEstudiantes.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("nota"));
		
		
		JComboBox<String> asistencia = new JComboBox<>();
		asistencia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {				
				if (e.getStateChange() == 2) {					
					String nombre = (String) asistencia.getSelectedItem();
					tableEstudiantes.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldas(nombre.toLowerCase()));
				}
			}
		});
        asistencia.addItem("ASISTENCIA");
        asistencia.addItem("MEDIA ASISTENCIA");
        asistencia.addItem("AUSENCIA");
        asistencia.addItem("AUSENCIA JUSTIFICADA");
		DefaultCellEditor cellEditor = new DefaultCellEditor(asistencia);
		tableEstudiantes.getColumnModel().getColumn(1).setCellEditor(cellEditor);
		
		tableEstudiantes.getTableHeader().setReorderingAllowed(false);
		tableEstudiantes.setRowHeight(25);
		
		tableEstudiantes.getColumnModel().getColumn(1).setPreferredWidth(30);
		tableEstudiantes.getColumnModel().getColumn(2).setPreferredWidth(40);
		
		JTableHeader header = tableEstudiantes.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla());
		
		scrollPaneTableEstudiantes.setViewportView(tableEstudiantes);
		
	}
	
	public Object[][] listarConvocatoria() {
		
		List<ConvocatoriaAsistencia> convocatorias = evento.getConvocatoriasAsistencias();
		
		ArrayList<String> linea = null;
		ArrayList<String[]> contenedor = new ArrayList<>();
							
		for(ConvocatoriaAsistencia c : convocatorias) {
						
			linea = new ArrayList<>();
			linea.add(c.getEstudiante().getDocumento().getCaracteres() + " - " + c.getEstudiante().getNombre1() + " " + c.getEstudiante().getApellido1());
			if(c.getAsistencia() == null) {
				linea.add("ASISTENCIA");
			}else {
				linea.add(c.getAsistencia());
			}
			if(c.getCalificacion()!=null) {
				linea.add(c.getCalificacion().toString());
			}else {
				linea.add("0");
			}
			contenedor.add(linea.toArray(new String[0]));
		}
		
		String[][] convocatoriasDatos = (String[][]) contenedor.toArray(new String[0][]);
				
		return convocatoriasDatos;
		
	}
	
	private void cerrar() {
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {		
				dispose();
			}
		});
		
	}

}
