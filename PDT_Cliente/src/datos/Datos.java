package datos;

import javax.naming.NamingException;

public class Datos {
	
	public static void cargar() throws NamingException {
		
		Localidades_Departamentos.cargarDatos();
		TiposTutor.cargarDatos();
		TiposEvento.cargarDatos();
		TiposUsuario.cargarDatos();
		Modalidades.cargarDatos();
		EstadosEvento.cargarDatos();
		ITRs.cargarDatos();
		Paises.cargarDatos();
		Generos.cargarDatos();
		Generaciones.cargarDatos();
		Areas.cargarDatos();
		
	}

}
