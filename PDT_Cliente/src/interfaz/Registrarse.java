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
import java.awt.Dimension;

import javax.naming.NamingException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;

import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import controladores.ControlBotonEnviar;
import controladores.Control_anio_ingreso;
import controladores.Control_longit_min;
import controladores.VisibilidadCampos;
import interfaces.ControlCampo;
import listas.ListaAreas;
import listas.ListaDepartamentos;
import listas.ListaItrs;
import listas.ListaLocalidades;
import listas.ListaTipos;

import com.entities.Departamento;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemEvent;

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
	private static JDateChooser dateChooser;
	private static JYearChooser yearChooser;
	private static JComboBox<String> area_comboBox;
	
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
	private static JLabel fec_ingreso_label;
	private static JLabel rol_label;
	private static JLabel asterisco_label_14_1;
	private static JLabel asterisco_label_1;
	private static JLabel area_label;
	private static JLabel asterisco_label_15_1;
	
	private static boolean registro = false;
	
	public static boolean getRegistro() {
		return registro;
	}
	
	public static void setRegistro(boolean registro) {
		Registrarse.registro = registro;
	}
	
	public Registrarse() throws NamingException {
		
		cerrar();
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Registrarse.class.getResource("/recursos/imagenes/09-Isotipo-1.png")));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    setBounds(new Rectangle((width-610)/2, (height-550)/2, 610, 550));
		setResizable(false);
		setTitle("Registro de nuevo usuario");

		JPanel panelPrincipal = new JPanel();
		this.setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelArriba = new JPanel();
		panelArriba.setBounds(new Rectangle(0, 0, 600, 100));
		panelArriba.setBounds(0, 0, 594, 62);
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
		panelFondo.setBackground(new Color(240, 240, 240));
		panelFondo.setBounds(0, 59, 594, 439);
		panelFondo.setLayout(null);
		panelPrincipal.add(panelFondo);

		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		panelFondo.add(label);

		JLabel tipo_usu_label = new JLabel("Tipo de usuario");
		tipo_usu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		tipo_usu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipo_usu_label.setBounds(84, 44, 116, 21);
		panelFondo.add(tipo_usu_label);

		tipo_usu_comboBox = new JComboBox<String>();
		tipo_usu_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		tipo_usu_comboBox
				.setToolTipText("Te registras como estudiante? Como tutor? O como analista?. Elige aqu\u00ED.");
		tipo_usu_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tipo_usu_comboBox.setBounds(235, 43, 130, 22);
		tipo_usu_comboBox.addItem("ANALISTA");
		tipo_usu_comboBox.addItem("ESTUDIANTE");
		tipo_usu_comboBox.addItem("TUTOR");
		tipo_usu_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 2) {
					VisibilidadCampos.cambiarVisibilidad();
				}
			}
		});
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
		nom1_field.setBounds(161, 97, 130, 21);
		panelFondo.add(nom1_field);
		nom1_field.setColumns(10);

		JLabel asterisco_label = new JLabel("*");
		asterisco_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label.setForeground(new Color(255, 0, 0));
		asterisco_label.setBounds(210, 43, 15, 21);
		panelFondo.add(asterisco_label);

		JLabel asterisco_label_2 = new JLabel("*");
		asterisco_label_2.setForeground(Color.RED);
		asterisco_label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_2.setBounds(136, 96, 15, 21);
		panelFondo.add(asterisco_label_2);

		JLabel nom2_label = new JLabel("Segundo nombre");
		nom2_label.setHorizontalAlignment(SwingConstants.TRAILING);
		nom2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		nom2_label.setBounds(303, 97, 116, 21);
		panelFondo.add(nom2_label);

		nom2_field = new JTextField();
		nom2_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		nom2_field.setToolTipText("Ingresa aqu\u00ED tu segundo nombre. (Opcional)");
		nom2_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nom2_field.setColumns(10);
		nom2_field.setBounds(454, 97, 130, 21);
		panelFondo.add(nom2_field);

		JLabel ape1_label = new JLabel("Primer apellido");
		ape1_label.setHorizontalAlignment(SwingConstants.TRAILING);
		ape1_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ape1_label.setBounds(10, 130, 116, 21);
		panelFondo.add(ape1_label);

		ape1_field = new JTextField();
		ape1_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		ape1_field.setToolTipText("Ingresa aqu\u00ED tu primer apellido.");
		ape1_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ape1_field.setColumns(10);
		ape1_field.setBounds(161, 130, 130, 21);
		panelFondo.add(ape1_field);

		JLabel asterisco_label_3 = new JLabel("*");
		asterisco_label_3.setForeground(Color.RED);
		asterisco_label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_3.setBounds(136, 129, 15, 21);
		panelFondo.add(asterisco_label_3);

		JLabel ape2_label = new JLabel("Segundo apellido");
		ape2_label.setHorizontalAlignment(SwingConstants.TRAILING);
		ape2_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		ape2_label.setBounds(303, 129, 116, 21);
		panelFondo.add(ape2_label);

		ape2_field = new JTextField();
		ape2_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		ape2_field.setToolTipText("Ingresa aqu\u00ED tu segundo apellido. (Opcional)");
		ape2_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ape2_field.setColumns(10);
		ape2_field.setBounds(454, 129, 130, 21);
		panelFondo.add(ape2_field);

		JLabel cedu_label = new JLabel("C\u00E9dula");
		cedu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		cedu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		cedu_label.setBounds(10, 166, 116, 21);
		panelFondo.add(cedu_label);

		cedu_field = new JTextField();
		cedu_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		cedu_field.setToolTipText("Ingresa aqu\u00ED tu n\u00FAmero de documento sin espacios, puntos ni guiones.");
		cedu_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cedu_field.setColumns(10);
		cedu_field.setBounds(161, 166, 130, 21);
		panelFondo.add(cedu_field);

		JLabel asterisco_label_4 = new JLabel("*");
		asterisco_label_4.setForeground(Color.RED);
		asterisco_label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_4.setBounds(136, 165, 15, 21);
		panelFondo.add(asterisco_label_4);

		JLabel fec_nac_label = new JLabel("Fecha nacimiento");
		fec_nac_label.setHorizontalAlignment(SwingConstants.TRAILING);
		fec_nac_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		fec_nac_label.setBounds(303, 166, 116, 21);
		panelFondo.add(fec_nac_label);

		JLabel asterisco_label_5 = new JLabel("*");
		asterisco_label_5.setForeground(Color.RED);
		asterisco_label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_5.setBounds(429, 165, 15, 21);
		panelFondo.add(asterisco_label_5);

		JLabel email_pers_label = new JLabel("E-mail personal");
		email_pers_label.setHorizontalAlignment(SwingConstants.TRAILING);
		email_pers_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_pers_label.setBounds(10, 199, 116, 21);
		panelFondo.add(email_pers_label);

		mail_pers_field = new JTextField();
		mail_pers_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		mail_pers_field.setToolTipText("Ingresa aqu\u00ED tu e-mail personal. ej. juanperez@gmail.com.");
		mail_pers_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mail_pers_field.setColumns(10);
		mail_pers_field.setBounds(161, 199, 130, 21);
		panelFondo.add(mail_pers_field);

		JLabel asterisco_label_6 = new JLabel("*");
		asterisco_label_6.setForeground(Color.RED);
		asterisco_label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_6.setBounds(136, 198, 15, 21);
		panelFondo.add(asterisco_label_6);

		JLabel telef_label = new JLabel("Tel\u00E9fono");
		telef_label.setHorizontalAlignment(SwingConstants.TRAILING);
		telef_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		telef_label.setBounds(303, 199, 116, 21);
		panelFondo.add(telef_label);

		telef_field = new JTextField();
		telef_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		telef_field.setToolTipText("Ingresa aqu\u00ED tu tel\u00E9fono.");
		telef_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		telef_field.setColumns(10);
		telef_field.setBounds(454, 199, 130, 21);
		panelFondo.add(telef_field);

		JLabel departamento_label = new JLabel("Departamento");
		departamento_label.setHorizontalAlignment(SwingConstants.TRAILING);
		departamento_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		departamento_label.setBounds(10, 232, 116, 21);
		panelFondo.add(departamento_label);

		departam_comboBox = new JComboBox<String>();
		
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
					ComboBoxModel<String> modeloLocalidades = new DefaultComboBoxModel<>(ListaLocalidades.getListaString(id));
					localidad_comboBox.setModel(modeloLocalidades);
				}
			}
		});
		
		departam_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		departam_comboBox.setToolTipText("Elige el departamento donde resides.");
		departam_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		departam_comboBox.setBounds(161, 231, 130, 22);
		ComboBoxModel<String> modeloDepartamentos = new DefaultComboBoxModel<>(ListaDepartamentos.getListaString());
		departam_comboBox.setModel(modeloDepartamentos);		
		panelFondo.add(departam_comboBox);		
		
		JLabel asterisco_label_7 = new JLabel("*");
		asterisco_label_7.setForeground(Color.RED);
		asterisco_label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_7.setBounds(429, 198, 15, 21);
		panelFondo.add(asterisco_label_7);

		JLabel asterisco_label_8 = new JLabel("*");
		asterisco_label_8.setForeground(Color.RED);
		asterisco_label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_8.setBounds(136, 231, 15, 21);
		panelFondo.add(asterisco_label_8);

		localidad_comboBox = new JComboBox<String>();
		localidad_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		localidad_comboBox.setToolTipText("Elige la localidad (pueblo, villa) donde resides.");
		localidad_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		localidad_comboBox.setBounds(454, 231, 130, 22);	
		ComboBoxModel<String> modeloLocalidades = new DefaultComboBoxModel<>(ListaLocalidades.getListaString(1));
		localidad_comboBox.setModel(modeloLocalidades);			
		panelFondo.add(localidad_comboBox);

		JLabel localidad_label = new JLabel("Localidad");
		localidad_label.setHorizontalAlignment(SwingConstants.TRAILING);
		localidad_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		localidad_label.setBounds(303, 232, 116, 21);
		panelFondo.add(localidad_label);

		JLabel asterisco_label_9 = new JLabel("*");
		asterisco_label_9.setForeground(Color.RED);
		asterisco_label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_9.setBounds(429, 231, 15, 21);
		panelFondo.add(asterisco_label_9);

		JLabel email_instit_label = new JLabel("E-mail institucional");
		email_instit_label.setHorizontalAlignment(SwingConstants.TRAILING);
		email_instit_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_instit_label.setBounds(10, 272, 116, 21);
		panelFondo.add(email_instit_label);

		mail_instit_field = new JTextField();
		mail_instit_field.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		mail_instit_field
				.setToolTipText("Ingresa aqu\u00ED tu e-mail institucional. ej. juan.perez@estudiantes.utec.edu.uy.");
		mail_instit_field.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mail_instit_field.setColumns(10);
		mail_instit_field.setBounds(161, 272, 130, 21);
		panelFondo.add(mail_instit_field);

		JLabel asterisco_label_10 = new JLabel("*");
		asterisco_label_10.setForeground(Color.RED);
		asterisco_label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_10.setBounds(136, 271, 15, 21);
		panelFondo.add(asterisco_label_10);

		JLabel itr_label = new JLabel("I.T.R.");
		itr_label.setHorizontalAlignment(SwingConstants.TRAILING);
		itr_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		itr_label.setBounds(303, 272, 116, 21);
		panelFondo.add(itr_label);

		itr_comboBox = new JComboBox<String>();
		itr_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		itr_comboBox.setToolTipText("Elige el ITR (Instituto Tecnol\u00F3gico Regional, ej. ITR Durazno).");
		itr_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		itr_comboBox.setBounds(454, 271, 130, 22);
		ComboBoxModel<String> modeloItr = new DefaultComboBoxModel<>(ListaItrs.getListaString());
		itr_comboBox.setModel(modeloItr);
		panelFondo.add(itr_comboBox);

		fec_ingreso_label = new JLabel("A\u00F1o de ingreso");
		fec_ingreso_label.setHorizontalAlignment(SwingConstants.TRAILING);
		fec_ingreso_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		fec_ingreso_label.setBounds(10, 314, 116, 21);
		panelFondo.add(fec_ingreso_label);

		JLabel asterisco_label_13 = new JLabel("*");
		asterisco_label_13.setForeground(Color.RED);
		asterisco_label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_13.setBounds(429, 271, 15, 21);
		panelFondo.add(asterisco_label_13);

		asterisco_label_1 = new JLabel("*");
		asterisco_label_1.setForeground(Color.RED);
		asterisco_label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_1.setBounds(136, 313, 15, 21);
		panelFondo.add(asterisco_label_1);

		rol_label = new JLabel("Rol");
		rol_label.setHorizontalAlignment(SwingConstants.TRAILING);
		rol_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		rol_label.setBounds(303, 313, 116, 21);
		panelFondo.add(rol_label);

		rol_comboBox = new JComboBox<String>();
		rol_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		rol_comboBox.setToolTipText("Selecciona el rol que asumir\u00E1s.");
		rol_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rol_comboBox.setBounds(454, 313, 130, 22);
		ComboBoxModel<String> modeloTipos = new DefaultComboBoxModel<>(ListaTipos.getListaString());		
		rol_comboBox.setModel(modeloTipos);	
		panelFondo.add(rol_comboBox);
		
		area_label = new JLabel("Area");
		area_label.setHorizontalAlignment(SwingConstants.TRAILING);
		area_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		area_label.setBounds(10, 314, 116, 21);
		panelFondo.add(area_label);
		
		asterisco_label_15_1 = new JLabel("*");
		asterisco_label_15_1.setForeground(Color.RED);
		asterisco_label_15_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_15_1.setBounds(136, 313, 15, 21);
		panelFondo.add(asterisco_label_15_1);
		
		area_comboBox = new JComboBox<String>();
		area_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		area_comboBox.setToolTipText("Selecciona el área a la que perteneces.");
		area_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		area_comboBox.setBounds(161, 315, 130, 20);
		ComboBoxModel<String> modeloAreas = new DefaultComboBoxModel<>(ListaAreas.getListaString());		
		area_comboBox.setModel(modeloAreas);
		panelFondo.add(area_comboBox);

		asterisco_label_14_1 = new JLabel("*");
		asterisco_label_14_1.setForeground(Color.RED);
		asterisco_label_14_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		asterisco_label_14_1.setBounds(429, 313, 15, 21);
		panelFondo.add(asterisco_label_14_1);

		aviso = new JLabel("Los campos marcados con (*) son obligatorios");
		aviso.setForeground(new Color(255, 0, 0));
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setFont(new Font("Tahoma", Font.BOLD, 10));
		aviso.setBounds(10, 352, 327, 21);
		panelFondo.add(aviso);

		btn_reg_siguiente = new JButton("Siguiente");
		btn_reg_siguiente.setFocusable(false);
		btn_reg_siguiente.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		btn_reg_siguiente.setForeground(new Color(255, 255, 255));
		btn_reg_siguiente.setBackground(new Color(0, 178, 240));
		btn_reg_siguiente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_reg_siguiente.setBounds(235, 395, 130, 23);
		btn_reg_siguiente.setEnabled(false);
		btn_reg_siguiente
				.setToolTipText("El botón se activar cuando los campos obligatorios estén completos y correctos.");
		panelFondo.add(btn_reg_siguiente);

		JPanel panel_gris = new JPanel();
		panel_gris.setBackground(new Color(192, 192, 192));
		panel_gris.setBounds(292, 0, 302, 32);
		panelFondo.add(panel_gris);

		JLabel lblNewLabel = new JLabel("Registro de usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setBackground(new Color(0, 178, 240));
		lblNewLabel.setBounds(0, 0, 296, 32);
		panelFondo.add(lblNewLabel);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(454, 166, 130, 20);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		panelFondo.add(dateChooser);

		yearChooser = new JYearChooser();
		yearChooser.setBounds(161, 315, 130, 20);
		new Control_anio_ingreso(2014);
		panelFondo.add(yearChooser);

		r_nom1 = new RestrictedTextField(Registrarse.nom1_field);
		r_nom1.setOnlyText(true);
		r_nom1.setAcceptSpace(true);
		r_nom1.setLimit(16);
		Control_longit_min c_nom1 = new Control_longit_min(nom1_field, 2);
		nom1_field.getDocument().addDocumentListener(c_nom1);

		r_nom2 = new RestrictedTextField(Registrarse.nom2_field);
		r_nom2.setOnlyText(true);
		r_nom2.setAcceptSpace(true);
		r_nom2.setLimit(16);
		Control_longit_min c_nom2 = new Control_longit_min(nom2_field, 2);
		nom2_field.getDocument().addDocumentListener(c_nom2);

		r_ape1 = new RestrictedTextField(Registrarse.ape1_field);
		r_ape1.setOnlyText(true);
		r_ape1.setAcceptSpace(true);
		r_ape1.setLimit(16);
		Control_longit_min c_ape1 = new Control_longit_min(ape1_field, 2);
		ape1_field.getDocument().addDocumentListener(c_ape1);

		r_ape2 = new RestrictedTextField(Registrarse.ape2_field);
		r_ape2.setOnlyText(true);
		r_ape2.setAcceptSpace(true);
		r_ape2.setLimit(16);
		Control_longit_min c_ape2 = new Control_longit_min(ape2_field, 2);
		ape2_field.getDocument().addDocumentListener(c_ape2);

		r_cedu = new RestrictedTextField(Registrarse.cedu_field);
		r_cedu.setOnlyNums(true);
		r_cedu.setLimit(8);
		Control_longit_min c_cedu = new Control_longit_min(cedu_field, 8);
		cedu_field.getDocument().addDocumentListener(c_cedu);

		r_mail_pers = new RestrictedTextField(Registrarse.mail_pers_field);
		r_mail_pers.setLimit(30);
		Control_longit_min c_mail_pers = new Control_longit_min(mail_pers_field, 12);
		mail_pers_field.getDocument().addDocumentListener(c_mail_pers);

		r_telef = new RestrictedTextField(Registrarse.telef_field);
		r_telef.setOnlyNums(true);
		r_telef.setLimit(12);
		Control_longit_min c_telef = new Control_longit_min(telef_field, 8);
		telef_field.getDocument().addDocumentListener(c_telef);

		r_mail_instit = new RestrictedTextField(Registrarse.mail_instit_field);
		r_mail_instit.setLimit(60);
		Control_longit_min c_mail_instit = new Control_longit_min(mail_instit_field, 15);
		mail_instit_field.getDocument().addDocumentListener(c_mail_instit);

		listaCampos = new LinkedList<ControlCampo>();
		listaCampos.add(c_nom1);
		listaCampos.add(c_ape1);
		listaCampos.add(c_cedu);
		listaCampos.add(c_mail_pers);
		listaCampos.add(c_telef);
		listaCampos.add(c_mail_instit);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		btn_reg_siguiente.addActionListener(new ControlBotonEnviar());
		VisibilidadCampos.cambiarVisibilidad();
		
	}
	
	public static JComboBox<String> getArea_comboBox() {
		return area_comboBox;
	}

	public static JLabel getArea_label() {
		return area_label;
	}

	public static JLabel getAsterisco_label_15_1() {
		return asterisco_label_15_1;
	}

	public static JLabel getAsterisco_label_1() {
		return asterisco_label_1;
	}

	public static JLabel getFec_ingreso_label() {
		return fec_ingreso_label;
	}

	public static JLabel getRol_label() {
		return rol_label;
	}

	public static JLabel getAsterisco_label_14_1() {
		return asterisco_label_14_1;
	}

	public static JDateChooser getDateChooser() {
		return dateChooser;
	}

	public static JYearChooser getYearChooser() {
		return yearChooser;
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
	
	private void cerrar() {
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {		
				dispose();
				new Login();
			}
		});
		
	}
	
	public static void limpiar() {
		nom1_field.setText("");
		nom2_field.setText("");
		ape1_field.setText("");
		ape2_field.setText("");
		cedu_field.setText("");
		mail_instit_field.setText("");
		mail_pers_field.setText("");
		tipo_usu_comboBox.setSelectedIndex(0);
		departam_comboBox.setSelectedIndex(0);
		localidad_comboBox.setSelectedIndex(0);
		dateChooser.setDate(null);
		yearChooser.setYear(2023);
		itr_comboBox.setSelectedIndex(0);
		area_comboBox.setSelectedIndex(0);
		rol_comboBox.setSelectedIndex(0);
		telef_field.setText("");
	}
	
}