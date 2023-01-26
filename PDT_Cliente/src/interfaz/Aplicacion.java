package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import controladores.ControlBotonesAplicacion;
import controladores.VisibilidadCampos;
import datos.ComprobarTipoUsuario;
import listas.ListaItrs;
import listas.ListaUsuarios;
import modelos.MyDefaultTableModel;
import renders.myeditor;
import renders.rendererButton;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;

public class Aplicacion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel btn_container_panel;
	private static JButton btn_usuarios;
	private static JButton btn_eventos;
	private static JButton btn_constancias;
	private static JButton btn_reclamos;
	private JPanel panel_usuarios;
	private JPanel panel_eventos;
	private JPanel panel_constancias;
	private JPanel panel_reclamos;
	private static JPanel card_container_panel;
	private JTable table;
	private JLabel lbl_estado;
	private static MyDefaultTableModel myModel;
	private static JLabel lbl_generacion;
	private static JComboBox<String> combo_filtro_tipoUsu;
	private static JComboBox<String> combo_filtro_itr;
	private static JComboBox<Object> combo_filtro_Generac;
	private static JComboBox<String> combo_filtro_estado;
	private static Usuario usuario;
	private static String tipoUsuario;

	public Aplicacion(Long idUsuario) {
		
		setUsuario(idUsuario);
		cerrar();
		getContentPane().setLayout(null);

		btn_container_panel = new JPanel();
		btn_container_panel.setBounds(0, 0, 152, 746);
		getContentPane().add(btn_container_panel);
		btn_container_panel.setLayout(null);

		btn_usuarios = new JButton("USUARIOS");
		btn_usuarios.setBounds(0, 5, 121, 25);
		btn_usuarios.setMinimumSize(new Dimension(120, 23));
		btn_usuarios.setMaximumSize(new Dimension(120, 23));
		btn_usuarios.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_usuarios);
		btn_usuarios.addActionListener(new ControlBotonesAplicacion());

		btn_eventos = new JButton("EVENTOS");
		btn_eventos.setBounds(0, 41, 121, 25);
		btn_eventos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_eventos);
		btn_eventos.addActionListener(new ControlBotonesAplicacion());

		btn_constancias = new JButton("CONSTANCIAS");

		btn_constancias.setBounds(0, 77, 121, 25);
		btn_constancias.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_constancias);
		btn_constancias.addActionListener(new ControlBotonesAplicacion());

		btn_reclamos = new JButton("RECLAMOS");
		btn_reclamos.setBounds(0, 113, 121, 25);
		btn_reclamos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_container_panel.add(btn_reclamos);
		btn_reclamos.addActionListener(new ControlBotonesAplicacion());

		card_container_panel = new JPanel();
		card_container_panel.setBounds(130, 0, 892, 746);
		getContentPane().add(card_container_panel);
		card_container_panel.setLayout(new CardLayout(0, 0));

		panel_usuarios = new JPanel();
		panel_usuarios.setBackground(new Color(255, 255, 255));
		panel_usuarios.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_usuarios, "Panel de Usuarios");
		panel_usuarios.setLayout(null);
		
		myModel = new MyDefaultTableModel(
				ListaUsuarios.getListaStringListado(),
				new String[] { "Estado", "Nombre de usuario", "Tipo de usuario", "Nombre 1", "Apellido 1", "ITR" });
		myModel.addColumn("Ver más");
		
		JTable t = new JTable(myModel);
		t.setRowHeight(30);
		JScrollPane sp = new JScrollPane(t);
		sp.setBounds(60, 146, 780, 400);
		panel_usuarios.add(sp);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		for(int i = 0; i < t.getColumnCount(); i++) {
			t.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
		TableColumn columnaEditar;
		columnaEditar = t.getColumnModel().getColumn(t.getColumnModel().getColumnCount()-1);
		columnaEditar.setCellEditor(new myeditor(t));
		columnaEditar.setCellRenderer(new rendererButton());
		
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
				if (e.getStateChange() == 2) {
					VisibilidadCampos.cambiarVisibilidadListadoUsuarios();
				}
			}
		});
		panel_usuarios.add(combo_filtro_tipoUsu);

		combo_filtro_itr = new JComboBox<String>();
		combo_filtro_itr.setBounds(325, 100, 130, 22);
		combo_filtro_itr.setModel(new DefaultComboBoxModel<>(getItrs()));
		combo_filtro_itr.addItem("TODOS");
		panel_usuarios.add(combo_filtro_itr);		
		
		combo_filtro_Generac = new JComboBox<Object>();
		combo_filtro_Generac.setBounds(575, 100, 70, 22);
		combo_filtro_Generac.setModel(new DefaultComboBoxModel<>(getGeneraciones()));
		combo_filtro_Generac.setVisible(false);
		panel_usuarios.add(combo_filtro_Generac);

		combo_filtro_estado = new JComboBox<String>();
		combo_filtro_estado.setBounds(465, 100, 100, 22);
		combo_filtro_estado.addItem("TODOS");
		combo_filtro_estado.addItem("SIN VALIDAR");
		combo_filtro_estado.addItem("ACTIVO");
		combo_filtro_estado.addItem("ELIMINADO");
		panel_usuarios.add(combo_filtro_estado);

		panel_eventos = new JPanel();
		panel_eventos.setBackground(new Color(0, 128, 0));
		panel_eventos.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_eventos, "Panel de Eventos");

		panel_constancias = new JPanel();
		panel_constancias.setBackground(new Color(0, 0, 255));
		panel_constancias.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_constancias, "Panel de Constancias");

		panel_reclamos = new JPanel();
		panel_reclamos.setBackground(new Color(64, 0, 64));
		panel_reclamos.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_reclamos, "Panel de Reclamos");
		
		JLabel lblUserName = new JLabel(usuario.getNombreUsuario());
		lblUserName.setBounds(0, 233, 130, 26);
		btn_container_panel.add(lblUserName);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		btn_reclamos.addActionListener(new ControlBotonesAplicacion());
		
		JLabel lblUserType = new JLabel(getTipoUsuario());
		lblUserType.setBounds(0, 196, 130, 26);
		btn_container_panel.add(lblUserType);
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserType.setHorizontalAlignment(SwingConstants.CENTER);
		btn_reclamos.addActionListener(new ControlBotonesAplicacion());

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public static  JButton getBtn_usuarios() {
		return btn_usuarios;
	}

	public static  JButton getBtn_eventos() {
		return btn_eventos;
	}

	public static  JButton getBtnConstancias() {
		return btn_constancias;
	}

	public static  JButton getBtnReclamos() {
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
	
	public static DefaultTableModel getMyModel() {
		return myModel;
	}

	public static void setUsuario(Long idUsuario) {
		UsuarioBeanRemote usuarioBean = null;
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote");
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
		try {
			setTipoUsuario(ComprobarTipoUsuario.is(getUsuario()));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void cerrar() {
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
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
		while(anio < actual) {
			generaciones.add(Integer.toString(anio));
			anio++;
		}
		
		return (Object[]) generaciones.toArray();
		
	}
	
	public String[] getItrs() {
		
		String[] list = ListaItrs.getListaString();
		String[] lista = new String[list.length + 1];
		
		for(int i = 0; i < lista.length; i++) {
			
			if(i == 0) {
				lista[i] = "TODOS";
			}else {
				lista[i] = list[i-1];
			}
			
		}
				
		return lista;
		
	}
	
}
