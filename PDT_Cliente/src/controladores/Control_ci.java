package controladores;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import interfaces.ControlCampo;
import interfaz.Registrarse;

public class Control_ci implements ControlCampo{

	private static Control_ci instancia;
	private int num_ci;
	private int[] digitos = new int [8];
	private final int[] CONSTANTES = {2,9,8,7,6,3,4};
	private boolean ciCorrecta;
	
//-------------------------------------------	
	//solo hace falta una instancia de control
	// asi que lo hice Singleton
	private Control_ci() {}
	
	public static Control_ci getInstance() {
		
		if(instancia==null) {
			
			instancia = new Control_ci();
		}
		return instancia;
	}
//-------------------------------------------
	

//---------------------------------------------	
	// metodo private para parsear el numero 
	// porque solo se usadentro de la clase  
	private void obtenerNumeroCi(String ci) {
		
		try {
			num_ci = Integer.parseInt(ci);
		}catch(InputMismatchException e) {
			
			JOptionPane.showMessageDialog(null, "Algo falló al intentar parsear la CI");
			e.printStackTrace();
		}	
	}
//---------------------------------------------	

	
//----------------------------------------------------
	// metodo para separar en digitos el numero
	// de cedula y ponerlos en un array (tambien private)
	// ej: 31784968 -> [3],[1],[7],[8],[4],[9],[6],[8]
	private void extraerDigitos() {
			
		for(int i=0; i<digitos.length; i++) {
			
			digitos[digitos.length - (i+1)] = num_ci % 10;
			num_ci = (num_ci - digitos[digitos.length - (i+1)]) / 10;
		}
	}
//-----------------------------------------------------

	
//-----------------------------------------------------
	// este es el metodo principal, el unico publico
	// aparte del que devuelve la instancia de la clase.
	// primero ejecuta los metodos private definidos antes
	// y luego ejecuta el procedimiento que esta comentado
	// al final
	public void controlCampo(){
		
		
		String ci = Registrarse.getCedu_field().getText();
		obtenerNumeroCi(ci);
		extraerDigitos();
		
		ciCorrecta = false;
		
		int suma = 0;
		
		for(int i=0;i<CONSTANTES.length;i++) {
			
			suma += CONSTANTES[i]*digitos[i];
		}
		int m = suma % 10;
		int verificador = (10-m) % 10;
		
		if(digitos[7] == verificador) {
			
			ciCorrecta = true;
		}
		
	}
//---------------------------------------------------

	

	@Override
	public boolean isOk() {
		// TODO Auto-generated method stub
		return ciCorrecta;
	}


	
/*
	 El dígito posterior al guión (h) es también llamado dígito verificador.

	Para obtener h debemos:
	
	Multiplicar a,b,c,d,e,f,g por las siguientes constantes:
	(a; b; c; d; e; f; g) .* (2; 9; 8; 7; 6; 3; 4)
	
	El resultado de la suma s = 2*a + 9*b + 8*c + 7*d + 6*e + 3*f + 4*g 
	es dividido por 10 quedándonos con resto (M = s modulo 10)
	
	Finalmente h = (10 – M) % 10
	
	Ejemplo practico:
	Si la CI es 1.234.567:
	
	s = 2*1 + 9*2 + 8*3 + 7*4 + 6*5 + 3*6 + 4*7 = 148
	M = 148 % 10 = 8
	h = (10 – 8) % 10 = 2
	
	Obteniendo que 1.234.567-2 es un número de CI valido.
*/
}
