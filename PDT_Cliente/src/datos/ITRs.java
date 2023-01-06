package datos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Departamento;
import com.entities.Itr;
import com.entities.Localidad;
import com.exception.ServicesException;
import com.services.DepartamentoBeanRemote;
import com.services.ItrBeanRemote;
import com.services.LocalidadBeanRemote;

public class ITRs {
	
public static void cargarDatos() throws NamingException {
		
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 

		
		ArrayList<String> lista;
		String directorioRaiz = System.getProperty("user.dir");
		try {
			lista = new ArrayList<>(Files.readAllLines(Paths.get(directorioRaiz + "\\src\\recursos\\datos\\itrs.txt")));
			cargarItrs(lista,itrBean,localidadBean,departamentoBean);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void cargarItrs(ArrayList<String> lista,ItrBeanRemote itrBean,LocalidadBeanRemote localidadBean, DepartamentoBeanRemote departamentoBean) {
		
		for(String s : lista) {
			
			int ind =s.indexOf(",");
			String departamento = s.substring(0,ind);
			Departamento depa = new Departamento();
			depa = departamentoBean.findAll(departamento).get(0);
			
			int ultimo = s.length();
			s = s.substring(ind+1,ultimo);
			
			
			ind =s.indexOf(",");
			String localidad = s.substring(0,ind);

			Localidad local = new Localidad();
			List<Localidad> localidades = localidadBean.findAll(localidad);
			for(Localidad l : localidades) {
				if(l.getDepartamento().getIdDepartamento() == depa.getIdDepartamento()) {
					local = l;
				}
			}
			
			
			ultimo = s.length();
			s = s.substring(ind+1,ultimo);
			
			String nombre = s;
						
			Itr itr = new Itr();
			try {
				
				itr = itrBean.findAll(nombre).get(0);
				
			}catch(Exception e){
				
				itr.setNombre(nombre);
				itr.setLocalidad(local);

				try {
					
					itrBean.create(itr);
					itr = itrBean.findAll(nombre).get(0);
					
				} catch (ServicesException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
	}

}
