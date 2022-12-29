package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Gestion;
import com.exception.ServicesException;

/**
 * Session Bean implementation class GestionBean
 */
@Stateless
@LocalBean
public class GestionBean implements GestionBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GestionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Gestion gestion) throws ServicesException {
   		try{
      			em.persist(gestion);
      			em.flush();
      		}catch(PersistenceException e){
      			throw new ServicesException("No se pudo crear el GESTION");
      		}			
   	}

   	@Override
   	public void update(Gestion gestion) throws ServicesException {
   		try{
      			em.merge(gestion);
      			em.flush();
      		}catch(PersistenceException e){
      			throw new ServicesException("No se pudo actualizar el GESTION");
      		}	
   	}

   	@Override
   	public void drop(Long idGestion) throws ServicesException {
   		try{
   			Gestion gestion = em.find(Gestion.class, idGestion);
      		em.remove(gestion);
      		em.flush();
      	}catch(PersistenceException e){
      		throw new ServicesException("No se pudo eliminar el GESTION");
      	}
   	}
	
	@Override
   	public List<Gestion> findAll() {
   		TypedQuery<Gestion> query = em.createQuery("SELECT g FROM Gestion g",Gestion.class); 
      		return query.getResultList();
   	}

   	@Override
   	public List<Gestion> findAll(String filter) {
   		TypedQuery<Gestion> query = em.createQuery("SELECT g FROM Gestion g WHERE g.nombre LIKE :nombre",Gestion.class)
      				.setParameter("nombre", filter); 
      		return query.getResultList();
    }

	@Override
	public Gestion find(Long idGestion) throws ServicesException {
		try{
   			Gestion gestion = em.find(Gestion.class, idGestion);
      		return gestion;
      	}catch(PersistenceException e){
      		throw new ServicesException("No se pudo obtener el GESTION");
      	}
	}

}
