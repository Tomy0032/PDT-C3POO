package datos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.entities.Area;
import com.entities.Departamento;
import com.entities.Documento;
import com.entities.Generacion;
import com.entities.Itr;
import com.entities.Localidad;
import com.entities.TipoTutor;
import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.exception.ServicesException;
import com.services.AreaBeanRemote;
import com.services.DepartamentoBeanRemote;
import com.services.DocumentoBeanRemote;
import com.services.GeneracionBeanRemote;
import com.services.GeneroBeanRemote;
import com.services.ItrBeanRemote;
import com.services.LocalidadBeanRemote;
import com.services.PaisBeanRemote;
import com.services.TipoTutorBeanRemote;
import com.services.TipoUsuarioBeanRemote;
import com.services.UsuarioBeanRemote;

import interfaz.Aplicacion;
import listas.ListaUsuarios;
import mail.EmailSenderService;

public class CrearUsuario {
	
	static Usuario usuario;

	public static boolean crear(String[] datos) throws NamingException {
		
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 
		PaisBeanRemote paisBean = (PaisBeanRemote) InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote"); 
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		@SuppressWarnings("unused")
		GeneroBeanRemote generoBean = (GeneroBeanRemote) InitialContext.doLookup("PDT_EJB/GeneroBean!com.services.GeneroBeanRemote"); 
		GeneracionBeanRemote generacionBean = (GeneracionBeanRemote) InitialContext.doLookup("PDT_EJB/GeneracionBean!com.services.GeneracionBeanRemote"); 
		TipoTutorBeanRemote tipoTutorBean = (TipoTutorBeanRemote) InitialContext.doLookup("PDT_EJB/TipoTutorBean!com.services.TipoTutorBeanRemote"); 
		AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("PDT_EJB/AreaBean!com.services.AreaBeanRemote"); 
		TipoUsuarioBeanRemote tipoUsuarioBean = (TipoUsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/TipoUsuarioBean!com.services.TipoUsuarioBeanRemote"); 
		
		usuario = new Usuario();
					
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

			usuario.setEstado(EstadoUsuario.SIN_VALIDAR);

			
			usuario.setContrasena(datos[16]);
			
			if(datos[0].equals("ESTUDIANTE")) {
				usuario.setNombreUsuario(usuario.getCorreoInstitucional().replaceAll("@estudiantes.utec.edu.uy", "").toString());
			}
			else {
				usuario.setNombreUsuario(usuario.getCorreoInstitucional().replaceAll("@utec.edu.uy", "").toString());
			}

			TipoUsuario tipo = tipoUsuarioBean.findAll(datos[0].toString()).get(0);
			usuario.setTipoUsuario(tipo);
			
			if(datos[0].equals("ESTUDIANTE")) {
				
				BigDecimal ano = new BigDecimal(datos[13]);			
				try {
					Generacion generacion = generacionBean.findAllForYear(ano).get(0);					
					usuario.setGeneracion(generacion);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println(ano);
				}
											
				usuarioBean.create(usuario);
			
			}
			else if(datos[0].equals("TUTOR")) {
				
				TipoTutor tipoTutor = tipoTutorBean.findAll(datos[14]).get(0);
				Area area = areaBean.findAll(datos[15]).get(0);

				usuario.setTipoTutor(tipoTutor);
				usuario.setArea(area);
						
				usuarioBean.create(usuario);
			
			}
			else if(datos[0].equals("ANALISTA")) {
				
				usuarioBean.create(usuario);

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

	public static boolean editar(String[] datos) throws NamingException {
		
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 
		DepartamentoBeanRemote departamentoBean = (DepartamentoBeanRemote) InitialContext.doLookup("PDT_EJB/DepartamentoBean!com.services.DepartamentoBeanRemote"); 
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 
		PaisBeanRemote paisBean = (PaisBeanRemote) InitialContext.doLookup("PDT_EJB/PaisBean!com.services.PaisBeanRemote"); 
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		@SuppressWarnings("unused")
		GeneroBeanRemote generoBean = (GeneroBeanRemote) InitialContext.doLookup("PDT_EJB/GeneroBean!com.services.GeneroBeanRemote"); 
		GeneracionBeanRemote generacionBean = (GeneracionBeanRemote) InitialContext.doLookup("PDT_EJB/GeneracionBean!com.services.GeneracionBeanRemote"); 
		TipoTutorBeanRemote tipoTutorBean = (TipoTutorBeanRemote) InitialContext.doLookup("PDT_EJB/TipoTutorBean!com.services.TipoTutorBeanRemote"); 
		AreaBeanRemote areaBean = (AreaBeanRemote) InitialContext.doLookup("PDT_EJB/AreaBean!com.services.AreaBeanRemote"); 
		TipoUsuarioBeanRemote tipoUsuarioBean = (TipoUsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/TipoUsuarioBean!com.services.TipoUsuarioBeanRemote"); 
				
		Usuario usuario = Aplicacion.getUsuario();
		
		usuario.setApellido1(datos[0]);
		
		usuario.setApellido2(datos[1]);

		usuario.setCorreoPersonal(datos[2]);
		
		Date date=Date.valueOf(datos[3]);
		usuario.setFechaNacimiento(date);
		
		usuario.setNombre1(datos[4]);

		usuario.setNombre2(datos[5]);
			
		usuario.setTelefono(datos[6]);
		try {	
					
			Itr itr = itrBean.findAll(datos[7]).get(0);
			usuario.setItr(itr);
				
			Departamento departamento = departamentoBean.findAll(datos[8]).get(0);
			Localidad localidad = new Localidad();
			List<Localidad> localidades = localidadBean.findAll(datos[9]);
			for(Localidad l : localidades) {
				if(l.getDepartamento().getIdDepartamento() == departamento.getIdDepartamento()) {
					localidad = l;
				}
			}
			usuario.setLocalidad(localidad);

			
			if(Aplicacion.getTipoUsuario().equals("ESTUDIANTE")) {
				
				BigDecimal ano = new BigDecimal(datos[10]);			
				try {
					Generacion generacion = generacionBean.findAllForYear(ano).get(0);					
					usuario.setGeneracion(generacion);
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println(ano);
				}
											
				usuarioBean.update(usuario);
			
			}
			else if(Aplicacion.getTipoUsuario().equals("TUTOR")) {
				
				TipoTutor tipoTutor = tipoTutorBean.findAll(datos[11]).get(0);
				Area area = areaBean.findAll(datos[12]).get(0);

				usuario.setTipoTutor(tipoTutor);
				usuario.setArea(area);
						
				usuarioBean.update(usuario);
			
			}
			else if(Aplicacion.getTipoUsuario().equals("ANALISTA")) {
				
				usuarioBean.update(usuario);

			}
			
			JOptionPane.showMessageDialog(new JFrame(), "Datos actualizados correctamente");
			ListaUsuarios.cargarLista();
			Aplicacion.filtros();
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

	public static boolean editarPassword(String password) throws NamingException {
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		
		System.out.println(password);
		
		Usuario usuario = Aplicacion.getUsuario();
		usuario.setContrasena(password);
		
		try {
			usuarioBean.update(usuario);
			JOptionPane.showMessageDialog(new JFrame(), "Contraseña actualizada correctamente");
			ListaUsuarios.cargarLista();
			Aplicacion.filtros();
			return true;
		}catch(Exception e) {
			
		}
		return false;
		
	}
	
}
