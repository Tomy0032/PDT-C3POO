package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Responsabilidad;
import com.entities.Tutor;
import com.exception.ServicesException;

/**
 * Session Bean implementation class TutorBean
 */
@Stateless
@LocalBean
public class TutorBean implements TutorBeanRemote {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public TutorBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void create(Tutor tutor) throws ServicesException {
		try{
   			em.persist(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear el TUTOR");
   		}			
	}

	@Override
	public void update(Tutor tutor) throws ServicesException {
		try{
   			em.merge(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar el TUTOR");
   		}	
	}

	@Override
	public void drop(Long idTutor) throws ServicesException {
		try{
			Tutor tutor = em.find(Tutor.class, idTutor);
   			em.remove(tutor);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar el Tutor");
   		}
	}

	@Override
	public void addResponsabilidad(Long idTutor, Responsabilidad responsabilidad) throws ServicesException {
		try{
			Tutor tutor = em.find(Tutor.class, idTutor);
			tutor.getResponsabilidades().add(responsabilidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la RESPONSABILIDAD al TUTOR");
		}
	}

	@Override
	public void removeResponsabilidad(Long idTutor, Long idResponsabilidad) throws ServicesException {
		try{
			Tutor tutor = em.find(Tutor.class, idTutor);
			Responsabilidad responsabilidad = em.find(Responsabilidad.class, idResponsabilidad);
			tutor.getResponsabilidades().remove(responsabilidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la RESPONSABILIDAD del TUTOR");
		}		
	}

	@Override
	public List<Tutor> findAll() {
		TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t",Tutor.class); 
   		return query.getResultList();
	}

	@Override
	public List<Tutor> findAll(String filter) {
		TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t WHERE t.nombre LIKE :nombre",Tutor.class)
   				.setParameter("nombre", filter); 
   		return query.getResultList();
	}

	@Override
	public Tutor find(Long idTutor) throws ServicesException {
		try{
			Tutor tutor = em.find(Tutor.class, idTutor);
   			return tutor;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener el TUTOR");
   		}
	}

}
