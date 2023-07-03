package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import componentes.PanelListaSolicitudesDeConstancias;
import componentes.PanelEditarMisDatos;
import componentes.PanelListadoEventos;
import componentes.PanelNuevaConstancia;
import componentes.PanelNuevoEvento;
import componentes.PanelListasEvento;
import componentes.PanelEditarUsuario;
import componentes.PanelListadoUsuarios;
import componentes.PanelNuevoReclamo;
import componentes.PanelListaReclamos;
import controladores.ControlBotonesAplicacion;
import controladores.Control_username_aplicacion;
import interfaces.Layout_para_aplicacion;
import interfaces.Layout_para_botonera_aplicacion;
import utilidades.ModeloTabla;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class Aplicacion extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel btn_container_panel;
	private static JButton btn_usuarios;
	private static JButton btn_eventos;
	private static JButton btn_constancias;
	private static JButton btn_reclamos;
	private static JButton btn_mant_listas;
	private static JButton btn_cerrarSesion;
	private JPanel panel_usuarios;
	private JPanel panel_eventos;
	private JPanel panel_constancias;
	private JPanel panel_reclamos;
	private static JPanel card_container_panel;
	private static JLabel lblUserName;
	private JLabel lbl_estado;
	private JPanel panel_editar_usuario;
	private static JLabel lblUserType;
	private static JLabel lbl_generacion;
	private static Usuario usuario;
	private static String tipoUsuario;
	
	private static String[] titulos = new String[] {
			"Estado", "Nombre de usuario", "Usuario", "ITR", "Generaci�n", "", "", "", ""};
	private static JTable tablaUsuarios;
	private static ModeloTabla modelo;
	private static JScrollPane scrollPaneTabla;

	public Aplicacion(Long idUsuario) {

		if(idUsuario!=0L) {
			setUsuario(idUsuario);
		}
		cerrar();
//		getContentPane().setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JPanel panel_principal = new JPanel();
		panel_principal.setLayout(new Layout_para_aplicacion());
		add(panel_principal);

		btn_container_panel = new JPanel();
		panel_principal.add(btn_container_panel);
		btn_container_panel.setLayout(new Layout_para_botonera_aplicacion());

		btn_usuarios = new JButton("USUARIOS");
		btn_usuarios.setMinimumSize(new Dimension(120, 23));
		btn_usuarios.setMaximumSize(new Dimension(120, 23));
		btn_usuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_usuarios);
		btn_usuarios.addActionListener(new ControlBotonesAplicacion());

		btn_eventos = new JButton("EVENTOS");
		btn_eventos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_eventos);
		btn_eventos.addActionListener(new ControlBotonesAplicacion());

		btn_constancias = new JButton("CONSTANCIAS");
		btn_constancias.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_constancias);
		btn_constancias.addActionListener(new ControlBotonesAplicacion());

		btn_reclamos = new JButton("RECLAMOS");
		btn_reclamos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_reclamos);
		btn_reclamos.addActionListener(new ControlBotonesAplicacion());

		btn_mant_listas = new JButton("MANTENIMIENTO DE LISTAS");
		btn_mant_listas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_container_panel.add(btn_mant_listas);
		btn_mant_listas.addActionListener(new ControlBotonesAplicacion());
		
		btn_cerrarSesion = new JButton("CERRAR SESION");
		btn_cerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_cerrarSesion);
		
//----------------------------------------------------------------------------------------		
		card_container_panel = new JPanel();
		panel_principal.add(card_container_panel);
		card_container_panel.setLayout(new CardLayout(0, 0));


		panel_usuarios = new JPanel();
		card_container_panel.add(panel_usuarios,"Panel de Usuarios");
		
		JTabbedPane tabbedPaneUsuarios = new JTabbedPane(JTabbedPane.TOP);
		panel_usuarios.setLayout(new BorderLayout());
		panel_usuarios.add(tabbedPaneUsuarios);
		
		PanelListadoUsuarios panelListadoUsuarios = new PanelListadoUsuarios();
		tabbedPaneUsuarios.addTab("Listado de Usuarios", panelListadoUsuarios);
			
		
		JTabbedPane tabbedPaneEventos = new JTabbedPane(JTabbedPane.TOP);
		panel_eventos.setLayout(new BorderLayout());
		panel_eventos.add(tabbedPaneEventos);
		
		panel_eventos = new JPanel();
		card_container_panel.add(panel_eventos,"Panel de Eventos");			
			
		PanelNuevoEvento panelNuevoEvento = new PanelNuevoEvento();
		tabbedPaneEventos.addTab("Nuevo Evento", panelNuevoEvento);

		PanelListadoEventos panelListarEventos = new PanelListadoEventos();
		tabbedPaneEventos.addTab("Listar Eventos", panelListarEventos);
		
		PanelListasEvento panelListasEvento = new PanelListasEvento();
		tabbedPaneEventos.addTab("Mantenimiento de listas auxiliares", panelListasEvento);

		PanelEditarMisDatos panel_editar_mis_datos = new PanelEditarMisDatos();
		card_container_panel.add(panel_editar_mis_datos, "Panel Editar mis datos");
		
		PanelEditarUsuario panel_editar_usuario = new PanelEditarUsuario();
		card_container_panel.add(panel_editar_usuario, "Panel Editar usuario");

		
		panel_constancias = new JPanel();
		panel_constancias.setLayout(new BorderLayout());
		card_container_panel.add(panel_constancias, "Panel de Constancias");

		JTabbedPane tabbedPaneConstancia;
		
		tabbedPaneConstancia = new JTabbedPane(JTabbedPane.TOP);
		panel_constancias.add(tabbedPaneConstancia);
		
		if (tipoUsuario.equalsIgnoreCase("ESTUDIANTE")) {
			PanelNuevaConstancia nueva_constancia = new PanelNuevaConstancia();
			tabbedPaneConstancia.add("Pedir Constancia",nueva_constancia);
		}
		PanelListaSolicitudesDeConstancias listaSolicitudes = new PanelListaSolicitudesDeConstancias();
		tabbedPaneConstancia.add("Lista solicitudes constancias",listaSolicitudes);
		
		
		panel_reclamos = new JPanel();
		panel_reclamos.setLayout(new BorderLayout());
		card_container_panel.add(panel_reclamos, "Panel de Reclamos");
		
		JTabbedPane tabbedPaneReclamos = new JTabbedPane(JTabbedPane.TOP);
		panel_reclamos.setLayout(new BorderLayout());
		panel_reclamos.add(tabbedPaneReclamos);
		
		if(tipoUsuario.equalsIgnoreCase("ESTUDIANTE")) {
			PanelNuevoReclamo nuevoReclamo = new PanelNuevoReclamo();
			tabbedPaneReclamos.add("Enviar Reclamo",nuevoReclamo);
		}
		PanelListaReclamos listaReclamos = new PanelListaReclamos();
		tabbedPaneReclamos.add("Lista Reclamos",listaReclamos);
		
		
//----------------------------------------------------------		
		
		if(idUsuario!=0L) {
			lblUserName = new JLabel(usuario.getNombreUsuario());
		}
		lblUserName = new JLabel("admin");
		lblUserName.setBounds(0, 233, 130, 26);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setOpaque(true);
		lblUserName.addMouseListener(new Control_username_aplicacion());
		btn_container_panel.add(lblUserName);
		
		
		btn_reclamos.addActionListener(new ControlBotonesAplicacion());


		lblUserType = new JLabel(getTipoUsuario());
		lblUserType.setBounds(0, 196, 130, 26);
		btn_container_panel.add(lblUserType);
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserType.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_arriba = new JPanel();
		panel_arriba.setBackground(new Color(0, 0, 0));
		panel_principal.add(panel_arriba);
		panel_arriba.setLayout(null);
		PanelFondo logo = new PanelFondo("/recursos/imagenes/09-Isotipo-1.png");
		PanelFondo logo_1 = new PanelFondo("/recursos/imagenes/banner2_utec.png");
		logo.setBounds(11, 11, 80, 80);
		logo_1.setBounds(101, 11, 186, 82);
		panel_arriba.add(logo);
		panel_arriba.add(logo_1);

		btn_reclamos.addActionListener(new ControlBotonesAplicacion());
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registrarse.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public static JButton getBtn_usuarios() {
		return btn_usuarios;
	}

	public static JButton getBtn_eventos() {
		return btn_eventos;
	}

	public static JButton getBtnConstancias() {
		return btn_constancias;
	}

	public static JButton getBtn_constancias() {
		return btn_constancias;
	}

	public static void setBtn_constancias(JButton btn_constancias) {
		Aplicacion.btn_constancias = btn_constancias;
	}

	public static JButton getBtn_reclamos() {
		return btn_reclamos;
	}

	public static void setBtn_reclamos(JButton btn_reclamos) {
		Aplicacion.btn_reclamos = btn_reclamos;
	}

	public static JButton getBtn_mant_listas() {
		return btn_mant_listas;
	}

	public static void setBtn_mant_listas(JButton btn_mant_listas) {
		Aplicacion.btn_mant_listas = btn_mant_listas;
	}

	public static JButton getBtn_cerrarSesion() {
		return btn_cerrarSesion;
	}

	public static void setBtn_cerrarSesion(JButton btn_cerrarSesion) {
		Aplicacion.btn_cerrarSesion = btn_cerrarSesion;
	}

	public JPanel getPanel_usuarios() {
		return panel_usuarios;
	}

	public void setPanel_usuarios(JPanel panel_usuarios) {
		this.panel_usuarios = panel_usuarios;
	}

	public JPanel getPanel_eventos() {
		return panel_eventos;
	}

	public void setPanel_eventos(JPanel panel_eventos) {
		this.panel_eventos = panel_eventos;
	}

	public JPanel getPanel_constancias() {
		return panel_constancias;
	}

	public void setPanel_constancias(JPanel panel_constancias) {
		this.panel_constancias = panel_constancias;
	}

	public JPanel getPanel_reclamos() {
		return panel_reclamos;
	}

	public void setPanel_reclamos(JPanel panel_reclamos) {
		this.panel_reclamos = panel_reclamos;
	}

	public JLabel getLbl_estado() {
		return lbl_estado;
	}

	public void setLbl_estado(JLabel lbl_estado) {
		this.lbl_estado = lbl_estado;
	}

	public JPanel getPanel_editar_usuario() {
		return panel_editar_usuario;
	}

	public void setPanel_editar_usuario(JPanel panel_editar_usuario) {
		this.panel_editar_usuario = panel_editar_usuario;
	}

	public static JLabel getLblUserType() {
		return lblUserType;
	}

	public static void setLblUserType(JLabel lblUserType) {
	}

	public static String[] getTitulos() {
		return titulos;
	}

	public static void setTitulos(String[] titulos) {
		Aplicacion.titulos = titulos;
	}

	public static ModeloTabla getModelo() {
		return modelo;
	}

	public static void setModelo(ModeloTabla modelo) {
		Aplicacion.modelo = modelo;
	}

	public static JScrollPane getScrollPaneTabla() {
		return scrollPaneTabla;
	}

	public static void setScrollPaneTabla(JScrollPane scrollPaneTabla) {
		Aplicacion.scrollPaneTabla = scrollPaneTabla;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setBtn_container_panel(JPanel btn_container_panel) {
		Aplicacion.btn_container_panel = btn_container_panel;
	}

	public static void setBtn_usuarios(JButton btn_usuarios) {
		Aplicacion.btn_usuarios = btn_usuarios;
	}

	public static void setBtn_eventos(JButton btn_eventos) {
		Aplicacion.btn_eventos = btn_eventos;
	}

	public static void setCard_container_panel(JPanel card_container_panel) {
		Aplicacion.card_container_panel = card_container_panel;
	}

	public static void setLblUserName(JLabel lblUserName) {
		Aplicacion.lblUserName = lblUserName;
	}

	public static void setLbl_generacion(JLabel lbl_generacion) {
		Aplicacion.lbl_generacion = lbl_generacion;
	}

	public static void setUsuario(Usuario usuario) {
		Aplicacion.usuario = usuario;
	}

	public static void setTablaUsuarios(JTable tablaUsuarios) {
		Aplicacion.tablaUsuarios = tablaUsuarios;
	}

	public static JButton getBtnReclamos() {
		return btn_reclamos;
	}

	public static JPanel getCard_container_panel() {
		return card_container_panel;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static String getTipoUsuario() {
		return tipoUsuario;
	}

	public static void setTipoUsuario(String tipoUsuario) {
		Aplicacion.tipoUsuario = tipoUsuario;
	}

	public static JLabel getLbl_generacion() {
		return lbl_generacion;
	}

	public static JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public static void setUsuario(Long idUsuario) {
		UsuarioBeanRemote usuarioBean = null;
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Usuario user = null;
		try {
			user = usuarioBean.find(idUsuario);
		} catch (ServicesException e) {
			e.printStackTrace();
		}

		Aplicacion.usuario = user;
		setTipoUsuario(user.getTipoUsuario().getNombre());
	}

	private void cerrar() {

		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				new Login();
			}
		});

	}

	public static JLabel getLblUserName() {
		return lblUserName;
	}
	
	public static JPanel getBtn_container_panel() {
		return btn_container_panel;
	}

	public static void setUsuario2(Usuario usuario2) {
		usuario = usuario2;
	}
	
}
