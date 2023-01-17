package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import controladores.ControlBotonesAplicacion;
import datos.ComprobarTipoUsuario;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Color;

public class Aplicacion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel btn_container_panel;
	private static JButton btn_usuarios;
	private static  JButton btn_eventos;
	private static  JButton btn_constancias;
	private static  JButton btn_reclamos;
	private JPanel panel_usuarios;
	private JPanel panel_eventos;
	private JPanel panel_constancias;
	private JPanel panel_reclamos;
	private static JPanel card_container_panel;
	private static Usuario usuario;
	private static String tipoUsuario;

	public Aplicacion(Long idUsuario) {
		
		setUsuario(idUsuario);
		cerrar();
		getContentPane().setLayout(null);

		btn_container_panel = new JPanel();
		btn_container_panel.setBounds(0, 0, 130, 746);
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

		card_container_panel = new JPanel();
		card_container_panel.setBounds(130, 0, 892, 746);
		getContentPane().add(card_container_panel);
		card_container_panel.setLayout(new CardLayout(0, 0));

		panel_usuarios = new JPanel();
		panel_usuarios.setBackground(new Color(128, 128, 0));
		panel_usuarios.setForeground(new Color(0, 0, 0));
		card_container_panel.add(panel_usuarios, "Panel de Usuarios");

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
	
}
