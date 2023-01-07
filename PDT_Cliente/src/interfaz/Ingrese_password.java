package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controladores.ControlBotonPassword;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Ingrese_password extends JFrame {
	private static JPasswordField password;
	private static JPasswordField rep_password;
	private JButton btn_reg_enviar;
	private static JLabel lblAviso;

	public Ingrese_password() {
		setBounds(new Rectangle(100, 100, 320, 320));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Ingrese_password.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Establezca su contrase\u00F1a");
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 384, 65);
		getContentPane().add(panel);
		panel.setLayout(null);

		PanelFondo panel_1 = new PanelFondo("/recursos/imagenes/09-Isotipo-1.png");
		panel_1.setBounds(10, 11, 35, 40);
		panel.add(panel_1);

		PanelFondo panel_2 = new PanelFondo("/recursos/imagenes/banner2_utec.png");
		panel_2.setBounds(55, 11, 100, 40);
		panel.add(panel_2);

		JLabel lblNewLabel = new JLabel("Registro de usuario");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setBackground(new Color(0, 178, 240));
		lblNewLabel.setBounds(0, 64, 168, 22);
		getContentPane().add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(166, 64, 218, 22);
		getContentPane().add(panel_3);

		password = new JPasswordField();
		password.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		password.setToolTipText("Ingresa aqu\u00ED tu contrase\u00F1a");
		password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		password.setBounds(182, 134, 90, 22);
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
		rep_password.setBounds(182, 177, 90, 22);
		getContentPane().add(rep_password);

		JLabel asterisco_label_2_1 = new JLabel("*");
		asterisco_label_2_1.setForeground(Color.RED);
		asterisco_label_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_2_1.setBounds(157, 176, 15, 21);
		getContentPane().add(asterisco_label_2_1);

		btn_reg_enviar = new JButton("Enviar");
		btn_reg_enviar.setForeground(Color.WHITE);
		btn_reg_enviar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_reg_enviar.setFocusable(false);
		btn_reg_enviar.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		btn_reg_enviar.setBackground(new Color(0, 178, 240));
		btn_reg_enviar.setBounds(75, 247, 146, 23);
		btn_reg_enviar.addActionListener(new ControlBotonPassword());
		getContentPane().add(btn_reg_enviar);
		
		lblAviso = new JLabel("Las constrase\u00F1as no coinciden");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setForeground(Color.RED);
		lblAviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAviso.setBounds(0, 215, 301, 21);
		lblAviso.setVisible(false);
		getContentPane().add(lblAviso);

		setVisible(true);
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
}
