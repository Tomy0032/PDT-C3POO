package controladores;
import interfaz.Registrarse;

public class VisibilidadCampos {
	
	public static void cambiarVisibilidad() {
		
		String tipo = Registrarse.getTipo_usu_comboBox().getSelectedItem().toString();
		
		switch(tipo) {
		case "ANALISTA":
			Registrarse.getYearChooser().setVisible(false);
			Registrarse.getRol_comboBox().setVisible(false);
			Registrarse.getArea_comboBox().setVisible(false);
			
			Registrarse.getAsterisco_label_1().setVisible(false);
			Registrarse.getAsterisco_label_14_1().setVisible(false);
			Registrarse.getAsterisco_label_15_1().setVisible(false);
			
			Registrarse.getFec_ingreso_label().setVisible(false);
			Registrarse.getRol_label().setVisible(false);
			Registrarse.getArea_label().setVisible(false);
			
			break;
			
		case "ESTUDIANTE":
			Registrarse.getYearChooser().setVisible(true);
			Registrarse.getRol_comboBox().setVisible(false);
			Registrarse.getArea_comboBox().setVisible(false);
			
			Registrarse.getAsterisco_label_1().setVisible(true);
			Registrarse.getAsterisco_label_14_1().setVisible(false);
			Registrarse.getAsterisco_label_15_1().setVisible(false);
			
			Registrarse.getFec_ingreso_label().setVisible(true);
			Registrarse.getRol_label().setVisible(false);
			Registrarse.getArea_label().setVisible(false);
			
			break;
		
		case "TUTOR":
			Registrarse.getYearChooser().setVisible(false);
			Registrarse.getRol_comboBox().setVisible(true);
			Registrarse.getArea_comboBox().setVisible(true);
			
			Registrarse.getAsterisco_label_1().setVisible(false);
			Registrarse.getAsterisco_label_14_1().setVisible(true);
			Registrarse.getAsterisco_label_15_1().setVisible(true);
			
			Registrarse.getFec_ingreso_label().setVisible(false);
			Registrarse.getRol_label().setVisible(true);
			Registrarse.getArea_label().setVisible(true);
			
			break;
		}
		
	}

}
