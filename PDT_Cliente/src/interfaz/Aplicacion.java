package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.JTableHeader;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import componentes.PanelListaSolicitudesDeConstancias;
import componentes.PanelEditarUsuario;
import componentes.PanelListadoEventos;
import componentes.PanelNuevaConstancia;
import componentes.PanelNuevoEvento;
import controladores.ControlBotonesAplicacion;
import controladores.Control_username_aplicacion;
import datos.OperacionUsuario;
import interfaces.Layout_para_aplicacion;
import interfaces.Layout_para_botonera_aplicacion;
import listas.ListaItrs;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

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

public class Aplicacion extends JFrame implements MouseListener{
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
	private static JLabel lbl_generacion;
	private static JComboBox<String> combo_filtro_tipoUsu;
	private static JComboBox<String> combo_filtro_itr;
	private static JComboBox<Object> combo_filtro_Generac;
	private static JComboBox<String> combo_filtro_estado;
	private static Usuario usuario;
	private static String tipoUsuario;
	
	private static String[] titulos = new String[] {
			"Estado", "Nombre de usuario", "Usuario", "ITR", "Generación", "", "", "", ""};
	private static JTable tablaUsuarios;
	private static ModeloTabla modelo;
	private static JScrollPane scrollPaneTabla;

	public Aplicacion(Long idUsuario) throws NamingException, ServicesException {

		if(idUsuario!=0L) {
			setUsuario(idUsuario);
		}
		cerrar();
		//getContentPane().setLayout(null);
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
		panel_usuarios.setBackground(new Color(255, 255, 255));
		panel_usuarios.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_usuarios, "Panel de Usuarios");
		panel_usuarios.setLayout(null);
				
		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(60, 146, 780, 400);
		panel_usuarios.add(scrollPaneTabla);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setBackground(Color.WHITE);
		tablaUsuarios.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tablaUsuarios.addMouseListener(this);
		tablaUsuarios.setOpaque(false);
		
		scrollPaneTabla.setViewportView(tablaUsuarios);
		
		JLabel lbl_filtros = new JLabel("Filtrar por:");
		lbl_filtros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_filtros.setBounds(116, 73, 61, 22);
		panel_usuarios.add(lbl_filtros);

		JLabel lbl_tipo_usuario = new JLabel("Tipo Usuario");
		lbl_tipo_usuario.setBounds(205, 73, 110, 22);
		panel_usuarios.add(lbl_tipo_usuario);

		lbl_generacion = new JLabel("Generaci\u00F3n");
		lbl_generacion.setBounds(575, 73, 70, 22);
		lbl_generacion.setVisible(false);
		panel_usuarios.add(lbl_generacion);

		JLabel lbl_itr = new JLabel("ITR");
		lbl_itr.setBounds(325, 73, 130, 22);
		panel_usuarios.add(lbl_itr);

		lbl_estado = new JLabel("Estado");
		lbl_estado.setBounds(465, 73, 100, 22);
		panel_usuarios.add(lbl_estado);

		combo_filtro_tipoUsu = new JComboBox<String>();
		combo_filtro_tipoUsu.setBounds(205, 100, 110, 22);
		combo_filtro_tipoUsu.addItem("TODOS");
		combo_filtro_tipoUsu.addItem("ANALISTA");
		combo_filtro_tipoUsu.addItem("ESTUDIANTE");
		combo_filtro_tipoUsu.addItem("TUTOR");
		combo_filtro_tipoUsu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_usuarios.add(combo_filtro_tipoUsu);

		combo_filtro_itr = new JComboBox<String>();
		combo_filtro_itr.setBounds(325, 100, 130, 22);
		combo_filtro_itr.setModel(new DefaultComboBoxModel<>(getItrs()));
		combo_filtro_itr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_usuarios.add(combo_filtro_itr);

		combo_filtro_Generac = new JComboBox<Object>();
		combo_filtro_Generac.setBounds(575, 100, 70, 22);
		combo_filtro_Generac.setModel(new DefaultComboBoxModel<>(getGeneraciones()));
		combo_filtro_Generac.setVisible(false);
		combo_filtro_Generac.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_usuarios.add(combo_filtro_Generac);

		combo_filtro_estado = new JComboBox<String>();
		combo_filtro_estado.setBounds(465, 100, 100, 22);
		combo_filtro_estado.addItem("TODOS");
		combo_filtro_estado.addItem("SIN VALIDAR");
		combo_filtro_estado.addItem("ACTIVO");
		combo_filtro_estado.addItem("ELIMINADO");
		combo_filtro_estado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_usuarios.add(combo_filtro_estado);

		
		
		panel_eventos = new JPanel();
		card_container_panel.add(panel_eventos,"Panel de Eventos");

		JTabbedPane tabbedPaneEventos = new JTabbedPane(JTabbedPane.TOP);
		panel_eventos.setLayout(new BorderLayout());
		panel_eventos.add(tabbedPaneEventos);
		
		PanelNuevoEvento panelNuevoEvento = new PanelNuevoEvento();
		tabbedPaneEventos.addTab("Nuevo Evento", panelNuevoEvento);

		PanelListadoEventos panelListarEventos = new PanelListadoEventos();
		tabbedPaneEventos.addTab("Listar Eventos", panelListarEventos);

		PanelEditarUsuario panel_editar_usuario = new PanelEditarUsuario();
		card_container_panel.add(panel_editar_usuario, "Panel Editar usuario");

		
		panel_constancias = new JPanel();
		panel_constancias.setLayout(new BorderLayout());
		card_container_panel.add(panel_constancias, "Panel de Constancias");

		JTabbedPane tabbedPaneConstancia = new JTabbedPane(JTabbedPane.TOP);
		panel_constancias.add(tabbedPaneConstancia);
		
		PanelNuevaConstancia nueva_constancia = new PanelNuevaConstancia();
		tabbedPaneConstancia.add("Pedir Constancia",nueva_constancia);
		
//		PanelListaSolicitudesDeConstancias listaSolicitudes = new PanelListaSolicitudesDeConstancias();
//		tabbedPaneConstancia.add("Lista solicitudes constancias",listaSolicitudes);
		
		panel_reclamos = new JPanel();
		panel_reclamos.setBackground(new Color(64, 0, 64));
		panel_reclamos.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_reclamos, "Panel de Reclamos");

		
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


		JLabel lblUserType = new JLabel(getTipoUsuario());
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
		
		construirTabla(ListaUsuarios.getListaStringListado(),titulos);

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

	public static JComboBox<String> getCombo_filtro_tipoUsu() {
		return combo_filtro_tipoUsu;
	}

	public static JComboBox<String> getCombo_filtro_itr() {
		return combo_filtro_itr;
	}

	public static JComboBox<Object> getCombo_filtro_Generac() {
		return combo_filtro_Generac;
	}

	public static JComboBox<String> getCombo_filtro_estado() {
		return combo_filtro_estado;
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

	public Object[] getGeneraciones() {

		int anio = 2014;
		LocalDate current_date = LocalDate.now();
		int actual = current_date.getYear();

		List<String> generaciones = new ArrayList<>();
		generaciones.add("TODAS");
		while (anio < actual) {
			generaciones.add(Integer.toString(anio));
			anio++;
		}

		return (Object[]) generaciones.toArray();

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
	
	private void filtros(ItemEvent e) throws ServicesException, NamingException {
		if (e.getStateChange() == 2) {
			combo_filtro_Generac.setVisible(false);
			switch(combo_filtro_tipoUsu.getSelectedItem().toString()) {
			case "ANALISTA":
				construirTabla(ListaUsuarios.getListaAnalistasStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
				break;
			case "ESTUDIANTE":
				combo_filtro_Generac.setVisible(true);
				construirTabla(ListaUsuarios.getListaEstudiantesStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString(),combo_filtro_Generac.getSelectedItem().toString()), titulos);
				break;
			case "TUTOR":
				construirTabla(ListaUsuarios.getListaTutoresStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);				
				break;
			case "TODOS":
				construirTabla(ListaUsuarios.getListaStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
				break;
			}
		}
	}
	
	public static void filtros() throws ServicesException, NamingException {
		combo_filtro_Generac.setVisible(false);
		switch(combo_filtro_tipoUsu.getSelectedItem().toString()) {
		case "ANALISTA":
			construirTabla(ListaUsuarios.getListaAnalistasStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
			break;
		case "ESTUDIANTE":
			combo_filtro_Generac.setVisible(true);
			construirTabla(ListaUsuarios.getListaEstudiantesStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString(),combo_filtro_Generac.getSelectedItem().toString()), titulos);
			break;
		case "TUTOR":
			construirTabla(ListaUsuarios.getListaTutoresStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);				
			break;
		case "TODOS":
			construirTabla(ListaUsuarios.getListaStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
			break;
		}
		
	}
	
	public static void construirTabla(Object[][] datos, String[] titulos) {
		
		modelo = new ModeloTabla(datos,titulos);
		tablaUsuarios.setModel(modelo);
		
		
		for(int i = 0; i < titulos.length - 2; i++) {
			tablaUsuarios.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}
		tablaUsuarios.getColumnModel().getColumn(Utilidades.GENERACION).setCellRenderer(new GestionCeldas("numerico"));		
		tablaUsuarios.getColumnModel().getColumn(Utilidades.VER).setCellRenderer(new GestionCeldas("icono"));
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ACTIVAR).setCellRenderer(new GestionCeldas("icono"));
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ELIMINAR).setCellRenderer(new GestionCeldas("icono"));
		tablaUsuarios.getColumnModel().getColumn(Utilidades.EDITAR).setCellRenderer(new GestionCeldas("icono"));

		tablaUsuarios.getTableHeader().setReorderingAllowed(false);
		tablaUsuarios.setRowHeight(25);
		
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ESTADO).setPreferredWidth(180);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.USUARIO).setPreferredWidth(300);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.TIPO).setPreferredWidth(250);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ITR).setPreferredWidth(360);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.GENERACION).setPreferredWidth(130);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.VER).setPreferredWidth(30);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ACTIVAR).setPreferredWidth(30);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ELIMINAR).setPreferredWidth(30);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.EDITAR).setPreferredWidth(30);
		
		JTableHeader header = tablaUsuarios.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla());
		
		scrollPaneTabla.setViewportView(tablaUsuarios);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = tablaUsuarios.rowAtPoint(e.getPoint());
		int columna = tablaUsuarios.columnAtPoint(e.getPoint());
				
		if (columna==Utilidades.VER) {
			
			try {
				OperacionUsuario.mostrar(fila);
			} catch (ServicesException | NamingException e1) {
				e1.printStackTrace();
			}
		}
		
		if (columna==Utilidades.ACTIVAR) {
			if(!tablaUsuarios.getValueAt(fila, columna).toString().equals("")) {
				try {
					OperacionUsuario.activar(fila);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if (columna==Utilidades.ELIMINAR) {
			
			try {
				OperacionUsuario.eliminar(fila);
			} catch (ServicesException | NamingException e1) {
				e1.printStackTrace();
			}
		}
		
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

	public static JLabel getLblUserName() {
		return lblUserName;
	}
	
	public static JPanel getBtn_container_panel() {
		return btn_container_panel;
	}

	
}
