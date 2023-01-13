package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Responsabilidad;
import com.entities.Tipo;
import com.entities.Tutor;
import com.entities.Usuario;
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
	public List<Tutor> findAll() throws ServicesException {
		try {
			TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t",Tutor.class); 
	   		return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron TUTORES");
		}
	}

	@Override
	public List<Tutor> findAllForArea(Area area) throws ServicesException {
		try {
			TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t WHERE t.area = :area",Tutor.class)
	   				.setParameter("area", area); 
	   		return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron TUTORES para esa AREA");
		}
	}
	
	@Override
	public List<Tutor> findAllForTipo(Tipo tipo) throws ServicesException {
		try {
			TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t WHERE t.tipo = :tipo",Tutor.class)
	   				.setParameter("tipo", tipo); 
	   		return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron TUTORES para ese TIPO");
		}
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

	@Override
	public Tutor findForUser(Usuario usuario) throws ServicesException {
		try {	
			TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t WHERE t.usuario = :usuario",Tutor.class)
	   				.setParameter("usuario", usuario); 
	   		return query.getResultList().get(0);
		}catch(Exception e) {
			throw new ServicesException("El USUARIO no es TUTOR");
		}
	}
	
}
