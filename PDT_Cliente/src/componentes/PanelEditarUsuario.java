package componentes;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JComboBox;

import com.entities.Departamento;
import com.entities.Usuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

import interfaz.PanelFondo;
import listas.ListaAreas;
import listas.ListaDepartamentos;
import listas.ListaItrs;
import listas.ListaLocalidades;
import listas.ListaTiposTutor;
import listas.ListaTiposUsuario;

import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JYearChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import controladores.ControlBotonEditarMisDatos;
import controladores.ControlBotonEditarUsuario;
import controladores.Control_longit_min;
import controladores.VisibilidadCampos;
import interfaces.ControlCampo;

public class PanelEditarUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField nombre1Field;
	private static JTextField nombre2Field;
	private static JTextField apellido1Field;
	private static JTextField apellido2Field;
	private static JTextField ciField;
	private static JTextField personalField;
	private static JTextField institucionalField;
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
	protected static DefaultComboBoxModel<String> modeloLocalidades;
	private static JYearChooser yearChooser;
	private static JComboBox<String> itr_comboBox;
	private static JComboBox<String> rol_comboBox;
	private static JComboBox<String> area_comboBox;
	private static Usuario usuario;
	int iconStatus = 0;
	private static JComboBox<String> tipo_usu_comboBox;
	private static DefaultComboBoxModel<String> modeloTipoUsuario;
	private static DefaultComboBoxModel<String> modeloItr;
	private static DefaultComboBoxModel<String> modeloTipos;
	private static DefaultComboBoxModel<String> modeloDepartamentos;
	private static DefaultComboBoxModel<String> modeloAreas;
	private static JLabel rol_label;
	private static JLabel area_label;
	private static JLabel fec_ingreso_label;
	
	
	public PanelEditarUsuario() {
		setLayout(null);
		
		PanelFondo panelFondo = new PanelFondo("");
		panelFondo.setLayout(null);
		panelFondo.setBackground(SystemColor.menu);
		panelFondo.setBounds(0, 0, 927, 698);
		add(panelFondo);
		
		JLabel label = new JLabel("New label");
		label.setBounds(0, 0, 0, 0);
		panelFondo.add(label);
		
		JLabel tipo_usu_label = new JLabel("Tipo de usuario *");
		tipo_usu_label.setHorizontalAlignment(SwingConstants.TRAILING);
		tipo_usu_label.setFont(new Font("Tahoma", Font.BOLD, 12));
		tipo_usu_label.setBounds(367, 41, 116, 22);
		panelFondo.add(tipo_usu_label);
		
		JLabel nom1_label = new JLabel("Primer nombre *");
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
						PanelEditarUsuario.modeloLocalidades = new DefaultComboBoxModel<>(ListaLocalidades.getListaString(id));
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
		ComboBoxModel<String> modeloLocalidades = new DefaultComboBoxModel<>(ListaLocalidades.getListaString(departam_comboBox.getSelectedIndex()+1));
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
		
		btn_reg_siguiente.addActionListener(new ControlBotonEditarUsuario());
		
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
		
		tipo_usu_comboBox = new JComboBox<String>();
		tipo_usu_comboBox.setBorder(new LineBorder(new Color(0, 178, 240), 1, true));
		tipo_usu_comboBox
				.setToolTipText("Te registras como estudiante? Como tutor? O como analista?. Elige aqu\u00ED.");
		tipo_usu_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tipo_usu_comboBox.setBounds(497, 41, 162, 22);
		tipo_usu_comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		modeloTipoUsuario = new DefaultComboBoxModel<>(ListaTiposUsuario.getListaString());
		tipo_usu_comboBox.setModel(modeloTipoUsuario);
		tipo_usu_comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 2) {
					VisibilidadCampos.cambiarVisibilidadEditarUsuario();
				}
			}
		});
		panelFondo.add(tipo_usu_comboBox);
		
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
						
	}
	
	public static void estasblecerDadtos() {
		
		if(usuario.getTipoUsuario().getNombre().equals("TUTOR")) {
			area_label.setVisible(true);
			area_comboBox.setVisible(true);
			rol_comboBox.setVisible(true);
			rol_label.setVisible(true);
			int area = 0;
			for(int i = 0; i < ListaAreas.getListaString().length; i ++) {
				if(ListaAreas.getListaString()[i].equals(usuario.getArea().getNombre())) {
					area=i;
				}
			}
			modeloAreas.setSelectedItem(modeloAreas.getElementAt(area));
			int tipos = 0;
			for(int i = 0; i < ListaTiposTutor.getListaString().length; i ++) {
				if(ListaTiposTutor.getListaString()[i].equals(usuario.getTipoTutor().getNombre())) {
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
		if(usuario.getTipoUsuario().getNombre().equals("ESTUDIANTE")) {
			fec_ingreso_label.setVisible(true);
			yearChooser.setVisible(true);
			yearChooser.setYear(usuario.getGeneracion().getAno().intValue());
		}else{
			fec_ingreso_label.setVisible(false);
			yearChooser.setVisible(false);
		}
		
		
		nombre1Field.setText(usuario.getNombre1());
		nacimientoDateChooser.setDate(usuario.getFechaNacimiento());
		institucionalField.setText(usuario.getCorreoInstitucional());
		personalField.setText(usuario.getCorreoPersonal());
		telefonoField.setText(usuario.getTelefono());
		ciField.setText(usuario.getDocumento().getCaracteres());
		apellido2Field.setText(usuario.getApellido2());
		apellido1Field.setText(usuario.getApellido1());
		nombre2Field.setText(usuario.getNombre2());
				
		int dep = 0;
		for(int i = 0; i < ListaDepartamentos.getListaString().length; i ++) {
			if(ListaDepartamentos.getListaString()[i].equals(usuario.getLocalidad().getDepartamento().getNombre())) {
				dep=i;
			}
		}
		modeloDepartamentos.setSelectedItem(modeloDepartamentos.getElementAt(dep));
		localidad = 0;
		for(int i = 0; i < ListaLocalidades.getListaString(dep+1).length; i ++) {
			if(ListaLocalidades.getListaString(dep+1)[i].equals(usuario.getLocalidad().getNombre())) {
				localidad=i;
			}
		}
		
		int itr = 0;
		for(int i = 0; i < ListaItrs.getListaString().length; i ++) {
			if(ListaItrs.getListaString()[i].equals(usuario.getItr().getNombre())) {
				itr=i;
			}
		}
		modeloItr.setSelectedItem(modeloItr.getElementAt(itr));
		int tipo = 0;
		for(int i = 0; i < ListaTiposUsuario.getListaString().length; i ++) {
			if(ListaTiposUsuario.getListaString()[i].equals(usuario.getTipoUsuario().getNombre())) {
				itr=i;
			}
		}
		modeloTipoUsuario.setSelectedItem(modeloTipoUsuario.getElementAt(itr));
		modeloLocalidades.setSelectedItem(modeloLocalidades.getElementAt(localidad));
		
	}

	public static void setAviso(String aviso) {
		aviso_1.setText(aviso);
	}
	
	public static JTextField getNombre1Field() {
		return nombre1Field;
	}

	public static void setNombre1Field(JTextField nombre1Field) {
		PanelEditarUsuario.nombre1Field = nombre1Field;
	}

	public static JTextField getNombre2Field() {
		return nombre2Field;
	}

	public static void setNombre2Field(JTextField nombre2Field) {
		PanelEditarUsuario.nombre2Field = nombre2Field;
	}

	public static JTextField getApellido1Field() {
		return apellido1Field;
	}

	public static void setApellido1Field(JTextField apellido1Field) {
		PanelEditarUsuario.apellido1Field = apellido1Field;
	}

	public static JTextField getApellido2Field() {
		return apellido2Field;
	}

	public static void setApellido2Field(JTextField apellido2Field) {
		PanelEditarUsuario.apellido2Field = apellido2Field;
	}

	public static JTextField getCiField() {
		return ciField;
	}

	public static void setCiField(JTextField ciField) {
		PanelEditarUsuario.ciField = ciField;
	}

	public static JTextField getPersonalField() {
		return personalField;
	}

	public static void setPersonalField(JTextField personalField) {
		PanelEditarUsuario.personalField = personalField;
	}

	public static JTextField getInstitucionalField() {
		return institucionalField;
	}

	public static void setInstitucionalField(JTextField institucionalField) {
		PanelEditarUsuario.institucionalField = institucionalField;
	}

	public static LinkedList<ControlCampo> getListaCampos() {
		return listaCampos;
	}

	public static void setListaCampos(LinkedList<ControlCampo> listaCampos) {
		PanelEditarUsuario.listaCampos = listaCampos;
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
		PanelEditarUsuario.telefonoField = telefonoField;
	}

	public static JComboBox<String> getDepartam_comboBox() {
		return departam_comboBox;
	}

	public static void setDepartam_comboBox(JComboBox<String> departam_comboBox) {
		PanelEditarUsuario.departam_comboBox = departam_comboBox;
	}

	public static JComboBox<String> getLocalidad_comboBox() {
		return localidad_comboBox;
	}

	public static void setLocalidad_comboBox(JComboBox<String> localidad_comboBox) {
		PanelEditarUsuario.localidad_comboBox = localidad_comboBox;
	}

	public int getLocalidad() {
		return localidad;
	}

	public void setLocalidad(int localidad) {
		PanelEditarUsuario.localidad = localidad;
	}

	public static JLabel getAviso_1() {
		return aviso_1;
	}

	public static void setAviso_1(JLabel aviso_1) {
		PanelEditarUsuario.aviso_1 = aviso_1;
	}

	public static DefaultComboBoxModel<String> getModeloLocalidades() {
		return modeloLocalidades;
	}

	public static void setModeloLocalidades(DefaultComboBoxModel<String> modeloLocalidades) {
		PanelEditarUsuario.modeloLocalidades = modeloLocalidades;
	}

	public static JDateChooser getNacimientoDateChooser() {
		return nacimientoDateChooser;
	}

	public static void setNacimientoDateChooser(JDateChooser nacimientoDateChooser) {
		PanelEditarUsuario.nacimientoDateChooser = nacimientoDateChooser;
	}
	
	public static JButton getBtn_reg_siguiente() {
		return btn_reg_siguiente;
	}

	public static void setBtn_reg_siguiente(JButton btn_reg_siguiente) {
		PanelEditarUsuario.btn_reg_siguiente = btn_reg_siguiente;
	}

	public static JYearChooser getYearChooser() {
		return yearChooser;
	}

	public void setYearChooser(JYearChooser yearChooser) {
		PanelEditarUsuario.yearChooser = yearChooser;
	}

	public static JComboBox<String> getTipo_usu_comboBox() {
		return tipo_usu_comboBox;
	}

	public void setTipo_usu_comboBox(JComboBox<String> tipo_usu_comboBox) {
		this.tipo_usu_comboBox = tipo_usu_comboBox;
	}

	public static DefaultComboBoxModel<String> getModeloTipoUsuario() {
		return modeloTipoUsuario;
	}

	public static void setModeloTipoUsuario(DefaultComboBoxModel<String> modeloTipoUsuario) {
		PanelEditarUsuario.modeloTipoUsuario = modeloTipoUsuario;
	}

	public static DefaultComboBoxModel<String> getModeloItr() {
		return modeloItr;
	}

	public static void setModeloItr(DefaultComboBoxModel<String> modeloItr) {
		PanelEditarUsuario.modeloItr = modeloItr;
	}

	public static DefaultComboBoxModel<String> getModeloTipos() {
		return modeloTipos;
	}

	public static void setModeloTipos(DefaultComboBoxModel<String> modeloTipos) {
		PanelEditarUsuario.modeloTipos = modeloTipos;
	}

	public static DefaultComboBoxModel<String> getModeloDepartamentos() {
		return modeloDepartamentos;
	}

	public static void setModeloDepartamentos(DefaultComboBoxModel<String> modeloDepartamentos) {
		PanelEditarUsuario.modeloDepartamentos = modeloDepartamentos;
	}

	public static DefaultComboBoxModel<String> getModeloAreas() {
		return modeloAreas;
	}

	public static void setModeloAreas(DefaultComboBoxModel<String> modeloAreas) {
		PanelEditarUsuario.modeloAreas = modeloAreas;
	}

	public static JLabel getRol_label() {
		return rol_label;
	}

	public static void setRol_label(JLabel rol_label) {
		PanelEditarUsuario.rol_label = rol_label;
	}

	public static JLabel getArea_label() {
		return area_label;
	}

	public static void setArea_label(JLabel area_label) {
		PanelEditarUsuario.area_label = area_label;
	}

	public static JLabel getFec_ingreso_label() {
		return fec_ingreso_label;
	}

	public static void setFec_ingreso_label(JLabel fec_ingreso_label) {
		PanelEditarUsuario.fec_ingreso_label = fec_ingreso_label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static JComboBox<String> getItr_comboBox() {
		return itr_comboBox;
	}

	public static void setItr_comboBox(JComboBox<String> itr_comboBox) {
		PanelEditarUsuario.itr_comboBox = itr_comboBox;
	}

	public static JComboBox<String> getRol_comboBox() {
		return rol_comboBox;
	}

	public static void setRol_comboBox(JComboBox<String> rol_comboBox) {
		PanelEditarUsuario.rol_comboBox = rol_comboBox;
	}

	public static JComboBox<String> getArea_comboBox() {
		return area_comboBox;
	}

	public static void setArea_comboBox(JComboBox<String> area_comboBox) {
		PanelEditarUsuario.area_comboBox = area_comboBox;
	}

	public static Usuario getUsuario() {
		return usuario;
	}

	public static void setUsuario(Usuario usuario) {
		PanelEditarUsuario.usuario = usuario;
	}
	
}
