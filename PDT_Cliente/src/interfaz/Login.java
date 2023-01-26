package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPasswordField;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import controladores.ControlBotonIniciar;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField nom_usuario_login;
	private static JPasswordField passw_usuario_login;
	private static JLabel lblAviso;
	private static JLabel lblAviso2;
	private static JLabel lblAviso3;
		
	public Login() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    setBounds(new Rectangle((width-305)/2, (height-340)/2, 305, 380));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registrarse.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		PanelFondo panel = new PanelFondo("/recursos/imagenes/09-isotipo-1.png");
		panel.setBounds(41, 27, 38, 38);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesi\u00F3n en UTEC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(89, 27, 168, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(121, 95, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		nom_usuario_login = new JTextField();
		nom_usuario_login.setHorizontalAlignment(SwingConstants.CENTER);
		nom_usuario_login.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nom_usuario_login.setToolTipText("Ingrese aqui su nombre de usuario");
		nom_usuario_login.setBounds(64, 115, 161, 22);
		getContentPane().add(nom_usuario_login);
		nom_usuario_login.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setToolTipText("Ingrese aqu\u00ED su contrase\u00F1a.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(110, 151, 68, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		passw_usuario_login = new JPasswordField();
		passw_usuario_login.setHorizontalAlignment(SwingConstants.CENTER);
		passw_usuario_login.setToolTipText("Ingrese aqu\u00ED su contrase\u00F1a.");
		passw_usuario_login.setColumns(10);
		passw_usuario_login.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		passw_usuario_login.setBounds(64, 172, 140, 22);
		getContentPane().add(passw_usuario_login);
		
		JButton showPass = new JButton("");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPass.getIcon().toString().equals("file:/C:/Users/gonza/GitHub/PDT-C3POO/PDT_Cliente/bin/recursos/imagenes/eye.png")){
					showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye2.png")));
					passw_usuario_login.setEchoChar((char)0);
				}else {
					showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
					passw_usuario_login.setEchoChar((char)'•');
				}
			}
		});
		showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
		showPass.setBounds(203, 172, 22, 22);
		showPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(showPass);
		
		JButton btn_inic_sesion_login = new JButton("Iniciar sesi\u00F3n");
		btn_inic_sesion_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				List<String> verificacion = new ArrayList<>();
				try {
					verificacion = ControlBotonIniciar.comprobarUsuario();
				} catch (NamingException e2) {
					
				}
				if(verificacion.get(0) == "si") {
					new Aplicacion(Long.parseLong(verificacion.get(2)));					
					dispose();	
				}							
			}
		});
		btn_inic_sesion_login.setBorder(new LineBorder(new Color(0, 178, 240), 2, true));
		btn_inic_sesion_login.setBackground(new Color(0, 178, 240));
		btn_inic_sesion_login.setForeground(new Color(255, 255, 255));
		btn_inic_sesion_login.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_inic_sesion_login.setFocusable(false);
		btn_inic_sesion_login.setBounds(81, 235, 126, 23);
		btn_inic_sesion_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btn_inic_sesion_login);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					new Registrarse();
					dispose();
				} catch (NamingException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnRegistrarse.setBorder(new LineBorder(new Color(0, 178, 240), 2, true));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.setBackground(new Color(0, 178, 240));
		btnRegistrarse.setBounds(81, 274, 126, 23);
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(btnRegistrarse);
		
		lblAviso = new JLabel("Error de autentificaci\u00F3n");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(45, 205, 196, 14);
		lblAviso.setForeground(Color.RED);
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAviso.setVisible(false);
		getContentPane().add(lblAviso);
		
		lblAviso2 = new JLabel("Debe completar todos los campos");
		lblAviso2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso2.setBounds(45, 205, 196, 14);
		lblAviso2.setForeground(Color.RED);
		lblAviso2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAviso2.setVisible(false);
		getContentPane().add(lblAviso2);
		
		lblAviso3 = new JLabel("El usuario no está habilitado");
		lblAviso3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso3.setBounds(45, 205, 196, 14);
		lblAviso3.setForeground(Color.RED);
		lblAviso3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAviso3.setVisible(false);
		getContentPane().add(lblAviso3);
		
		setVisible(true);
		
		
	}

	public static JTextField getNom_usuario_login() {
		return nom_usuario_login;
	}

	public static JPasswordField getPassw_usuario_login() {
		return passw_usuario_login;
	}
	
	public static JLabel getLblAviso() {
		return lblAviso;
	}
	
	public static JLabel getLblAviso2() {
		return lblAviso2;
	}

	public static JLabel getLblAviso3() {
		return lblAviso3;
	}
	
	
}
