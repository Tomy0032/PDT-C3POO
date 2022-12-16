package interfaz;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import controladores.Control_longit_min;
import interfaces.ControlCampo;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

public class Registrarse extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField nom1_field;
	private static JTextField nom2_field;
	private static JTextField ape1_field;
	private static JTextField ape2_field;
	private static JTextField cedu_field;
	private static JComboBox<String> tipo_usu_comboBox;
	private static JTextField mail_pers_field;
	private static JTextField telef_field;
	private static JComboBox<String> departam_comboBox;
	private static JComboBox<String> localidad_comboBox;
	private static JTextField mail_instit_field;
	private static JComboBox<String> itr_comboBox;
	private static JComboBox<String> rol_comboBox;
	private static JButton btn_reg_siguiente;

	private static JLabel aviso;

	private RestrictedTextField r_nom1;
	private RestrictedTextField r_nom2;
	private RestrictedTextField r_ape1;
	private RestrictedTextField r_ape2;
	private RestrictedTextField r_cedu;
	private RestrictedTextField r_mail_pers;
	private RestrictedTextField r_telef;
	private RestrictedTextField r_mail_instit;
	
	private static LinkedList<ControlCampo> listaCampos;
	

	public Registrarse() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Registrarse.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		setBounds(new Rectangle(100, 100, 600, 550));
		setResizable(false);
		setTitle("Registro de nuevo usuario");

		JPanel panelPrincipal = new JPanel();
		this.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelArriba = new JPanel();
		panelArriba.setBounds(new Rectangle(0, 0, 600, 100));
		panelArriba.setBounds(0, 0, 584, 62);
		panelArriba.setBackground(Color.BLACK);
		panelPrincipal.add(panelArriba);
		panelArriba.setLayout(null);

		PanelFondo panel_logo = new PanelFondo("/recursos/imagenes/09-Isotipo-1.png");
		panel_logo.setBounds(18, 11, 36, 40);
		panelArriba.add(panel_logo);

		PanelFondo panel_logo_1 = new PanelFondo("/recursos/imagenes/banner2_utec.png");
		panel_logo_1.setBounds(64, 11, 102, 40);
		panelArriba.add(panel_logo_1);

		PanelFondo panelFondo = new PanelFondo("");
		panelFondo.setBounds(0, 61, 584, 430);
		panelFondo.setLayout(null);
		panelPrincipal.add(panelFondo);

		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		panelFondo.add(label);

		JLabel tipo_usu_label = new JLabel("Tipo de usuario");
		tipo_usu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		tipo_usu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipo_usu_label.setBounds(10, 54, 116, 21);
		panelFondo.add(tipo_usu_label);

		tipo_usu_comboBox = new JComboBox<String>();
		tipo_usu_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		tipo_usu_comboBox.setToolTipText("Te registras como estudiante? Como tutor? O como analista?. Elige aqu\u00ED.");
		tipo_usu_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tipo_usu_comboBox.setBounds(161, 53, 90, 22);
		panelFondo.add(tipo_usu_comboBox);

		JLabel nom1_label = new JLabel("Primer nombre");
		nom1_label.setHorizontalAlignment(SwingConstants.TRAILING);
		nom1_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom1_label.setBounds(10, 97, 116, 21);
		panelFondo.add(nom1_label);

		nom1_field = new JTextField();
		nom1_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nom1_field.setToolTipText("Ingresa aqu\u00ED tu primer nombre, o el \u00FAnico si s\u00F3lo tienes uno. ");
		nom1_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nom1_field.setBounds(161, 97, 90, 21);
		panelFondo.add(nom1_field);
		nom1_field.setColumns(10);

		JLabel asterisco_label = new JLabel("*");
		asterisco_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label.setForeground(new Color(255, 0, 0));
		asterisco_label.setBounds(136, 53, 15, 21);
		panelFondo.add(asterisco_label);

		JLabel asterisco_label_2 = new JLabel("*");
		asterisco_label_2.setForeground(Color.RED);
		asterisco_label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_2.setBounds(136, 96, 15, 21);
		panelFondo.add(asterisco_label_2);

		JLabel nom2_label = new JLabel("Segundo nombre");
		nom2_label.setHorizontalAlignment(SwingConstants.TRAILING);
		nom2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom2_label.setBounds(10, 139, 116, 21);
		panelFondo.add(nom2_label);

		nom2_field = new JTextField();
		nom2_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nom2_field.setToolTipText("Ingresa aqu\u00ED tu segundo nombre. (Opcional)");
		nom2_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nom2_field.setColumns(10);
		nom2_field.setBounds(161, 139, 90, 21);
		panelFondo.add(nom2_field);

		JLabel ape1_label = new JLabel("Primer apellido");
		ape1_label.setHorizontalAlignment(SwingConstants.TRAILING);
		ape1_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ape1_label.setBounds(10, 182, 116, 21);
		panelFondo.add(ape1_label);

		ape1_field = new JTextField();
		ape1_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		ape1_field.setToolTipText("Ingresa aqu\u00ED tu primer apellido.");
		ape1_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ape1_field.setColumns(10);
		ape1_field.setBounds(161, 182, 90, 21);
		panelFondo.add(ape1_field);

		JLabel asterisco_label_3 = new JLabel("*");
		asterisco_label_3.setForeground(Color.RED);
		asterisco_label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_3.setBounds(136, 181, 15, 21);
		panelFondo.add(asterisco_label_3);

		JLabel ape2_label = new JLabel("Segundo apellido");
		ape2_label.setHorizontalAlignment(SwingConstants.TRAILING);
		ape2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ape2_label.setBounds(10, 225, 116, 21);
		panelFondo.add(ape2_label);

		ape2_field = new JTextField();
		ape2_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		ape2_field.setToolTipText("Ingresa aqu\u00ED tu segundo apellido. (Opcional)");
		ape2_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ape2_field.setColumns(10);
		ape2_field.setBounds(161, 225, 90, 21);
		panelFondo.add(ape2_field);

		JLabel cedu_label = new JLabel("C\u00E9dula");
		cedu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		cedu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		cedu_label.setBounds(10, 271, 116, 21);
		panelFondo.add(cedu_label);

		cedu_field = new JTextField();
		cedu_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		cedu_field.setToolTipText("Ingresa aqu\u00ED tu n\u00FAmero de documento sin espacios, puntos ni guiones.");
		cedu_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cedu_field.setColumns(10);
		cedu_field.setBounds(161, 271, 90, 21);
		panelFondo.add(cedu_field);

		JLabel asterisco_label_4 = new JLabel("*");
		asterisco_label_4.setForeground(Color.RED);
		asterisco_label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_4.setBounds(136, 270, 15, 21);
		panelFondo.add(asterisco_label_4);

		JLabel fec_nac_label = new JLabel("Fecha nacimiento");
		fec_nac_label.setHorizontalAlignment(SwingConstants.TRAILING);
		fec_nac_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		fec_nac_label.setBounds(10, 315, 116, 21);
		panelFondo.add(fec_nac_label);

		JLabel asterisco_label_5 = new JLabel("*");
		asterisco_label_5.setForeground(Color.RED);
		asterisco_label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_5.setBounds(136, 314, 15, 21);
		panelFondo.add(asterisco_label_5);

		JLabel email_pers_label = new JLabel("E-mail personal");
		email_pers_label.setHorizontalAlignment(SwingConstants.TRAILING);
		email_pers_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_pers_label.setBounds(266, 54, 116, 21);
		panelFondo.add(email_pers_label);

		mail_pers_field = new JTextField();
		mail_pers_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		mail_pers_field.setToolTipText("Ingresa aqu\u00ED tu e-mail personal. ej. juanperez@gmail.com.");
		mail_pers_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mail_pers_field.setColumns(10);
		mail_pers_field.setBounds(417, 54, 90, 21);
		panelFondo.add(mail_pers_field);

		JLabel asterisco_label_6 = new JLabel("*");
		asterisco_label_6.setForeground(Color.RED);
		asterisco_label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_6.setBounds(392, 53, 15, 21);
		panelFondo.add(asterisco_label_6);

		JLabel telef_label = new JLabel("Tel\u00E9fono");
		telef_label.setHorizontalAlignment(SwingConstants.TRAILING);
		telef_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		telef_label.setBounds(266, 97, 116, 21);
		panelFondo.add(telef_label);

		telef_field = new JTextField();
		telef_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		telef_field.setToolTipText("Ingresa aqu\u00ED tu tel\u00E9fono.");
		telef_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		telef_field.setColumns(10);
		telef_field.setBounds(417, 97, 90, 21);
		panelFondo.add(telef_field);

		JLabel departamento_label = new JLabel("Departamento");
		departamento_label.setHorizontalAlignment(SwingConstants.TRAILING);
		departamento_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		departamento_label.setBounds(266, 139, 116, 21);
		panelFondo.add(departamento_label);

		departam_comboBox = new JComboBox<String>();
		departam_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		departam_comboBox.setToolTipText("Elige el departamento donde resides.");
		departam_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departam_comboBox.setBounds(417, 138, 90, 22);
		panelFondo.add(departam_comboBox);

		JLabel asterisco_label_7 = new JLabel("*");
		asterisco_label_7.setForeground(Color.RED);
		asterisco_label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_7.setBounds(392, 96, 15, 21);
		panelFondo.add(asterisco_label_7);

		JLabel asterisco_label_8 = new JLabel("*");
		asterisco_label_8.setForeground(Color.RED);
		asterisco_label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_8.setBounds(392, 138, 15, 21);
		panelFondo.add(asterisco_label_8);

		localidad_comboBox = new JComboBox<String>();
		localidad_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		localidad_comboBox.setToolTipText("Elige la localidad (pueblo, villa) donde resides.");
		localidad_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		localidad_comboBox.setBounds(417, 181, 90, 22);
		panelFondo.add(localidad_comboBox);

		JLabel localidad_label = new JLabel("Localidad");
		localidad_label.setHorizontalAlignment(SwingConstants.TRAILING);
		localidad_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		localidad_label.setBounds(266, 182, 116, 21);
		panelFondo.add(localidad_label);

		JLabel asterisco_label_9 = new JLabel("*");
		asterisco_label_9.setForeground(Color.RED);
		asterisco_label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_9.setBounds(392, 181, 15, 21);
		panelFondo.add(asterisco_label_9);

		JLabel email_instit_label = new JLabel("E-mail institucional");
		email_instit_label.setHorizontalAlignment(SwingConstants.TRAILING);
		email_instit_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_instit_label.setBounds(266, 225, 116, 21);
		panelFondo.add(email_instit_label);

		mail_instit_field = new JTextField();
		mail_instit_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		mail_instit_field
				.setToolTipText("Ingresa aqu\u00ED tu e-mail institucional. ej. juan.perez@estudialtes.utec.edu.uy.");
		mail_instit_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mail_instit_field.setColumns(10);
		mail_instit_field.setBounds(417, 225, 90, 21);
		panelFondo.add(mail_instit_field);

		JLabel asterisco_label_10 = new JLabel("*");
		asterisco_label_10.setForeground(Color.RED);
		asterisco_label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_10.setBounds(392, 224, 15, 21);
		panelFondo.add(asterisco_label_10);

		JLabel itr_label = new JLabel("I.T.R.");
		itr_label.setHorizontalAlignment(SwingConstants.TRAILING);
		itr_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		itr_label.setBounds(266, 271, 116, 21);
		panelFondo.add(itr_label);

		itr_comboBox = new JComboBox<String>();
		itr_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		itr_comboBox.setToolTipText("Elige el ITR (Instituto Tecnol\u00F3gico Regional, ej. ITR Durazno).");
		itr_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itr_comboBox.setBounds(417, 270, 90, 22);
		panelFondo.add(itr_comboBox);

		JLabel fec_ingreso_label = new JLabel("A\u00F1o de ingreso");
		fec_ingreso_label.setHorizontalAlignment(SwingConstants.TRAILING);
		fec_ingreso_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		fec_ingreso_label.setBounds(266, 315, 116, 21);
		panelFondo.add(fec_ingreso_label);

		JLabel asterisco_label_13 = new JLabel("*");
		asterisco_label_13.setForeground(Color.RED);
		asterisco_label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_13.setBounds(392, 270, 15, 21);
		panelFondo.add(asterisco_label_13);

		JLabel asterisco_label_14 = new JLabel("*");
		asterisco_label_14.setForeground(Color.RED);
		asterisco_label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_14.setBounds(392, 314, 15, 21);
		panelFondo.add(asterisco_label_14);

		JLabel rol_label = new JLabel("Rol");
		rol_label.setHorizontalAlignment(SwingConstants.TRAILING);
		rol_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		rol_label.setBounds(266, 362, 116, 21);
		panelFondo.add(rol_label);

		rol_comboBox = new JComboBox<String>();
		rol_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		rol_comboBox.setToolTipText("Selecciona el rol que asumir\u00E1s.");
		rol_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rol_comboBox.setBounds(417, 362, 90, 22);
		panelFondo.add(rol_comboBox);

		JLabel asterisco_label_14_1 = new JLabel("*");
		asterisco_label_14_1.setForeground(Color.RED);
		asterisco_label_14_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_14_1.setBounds(392, 362, 15, 21);
		panelFondo.add(asterisco_label_14_1);

		aviso = new JLabel("Los campos marcados con (*) son obligatorios");
		aviso.setForeground(new Color(255, 0, 0));
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso.setBounds(20, 352, 291, 21);
		panelFondo.add(aviso);

		btn_reg_siguiente = new JButton("Siguiente");
		btn_reg_siguiente.setFocusable(false);
		btn_reg_siguiente.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		btn_reg_siguiente.setForeground(new Color(255, 255, 255));
		btn_reg_siguiente.setBackground(new Color(0, 178, 240));
		btn_reg_siguiente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_reg_siguiente.setBounds(217, 405, 146, 23);
		
		
		panelFondo.add(btn_reg_siguiente);

		JPanel panel_gris = new JPanel();
		panel_gris.setBackground(new Color(192, 192, 192));
		panel_gris.setBounds(287, 0, 297, 32);
		panelFondo.add(panel_gris);

		JLabel lblNewLabel = new JLabel("Registro de usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setBackground(new Color(0, 178, 240));
		lblNewLabel.setBounds(0, 0, 291, 32);
		panelFondo.add(lblNewLabel);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(161, 315, 90, 20);
		panelFondo.add(dateChooser);

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(417, 315, 90, 20);
		panelFondo.add(yearChooser);
		
		r_nom1 = new RestrictedTextField(this.nom1_field);
		r_nom1.setOnlyText(true);
		r_nom1.setLimit(20);
		Control_longit_min c_nom1 = new Control_longit_min(nom1_field, 3);
		nom1_field.getDocument().addDocumentListener(c_nom1);
		
		r_nom2 = new RestrictedTextField(this.nom2_field);
		r_nom2.setOnlyText(true);
		r_nom2.setLimit(20);
		Control_longit_min c_nom2 = new Control_longit_min(nom2_field, 3);
		nom2_field.getDocument().addDocumentListener(c_nom2);

		r_ape1 = new RestrictedTextField(this.ape1_field);
		r_ape1.setOnlyText(true);
		r_ape1.setLimit(20);
		Control_longit_min c_ape1 = new Control_longit_min(ape1_field, 3);
		ape1_field.getDocument().addDocumentListener(c_ape1);

		r_ape2 = new RestrictedTextField(this.ape2_field);
		r_ape2.setOnlyText(true);
		r_ape2.setLimit(20);
		Control_longit_min c_ape2 = new Control_longit_min(ape1_field, 3);
		ape2_field.getDocument().addDocumentListener(c_ape2);
		
		r_cedu = new RestrictedTextField(this.cedu_field);
		r_cedu.setOnlyNums(true);
		r_cedu.setLimit(8);
		Control_longit_min c_cedu = new Control_longit_min(cedu_field, 8);
		cedu_field.getDocument().addDocumentListener(c_cedu);
		
		r_mail_pers = new RestrictedTextField(this.mail_pers_field);
		r_mail_pers.setLimit(30);
		Control_longit_min c_mail_pers = new Control_longit_min(mail_pers_field, 12);
		mail_pers_field.getDocument().addDocumentListener(c_mail_pers);
		
		r_telef = new RestrictedTextField(this.telef_field);
		r_telef.setOnlyNums(true);
		r_telef.setLimit(12);
		Control_longit_min c_telef = new Control_longit_min(telef_field, 8);
		telef_field.getDocument().addDocumentListener(c_telef);
		
		r_mail_instit = new RestrictedTextField(this.mail_instit_field);
		r_mail_instit.setLimit(30);
		Control_longit_min c_mail_instit = new Control_longit_min(mail_instit_field,15);
		mail_instit_field.getDocument().addDocumentListener(c_mail_instit);
		
		listaCampos = new LinkedList<ControlCampo>();
		listaCampos.add(c_nom1);		
		listaCampos.add(c_nom2);
		listaCampos.add(c_ape1);
		listaCampos.add(c_ape2);
		listaCampos.add(c_cedu);
		listaCampos.add(c_mail_pers);
		listaCampos.add(c_telef);
		listaCampos.add(c_mail_instit);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

	public static LinkedList<ControlCampo> getListaCampos() {
		return listaCampos;
	}


	public static JLabel getAviso() {
		return aviso;
	}

	public static void setAviso(String aviso) {
		Registrarse.aviso.setText(aviso);
	}

	public static JTextField getNom1_field() {
		return nom1_field;
	}

	public static JTextField getNom2_field() {
		return nom2_field;
	}

	public static JTextField getApe1_field() {
		return ape1_field;
	}

	public static JTextField getApe2_field() {
		return ape2_field;
	}

	public static JTextField getCedu_field() {
		return cedu_field;
	}

	public static JComboBox<String> getTipo_usu_comboBox() {
		return tipo_usu_comboBox;
	}

	public static JTextField getMail_pers_field() {
		return mail_pers_field;
	}

	public static JTextField getTelef_field() {
		return telef_field;
	}

	public static JComboBox<String> getDepartam_comboBox() {
		return departam_comboBox;
	}

	public static JComboBox<String> getLocalidad_comboBox() {
		return localidad_comboBox;
	}

	public static JTextField getMail_instit_field() {
		return mail_instit_field;
	}

	public static JComboBox<String> getItr_comboBox() {
		return itr_comboBox;
	}

	public static JComboBox<String> getRol_comboBox() {
		return rol_comboBox;
	}

	public static JButton getBtn_enviar() {
		return btn_reg_siguiente;
	}
}
