package controladores;

import interfaz.Registrarse;

public class Control_email_institucional extends Control_formato_email{

	public Control_email_institucional(String email) {		
		super(email);
	}
	
	public void controlCampo() {
		
		Registrarse.getApe1_field().getText();
		String estudiante = "@estudiantes.utec.edu.uy", tutor_analista = "@utec.edu.uy";
		Registrarse.getNom1_field().getText();
		String tipoUsuario = (String)Registrarse.getTipo_usu_comboBox().getSelectedItem();
		
//		String estudianteCorrecto = nom.toLowerCase()+"."+ape.toLowerCase()+estudiante,
//		tutor_analista_correcto = nom.toLowerCase()+"."+ape.toLowerCase()+tutor_analista;
		
		
		if( ( tipoUsuario.equals("ANALISTA") || tipoUsuario.equals("TUTOR") ) 
		   && super.email.endsWith(tutor_analista)) {
			
			super.match = true;
		
		}else if(tipoUsuario.equals("ESTUDIANTE")
				&& super.email.endsWith(estudiante)) {
			
			super.match = true;

		}else {
			
			super.match = false;
		}
		
	}
}
