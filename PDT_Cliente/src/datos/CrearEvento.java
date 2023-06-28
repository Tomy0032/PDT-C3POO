package datos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.entities.Modalidad;
import com.entities.EstadoEvento;
import com.entities.Documento;
import com.entities.Itr;
import com.entities.Localidad;
import com.entities.TipoEvento;
import com.entities.Evento;
import com.entities.Usuario;
import com.enums.EstadoUsuario;
import com.exception.ServicesException;
import com.services.ModalidadBeanRemote;
import com.services.DepartamentoBeanRemote;
import com.services.DocumentoBeanRemote;
import com.services.EventoBeanRemote;
import com.services.GeneroBeanRemote;
import com.services.ItrBeanRemote;
import com.services.EstadoEventoBeanRemote;
import com.services.ModalidadBean;
import com.services.PaisBeanRemote;
import com.services.TipoTutorBeanRemote;
import com.services.TipoEventoBeanRemote;
import com.services.UsuarioBeanRemote;

import componentes.PanelFichaEvento;
import componentes.PanelListadoEventos;
import listas.ListaEventos;
import listas.ListaUsuarios;
import mail.EmailSenderService;

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
			
			JOptionPane.showMessageDialog(new JFrame(), "Evento editado correctamente");
			
			return true;
			
		} catch (ServicesException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
