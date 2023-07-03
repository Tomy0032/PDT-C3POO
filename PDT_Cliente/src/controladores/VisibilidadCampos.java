package controladores;
import componentes.PanelEditarUsuario;
import componentes.PanelListadoUsuarios;
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
		String tipo = PanelListadoUsuarios.getCombo_filtro_tipoUsu().getSelectedItem().toString();
		switch(tipo) {
			case "ESTUDIANTE":
				PanelListadoUsuarios.getLbl_generacion().setVisible(true);
				PanelListadoUsuarios.getCombo_filtro_Generac().setVisible(true);
				break;
			default:
				PanelListadoUsuarios.getLbl_generacion().setVisible(false);
				PanelListadoUsuarios.getCombo_filtro_Generac().setVisible(false);
				break;
		}
	}

	public static void cambiarVisibilidadEditarUsuario() {
		String tipo = PanelEditarUsuario.getTipo_usu_comboBox().getSelectedItem().toString();
		switch(tipo) {
		case "ANALISTA":
			PanelEditarUsuario.getYearChooser().setVisible(false);
			PanelEditarUsuario.getRol_comboBox().setVisible(false);
			PanelEditarUsuario.getArea_comboBox().setVisible(false);
						
			PanelEditarUsuario.getFec_ingreso_label().setVisible(false);
			PanelEditarUsuario.getRol_label().setVisible(false);
			PanelEditarUsuario.getArea_label().setVisible(false);
			
			break;
			
		case "ESTUDIANTE":
			PanelEditarUsuario.getYearChooser().setVisible(true);
			PanelEditarUsuario.getRol_comboBox().setVisible(false);
			PanelEditarUsuario.getArea_comboBox().setVisible(false);
			
		
			PanelEditarUsuario.getFec_ingreso_label().setVisible(true);
			PanelEditarUsuario.getRol_label().setVisible(false);
			PanelEditarUsuario.getArea_label().setVisible(false);
			
			break;
		
		case "TUTOR":
			PanelEditarUsuario.getYearChooser().setVisible(false);
			PanelEditarUsuario.getRol_comboBox().setVisible(true);
			PanelEditarUsuario.getArea_comboBox().setVisible(true);
						
			PanelEditarUsuario.getFec_ingreso_label().setVisible(false);
			PanelEditarUsuario.getRol_label().setVisible(true);
			PanelEditarUsuario.getArea_label().setVisible(true);
			
			break;
		}
				
	}

}
