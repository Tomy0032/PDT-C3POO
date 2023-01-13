package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import controladores.ControlBotonPassword;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Ingrese_password extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPasswordField password;
	private static JPasswordField rep_password;
	private JButton btn_reg_enviar;
	private static JLabel lblAviso4;
	private static JLabel lblAviso2;
	private static JLabel lblAviso3;
	private static JLabel lblAviso;
	
	private boolean registro;
	private RestrictedTextField r_password;

	public Ingrese_password() {
		
		cerrar();
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    setBounds(new Rectangle((width-356)/2, (height-375)/2, 356, 375));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ingrese_password.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Establezca su contrase\u00F1a");
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 340, 65);
		getContentPane().add(panel);
		panel.setLayout(null);

		PanelFondo panel_1 = new PanelFondo("/recursos/imagenes/09-Isotipo-1.png");
		panel_1.setBounds(10, 11, 41, 40);
		panel.add(panel_1);

		PanelFondo panel_2 = new PanelFondo("/recursos/imagenes/banner2_utec.png");
		panel_2.setBounds(62, 11, 100, 40);
		panel.add(panel_2);

		JLabel lblNewLabel = new JLabel("Registro de usuario");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setBackground(new Color(0, 178, 240));
		lblNewLabel.setBounds(0, 64, 168, 33);
		getContentPane().add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(166, 64, 174, 33);
		getContentPane().add(panel_3);

		password = new JPasswordField();
		password.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		password.setToolTipText("Ingresa aqu\u00ED tu contrase\u00F1a");
		password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		password.setBounds(175, 134, 129, 22);
		getContentPane().add(password);

		JLabel asterisco_label_2 = new JLabel("*");
		asterisco_label_2.setForeground(Color.RED);
		asterisco_label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_2.setBounds(157, 133, 15, 21);
		getContentPane().add(asterisco_label_2);

		JLabel password_label = new JLabel("Contrase\u00F1a");
		password_label.setHorizontalAlignment(SwingConstants.TRAILING);
		password_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		password_label.setBounds(31, 134, 116, 21);
		getContentPane().add(password_label);

		JLabel rep_password_label = new JLabel("Repetir Contrase\u00F1a");
		rep_password_label.setHorizontalAlignment(SwingConstants.TRAILING);
		rep_password_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		rep_password_label.setBounds(18, 177, 129, 21);
		getContentPane().add(rep_password_label);

		rep_password = new JPasswordField();
		rep_password.setToolTipText("Ingresa aqu\u00ED tu contrase\u00F1a");
		rep_password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rep_password.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		rep_password.setBounds(175, 177, 129, 22);
		getContentPane().add(rep_password);

		JLabel asterisco_label_2_1 = new JLabel("*");
		asterisco_label_2_1.setForeground(Color.RED);
		asterisco_label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_2_1.setBounds(157, 177, 15, 21);
		getContentPane().add(asterisco_label_2_1);

		btn_reg_enviar = new JButton("Enviar");
		btn_reg_enviar.setForeground(Color.WHITE);
		btn_reg_enviar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_reg_enviar.setFocusable(false);
		btn_reg_enviar.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		btn_reg_enviar.setBackground(new Color(0, 178, 240));
		btn_reg_enviar.setBounds(97, 287, 146, 23);
		btn_reg_enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlBotonPassword c = new ControlBotonPassword();
				if(c.controlar()) {
					Registrarse.limpiar();
					dispose();
				}
				
			}

		});
		getContentPane().add(btn_reg_enviar);
		
		lblAviso = new JLabel("Las constrase\u00F1as no coinciden");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setForeground(Color.RED);
		lblAviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAviso.setBounds(20, 255, 301, 21);
		lblAviso.setVisible(false);
		getContentPane().add(lblAviso);
		
		lblAviso2 = new JLabel("La contraseña debe incluir números");
		lblAviso2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso2.setForeground(Color.RED);
		lblAviso2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAviso2.setBounds(20, 255, 301, 21);
		lblAviso2.setVisible(false);
		getContentPane().add(lblAviso2);
		
		lblAviso3 = new JLabel("La contraseña debe incluir letras");
		lblAviso3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso3.setForeground(Color.RED);
		lblAviso3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAviso3.setBounds(20, 255, 301, 21);
		lblAviso3.setVisible(false);
		getContentPane().add(lblAviso3);
		
		lblAviso4 = new JLabel("La contraseña es demasiado corta");
		lblAviso4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso4.setForeground(Color.RED);
		lblAviso4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAviso4.setBounds(20, 255, 301, 21);
		lblAviso4.setVisible(false);
		getContentPane().add(lblAviso4);
		
		JTextPane Info = new JTextPane();
		Info.setEditable(false);
		Info.setBackground(SystemColor.menu);
		Info.setText("La contrase\u00F1a debe tener entre 8 y 16 caracteres e incluir n\u00FAmeros y letras");
		Info.setBounds(31, 215, 280, 33);
		getContentPane().add(Info);
			
		JButton showPass = new JButton("");
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPass.getIcon().toString().equals("file:/C:/Users/gonza/GitHub/PDT-C3POO/PDT_Cliente/bin/recursos/imagenes/eye.png")){
					showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye2.png")));
					password.setEchoChar((char)0);
				}else {
					showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
					password.setEchoChar((char)'•');
				}
			}
		});
		showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
		showPass.setBounds(303, 134, 22, 22);
		getContentPane().add(showPass);
			
		JButton showRePass = new JButton("");
		showRePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showRePass.getIcon().toString().equals("file:/C:/Users/gonza/GitHub/PDT-C3POO/PDT_Cliente/bin/recursos/imagenes/eye.png")){
					showRePass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye2.png")));
					rep_password.setEchoChar((char)0);
				}else {
					showRePass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
					rep_password.setEchoChar((char)'•');
				}
			}
		});
		showRePass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
		showRePass.setBounds(303, 177, 22, 22);
		getContentPane().add(showRePass);
		
		r_password = new RestrictedTextField(password);
		r_password.setLimit(16);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setVisible(true);
	}

	public static JLabel getLblAviso4() {
		return lblAviso4;
	}

	public static JLabel getLblAviso2() {
		return lblAviso2;
	}

	public static JLabel getLblAviso3() {
		return lblAviso3;
	}

	public static JPasswordField getPassword() {
		return password;
	}

	public static JPasswordField getRep_password() {
		return rep_password;
	}

	public static JLabel getLblAviso() {
		return lblAviso;
	}

	public static void setRep_password(JPasswordField rep_password) {
		Ingrese_password.rep_password = rep_password;
	}

	public JButton getBtn_reg_enviar() {
		return btn_reg_enviar;
	}

	public boolean getRegistro() {
		return this.registro;
	}

	public void setRegistro(boolean registro) {
		this.registro = registro;
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
