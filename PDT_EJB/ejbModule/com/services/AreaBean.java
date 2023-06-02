package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
@LocalBean
public class AreaBean implements AreaBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public AreaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Area area) throws ServicesException {
   		try{
   			em.persist(area);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el AREA");
   		}		
   	}

   	@Override
   	public void update(Area area) throws ServicesException {
   		try{
   			em.merge(area);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el AREA");
   		}		
   	}

   	@Override
   	public void drop(Long idArea) throws ServicesException {
   		try{
   			Area area = em.find(Area.class, idArea);
   			em.remove(area);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el AREA");
   		}
   	}
   	
   	@Override
   	public void addTutor(Long idArea, Usuario tutor) throws ServicesException {
   		try{
   			Area area = em.find(Area.class, idArea);
   			area.getTutores().add(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el TUTOR al AREA");
   		}		
   	}
   	
   	@Override
   	public void removeTutor(Long idArea, Long idTutor) throws ServicesException {
   		try{
   			Area area = em.find(Area.class, idArea);
   			Usuario tutor = em.find(Usuario.class, idTutor);
   			area.getTutores().remove(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el TUTOR del AREA");
   		}		
   	}
   	
   	@Override
   	public List<Area> findAll() throws ServicesException {
   		try{
   			TypedQuery<Area> query = em.createQuery("SELECT a FROM Area a",Area.class); 
   			return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron AREAS");
		}
   	}

   	@Override
   	public List<Area> findAll(String filter) throws ServicesException {
   		try {
	   		TypedQuery<Area> query = em.createQuery("SELECT a FROM Area a WHERE a.nombre LIKE :nombre",Area.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron AREAS con ese NOMBRE");
		}
   	}

	@Override
	public Area find(Long idArea) throws ServicesException {
		try{
   			Area area = em.find(Area.class, idArea);
   			return area;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el AREA");
   		}
	}

}
