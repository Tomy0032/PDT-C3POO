package componentes;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import interfaz.Aplicacion;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelListaSolicitudesDeConstancias extends JPanel{

	private JTextField filtroUsuario;
	private JComboBox<String> filtroEstado;
	private JTable listaSolicitudesConstancias;
	private JLabel labelTitulo;
	private JLabel labelFiltroEstado;
	private JLabel labelFiltroUsuario;

	
	public PanelListaSolicitudesDeConstancias() {
		
		setLayout(null);
		
		filtroEstado = new JComboBox<String>();
		filtroEstado.setBounds(66,100,150,25);
		add(filtroEstado);
		
		if(Aplicacion.getTipoUsuario() == null || Aplicacion.getTipoUsuario().equalsIgnoreCase("ANALISTA")) {
			
			labelFiltroUsuario = new JLabel("Filtrar por usuario");
			labelFiltroUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			labelFiltroUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelFiltroUsuario.setBounds(529, 65, 150, 25);
			add(labelFiltroUsuario);
			
			filtroUsuario = new JTextField();
			filtroUsuario.setBounds(529,100,150,25);
			add(filtroUsuario);
		}
		
		
		listaSolicitudesConstancias = new JTable();
		listaSolicitudesConstancias.setBounds(66,135,613,100);
		listaSolicitudesConstancias.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(listaSolicitudesConstancias);
		
		labelTitulo = new JLabel("LISTA DE SOLICITUDES DE CONSTANCIAS");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(250, 10, 348, 25);
		add(labelTitulo);
		
		labelFiltroEstado = new JLabel("Filtrar por estado");
		labelFiltroEstado.setHorizontalAlignment(SwingConstants.CENTER);
		labelFiltroEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelFiltroEstado.setBounds(66, 65, 150, 25);
		add(labelFiltroEstado);
		
		
		add(labelFiltroUsuario);
		
		
		
		

	}
}
