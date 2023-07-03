package componentes;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import interfaz.Aplicacion;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class PanelListaReclamos extends JPanel{
	private JTable table;
	private JTextField textField;
	private PanelNuevoReclamo panelEditarReclamo;
	private JTextArea areaAcciones;
	
	public PanelListaReclamos() {
		setLayout(null);
		
		JLabel lblTituloPanel = new JLabel("LISTA DE RECLAMOS");
		lblTituloPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloPanel.setBounds(479, 29, 188, 27);
		add(lblTituloPanel);
		
		table = new JTable();
		table.setBounds(10, 128, 935, 88);
		add(table);
		
		JComboBox filtroEstado = new JComboBox();
		filtroEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		filtroEstado.setBounds(10, 97, 131, 21);
		add(filtroEstado);
		
		JLabel lblFiltroEstado = new JLabel("Estado");
		lblFiltroEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltroEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiltroEstado.setBounds(10, 66, 131, 21);
		add(lblFiltroEstado);
		
		if(Aplicacion.getTipoUsuario().equalsIgnoreCase("ANALISTA")) {
		
			JLabel lblFiltroUsuario = new JLabel("Usuario");
			lblFiltroUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblFiltroUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblFiltroUsuario.setBounds(351, 66, 131, 21);
			add(lblFiltroUsuario);
			
			textField = new JTextField();
			textField.setBounds(351, 97, 131, 21);
			add(textField);
			textField.setColumns(10);
		}
		
		
		if(Aplicacion.getTipoUsuario().equalsIgnoreCase("ESTUDIANTE")) {
			panelEditarReclamo = new PanelNuevoReclamo();
			panelEditarReclamo.setBounds(10,226,935,406);
			panelEditarReclamo.setTitulo("EDITAR RECLAMO");
			add(panelEditarReclamo);
		}
		
		if(Aplicacion.getTipoUsuario().equalsIgnoreCase("ANALISTA")) {
			JLabel lblAcciones = new JLabel("Acciones ");
			lblAcciones.setHorizontalAlignment(SwingConstants.CENTER);
			lblAcciones.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAcciones.setBounds(10, 226, 131, 25);
			add(lblAcciones);
			
			areaAcciones = new JTextArea();
			areaAcciones.setLineWrap(true);
			JScrollPane scrollAcciones = new JScrollPane(areaAcciones);
			scrollAcciones.setBounds(151, 226, 795, 200);
			add(scrollAcciones);
		}
		
	}
}
