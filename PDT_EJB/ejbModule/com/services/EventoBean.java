package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Constancia;
import com.entities.ConvocatoriaAsistencia;
import com.entities.Evento;
import com.entities.Gestion;
import com.entities.Justificacion;
import com.entities.Reclamo;
import com.entities.Responsabilidad;
import com.exception.ServicesException;

/**
 * Session Bean implementation class EventoBean
 */
@Stateless
@LocalBean
public class EventoBean implements EventoBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EventoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Evento evento) throws ServicesException {
   		try{
      			em.persist(evento);
      			em.flush();
      		}catch(PersistenceException e){
      			throw new ServicesException("No se pudo crear el EVENTO");
      		}			
   	}

   	@Override
   	public void update(Evento evento) throws ServicesException {
   		try{
      			em.merge(evento);
      			em.flush();
      		}catch(PersistenceException e){
      			throw new ServicesException("No se pudo actualizar el EVENTO");
      		}	
   	}

   	@Override
   	public void drop(Long idEvento) throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
      			em.remove(evento);
      			em.flush();
      	}catch(PersistenceException e){
      		throw new ServicesException("No se pudo eliminar el EVENTO");
      	}
   	}

   	@Override
   	public void addConstancia(Long idEvento, Constancia constancia) throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			evento.getConstancias().add(constancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la CONSTANCIA al EVENTO");
   		}
   	}

   	@Override
   	public void removeConstancia(Long idEvento, Long idConstancia) throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			Constancia constancia = em.find(Constancia.class, idConstancia);
   			evento.getConstancias().remove(constancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la CONSTANCIA del EVENTO");
   		}		
   	}

   	@Override
   	public void addJustificacion(Long idEvento, Justificacion justificacion)
   			throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			evento.getJustificaciones().add(justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la JUSTIFICACION al EVENTO");
   		}		
   	}

   	@Override
   	public void removeJustificacion(Long idEvento, Long idJustificacion) throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			Justificacion justificacion = em.find(Justificacion.class, idJustificacion);
   			evento.getJustificaciones().remove(justificacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la JUSTIFICACION del EVENTO");
   		}		
   	}

   	@Override
   	public void addConvocatoriaAsistencia(Long idEvento, ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			evento.getConvocatoriasAsistencias().add(convocatoriaAsistencia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la CONVOCATORIA ASISTENCIA al EVENTO");
   		}			
   	}

   	@Override
   	public void removeConvocatoriaAsistencia(Long idEvento, Long idConvocatoriaAsistencia) throws ServicesException {
   		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			ConvocatoriaAsistencia convocatoriaAsistencia = em.find(ConvocatoriaAsistencia.class, idConvocatoriaAsistencia);
   			evento.getConvocatoriasAsistencias().remove(convocatoriaAsistencia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la CONVOCATORIA ASISTENCIA del EVENTO");
   		}
   	} 	

	@Override
	public void addGestion(Long idEvento, Gestion gestion) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			evento.getGestiones().add(gestion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la GESTION al EVENTO");
   		}		
	}

	@Override
	public void removeGestion(Long idEvento, Long idGestion) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			Gestion gestion = em.find(Gestion.class, idGestion);
   			evento.getGestiones().remove(gestion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la GESTION del EVENTO");
   		}
	}

	@Override
	public void addReclamo(Long idEvento, Reclamo reclamo) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			evento.getReclamos().add(reclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el RECLAMO al EVENTO");
   		}	
	}

	@Override
	public void removeReclamo(Long idEvento, Long idReclamo) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			Reclamo reclamo = em.find(Reclamo.class, idReclamo);
   			evento.getReclamos().remove(reclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el RECLAMO del EVENTO");
   		}
	}

	@Override
	public void addResponsabilidad(Long idEvento, Responsabilidad responsabilidad) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			evento.getResponsabilidades().add(responsabilidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la RESPONSABILIDAD al EVENTO");
   		}	
	}

	@Override
	public void removeResponsabilidad(Long idEvento, Long idResponsabilidad) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
   			Responsabilidad responsabilidad = em.find(Responsabilidad.class, idResponsabilidad);
   			evento.getResponsabilidades().remove(responsabilidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la RESPONSABILIDAD del EVENTO");
   		}
	}
	
	@Override
   	public List<Evento> findAll() {
   		TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e",Evento.class); 
      		return query.getResultList();
   	}

   	@Override
   	public List<Evento> findAll(String filter) {
   		TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.nombre LIKE :nombre",Evento.class)
      				.setParameter("nombre", filter); 
      		return query.getResultList();
    }

	@Override
	public Evento find(Long idEvento) throws ServicesException {
		try{
   			Evento evento = em.find(Evento.class, idEvento);
      			return evento;
      	}catch(PersistenceException e){
      		throw new ServicesException("No se pudo obtener el EVENTO");
      	}
	} 
	
}
