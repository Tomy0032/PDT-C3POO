package datos;

import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.math.BigDecimal;

import com.entities.Modalidad;
import com.entities.ConvocatoriaAsistencia;
import com.entities.EstadoEvento;
import com.entities.Itr;
import com.entities.TipoEvento;
import com.entities.Evento;
import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.ModalidadBeanRemote;
import com.services.DocumentoBeanRemote;
import com.services.EventoBeanRemote;
import com.services.ItrBeanRemote;
import com.services.EstadoEventoBeanRemote;
import com.services.TipoEventoBeanRemote;
import com.services.UsuarioBeanRemote;
import com.services.ConvocatoriaAsistenciaBeanRemote;


import componentes.PanelFichaEvento;
import componentes.PanelListadoEventos;
import listas.ListaEventos;
import listas.ListaUsuarios;

public class CrearEvento {
	
	static Usuario usuario;

	public static boolean crear(String[] datos, ArrayList<String> tutores) throws NamingException {
		
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext.doLookup("PDT_EJB/EventoBean!com.services.EventoBeanRemote"); 
		EstadoEventoBeanRemote estadoEventoBean = (EstadoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/EstadoEventoBean!com.services.EstadoEventoBeanRemote"); 
		ModalidadBeanRemote modalidadBean = (ModalidadBeanRemote) InitialContext.doLookup("PDT_EJB/ModalidadBean!com.services.ModalidadBeanRemote"); 
		TipoEventoBeanRemote tipoEventoBean = (TipoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoEventoBean!com.services.TipoEventoBeanRemote"); 
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		try {
			
			Evento evento = new Evento();
			
			evento.setNombre(datos[0]);
			
			TipoEvento tipoEvento = tipoEventoBean.findAll(datos[1]).get(0);
			evento.setTipo(tipoEvento);
		
			Date inicio = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(datos[2] + " " + datos[3]);
			Date fin = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(datos[4] + " " + datos[5]);
			
			evento.setFechaHoraInicio(inicio);
			evento.setFechaHoraFinal(fin);
			
			Modalidad modalidad = modalidadBean.findAll(datos[6]).get(0);			
			evento.setModalidad(modalidad);
			
			EstadoEvento estadoEvento = estadoEventoBean.find(3L);
			evento.setEstado(estadoEvento);
			
			Itr itr = itrBean.findAll(datos[7]).get(0);
			evento.setItr(itr);
			
			evento.setLocalizacion(datos[8]);
			
			List<Usuario> tutoresList = new LinkedList<Usuario>();
			
			for(String s : tutores) {
				s=s.substring(0,8);
				try {
					usuario = usuarioBean.findAllForDocument(documentoBean.findAll(s).get(0)).get(0);
				} catch (ServicesException e) {
					e.printStackTrace();
				}
				tutoresList.add(usuario);
			}
		
			evento.setTutores(tutoresList);
			eventoBean.create(evento);	
			
			ListaEventos.cargarLista();
			ListaUsuarios.cargarLista();
			PanelListadoEventos.construirTabla(ListaEventos.getListaStringListado(),PanelListadoEventos.getTitulos());
			
			JOptionPane.showMessageDialog(new JFrame(), "Evento creado correctamente");
			
			return true;
			
		} catch (ServicesException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public static boolean editar(Evento evento, String[] datos, ArrayList<String> tutores) throws NamingException {
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 
		ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext.doLookup("PDT_EJB/ItrBean!com.services.ItrBeanRemote"); 
		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext.doLookup("PDT_EJB/EventoBean!com.services.EventoBeanRemote"); 
		EstadoEventoBeanRemote estadoEventoBean = (EstadoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/EstadoEventoBean!com.services.EstadoEventoBeanRemote"); 
		ModalidadBeanRemote modalidadBean = (ModalidadBeanRemote) InitialContext.doLookup("PDT_EJB/ModalidadBean!com.services.ModalidadBeanRemote"); 
		TipoEventoBeanRemote tipoEventoBean = (TipoEventoBeanRemote) InitialContext.doLookup("PDT_EJB/TipoEventoBean!com.services.TipoEventoBeanRemote"); 
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		try {
			
			evento.setNombre(datos[0]);
			
			TipoEvento tipoEvento = tipoEventoBean.findAll(datos[1]).get(0);
			evento.setTipo(tipoEvento);
		
			Date inicio = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(datos[2] + " " + datos[3]);
			Date fin = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(datos[4] + " " + datos[5]);
			
			evento.setFechaHoraInicio(inicio);
			evento.setFechaHoraFinal(fin);
			
			Modalidad modalidad = modalidadBean.findAll(datos[6]).get(0);			
			evento.setModalidad(modalidad);
			
			EstadoEvento estadoEvento = estadoEventoBean.find(3L);
			evento.setEstado(estadoEvento);
			
			Itr itr = itrBean.findAll(datos[7]).get(0);
			evento.setItr(itr);
			
			evento.setLocalizacion(datos[8]);
			
			List<Usuario> tutoresList = new LinkedList<Usuario>();
			
			for(String s : tutores) {
				s=s.substring(0,8);
				try {
					usuario = usuarioBean.findAllForDocument(documentoBean.findAll(s).get(0)).get(0);
				} catch (ServicesException e) {
					e.printStackTrace();
				}
				tutoresList.add(usuario);
			}
		
			evento.setTutores(tutoresList);
			eventoBean.update(evento);	
			
			ListaEventos.cargarLista();
			ListaUsuarios.cargarLista();
			PanelListadoEventos.construirTabla(ListaEventos.getListaStringListado(),PanelListadoEventos.getTitulos());
			PanelListadoEventos.filtros();
			PanelFichaEvento.cargarDatos(evento);
			PanelFichaEvento.limpiar();
			PanelFichaEvento.crearModeloTablaTutores(evento);
			
			JOptionPane.showMessageDialog(new JFrame(), "Evento editado correctamente");
			
			return true;
			
		} catch (ServicesException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean editarEstudiantes(Evento evento, ArrayList<String> estudiantes) throws NamingException {
		
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 
		EventoBeanRemote eventoBean = (EventoBeanRemote) InitialContext.doLookup("PDT_EJB/EventoBean!com.services.EventoBeanRemote"); 
		ConvocatoriaAsistenciaBeanRemote asistenciaBean = (ConvocatoriaAsistenciaBeanRemote) InitialContext.doLookup("PDT_EJB/ConvocatoriaAsistenciaBean!com.services.ConvocatoriaAsistenciaBeanRemote"); 
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 

		List<Usuario> estudiantesList = new LinkedList<Usuario>();
		
		for(String s : estudiantes) {
			s=s.substring(0,8);
			try {
				usuario = usuarioBean.findAllForDocument(documentoBean.findAll(s).get(0)).get(0);
			} catch (ServicesException e) {
				e.printStackTrace();
			}
			estudiantesList.add(usuario);
		}
		
		for(ConvocatoriaAsistencia c : evento.getConvocatoriasAsistencias()) {
			try {
				asistenciaBean.drop(c.getIdConvocatoriaAsistencia());
				eventoBean.removeConvocatoriaAsistencia(evento.getIdEvento(), c.getIdConvocatoriaAsistencia());
			} catch (ServicesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ConvocatoriaAsistencia c = new ConvocatoriaAsistencia();
		List<ConvocatoriaAsistencia> asistencias = new LinkedList<ConvocatoriaAsistencia>();
		
		for(Usuario e : estudiantesList) {
			c.setEstudiante(e);
			c.setEvento(evento);
			try {
				asistenciaBean.create(c);
				eventoBean.addConvocatoriaAsistencia(evento.getIdEvento(), c);
			} catch (ServicesException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
			
		}
				
		ListaEventos.cargarLista();
		ListaUsuarios.cargarLista();
		try {
			PanelListadoEventos.construirTabla(ListaEventos.getListaStringListado(),PanelListadoEventos.getTitulos());
			PanelListadoEventos.filtros();
		} catch (NamingException | ServicesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PanelFichaEvento.cargarDatos(evento);
		PanelFichaEvento.crearModeloTablaEstudiantes(evento);
		PanelFichaEvento.limpiar();
		JOptionPane.showMessageDialog(new JFrame(), "Lista de estudianes modificados correctamente");
				
		return true;
	}

	public static void asistencia(List<String[]> lista, Evento evento) throws NamingException, ServicesException {
		
		ConvocatoriaAsistenciaBeanRemote asistenciaBean = (ConvocatoriaAsistenciaBeanRemote) InitialContext.doLookup("PDT_EJB/ConvocatoriaAsistenciaBean!com.services.ConvocatoriaAsistenciaBeanRemote"); 

		Usuario usuario = new Usuario();
		int i = 0;
		
		for(ConvocatoriaAsistencia ca : evento.getConvocatoriasAsistencias()) {
			
			ca.setAsistencia(lista.get(i)[1]);
			ca.setCalificacion(new BigDecimal(lista.get(i)[2]));
			System.out.println(ca.getCalificacion());
			
			asistenciaBean.update(ca);
			
			i++;
			
		}
		
		JOptionPane.showMessageDialog(new JFrame(), "Asistencia cargada correctamente");
		
	}
	
}
