package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.naming.NamingException;

import com.exception.ServicesException;

import datos.CrearEvento;

import java.util.LinkedList;

import interfaz.Asistencia;

public class ControlBotonAsistencia implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String[] datos = new String[3];
		List<String[]> lista = new LinkedList<String[]>();
		
		for(int i = 0; i < Asistencia.getTabla().getRowCount(); i++) {
			datos[0] = (String) Asistencia.getTabla().getValueAt(i, 0);
			datos[1] = (String) Asistencia.getTabla().getValueAt(i, 1);
			if(Asistencia.getTabla().getValueAt(i, 2).getClass().equals(String.class)) {
				datos[2] = (String) Asistencia.getTabla().getValueAt(i, 2);
			}else {
				datos[2] = String.valueOf((Double) Asistencia.getTabla().getValueAt(i, 2));
			}
			lista.add(datos);
		}
		
		try {
			CrearEvento.asistencia(lista, Asistencia.getEvento());
		} catch (NamingException | ServicesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
