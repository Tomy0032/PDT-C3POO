package componentes;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelNuevaConstancia extends JPanel{

	private JComboBox<String> tipoConstancia;
	private JTable listaEventosComoAsistente;
	private JTextArea infoAdjunta;
	
	public PanelNuevaConstancia () {
		
		setLayout(null);
		
		JLabel titulo = new JLabel("SOLICITUD DE CONSTANCIA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		titulo.setBounds(356,27,268,25);
		add(titulo);
		
		tipoConstancia = new JComboBox<String>();
		tipoConstancia.setBounds(90,64,268,25);
		add(tipoConstancia);
		
		listaEventosComoAsistente = new JTable();
		listaEventosComoAsistente.setBounds(90,158,808,80);
		listaEventosComoAsistente.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(listaEventosComoAsistente);
		
		infoAdjunta = new JTextArea();
		infoAdjunta.setBounds(90,345,808,80);
		infoAdjunta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(infoAdjunta);
		
		JLabel labelListaEventos = new JLabel("Selecciona un evento de la lista");
		labelListaEventos.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelListaEventos.setBounds(90, 123, 268, 25);
		add(labelListaEventos);
		
		JLabel labelDatosAdjuntos = new JLabel("Agrega aqu\u00ED informaci\u00F3n adicional (aclaraciones y/o enlaces a documentos adjuntos)");
		labelDatosAdjuntos.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDatosAdjuntos.setBounds(90, 310, 584, 25);
		add(labelDatosAdjuntos);
		
	}

	public String getTipoConstancia() {
		return (String)tipoConstancia.getSelectedItem();
	}

	public String getInfoAdjunta() {
		return infoAdjunta.getText();
	}
}
