package com.services;

import java.net.IDN;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionReclamo;
import com.exception.ServicesException;

/**
 * Session Bean implementation class AccionReclamo
 */
@Stateless
@LocalBean
public class AccionReclamoBean implements AccionReclamoBeanRemote {

	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AccionReclamoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(AccionReclamo accionReclamo) throws ServicesException {
   		try{
   			em.persist(accionReclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la ACCION RECLAMO");
   		}		
   	}

   	@Override
   	public void update(AccionReclamo accionReclamo) throws ServicesException {
   		try{
   			em.merge(accionReclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la ACCION RECLAMO");
   		}		
   	}

   	@Override
   	public void drop(Long idAccionReclamo) throws ServicesException {
   		try{
   			AccionReclamo accionReclamo = em.find(AccionReclamo.class, idAccionReclamo);
   			em.remove(accionReclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la ACCION RECLAMO");
   		}
   	}
   	  	
   	@Override
   	public List<AccionReclamo> findAll() {
   		TypedQuery<AccionReclamo> query = em.createQuery("SELECT a FROM AccionReclamo a",AccionReclamo.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<AccionReclamo> findAll(String filter) {
   		TypedQuery<AccionReclamo> query = em.createQuery("SELECT a FROM AccionReclamo a WHERE a.nombre LIKE :nombre",AccionReclamo.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public AccionReclamo find(Long idAccionReclamo) throws ServicesException {
   		try{
   			AccionReclamo accionReclamo = em.find(AccionReclamo.class, idAccionReclamo);
   			return accionReclamo;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la ACCION RECLAMO");
   		}
   	}

}
