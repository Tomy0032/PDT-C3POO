package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nom_usuario_login;
	private JPasswordField passw_usuario_login;
	
	
	
	public Login() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		setResizable(false);
		setBounds(new Rectangle(100, 100, 305, 320));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registrarse.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		PanelFondo panel = new PanelFondo("/recursos/imagenes/09-isotipo-1.png");
		panel.setBounds(41, 27, 38, 38);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("iniciar sesi\u00F3n en UTEC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(89, 27, 168, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(120, 90, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		nom_usuario_login = new JTextField();
		nom_usuario_login.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nom_usuario_login.setToolTipText("Ingrese aqui su nombre de usuario");
		nom_usuario_login.setBounds(64, 115, 161, 20);
		getContentPane().add(nom_usuario_login);
		nom_usuario_login.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("contrase\u00F1a");
		lblNewLabel_1_1.setToolTipText("Ingrese aqu\u00ED su contrase\u00F1a.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(109, 146, 68, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		passw_usuario_login = new JPasswordField();
		passw_usuario_login.setToolTipText("Ingrese aqui su nombre de usuario");
		passw_usuario_login.setColumns(10);
		passw_usuario_login.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		passw_usuario_login.setBounds(64, 172, 161, 20);
		getContentPane().add(passw_usuario_login);
		
		JButton btn_inic_sesion_login = new JButton("iniciar sesi\u00F3n");
		btn_inic_sesion_login.setBorder(new LineBorder(new Color(0, 178, 240), 2, true));
		btn_inic_sesion_login.setBackground(new Color(0, 178, 240));
		btn_inic_sesion_login.setForeground(new Color(255, 255, 255));
		btn_inic_sesion_login.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_inic_sesion_login.setFocusable(false);
		btn_inic_sesion_login.setBounds(81, 203, 126, 23);
		getContentPane().add(btn_inic_sesion_login);
		
		JButton btnRegistrarse = new JButton("registrarse");
		
		btnRegistrarse.setBorder(new LineBorder(new Color(0, 178, 240), 2, true));
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.setBackground(new Color(0, 178, 240));
		btnRegistrarse.setBounds(81, 237, 126, 23);
		btnRegistrarse.setFocusable(false);
		getContentPane().add(btnRegistrarse);
		setVisible(true);
		
		
	}
}
