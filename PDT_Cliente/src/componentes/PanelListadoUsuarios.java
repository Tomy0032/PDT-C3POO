package componentes;

import java.awt.Font;
import java.awt.SystemColor;

import javax.naming.NamingException;

import com.exception.ServicesException;
import com.toedter.calendar.JDateChooser;

import controladores.ControlBotonCrearEvento;
import controladores.Control_longit_min_evento;
import datos.OperacionUsuario;
import interfaces.ControlCampo;
import interfaz.Aplicacion;
import interfaz.Login;
import interfaz.PanelFondo;
import listas.ListaItrs;
import listas.ListaModalidades;
import listas.ListaTiposEvento;
import listas.ListaUsuarios;
import utilidades.GestionCeldas;
import utilidades.GestionEncabezadoTabla;
import utilidades.ModeloTabla;
import utilidades.Utilidades;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.LinkedList;
import java.util.List;


public class PanelListadoUsuarios extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static JComboBox<String> combo_filtro_estado;
	private static JComboBox<Object> combo_filtro_Generac;
	private static JScrollPane scrollPaneTabla;
	private static JTable tablaUsuarios;
	private static JLabel lbl_generacion;
	private JLabel lbl_estado;
	private static JComboBox<String> combo_filtro_tipoUsu;
	private static JComboBox<String> combo_filtro_itr;
	private static String[] titulos = new String[] {
			"Estado", "Nombre de usuario", "Usuario", "ITR", "Generación", "", "", "", ""};
	private static ModeloTabla modelo;
	
	public PanelListadoUsuarios() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		PanelFondo panelFondo = new PanelFondo("");
		panelFondo.setLayout(null);
		panelFondo.setBackground(SystemColor.menu);
		panelFondo.setBounds(0, 0, 1087, 698);
		add(panelFondo);

				
		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(154, 118, 859, 459);
		panelFondo.add(scrollPaneTabla);
		
		tablaUsuarios = new JTable();
		tablaUsuarios.setBackground(Color.WHITE);
		tablaUsuarios.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tablaUsuarios.addMouseListener(this);
		tablaUsuarios.setOpaque(false);
		
		scrollPaneTabla.setViewportView(tablaUsuarios);
		
		JLabel lbl_filtros = new JLabel("Filtrar por:");
		lbl_filtros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_filtros.setBounds(289, 45, 61, 22);
		panelFondo.add(lbl_filtros);

		JLabel lbl_tipo_usuario = new JLabel("Tipo Usuario");
		lbl_tipo_usuario.setBounds(378, 45, 110, 22);
		panelFondo.add(lbl_tipo_usuario);

		lbl_generacion = new JLabel("Generaci\u00F3n");
		lbl_generacion.setBounds(748, 45, 70, 22);
		lbl_generacion.setVisible(false);
		panelFondo.add(lbl_generacion);

		JLabel lbl_itr = new JLabel("ITR");
		lbl_itr.setBounds(498, 45, 130, 22);
		panelFondo.add(lbl_itr);

		lbl_estado = new JLabel("Estado");
		lbl_estado.setBounds(638, 45, 100, 22);
		panelFondo.add(lbl_estado);

		combo_filtro_tipoUsu = new JComboBox<String>();
		combo_filtro_tipoUsu.setBounds(378, 72, 110, 22);
		combo_filtro_tipoUsu.addItem("TODOS");
		combo_filtro_tipoUsu.addItem("ANALISTA");
		combo_filtro_tipoUsu.addItem("ESTUDIANTE");
		combo_filtro_tipoUsu.addItem("TUTOR");
		combo_filtro_tipoUsu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panelFondo.add(combo_filtro_tipoUsu);

		combo_filtro_itr = new JComboBox<String>();
		combo_filtro_itr.setBounds(498, 72, 130, 22);
		combo_filtro_itr.setModel(new DefaultComboBoxModel<>(getItrs()));
		combo_filtro_itr.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panelFondo.add(combo_filtro_itr);

		combo_filtro_Generac = new JComboBox<Object>();
		combo_filtro_Generac.setBounds(748, 72, 70, 22);
		combo_filtro_Generac.setModel(new DefaultComboBoxModel<>(getGeneraciones()));
		combo_filtro_Generac.setVisible(false);
		combo_filtro_Generac.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panelFondo.add(combo_filtro_Generac);

		combo_filtro_estado = new JComboBox<String>();
		combo_filtro_estado.setBounds(638, 72, 100, 22);
		combo_filtro_estado.addItem("TODOS");
		combo_filtro_estado.addItem("SIN VALIDAR");
		combo_filtro_estado.addItem("ACTIVO");
		combo_filtro_estado.addItem("ELIMINADO");
		combo_filtro_estado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					filtros(e);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		});
		panelFondo.add(combo_filtro_estado);
		
		try {
			construirTabla(ListaUsuarios.getListaStringListado(),titulos);
		} catch (NamingException | ServicesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void filtros(ItemEvent e) throws ServicesException, NamingException {
		if (e.getStateChange() == 2) {
			combo_filtro_Generac.setVisible(false);
			lbl_generacion.setVisible(false);
			switch(combo_filtro_tipoUsu.getSelectedItem().toString()) {
			case "ANALISTA":
				construirTabla(ListaUsuarios.getListaAnalistasStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
				break;
			case "ESTUDIANTE":
				combo_filtro_Generac.setVisible(true);
				lbl_generacion.setVisible(true);
				construirTabla(ListaUsuarios.getListaEstudiantesStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString(),combo_filtro_Generac.getSelectedItem().toString()), titulos);
				break;
			case "TUTOR":
				construirTabla(ListaUsuarios.getListaTutoresStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);				
				break;
			case "TODOS":
				construirTabla(ListaUsuarios.getListaStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
				break;
			}
		}
	}
	
	public static void filtros() throws ServicesException, NamingException {
		combo_filtro_Generac.setVisible(false);
		lbl_generacion.setVisible(false);
		switch(combo_filtro_tipoUsu.getSelectedItem().toString()) {
		case "ANALISTA":
			construirTabla(ListaUsuarios.getListaAnalistasStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
			break;
		case "ESTUDIANTE":
			combo_filtro_Generac.setVisible(true);
			lbl_generacion.setVisible(true);
			construirTabla(ListaUsuarios.getListaEstudiantesStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString(),combo_filtro_Generac.getSelectedItem().toString()), titulos);
			break;
		case "TUTOR":
			construirTabla(ListaUsuarios.getListaTutoresStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);				
			break;
		case "TODOS":
			construirTabla(ListaUsuarios.getListaStringListado(combo_filtro_itr.getSelectedItem().toString(),combo_filtro_estado.getSelectedItem().toString()), titulos);
			break;
		}
		
	}
	
	public static void construirTabla(Object[][] datos, String[] titulos) {
		
		modelo = new ModeloTabla(datos,titulos);
		tablaUsuarios.setModel(modelo);
		
		
		for(int i = 0; i < titulos.length - 2; i++) {
			tablaUsuarios.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
		}
		tablaUsuarios.getColumnModel().getColumn(Utilidades.GENERACION).setCellRenderer(new GestionCeldas("numerico"));		
		tablaUsuarios.getColumnModel().getColumn(Utilidades.VER).setCellRenderer(new GestionCeldas("icono"));
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ACTIVAR).setCellRenderer(new GestionCeldas("icono"));
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ELIMINAR).setCellRenderer(new GestionCeldas("icono"));
		tablaUsuarios.getColumnModel().getColumn(Utilidades.EDITAR).setCellRenderer(new GestionCeldas("icono"));

		tablaUsuarios.getTableHeader().setReorderingAllowed(false);
		tablaUsuarios.setRowHeight(25);
		
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ESTADO).setPreferredWidth(180);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.USUARIO).setPreferredWidth(300);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.TIPO).setPreferredWidth(250);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ITR).setPreferredWidth(360);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.GENERACION).setPreferredWidth(130);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.VER).setPreferredWidth(30);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ACTIVAR).setPreferredWidth(30);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.ELIMINAR).setPreferredWidth(30);
		tablaUsuarios.getColumnModel().getColumn(Utilidades.EDITAR).setPreferredWidth(30);
		
		JTableHeader header = tablaUsuarios.getTableHeader();
		header.setDefaultRenderer(new GestionEncabezadoTabla());
		
		scrollPaneTabla.setViewportView(tablaUsuarios);
		
	}
	
	public Object[] getGeneraciones() {

		int anio = 2014;
		LocalDate current_date = LocalDate.now();
		int actual = current_date.getYear();

		List<String> generaciones = new ArrayList<>();
		generaciones.add("TODAS");
		while (anio < actual) {
			generaciones.add(Integer.toString(anio));
			anio++;
		}

		return (Object[]) generaciones.toArray();

	}

	public String[] getItrs() {

		String[] list = ListaItrs.getListaString();
		String[] lista = new String[list.length + 1];

		for (int i = 0; i < lista.length; i++) {

			if (i == 0) {
				lista[i] = "TODOS";
			} else {
				lista[i] = list[i - 1];
			}

		}

		return lista;

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = tablaUsuarios.rowAtPoint(e.getPoint());
		int columna = tablaUsuarios.columnAtPoint(e.getPoint());
				
		if (columna==Utilidades.VER) {
			
			try {
				OperacionUsuario.mostrar(fila);
			} catch (ServicesException | NamingException e1) {
				e1.printStackTrace();
			}
		}
		
		if (columna==Utilidades.ACTIVAR) {
			if(!tablaUsuarios.getValueAt(fila, columna).toString().equals("")) {
				try {
					OperacionUsuario.activar(fila);
				} catch (ServicesException | NamingException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if (columna==Utilidades.ELIMINAR) {
			
			try {
				OperacionUsuario.eliminar(fila);
			} catch (ServicesException | NamingException e1) {
				e1.printStackTrace();
			}
		}
		
		if (columna==Utilidades.EDITAR) {
			
			try {
				OperacionUsuario.editar(fila);
				CardLayout c = (CardLayout)Aplicacion.getCard_container_panel().getLayout();
				c.show(Aplicacion.getCard_container_panel(), "Panel Editar usuario");
			} catch (ServicesException | NamingException e1) {
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static JComboBox<String> getCombo_filtro_estado() {
		return combo_filtro_estado;
	}

	public static void setCombo_filtro_estado(JComboBox<String> combo_filtro_estado) {
		PanelListadoUsuarios.combo_filtro_estado = combo_filtro_estado;
	}

	public static JComboBox<Object> getCombo_filtro_Generac() {
		return combo_filtro_Generac;
	}

	public static void setCombo_filtro_Generac(JComboBox<Object> combo_filtro_Generac) {
		PanelListadoUsuarios.combo_filtro_Generac = combo_filtro_Generac;
	}

	public static JScrollPane getScrollPaneTabla() {
		return scrollPaneTabla;
	}

	public static void setScrollPaneTabla(JScrollPane scrollPaneTabla) {
		PanelListadoUsuarios.scrollPaneTabla = scrollPaneTabla;
	}

	public static JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public static void setTablaUsuarios(JTable tablaUsuarios) {
		PanelListadoUsuarios.tablaUsuarios = tablaUsuarios;
	}

	public static JLabel getLbl_generacion() {
		return lbl_generacion;
	}

	public static void setLbl_generacion(JLabel lbl_generacion) {
		PanelListadoUsuarios.lbl_generacion = lbl_generacion;
	}

	public JLabel getLbl_estado() {
		return lbl_estado;
	}

	public void setLbl_estado(JLabel lbl_estado) {
		this.lbl_estado = lbl_estado;
	}

	public static JComboBox<String> getCombo_filtro_tipoUsu() {
		return combo_filtro_tipoUsu;
	}

	public static void setCombo_filtro_tipoUsu(JComboBox<String> combo_filtro_tipoUsu) {
		PanelListadoUsuarios.combo_filtro_tipoUsu = combo_filtro_tipoUsu;
	}

	public static JComboBox<String> getCombo_filtro_itr() {
		return combo_filtro_itr;
	}

	public static void setCombo_filtro_itr(JComboBox<String> combo_filtro_itr) {
		PanelListadoUsuarios.combo_filtro_itr = combo_filtro_itr;
	}

	public static String[] getTitulos() {
		return titulos;
	}

	public static void setTitulos(String[] titulos) {
		PanelListadoUsuarios.titulos = titulos;
	}

	public static ModeloTabla getModelo() {
		return modelo;
	}

	public static void setModelo(ModeloTabla modelo) {
		PanelListadoUsuarios.modelo = modelo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
