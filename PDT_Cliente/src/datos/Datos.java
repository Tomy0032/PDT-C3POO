package datos;

import javax.naming.NamingException;

public class Datos {
	
	public static void cargar() throws NamingException {
		
		Localidades_Departamentos.cargarDatos();
		Tipos.cargarDatos();
		ITRs.cargarDatos();
		
	}

}
