package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.TipoEvento;
import com.entities.Evento;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoBean
 */
@Stateless
@LocalBean
public class TipoEventoBean implements TipoEventoBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TipoEventoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(TipoEvento tipo) throws ServicesException {
   		try{
   			em.persist(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el TIPO DE EVENTO");
   		}		
   	}

   	@Override
   	public void update(TipoEvento tipo) throws ServicesException {
   		try{
   			em.merge(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el TIPO DE EVENTO");
   		}		
   	}

   	@Override
   	public void drop(Long idTipo) throws ServicesException {
   		try{
   			TipoEvento tipo = em.find(TipoEvento.class, idTipo);
   			em.remove(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el TIPO DE EVENTO");
   		}
   	}
   	
   	@Override
   	public void addEvento(Long idTipo, Evento evento) throws ServicesException {
   		try{
   			TipoEvento tipo = em.find(TipoEvento.class, idTipo);
   			tipo.getEventos().add(evento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el EVENTO al TIPO DE EVENTO");
   		}		
   	}
   	
   	@Override
   	public void removeEvento(Long idTipo, Long idEvento) throws ServicesException {
   		try{
   			TipoEvento tipo = em.find(TipoEvento.class, idTipo);
   			Evento evento = em.find(Evento.class, idEvento);
   			tipo.getEventos().remove(evento);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el EVENTO del TIPO DE EVENTO");
   		}		
   	}
   	
   	@Override
   	public List<TipoEvento> findAll() throws ServicesException {
   		try {
	   		TypedQuery<TipoEvento> query = em.createQuery("SELECT t FROM TipoEvento t",TipoEvento.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS DE EVENTO");
		}
   	}

   	@Override
   	public List<TipoEvento> findAll(String filter) throws ServicesException {
   		try {
   			TypedQuery<TipoEvento> query = em.createQuery("SELECT t FROM TipoEvento t WHERE t.nombre LIKE :nombre",TipoEvento.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS DE EVENTO con ese NOMBRE");
		}
   	}

	@Override
	public TipoEvento find(Long idTipo) throws ServicesException {
		try{
   			TipoEvento tipo = em.find(TipoEvento.class, idTipo);
   			return tipo;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el TIPO DE EVENTO");
   		}
	}

}
