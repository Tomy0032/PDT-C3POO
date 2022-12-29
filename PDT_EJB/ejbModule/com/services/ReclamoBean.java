package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.AccionReclamo;
import com.entities.Reclamo;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ReclamoBean
 */
@Stateless
@LocalBean
public class ReclamoBean implements ReclamoBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ReclamoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Reclamo Reclamo) throws ServicesException {
   		try{
   			em.persist(Reclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la RECLAMO");
   		}		
   	}

   	@Override
   	public void update(Reclamo Reclamo) throws ServicesException {
   		try{
   			em.merge(Reclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la RECLAMO");
   		}		
   	}

   	@Override
   	public void drop(Long idReclamo) throws ServicesException {
   		try{
   			Reclamo Reclamo = em.find(Reclamo.class, idReclamo);
   			em.remove(Reclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la RECLAMO");
   		}
   	}
   	
   	@Override
   	public void addAccionReclamo(Long idReclamo, AccionReclamo accionReclamo) throws ServicesException {
   		try{
   			Reclamo Reclamo = em.find(Reclamo.class, idReclamo);
   			Reclamo.getAccionesReclamos().add(accionReclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar la ACCION Reclamo al la RECLAMO");
   		}		
   	}
   	
   	@Override
   	public void removeAccionReclamo(Long idReclamo, Long idAccionReclamo) throws ServicesException {
   		try{
   			Reclamo Reclamo = em.find(Reclamo.class, idReclamo);
   			AccionReclamo accionReclamo = em.find(AccionReclamo.class, idAccionReclamo);
   			Reclamo.getAccionesReclamos().remove(accionReclamo);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover la ACCION Reclamo de la RECLAMO");
   		}		
   	}

   	@Override
   	public List<Reclamo> findAll() {
   		TypedQuery<Reclamo> query = em.createQuery("SELECT r FROM Reclamo r",Reclamo.class); 
   		return query.getResultList();
   	}

   	@Override
   	public List<Reclamo> findAll(String filter) {
   		TypedQuery<Reclamo> query = em.createQuery("SELECT r FROM Reclamo r WHERE r.nombre LIKE :nombre",Reclamo.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
   	}

	@Override
	public Reclamo find(Long idReclamo) throws ServicesException {
		try{
   			Reclamo Reclamo = em.find(Reclamo.class, idReclamo);
   			return Reclamo;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la RECLAMO");
   		}
	}

}
