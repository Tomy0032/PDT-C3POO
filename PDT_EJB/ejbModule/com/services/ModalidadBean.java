package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Modalidad;
import com.entities.Evento;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoBean
 */
@Stateless
@LocalBean
public class ModalidadBean implements ModalidadBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ModalidadBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Modalidad modalidad) throws ServicesException {
   		try{
   			em.persist(modalidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la MODALIDAD");
   		}		
   	}

   	@Override
   	public void update(Modalidad modalidad) throws ServicesException {
   		try{
   			em.merge(modalidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la MODALIDAD");
   		}		
   	}

   	@Override
   	public void drop(Long idModalidad) throws ServicesException {
   		try{
   			Modalidad modalidad = em.find(Modalidad.class, idModalidad);
   			em.remove(modalidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la MODALIDAD");
   		}
   	}
   	
   	@Override
   	public void addEvento(Long idModalidad, Evento evento) throws ServicesException {
   		try{
   			Modalidad modalidad = em.find(Modalidad.class, idModalidad);
   			modalidad.getEventos().add(evento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el EVENTO a la MODADLIDAD");
   		}		
   	}
   	
   	@Override
   	public void removeEvento(Long idModalidad, Long idEvento) throws ServicesException {
   		try{
   			Modalidad modalidad = em.find(Modalidad.class, idModalidad);
   			Evento evento = em.find(Evento.class, idEvento);
   			modalidad.getEventos().remove(evento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el EVENTO de la MODALIDAD");
   		}		
   	}
   	
   	@Override
   	public List<Modalidad> findAll() throws ServicesException {
   		try {
	   		TypedQuery<Modalidad> query = em.createQuery("SELECT m FROM Modalidad m",Modalidad.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron MODALIDADES");
		}
   	}

   	@Override
   	public List<Modalidad> findAll(String filter) throws ServicesException {
   		try {
   			TypedQuery<Modalidad> query = em.createQuery("SELECT m FROM Modalidad m WHERE m.nombre LIKE :nombre",Modalidad.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron MODALIDADES con ese NOMBRE");
		}
   	}

	@Override
	public Modalidad find(Long idModalidad) throws ServicesException {
		try{
   			Modalidad modalidad = em.find(Modalidad.class, idModalidad);
   			return modalidad;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la MODALIDAD");
   		}
	}

}
