package componentes;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JComboBox;

import com.entities.Departamento;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

import interfaz.Aplicacion;
import interfaz.Ingrese_password;
import interfaz.PanelFondo;
import interfaz.Registrarse;
import listas.ListaAreas;
import listas.ListaDepartamentos;
import listas.ListaItrs;
import listas.ListaLocalidades;
import listas.ListaTiposTutor;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import com.toedter.calendar.JYearChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import controladores.ControlBotonEditarPassword;
import controladores.ControlBotonEditarMisDatos;
import controladores.ControlBotonEnviar;
import controladores.Control_longit_min;
import interfaces.ControlCampo;
import javax.swing.JPasswordField;

public class PanelEditarMisDatos extends JPanel {
	private static JTextField nombre1Field;
	private static JTextField nombre2Field;
	private static JTextField apellido1Field;
	private static JTextField apellido2Field;
	private static JTextField ciField;
	private static JTextField personalField;
	private static JTextField institucionalField;
	private static JTextField tipo_usuario_field;
	private static LinkedList<ControlCampo> listaCampos;
	private RestrictedTextField r_nom1;
	private RestrictedTextField r_nom2;
	private RestrictedTextField r_ape1;
	private RestrictedTextField r_ape2;
	private RestrictedTextField r_mail_pers;
	private RestrictedTextField r_telef;
	private RestrictedTextField r_mail_instit;
	private static JTextField telefonoField;
	private static JComboBox<String> departam_comboBox;
	private static JComboBox<String> localidad_comboBox;
	private static int localidad;
	private static JDateChooser nacimientoDateChooser;
	private static JButton btn_reg_siguiente;

	private static JLabel aviso_1;
	protected static DefaultComboBoxModel modeloLocalidades;
	private static JYearChooser yearChooser;
	private static JComboBox<String> itr_comboBox;
	private static JComboBox<String> rol_comboBox;
	private static JComboBox<String> area_comboBox;
	private static JLabel aviso_2;
	private static JPasswordField newPasswordField;
	private static JPasswordField repNewPasswordField;
	private static JPasswordField passwordField;
	int iconStatus = 0;
	private JLabel nom1_label;
	private static DefaultComboBoxModel modeloTipos;
	private static DefaultComboBoxModel modeloItr;
	private static DefaultComboBoxModel modeloDepartamentos;
	private static DefaultComboBoxModel modeloAreas;
	private static JLabel fec_ingreso_label;
	private static JLabel rol_label;
	private static JLabel area_label;
	
	
	@SuppressWarnings("unlikely-arg-type")
	public PanelEditarMisDatos() {
		setLayout(null);
		
		PanelFondo panelFondo = new PanelFondo("");
		panelFondo.setLayout(null);
		panelFondo.setBackground(SystemColor.menu);
		panelFondo.setBounds(0, 0, 941, 698);
		add(panelFondo);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		panelFondo.add(label);
		
		JLabel tipo_usu_label = new JLabel("Tipo de usuario *");
		tipo_usu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		tipo_usu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipo_usu_label.setBounds(367, 41, 116, 22);
		panelFondo.add(tipo_usu_label);
		
		nom1_label = new JLabel("Primer nombre *");
		nom1_label.setHorizontalAlignment(SwingConstants.TRAILING);
		nom1_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom1_label.setBounds(81, 97, 126, 21);
		panelFondo.add(nom1_label);
		
		nombre1Field = new JTextField();
		nombre1Field.setToolTipText("Ingresa aqu\u00ED tu primer nombre, o el \u00FAnico si s\u00F3lo tienes uno. ");
		nombre1Field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nombre1Field.setColumns(10);
		nombre1Field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nombre1Field.setBounds(217, 97, 190, 21);
		panelFondo.add(nombre1Field);
		
		JLabel nom2_label = new JLabel("Segundo nombre");
		nom2_label.setHorizontalAlignment(SwingConstants.TRAILING);
		nom2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom2_label.setBounds(532, 96, 116, 21);
		panelFondo.add(nom2_label);
		
		nombre2Field = new JTextField();
		nombre2Field.setToolTipText("Ingresa aqu\u00ED tu segundo nombre. (Opcional)");
		nombre2Field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nombre2Field.setColumns(10);
		nombre2Field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nombre2Field.setBounds(658, 96, 190, 21);
		panelFondo.add(nombre2Field);
		
		JLabel ape1_label = new JLabel("Primer apellido *");
		ape1_label.setHorizontalAlignment(SwingConstants.TRAILING);
		ape1_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ape1_label.setBounds(81, 130, 126, 21);
		panelFondo.add(ape1_label);
		
		apellido1Field = new JTextField();
		apellido1Field.setToolTipText("Ingresa aqu\u00ED tu primer apellido.");
		apellido1Field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		apellido1Field.setColumns(10);
		apellido1Field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		apellido1Field.setBounds(217, 130, 190, 21);
		panelFondo.add(apellido1Field);
		
		JLabel ape2_label = new JLabel("Segundo apellido");
		ape2_label.setHorizontalAlignment(SwingConstants.TRAILING);
		ape2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ape2_label.setBounds(532, 129, 116, 21);
		panelFondo.add(ape2_label);
		
		apellido2Field = new JTextField();
		apellido2Field.setToolTipText("Ingresa aqu\u00ED tu segundo apellido. (Opcional)");
		apellido2Field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		apellido2Field.setColumns(10);
		apellido2Field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		apellido2Field.setBounds(658, 128, 190, 21);
		panelFondo.add(apellido2Field);
		
		JLabel cedu_label = new JLabel("C\u00E9dula *");
		cedu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		cedu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		cedu_label.setBounds(81, 166, 126, 21);
		panelFondo.add(cedu_label);
		
		ciField = new JTextField();
		ciField.setEditable(false);
		ciField.setToolTipText("Ingresa aqu\u00ED tu n\u00FAmero de documento sin espacios, puntos ni guiones.");
		ciField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ciField.setColumns(10);
		ciField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		ciField.setBounds(217, 166, 190, 21);
		panelFondo.add(ciField);
		
		JLabel fec_nac_label = new JLabel("Fecha nacimiento *");
		fec_nac_label.setHorizontalAlignment(SwingConstants.TRAILING);
		fec_nac_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		fec_nac_label.setBounds(532, 165, 116, 21);
		panelFondo.add(fec_nac_label);
		
		JLabel email_pers_label = new JLabel("E-mail personal *");
		email_pers_label.setHorizontalAlignment(SwingConstants.TRAILING);
		email_pers_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_pers_label.setBounds(91, 199, 116, 21);
		panelFondo.add(email_pers_label);
		
		personalField = new JTextField();
		personalField.setToolTipText("Ingresa aqu\u00ED tu e-mail personal. ej. juanperez@gmail.com.");
		personalField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		personalField.setColumns(10);
		personalField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		personalField.setBounds(217, 199, 190, 21);
		panelFondo.add(personalField);
		
		JLabel telef_label = new JLabel("Tel\u00E9fono *");
		telef_label.setHorizontalAlignment(SwingConstants.TRAILING);
		telef_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		telef_label.setBounds(532, 198, 116, 21);
		panelFondo.add(telef_label);
		
		telefonoField = new JTextField();
		telefonoField.setToolTipText("Ingresa aqu\u00ED tu e-mail personal. ej. juanperez@gmail.com.");
		telefonoField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		telefonoField.setColumns(10);
		telefonoField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		telefonoField.setBounds(658, 199, 190, 21);
		panelFondo.add(telefonoField);
		
		JLabel departamento_label = new JLabel("Departamento *");
		departamento_label.setHorizontalAlignment(SwingConstants.RIGHT);
		departamento_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		departamento_label.setBounds(71, 232, 136, 21);
		panelFondo.add(departamento_label);
		
		departam_comboBox = new JComboBox<String>();
		departam_comboBox.setToolTipText("Elige el departamento donde resides.");
		departam_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departam_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		departam_comboBox.setBounds(217, 231, 190, 22);
		departam_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {				
				if (e.getStateChange() == 2) {	
					String nombre = (String) departam_comboBox.getSelectedItem();
					int id = 0;
					List<Departamento> depas = ListaDepartamentos.getLista();					
					for(Departamento d : depas) {
						if(d.getNombre().equals(nombre)) {
							id = (int) d.getIdDepartamento();
						}
					}
					try {
						PanelEditarMisDatos.modeloLocalidades = new DefaultComboBoxModel<>(ListaLocalidades.getListaString(id));
						localidad_comboBox.setModel(modeloLocalidades);
					}catch(Exception e1) {
					}
				}
			}
		});
		modeloDepartamentos = new DefaultComboBoxModel<>(ListaDepartamentos.getListaString());
		departam_comboBox.setModel(modeloDepartamentos);
		
		panelFondo.add(departam_comboBox);
		
		localidad_comboBox = new JComboBox<String>();
		localidad_comboBox.setToolTipText("Elige la localidad (pueblo, villa) donde resides.");
		localidad_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		localidad_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		localidad_comboBox.setBounds(658, 230, 190, 22);
		panelFondo.add(localidad_comboBox);
		
		JLabel localidad_label = new JLabel("Localidad *");
		localidad_label.setHorizontalAlignment(SwingConstants.TRAILING);
		localidad_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		localidad_label.setBounds(532, 231, 116, 21);
		modeloLocalidades = new DefaultComboBoxModel<>(ListaLocalidades.getListaString(departam_comboBox.getSelectedIndex()+1));
		localidad_comboBox.setModel(modeloLocalidades);
		panelFondo.add(localidad_label);
		
		JLabel email_instit_label = new JLabel("E-mail institucional *");
		email_instit_label.setHorizontalAlignment(SwingConstants.TRAILING);
		email_instit_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_instit_label.setBounds(81, 272, 126, 21);
		panelFondo.add(email_instit_label);
		
		institucionalField = new JTextField();
		institucionalField.setEditable(false);
		institucionalField.setToolTipText("Ingresa aqu\u00ED tu e-mail institucional. ej. juan.perez@estudiantes.utec.edu.uy.");
		institucionalField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		institucionalField.setColumns(10);
		institucionalField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		institucionalField.setBounds(217, 272, 190, 21);
		panelFondo.add(institucionalField);
		
		JLabel itr_label = new JLabel("I.T.R. *");
		itr_label.setHorizontalAlignment(SwingConstants.TRAILING);
		itr_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		itr_label.setBounds(532, 271, 116, 21);
		panelFondo.add(itr_label);
		
		itr_comboBox = new JComboBox<String>();
		itr_comboBox.setToolTipText("Elige el ITR (Instituto Tecnol\u00F3gico Regional, ej. ITR Durazno).");
		itr_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itr_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		itr_comboBox.setBounds(658, 270, 190, 22);
		modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		itr_comboBox.setModel(modeloItr);

		panelFondo.add(itr_comboBox);
		
		fec_ingreso_label = new JLabel("A\u00F1o de ingreso *");
		fec_ingreso_label.setHorizontalAlignment(SwingConstants.TRAILING);
		fec_ingreso_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		fec_ingreso_label.setBounds(81, 313, 126, 21);
		panelFondo.add(fec_ingreso_label);
		
		rol_label = new JLabel("Rol *");
		rol_label.setHorizontalAlignment(SwingConstants.TRAILING);
		rol_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		rol_label.setBounds(532, 313, 116, 21);
		panelFondo.add(rol_label);
		
		rol_comboBox = new JComboBox<String>();
		rol_comboBox.setToolTipText("Selecciona el rol que asumir\u00E1s.");
		rol_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rol_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		rol_comboBox.setBounds(658, 312, 190, 22);
		modeloTipos = new DefaultComboBoxModel<>(ListaTiposTutor.getListaString());
		rol_comboBox.setModel(modeloTipos);
		panelFondo.add(rol_comboBox);
		
		area_label = new JLabel("Area *");
		area_label.setHorizontalAlignment(SwingConstants.TRAILING);
		area_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		area_label.setBounds(81, 313, 126, 21);
		panelFondo.add(area_label);
		
		area_comboBox = new JComboBox<String>();
		area_comboBox.setToolTipText("Selecciona el \u00E1rea a la que perteneces.");
		area_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		area_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		area_comboBox.setBounds(217, 315, 190, 20);
		modeloAreas = new DefaultComboBoxModel<>(ListaAreas.getListaString());
		area_comboBox.setModel(modeloAreas);
		
		panelFondo.add(area_comboBox);
		
		JLabel aviso = new JLabel("");
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setForeground(Color.RED);
		aviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso.setBounds(114, 363, 794, 21);
		panelFondo.add(aviso);
		
		btn_reg_siguiente = new JButton("Actualizar datos");
		btn_reg_siguiente.setToolTipText("El bot\u00F3n se activa cuando los campos obligatorios est\u00E9n completos y correctos.");
		btn_reg_siguiente.setForeground(Color.WHITE);
		btn_reg_siguiente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_reg_siguiente.setFocusable(false);
		btn_reg_siguiente.setEnabled(false);
		btn_reg_siguiente.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		btn_reg_siguiente.setBackground(new Color(0, 178, 240));
		btn_reg_siguiente.setBounds(447, 394, 130, 23);
		panelFondo.add(btn_reg_siguiente);
		
		btn_reg_siguiente.addActionListener(new ControlBotonEditarMisDatos());
		
		nacimientoDateChooser = new JDateChooser();
		nacimientoDateChooser.setDateFormatString("dd/MM/yyyy");
		nacimientoDateChooser.setBounds(658, 165, 190, 20);
		panelFondo.add(nacimientoDateChooser);
		
		yearChooser = new JYearChooser();
		yearChooser.setBounds(217, 315, 190, 20);
		panelFondo.add(yearChooser);
		
		JLabel obligatorio_label = new JLabel("* Campo obligatorio");
		obligatorio_label.setHorizontalAlignment(SwingConstants.LEFT);
		obligatorio_label.setForeground(Color.GRAY);
		obligatorio_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		obligatorio_label.setBounds(78, 348, 162, 21);
		panelFondo.add(obligatorio_label);
		
		tipo_usuario_field = new JTextField();
		tipo_usuario_field.setEditable(false);
		tipo_usuario_field.setBounds(493, 41, 155, 22);
		tipo_usuario_field.setText(Aplicacion.getTipoUsuario());
		panelFondo.add(tipo_usuario_field);
		tipo_usuario_field.setColumns(10);

		
		
		r_nom1 = new RestrictedTextField(nombre2Field);
		r_nom1.setOnlyText(true);
		r_nom1.setAcceptSpace(true);
		r_nom1.setLimit(16);
		Control_longit_min c_nom1 = new Control_longit_min(nombre1Field, 2);
		nombre1Field.getDocument().addDocumentListener(c_nom1);

		r_nom2 = new RestrictedTextField(nombre2Field);
		r_nom2.setOnlyText(true);
		r_nom2.setAcceptSpace(true);
		r_nom2.setLimit(16);
		Control_longit_min c_nom2 = new Control_longit_min(nombre2Field, 2);
		nombre2Field.getDocument().addDocumentListener(c_nom2);

		r_ape1 = new RestrictedTextField(apellido1Field);
		r_ape1.setOnlyText(true);
		r_ape1.setAcceptSpace(true);
		r_ape1.setLimit(16);
		Control_longit_min c_ape1 = new Control_longit_min(apellido1Field, 2);
		apellido1Field.getDocument().addDocumentListener(c_ape1);

		r_ape2 = new RestrictedTextField(apellido2Field);
		r_ape2.setOnlyText(true);
		r_ape2.setAcceptSpace(true);
		r_ape2.setLimit(16);
		Control_longit_min c_ape2 = new Control_longit_min(apellido2Field, 2);
		apellido2Field.getDocument().addDocumentListener(c_ape2);

		r_mail_pers = new RestrictedTextField(personalField);
		r_mail_pers.setLimit(30);
		Control_longit_min c_mail_pers = new Control_longit_min(personalField, 12);
		personalField.getDocument().addDocumentListener(c_mail_pers);
		
		r_telef = new RestrictedTextField(telefonoField);
		r_telef.setOnlyNums(true);
		r_telef.setLimit(12);
		Control_longit_min c_telef = new Control_longit_min(telefonoField, 8);
		telefonoField.getDocument().addDocumentListener(c_telef);
		
		aviso_1 = new JLabel("");
		aviso_1.setHorizontalAlignment(SwingConstants.CENTER);
		aviso_1.setForeground(Color.RED);
		aviso_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso_1.setBounds(194, 364, 594, 21);
		panelFondo.add(aviso_1);
		
		listaCampos = new LinkedList<ControlCampo>();
		listaCampos.add(c_nom1);
		listaCampos.add(c_ape1);
		listaCampos.add(c_mail_pers);
		listaCampos.add(c_telef);
		
		JLabel actualizar_pass_label = new JLabel("Actualizar contrase\u00F1a");
		actualizar_pass_label.setForeground(Color.GRAY);
		actualizar_pass_label.setHorizontalAlignment(SwingConstants.LEFT);
		actualizar_pass_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		actualizar_pass_label.setBounds(81, 438, 175, 32);
		panelFondo.add(actualizar_pass_label);
		
		JLabel pass_label = new JLabel("Contrase\u00F1a anterior");
		pass_label.setHorizontalAlignment(SwingConstants.LEFT);
		pass_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass_label.setBounds(81, 480, 186, 21);
		panelFondo.add(pass_label);
		
		JLabel new_pass_label = new JLabel("Nueva contrase\u00F1a");
		new_pass_label.setHorizontalAlignment(SwingConstants.LEFT);
		new_pass_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		new_pass_label.setBounds(81, 522, 186, 21);
		panelFondo.add(new_pass_label);
		
		JLabel new_pass2_label = new JLabel("Repetie nueva contrase\u00F1a");
		new_pass2_label.setHorizontalAlignment(SwingConstants.LEFT);
		new_pass2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		new_pass2_label.setBounds(81, 560, 186, 21);
		panelFondo.add(new_pass2_label);
		
		JButton btn_newpass = new JButton("Actualizar contrase\u00F1a");
		btn_newpass.setToolTipText("El bot\u00F3n se activa cuando los campos obligatorios est\u00E9n completos y correctos.");
		btn_newpass.setForeground(Color.WHITE);
		btn_newpass.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_newpass.setFocusable(false);
		btn_newpass.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		btn_newpass.setBackground(new Color(0, 178, 240));
		btn_newpass.setBounds(175, 601, 190, 23);
		panelFondo.add(btn_newpass);
		
		btn_newpass.addActionListener(new ControlBotonEditarPassword());

		
		newPasswordField = new JPasswordField();
		newPasswordField.setToolTipText("Ingresa aqu\u00ED tu contrase\u00F1a");
		newPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newPasswordField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		newPasswordField.setBounds(277, 516, 145, 22);
		newPasswordField.setEchoChar((char)'•');
		panelFondo.add(newPasswordField);
		
		JButton showNewPass = new JButton("");
		showNewPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
		showNewPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iconStatus == 0){
					showNewPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye2.png")));
					newPasswordField.setEchoChar((char)0);
					iconStatus = 1;
				}else {
					showNewPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
					newPasswordField.setEchoChar((char)'•');
					iconStatus = 0;
				}
			}
		});
		showNewPass.setBounds(421, 516, 22, 22);
		panelFondo.add(showNewPass);
		
		repNewPasswordField = new JPasswordField();
		repNewPasswordField.setToolTipText("Ingresa aqu\u00ED tu contrase\u00F1a");
		repNewPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		repNewPasswordField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		repNewPasswordField.setBounds(277, 559, 145, 22);
		repNewPasswordField.setEchoChar((char)'•');
		panelFondo.add(repNewPasswordField);
		
		JButton showRePass = new JButton("");
		showRePass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
		showRePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iconStatus == 0){
					showRePass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye2.png")));
					repNewPasswordField.setEchoChar((char)0);
					iconStatus = 1;
				}else {
					showRePass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
					repNewPasswordField.setEchoChar((char)'•');
					iconStatus = 0;
				}
			}
		});
		showRePass.setBounds(421, 559, 22, 22);
		panelFondo.add(showRePass);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Ingresa aqu\u00ED tu contrase\u00F1a");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		passwordField.setBounds(277, 480, 145, 22);
		passwordField.setEchoChar((char)'•');
		panelFondo.add(passwordField);
		
		JButton showPass = new JButton("");
		showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
		showPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iconStatus == 0){
					showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye2.png")));
					passwordField.setEchoChar((char)0);
					iconStatus = 1;
				}else {
					showPass.setIcon(new ImageIcon(Ingrese_password.class.getResource("/recursos/imagenes/eye.png")));
					passwordField.setEchoChar((char)'•');
					iconStatus = 0;
				}
			}
		});
		showPass.setBounds(421, 480, 22, 22);
		panelFondo.add(showPass);
		
		aviso_2 = new JLabel("");
		aviso_2.setHorizontalAlignment(SwingConstants.CENTER);
		aviso_2.setForeground(Color.RED);
		aviso_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso_2.setBounds(0, 642, 554, 21);
		panelFondo.add(aviso_2);
		
		cargarDatos();
				
	}

	public static void cargarDatos() {
		
		tipo_usuario_field.setText(Aplicacion.getUsuario().getTipoUsuario().getNombre());
		nombre1Field.setText(Aplicacion.getUsuario().getNombre1());
		nacimientoDateChooser.setDate(Aplicacion.getUsuario().getFechaNacimiento());
		institucionalField.setText(Aplicacion.getUsuario().getCorreoInstitucional());
		personalField.setText(Aplicacion.getUsuario().getCorreoPersonal());
		telefonoField.setText(Aplicacion.getUsuario().getTelefono());
		ciField.setText(Aplicacion.getUsuario().getDocumento().getCaracteres());
		apellido2Field.setText(Aplicacion.getUsuario().getApellido2());
		apellido1Field.setText(Aplicacion.getUsuario().getApellido1());
		nombre2Field.setText(Aplicacion.getUsuario().getNombre2());
		
		
		if(Aplicacion.getTipoUsuario().equals("TUTOR")) {
			area_label.setVisible(true);
			area_comboBox.setVisible(true);
			rol_comboBox.setVisible(true);
			rol_label.setVisible(true);
			int area = 0;
			for(int i = 0; i < ListaAreas.getListaString().length; i ++) {
				if(ListaAreas.getListaString()[i].equals(Aplicacion.getUsuario().getArea().getNombre())) {
					area=i;
				}
			}
			modeloAreas.setSelectedItem(modeloAreas.getElementAt(area));
			int tipos = 0;
			for(int i = 0; i < ListaTiposTutor.getListaString().length; i ++) {
				if(ListaTiposTutor.getListaString()[i].equals(Aplicacion.getUsuario().getTipoTutor().getNombre())) {
					tipos=i;
				}
			}
			modeloTipos.setSelectedItem(modeloTipos.getElementAt(tipos));
		}else {
			area_label.setVisible(false);
			area_comboBox.setVisible(false);
			rol_comboBox.setVisible(false);
			rol_label.setVisible(false);
		}
		if(Aplicacion.getTipoUsuario().equals("ESTUDIANTE")) {
			fec_ingreso_label.setVisible(true);
			yearChooser.setVisible(true);
			yearChooser.setYear(Aplicacion.getUsuario().getGeneracion().getAno().intValue());
		}else{
			fec_ingreso_label.setVisible(false);
			yearChooser.setVisible(false);
		}
		int dep = 0;
		for(int i = 0; i < ListaDepartamentos.getListaString().length; i ++) {
			if(ListaDepartamentos.getListaString()[i].equals(Aplicacion.getUsuario().getLocalidad().getDepartamento().getNombre())) {
				dep=i;
			}
		}
		modeloDepartamentos.setSelectedItem(modeloDepartamentos.getElementAt(dep));
		localidad = 0;
		for(int i = 0; i < ListaLocalidades.getListaString(dep+1).length; i ++) {
			if(ListaLocalidades.getListaString(dep+1)[i].equals(Aplicacion.getUsuario().getLocalidad().getNombre())) {
				localidad=i;
			}
		}
		
		int itr = 0;
		for(int i = 0; i < ListaItrs.getListaString().length; i ++) {
			if(ListaItrs.getListaString()[i].equals(Aplicacion.getUsuario().getItr().getNombre())) {
				itr=i;
			}
		}
		modeloItr.setSelectedItem(modeloItr.getElementAt(itr));
		
		modeloLocalidades.setSelectedItem(modeloLocalidades.getElementAt(localidad));

	}
	
	public static void setAviso(String aviso) {
		aviso_1.setText(aviso);
	}
	
	public static void setAviso2(String aviso) {
		aviso_2.setText(aviso);
	}

	public static JTextField getNombre1Field() {
		return nombre1Field;
	}

	public static void setNombre1Field(JTextField nombre1Field) {
		PanelEditarMisDatos.nombre1Field = nombre1Field;
	}

	public static JTextField getNombre2Field() {
		return nombre2Field;
	}

	public static void setNombre2Field(JTextField nombre2Field) {
		PanelEditarMisDatos.nombre2Field = nombre2Field;
	}

	public static JTextField getApellido1Field() {
		return apellido1Field;
	}

	public static void setApellido1Field(JTextField apellido1Field) {
		PanelEditarMisDatos.apellido1Field = apellido1Field;
	}

	public static JTextField getApellido2Field() {
		return apellido2Field;
	}

	public static void setApellido2Field(JTextField apellido2Field) {
		PanelEditarMisDatos.apellido2Field = apellido2Field;
	}

	public static JTextField getCiField() {
		return ciField;
	}

	public static void setCiField(JTextField ciField) {
		PanelEditarMisDatos.ciField = ciField;
	}

	public static JTextField getPersonalField() {
		return personalField;
	}

	public static void setPersonalField(JTextField personalField) {
		PanelEditarMisDatos.personalField = personalField;
	}

	public static JTextField getInstitucionalField() {
		return institucionalField;
	}

	public static void setInstitucionalField(JTextField institucionalField) {
		PanelEditarMisDatos.institucionalField = institucionalField;
	}

	public static JTextField getTipo_usuario_field() {
		return tipo_usuario_field;
	}

	public static void setTipo_usuario_field(JTextField tipo_usuario_field) {
		PanelEditarMisDatos.tipo_usuario_field = tipo_usuario_field;
	}

	public static LinkedList<ControlCampo> getListaCampos() {
		return listaCampos;
	}

	public static void setListaCampos(LinkedList<ControlCampo> listaCampos) {
		PanelEditarMisDatos.listaCampos = listaCampos;
	}

	public RestrictedTextField getR_nom1() {
		return r_nom1;
	}

	public void setR_nom1(RestrictedTextField r_nom1) {
		this.r_nom1 = r_nom1;
	}

	public RestrictedTextField getR_nom2() {
		return r_nom2;
	}

	public void setR_nom2(RestrictedTextField r_nom2) {
		this.r_nom2 = r_nom2;
	}

	public RestrictedTextField getR_ape1() {
		return r_ape1;
	}

	public void setR_ape1(RestrictedTextField r_ape1) {
		this.r_ape1 = r_ape1;
	}

	public RestrictedTextField getR_ape2() {
		return r_ape2;
	}

	public void setR_ape2(RestrictedTextField r_ape2) {
		this.r_ape2 = r_ape2;
	}

	public RestrictedTextField getR_mail_pers() {
		return r_mail_pers;
	}

	public void setR_mail_pers(RestrictedTextField r_mail_pers) {
		this.r_mail_pers = r_mail_pers;
	}

	public RestrictedTextField getR_telef() {
		return r_telef;
	}

	public void setR_telef(RestrictedTextField r_telef) {
		this.r_telef = r_telef;
	}

	public RestrictedTextField getR_mail_instit() {
		return r_mail_instit;
	}

	public void setR_mail_instit(RestrictedTextField r_mail_instit) {
		this.r_mail_instit = r_mail_instit;
	}

	public static JTextField getTelefonoField() {
		return telefonoField;
	}

	public static void setTelefonoField(JTextField telefonoField) {
		PanelEditarMisDatos.telefonoField = telefonoField;
	}

	public static JComboBox<String> getDepartam_comboBox() {
		return departam_comboBox;
	}

	public static void setDepartam_comboBox(JComboBox<String> departam_comboBox) {
		PanelEditarMisDatos.departam_comboBox = departam_comboBox;
	}

	public static JComboBox<String> getLocalidad_comboBox() {
		return localidad_comboBox;
	}

	public static void setLocalidad_comboBox(JComboBox<String> localidad_comboBox) {
		PanelEditarMisDatos.localidad_comboBox = localidad_comboBox;
	}

	public int getLocalidad() {
		return localidad;
	}

	public void setLocalidad(int localidad) {
		this.localidad = localidad;
	}

	public static JLabel getAviso_1() {
		return aviso_1;
	}

	public static void setAviso_1(JLabel aviso_1) {
		PanelEditarMisDatos.aviso_1 = aviso_1;
	}

	public static DefaultComboBoxModel getModeloLocalidades() {
		return modeloLocalidades;
	}

	public static void setModeloLocalidades(DefaultComboBoxModel modeloLocalidades) {
		PanelEditarMisDatos.modeloLocalidades = modeloLocalidades;
	}

	public static JDateChooser getNacimientoDateChooser() {
		return nacimientoDateChooser;
	}

	public static void setNacimientoDateChooser(JDateChooser nacimientoDateChooser) {
		PanelEditarMisDatos.nacimientoDateChooser = nacimientoDateChooser;
	}
	
	public static JButton getBtn_reg_siguiente() {
		return btn_reg_siguiente;
	}

	public static void setBtn_reg_siguiente(JButton btn_reg_siguiente) {
		PanelEditarMisDatos.btn_reg_siguiente = btn_reg_siguiente;
	}

	public static JYearChooser getYearChooser() {
		return yearChooser;
	}

	public void setYearChooser(JYearChooser yearChooser) {
		this.yearChooser = yearChooser;
	}

	public static JComboBox<String> getItr_comboBox() {
		return itr_comboBox;
	}

	public static void setItr_comboBox(JComboBox<String> itr_comboBox) {
		PanelEditarMisDatos.itr_comboBox = itr_comboBox;
	}

	public static JComboBox<String> getRol_comboBox() {
		return rol_comboBox;
	}

	public static void setRol_comboBox(JComboBox<String> rol_comboBox) {
		PanelEditarMisDatos.rol_comboBox = rol_comboBox;
	}

	public static JComboBox<String> getArea_comboBox() {
		return area_comboBox;
	}

	public static void setArea_comboBox(JComboBox<String> area_comboBox) {
		PanelEditarMisDatos.area_comboBox = area_comboBox;
	}

	public static JLabel getAviso_2() {
		return aviso_2;
	}

	public static void setAviso_2(JLabel aviso_2) {
		PanelEditarMisDatos.aviso_2 = aviso_2;
	}

	public static JPasswordField getNewPasswordField() {
		return newPasswordField;
	}

	public static void setNewPasswordField(JPasswordField newPasswordField) {
		PanelEditarMisDatos.newPasswordField = newPasswordField;
	}

	public static JPasswordField getRepNewPasswordField() {
		return repNewPasswordField;
	}

	public static void setRepNewPasswordField(JPasswordField repNewPasswordField) {
		PanelEditarMisDatos.repNewPasswordField = repNewPasswordField;
	}

	public static JPasswordField getPasswordField() {
		return passwordField;
	}

	public static void setPasswordField(JPasswordField passwordField) {
		PanelEditarMisDatos.passwordField = passwordField;
	}
	
	
}
