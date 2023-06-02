package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.EstadoEvento;
import com.entities.Evento;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoBean
 */
@Stateless
@LocalBean
public class EstadoEventoBean implements EstadoEventoBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EstadoEventoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(EstadoEvento estado) throws ServicesException {
   		try{
   			em.persist(estado);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el ESTADO DE EVENTO");
   		}		
   	}

   	@Override
   	public void update(EstadoEvento estado) throws ServicesException {
   		try{
   			em.merge(estado);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el ESTADO DE EVENTO");
   		}		
   	}

   	@Override
   	public void drop(Long idEstado) throws ServicesException {
   		try{
   			EstadoEvento estado = em.find(EstadoEvento.class, idEstado);
   			em.remove(estado);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el ESTADO DE EVENTO");
   		}
   	}
   	
   	@Override
   	public void addEvento(Long idEstado, Evento evento) throws ServicesException {
   		try{
   			EstadoEvento estado = em.find(EstadoEvento.class, idEstado);
   			estado.getEventos().add(evento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el EVENTO al ESTADO DE EVENTO");
   		}		
   	}
   	
   	@Override
   	public void removeEvento(Long idEstado, Long idEvento) throws ServicesException {
   		try{
   			EstadoEvento estado = em.find(EstadoEvento.class, idEstado);
   			Evento evento = em.find(Evento.class, idEvento);
   			estado.getEventos().remove(evento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el ESTADO del TIPO DE EVENTO");
   		}		
   	}
   	
   	@Override
   	public List<EstadoEvento> findAll() throws ServicesException {
   		try {
	   		TypedQuery<EstadoEvento> query = em.createQuery("SELECT e FROM EstadoEvento e",EstadoEvento.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron ESTADOS DE EVENTO");
		}
   	}

   	@Override
   	public List<EstadoEvento> findAll(String filter) throws ServicesException {
   		try {
   			TypedQuery<EstadoEvento> query = em.createQuery("SELECT e FROM EstadoEvento e WHERE e.nombre LIKE :nombre",EstadoEvento.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron ESTADOS DE EVENTO con ese NOMBRE");
		}
   	}

	@Override
	public EstadoEvento find(Long idEstado) throws ServicesException {
		try{
			EstadoEvento estado = em.find(EstadoEvento.class, idEstado);
   			return estado;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el ESTADO DE EVENTO");
   		}
	}

}
