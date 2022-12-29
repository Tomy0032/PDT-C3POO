package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionConstancia;
import com.exception.ServicesException;

/**
 * Session Bean implementation class AccionConstanciaBean
 */
@Stateless
@LocalBean
public class AccionConstanciaBean implements AccionConstanciaBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AccionConstanciaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(AccionConstancia accionConstancia) throws ServicesException {
   		try{
   			em.persist(accionConstancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la ACCION CONSTANCIA");
   		}		
   	}

   	@Override
   	public void update(AccionConstancia accionConstancia) throws ServicesException {
   		try{
   			em.merge(accionConstancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la ACCION CONSTANCIA");
   		}		
   	}

   	@Override
   	public void drop(Long idAccionConstancia) throws ServicesException {
   		try{
   			AccionConstancia accionConstancia = em.find(AccionConstancia.class, idAccionConstancia);
   			em.remove(accionConstancia);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la ACCION CONSTANCIA");
   		}
   	}
   	  	
   	@Override
   	public List<AccionConstancia> findAll() {
   		TypedQuery<AccionConstancia> query = em.createQuery("SELECT a FROM AccionConstancia a",AccionConstancia.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<AccionConstancia> findAll(String filter) {
   		TypedQuery<AccionConstancia> query = em.createQuery("SELECT a FROM AccionConstancia a WHERE a.nombre LIKE :nombre",AccionConstancia.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public AccionConstancia find(Long idAccionConstancia) throws ServicesException {
		try{
   			AccionConstancia accionConstancia = em.find(AccionConstancia.class, idAccionConstancia);
   			return accionConstancia;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la ACCION CONSTANCIA");
   		}
	}

}
