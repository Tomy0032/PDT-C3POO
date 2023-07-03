package componentes;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

public class PanelNuevoReclamo extends JPanel{
	
	private JLabel tituloPanel;
	private JTextField titulo;
	private JTextArea descripcion;

	
	private JRadioButton radioVME,
	                     radioOptativa;
	private JComboBox<String> nombreVME,
			          nombreAPEuOptativa;
	
	private JRadioButton semestre1,
						 semestre2,
						 semestre3,
						 semestre4,
						 semestre5,
						 semestre6,
						 semestre7,
						 semestre8;

	private JComboBox<String> docente;
	private JSpinner spinnerCreditos;
	private JCalendar FechaEventoCreditos;
	private JButton btnReclamar;
		
	public JTextArea getDescripcion() {
		return descripcion;
	}

	public JRadioButton getRadioVME() {
		return radioVME;
	}

	public JRadioButton getRadioOptativa() {
		return radioOptativa;
	}

	public JComboBox<String> getNombreVME() {
		return nombreVME;
	}

	public JComboBox<String> getNombreAPEuOptativa() {
		return nombreAPEuOptativa;
	}

	public JRadioButton getSemestre1() {
		return semestre1;
	}

	public JRadioButton getSemestre2() {
		return semestre2;
	}

	public JRadioButton getSemestre3() {
		return semestre3;
	}

	public JRadioButton getSemestre4() {
		return semestre4;
	}

	public JRadioButton getSemestre5() {
		return semestre5;
	}

	public JRadioButton getSemestre6() {
		return semestre6;
	}

	public JRadioButton getSemestre7() {
		return semestre7;
	}

	public JRadioButton getSemestre8() {
		return semestre8;
	}

	public JComboBox<String> getDocente() {
		return docente;
	}

	public JSpinner getSpinnerCreditos() {
		return spinnerCreditos;
	}

	public JButton getBtnReclamar() {
		return btnReclamar;
	}

	
	public PanelNuevoReclamo() {
		
		setLayout(null);
		
		tituloPanel = new JLabel("NUEVO RECLAMO");
		tituloPanel.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tituloPanel.setBounds(356,27,268,25);
		add(tituloPanel);
		
		JLabel lblTituloReclamo = new JLabel("T\u00EDtulo del reclamo");
		lblTituloReclamo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTituloReclamo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTituloReclamo.setBounds(10, 62, 110, 25);
		add(lblTituloReclamo);
		
		titulo = new JTextField();
		titulo.setBounds(130,63,280,25);
		add(titulo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescripcion.setBounds(10, 97, 110, 25);
		add(lblDescripcion);
		
		descripcion = new JTextArea();
		descripcion.setLineWrap(true);
		JScrollPane scrollDescripcion = new JScrollPane(descripcion);
		scrollDescripcion.setBounds(130,98,280,120);
		scrollDescripcion.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(scrollDescripcion);
		
		
		
		JLabel lblVME = new JLabel("Evento VME");
		lblVME.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVME.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVME.setBounds(10, 224, 110, 25);
		add(lblVME);
		
		radioVME = new JRadioButton();
		radioVME.setSelected(true);
		radioVME.setBackground(Color.LIGHT_GRAY);
		radioVME.setBounds(130,224,21,25);
		add(radioVME);
		
		nombreVME = new JComboBox<String>();
		nombreVME.setBounds(161, 224, 249, 25);
		add(nombreVME);
		
		
		
		JLabel lblAPE = new JLabel("APE u Optativa");
		lblAPE.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAPE.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAPE.setBounds(10, 259, 110, 25);
		add(lblAPE);
		
		radioOptativa = new JRadioButton();
		radioOptativa.setBackground(Color.LIGHT_GRAY);
		radioOptativa.setBounds(130,259,21,25);
		add(radioOptativa);
		
		nombreAPEuOptativa = new JComboBox<String>();
		nombreAPEuOptativa.setBounds(161, 259, 249, 25);
		add(nombreAPEuOptativa);
		
		ButtonGroup grupoNombre = new ButtonGroup();
		grupoNombre.add(radioVME);
		grupoNombre.add(radioOptativa);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSemestre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSemestre.setBounds(10, 316, 110, 46);
		add(lblSemestre);
		
		semestre1 = new JRadioButton();
		semestre1.setSelected(true);
		semestre2 = new JRadioButton();
		semestre3 = new JRadioButton();
		semestre4 = new JRadioButton();
		semestre5 = new JRadioButton();		
		semestre6 = new JRadioButton();
		semestre7 = new JRadioButton();
		semestre8 = new JRadioButton();
		
		semestre1.setBounds(130,316,35,46);
		semestre2.setBounds(165,316,35,46);
		semestre3.setBounds(200,316,35,46);
		semestre4.setBounds(235,316,35,46);
		semestre5.setBounds(270,316,35,46);
		semestre6.setBounds(305,316,35,46);
		semestre7.setBounds(340,316,35,46);
		semestre8.setBounds(375,316,35,46);

		semestre1.setText("1");
		semestre2.setText("2");
		semestre3.setText("3");
		semestre4.setText("4");
		semestre5.setText("5");
		semestre6.setText("6");
		semestre7.setText("7");
		semestre8.setText("8");
		
		semestre1.setVerticalTextPosition(SwingConstants.TOP);
		semestre2.setVerticalTextPosition(SwingConstants.TOP);
		semestre3.setVerticalTextPosition(SwingConstants.TOP);
		semestre4.setVerticalTextPosition(SwingConstants.TOP);
		semestre5.setVerticalTextPosition(SwingConstants.TOP);
		semestre6.setVerticalTextPosition(SwingConstants.TOP);
		semestre7.setVerticalTextPosition(SwingConstants.TOP);
		semestre8.setVerticalTextPosition(SwingConstants.TOP);
		
		semestre1.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre2.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre3.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre4.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre5.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre6.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre7.setHorizontalTextPosition(SwingConstants.CENTER);
		semestre8.setHorizontalTextPosition(SwingConstants.CENTER);
		
		semestre1.setHorizontalAlignment(SwingConstants.CENTER);
		semestre2.setHorizontalAlignment(SwingConstants.CENTER);
		semestre3.setHorizontalAlignment(SwingConstants.CENTER);
		semestre4.setHorizontalAlignment(SwingConstants.CENTER);
		semestre5.setHorizontalAlignment(SwingConstants.CENTER);
		semestre6.setHorizontalAlignment(SwingConstants.CENTER);
		semestre7.setHorizontalAlignment(SwingConstants.CENTER);
		semestre8.setHorizontalAlignment(SwingConstants.CENTER);
		
		Font fuente = new Font("Tahoma",Font.BOLD,12);
		semestre1.setFont(fuente);
		semestre2.setFont(fuente);
		semestre3.setFont(fuente);
		semestre4.setFont(fuente);
		semestre5.setFont(fuente);
		semestre6.setFont(fuente);
		semestre7.setFont(fuente);
		semestre8.setFont(fuente);
		
		semestre1.setBackground(Color.LIGHT_GRAY);
		semestre2.setBackground(Color.LIGHT_GRAY);
		semestre3.setBackground(Color.LIGHT_GRAY);
		semestre4.setBackground(Color.LIGHT_GRAY);
		semestre5.setBackground(Color.LIGHT_GRAY);
		semestre6.setBackground(Color.LIGHT_GRAY);
		semestre7.setBackground(Color.LIGHT_GRAY);
		semestre8.setBackground(Color.LIGHT_GRAY);
		
		add(semestre1);
		add(semestre2);
		add(semestre3);
		add(semestre4);
		add(semestre5);
		add(semestre6);
		add(semestre7);
		add(semestre8);
		
		ButtonGroup grupoSemestres = new ButtonGroup();
		grupoSemestres.add(semestre1);
		grupoSemestres.add(semestre2);
		grupoSemestres.add(semestre3);
		grupoSemestres.add(semestre4);
		grupoSemestres.add(semestre5);
		grupoSemestres.add(semestre6);
		grupoSemestres.add(semestre7);
		grupoSemestres.add(semestre8);
		
		FechaEventoCreditos = new JCalendar();
		FechaEventoCreditos.setFont(new Font("Tahoma", Font.BOLD, 12));
		FechaEventoCreditos.setBounds(618, 62, 280, 168);
		add(FechaEventoCreditos);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(498, 62, 110, 25);
		add(lblFecha);
		
		JLabel lblDocente = new JLabel("Docente");
		lblDocente.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDocente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDocente.setBounds(498, 240, 110, 25);
		add(lblDocente);
		
		docente = new JComboBox<String>();
		docente.setBounds(618, 240, 280, 25);
		add(docente);
		
		JLabel lblCreditos = new JLabel("Cr\u00E9ditos");
		lblCreditos.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditos.setBounds(498, 277, 110, 25);
		add(lblCreditos);
		
		spinnerCreditos = new JSpinner();
		spinnerCreditos.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinnerCreditos.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinnerCreditos.setBounds(617, 279, 40, 21);
		add(spinnerCreditos);
		
		btnReclamar = new JButton("Enviar");
		btnReclamar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReclamar.setBounds(425, 370, 110, 25);
		add(btnReclamar);
		
		
	}

	public void setTitulo(String titulo) {
		tituloPanel.setText(titulo);
	}
	
}
