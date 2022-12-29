package datos;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.*;
import com.exception.*;
import com.services.*;

public class Localidades_Departamentos {
		
	public static void cargarDatos() throws NamingException {
		
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 

		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\localidades.txt")));
			cargarLocalidades(lista,departamentoBean,localidadBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargarLocalidades(ArrayList<String> lista,DepartamentoBeanRemote departamentoBean,LocalidadBeanRemote localidadBean) {
		
		for(String s : lista) {
			
			int ind =s.indexOf(",");
			String departamento = s.substring(0,ind);
			Departamento depa = new Departamento();
			try {
				
				depa = departamentoBean.findAll(departamento).get(0);
				
			}catch(Exception e){
				
				depa.setNombre(departamento);
				try {
					departamentoBean.create(depa);
					depa = departamentoBean.findAll(departamento).get(0);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			int ultimo = s.length();
			s = s.substring(ind+1,ultimo);
			String localidad = s;
			Localidad local = new Localidad();
			try {
				
				local = localidadBean.findAll(localidad).get(0);
				
			}catch(Exception e){
				
				local.setNombre(localidad);
				local.setDepartamento(depa);
				try {
					localidadBean.create(local);
					local = localidadBean.findAll(localidad).get(0);
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
	}

}
