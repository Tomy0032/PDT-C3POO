package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Tipo;
import com.entities.Tutor;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TipoBean
 */
@Stateless
@LocalBean
public class TipoBean implements TipoBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TipoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Tipo tipo) throws ServicesException {
   		try{
   			em.persist(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el TIPO");
   		}		
   	}

   	@Override
   	public void update(Tipo tipo) throws ServicesException {
   		try{
   			em.merge(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el TIPO");
   		}		
   	}

   	@Override
   	public void drop(Long idTipo) throws ServicesException {
   		try{
   			Tipo tipo = em.find(Tipo.class, idTipo);
   			em.remove(tipo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el TIPO");
   		}
   	}
   	
   	@Override
   	public void addTutor(Long idTipo, Tutor tutor) throws ServicesException {
   		try{
   			Tipo tipo = em.find(Tipo.class, idTipo);
   			tipo.getTutores().add(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el TUTOR al TIPO");
   		}		
   	}
   	
   	@Override
   	public void removeTutor(Long idTipo, Long idTutor) throws ServicesException {
   		try{
   			Tipo tipo = em.find(Tipo.class, idTipo);
   			Tutor tutor = em.find(Tutor.class, idTutor);
   			tipo.getTutores().remove(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el TUTOR del TIPO");
   		}		
   	}
   	
   	@Override
   	public List<Tipo> findAll() throws ServicesException {
   		try {
	   		TypedQuery<Tipo> query = em.createQuery("SELECT t FROM Tipo t",Tipo.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS");
		}
   	}

   	@Override
   	public List<Tipo> findAll(String filter) throws ServicesException {
   		try {
   			TypedQuery<Tipo> query = em.createQuery("SELECT t FROM Tipo t WHERE t.nombre LIKE :nombre",Tipo.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron TIPOS con ese NOMBRE");
		}
   	}

	@Override
	public Tipo tipo(Long idTipo) throws ServicesException {
		try{
   			Tipo tipo = em.find(Tipo.class, idTipo);
   			return tipo;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el TIPO");
   		}
	}

}
