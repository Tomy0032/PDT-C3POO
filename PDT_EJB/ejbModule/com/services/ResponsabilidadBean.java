package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Responsabilidad;
import com.exception.ServicesException;

/**
 * Session Bean implementation class ResponsabilidadBean
 */
@Stateless
@LocalBean
public class ResponsabilidadBean implements ResponsabilidadBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ResponsabilidadBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void create(Responsabilidad responsabilidad) throws ServicesException {
		try{
   			em.persist(responsabilidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la RESPONSABILIDAD");
   		}			
	}

	@Override
	public void update(Responsabilidad responsabilidad) throws ServicesException {
		try{
   			em.merge(responsabilidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la RESPONSABILIDAD");
   		}	
	}

	@Override
	public void drop(Long idResponsabilidad) throws ServicesException {
		try{
			Responsabilidad responsabilidad = em.find(Responsabilidad.class, idResponsabilidad);
   			em.remove(responsabilidad);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la RESPONSABILIDAD");
   		}
	}

	@Override
	public List<Responsabilidad> findAll() {
		TypedQuery<Responsabilidad> query = em.createQuery("SELECT r FROM Responsabilidad r",Responsabilidad.class); 
   		return query.getResultList();
	}

	@Override
	public Responsabilidad find(Long idResponsabilidad) throws ServicesException {
		try{
			Responsabilidad responsabilidad = em.find(Responsabilidad.class, idResponsabilidad);
   			return responsabilidad;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la RESPONSABILIDAD");
   		}
	}

}
