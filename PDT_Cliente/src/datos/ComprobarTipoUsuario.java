package datos;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.AnalistaBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.TutorBeanRemote;


public class ComprobarTipoUsuario {
	
	public static String is(Usuario usuario) throws NamingException {
		
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext.doLookup("PDT_EJB/AnalistaBean!com.services.AnalistaBeanRemote");
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext.doLookup("PDT_EJB/EstudianteBean!com.services.EstudianteBeanRemote");
		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext.doLookup("PDT_EJB/TutorBean!com.services.TutorBeanRemote");
		
		try {
			analistaBean.findForUser(usuario);
			return "ANALISTA";
		}catch(ServicesException e) {
//			System.out.println(e.getMessage());
		}
		try {
			estudianteBean.findForUser(usuario);
			return "ESTUDIANTE";
		}catch(ServicesException e) {
//			System.out.println(e.getMessage());
		}
		try {
			tutorBean.findForUser(usuario);
			return "TUTOR";
		}catch(ServicesException e) {
//			System.out.println(e.getMessage());
		}

		return null;
		
	}

}
