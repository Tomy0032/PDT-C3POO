package datos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.entities.Analista;
import com.entities.Area;
import com.entities.Departamento;
import com.entities.Documento;
import com.entities.Estudiante;
import com.entities.Generacion;
import com.entities.Itr;
import com.entities.Localidad;
import com.entities.Tipo;
import com.entities.Tutor;
import com.entities.Usuario;
import com.enums.Estado;
import com.exception.ServicesException;
import com.services.AnalistaBeanRemote;
import com.services.AreaBeanRemote;
import com.services.DepartamentoBeanRemote;
import com.services.DocumentoBeanRemote;
import com.services.EstudianteBeanRemote;
import com.services.GeneracionBeanRemote;
import com.services.GeneroBeanRemote;
import com.services.ItrBeanRemote;
import com.services.LocalidadBeanRemote;
import com.services.PaisBeanRemote;
import com.services.TipoBeanRemote;
import com.services.TutorBeanRemote;
import com.services.UsuarioBeanRemote;

import listas.ListaUsuarios;
import mail.EmailSenderService;

public class CrearUsuario {

	public static boolean crear(String[] datos) throws NamingException {
		
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 
		PaisBeanRemote paisBean = (PaisBeanRemote) InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote"); 
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		@SuppressWarnings("unused")
		GeneroBeanRemote generoBean = (GeneroBeanRemote) InitialContext.doLookup("PDT_EJB/GeneroBean!com.services.GeneroBeanRemote"); 
		EstudianteBeanRemote estudianteBean = (EstudianteBeanRemote) InitialContext.doLookup("PDT_EJB/EstudianteBean!com.services.EstudianteBeanRemote"); 
		GeneracionBeanRemote generacionBean = (GeneracionBeanRemote) InitialContext.doLookup("PDT_EJB/GeneracionBean!com.services.GeneracionBeanRemote"); 
		TutorBeanRemote tutorBean = (TutorBeanRemote) InitialContext.doLookup("PDT_EJB/TutorBean!com.services.TutorBeanRemote"); 
		TipoBeanRemote tipoBean = (TipoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoBean!com.services.TipoBeanRemote"); 
		AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("PDT_EJB/AreaBean!com.services.AreaBeanRemote"); 
		AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext.doLookup("PDT_EJB/AnalistaBean!com.services.AnalistaBeanRemote"); 
		
		Usuario usuario = new Usuario();
					
		usuario.setApellido1(datos[1]);
		if(!datos[2].equals("")) {
			usuario.setApellido2(datos[2]);
		}
		
		usuario.setCorreoInstitucional(datos[3]);
		usuario.setCorreoPersonal(datos[4]);
		
		Date date=Date.valueOf(datos[5]);
		usuario.setFechaNacimiento(date);
		
		usuario.setNombre1(datos[6]);
		if(!datos[7].equals("")) {
			usuario.setNombre2(datos[7]);
		}
			
		usuario.setTelefono(datos[8]);
		try {
			
			Documento documento = new Documento();
			documento.setCaracteres(datos[9]);
			documento.setPais(paisBean.find(1L));
			documentoBean.create(documento);
			documento = documentoBean.findAll(documento.getCaracteres()).get(0);
			usuario.setDocumento(documento);
		
					
			Itr itr = itrBean.findAll(datos[10]).get(0);
			usuario.setItr(itr);
				
			Departamento departamento = departamentoBean.findAll(datos[11]).get(0);
			Localidad localidad = new Localidad();
			List<Localidad> localidades = localidadBean.findAll(datos[12]);
			for(Localidad l : localidades) {
				if(l.getDepartamento().getIdDepartamento() == departamento.getIdDepartamento()) {
					localidad = l;
				}
			}
			usuario.setLocalidad(localidad);
			
//			usuario.setGenero(generoBean.find(1L));
			usuario.setEstado(Estado.SIN_VALIDAR);

			
			usuario.setContrasena(datos[16]);
			
			if(datos[0].equals("ESTUDIANTE")) {
				usuario.setNombreUsuario(usuario.getCorreoInstitucional().replaceAll("@estudiantes.utec.edu.uy", "").toString());
			}
			else {
				usuario.setNombreUsuario(usuario.getCorreoInstitucional().replaceAll("@utec.edu.uy", "").toString());
			}
//			usuario.setNombreUsuario(datos[6]+"."+datos[1]);
									
			usuarioBean.create(usuario);
			
			EmailSenderService.correoInicial(usuario.getCorreoInstitucional());
			
			usuario = usuarioBean.findAllForDocument(documento).get(0);
			
			if(datos[0].equals("ESTUDIANTE")) {
								
				BigDecimal ano = new BigDecimal(datos[13]);
			
				Generacion generacion = generacionBean.findAllForYear(ano).get(0);				
				
				Estudiante estudiante = new Estudiante();
				estudiante.setUsuario(usuario);
				estudiante.setGeneracion(generacion);
				
				estudianteBean.create(estudiante);
			
			}
			else if(datos[0].equals("TUTOR")) {
				
				Tipo tipo = tipoBean.findAll(datos[14]).get(0);
				Area area = areaBean.findAll(datos[15]).get(0);
					
				Tutor tutor = new Tutor();
				tutor.setUsuario(usuario);
				tutor.setTipo(tipo);
				tutor.setArea(area);
						
				tutorBean.create(tutor);
			
			}
			else if(datos[0].equals("ANALISTA")) {
						
				Analista analista = new Analista();
				analista.setUsuario(usuario);
				
				analistaBean.create(analista);

			}
			
			JOptionPane.showMessageDialog(new JFrame(), "Se ha completado el registro correctamente. Sus datos serán revisados antes de la activación de la cuenta");
			ListaUsuarios.cargarLista();
			return true;
			
		}catch(ServicesException e) {
			System.out.println(e.getMessage());
			try {
				Documento documento = documentoBean.findAll(datos[9]).get(0);
				documentoBean.drop(documento.getIdDocumento());
			}
			catch(ServicesException e1){
				System.out.println(e1.getMessage());
			}
		}
		
		return false;
		
	}
	
}
