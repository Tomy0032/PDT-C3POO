package controladores;
import interfaz.Aplicacion;
import interfaz.Registrarse;

public class VisibilidadCampos {
	
	public static void cambiarVisibilidadRegistro() {
		
		String tipo = Registrarse.getTipo_usu_comboBox().getSelectedItem().toString();
		
		switch(tipo) {
		case "ANALISTA":
			Registrarse.getYearChooser().setVisible(false);
			Registrarse.getRol_comboBox().setVisible(false);
			Registrarse.getArea_comboBox().setVisible(false);
						
			Registrarse.getFec_ingreso_label().setVisible(false);
			Registrarse.getRol_label().setVisible(false);
			Registrarse.getArea_label().setVisible(false);
			
			break;
			
		case "ESTUDIANTE":
			Registrarse.getYearChooser().setVisible(true);
			Registrarse.getRol_comboBox().setVisible(false);
			Registrarse.getArea_comboBox().setVisible(false);
			
		
			Registrarse.getFec_ingreso_label().setVisible(true);
			Registrarse.getRol_label().setVisible(false);
			Registrarse.getArea_label().setVisible(false);
			
			break;
		
		case "TUTOR":
			Registrarse.getYearChooser().setVisible(false);
			Registrarse.getRol_comboBox().setVisible(true);
			Registrarse.getArea_comboBox().setVisible(true);
						
			Registrarse.getFec_ingreso_label().setVisible(false);
			Registrarse.getRol_label().setVisible(true);
			Registrarse.getArea_label().setVisible(true);
			
			break;
		}
		
	}

	public static void cambiarVisibilidadListadoUsuarios() {
		String tipo = Aplicacion.getCombo_filtro_tipoUsu().getSelectedItem().toString();
		switch(tipo) {
			case "ESTUDIANTE":
				Aplicacion.getLbl_generacion().setVisible(true);
				Aplicacion.getCombo_filtro_Generac().setVisible(true);
				break;
			default:
				Aplicacion.getLbl_generacion().setVisible(false);
				Aplicacion.getCombo_filtro_Generac().setVisible(false);
				break;
		}
	}

}
