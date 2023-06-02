package com.services;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.entities.Generacion;
import com.exception.ServicesException;

/**
 * Session Bean implementation class GeneracionBean
 */
@Stateless
@LocalBean
public class GeneracionBean implements GeneracionBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public GeneracionBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void create(Generacion generacion) throws ServicesException {
   		try{
   			em.persist(generacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo crear la GENERACION");
   		}		
   	}

   	@Override
   	public void update(Generacion generacion) throws ServicesException {
   		try{
   			em.merge(generacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo actualizar la GENERACION");
   		}		
   	}

   	@Override
   	public void drop(Long idGeneracion) throws ServicesException {
   		try{
   			Generacion generacion = em.find(Generacion.class, idGeneracion);
   			em.remove(generacion);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo eliminar la GENERACION");
   		}
   	}
   	
   	@Override
   	public void addEstudiante(Long idGeneracion, Usuario estudiante) throws ServicesException {
   		try{
   			Generacion generacion = em.find(Generacion.class, idGeneracion);
   			generacion.getEstudiantes().add(estudiante);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo agregar el ESTUDIANTE a la GENERACION");
   		}		
   	}
   	
   	@Override
   	public void removeEstudiante(Long idGeneracion, Long idEstudiante) throws ServicesException {
   		try{
   			Generacion generacion = em.find(Generacion.class, idGeneracion);
   			Usuario estudiante = em.find(Usuario.class, idEstudiante);
   			generacion.getEstudiantes().remove(estudiante);
   			em.flush();
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo remover el ESTUDIANTE de la GENERACION");
   		}		
   	}

   	@Override
   	public List<Generacion> findAll() throws ServicesException {
   		try {
	   		TypedQuery<Generacion> query = em.createQuery("SELECT g FROM Generacion g",Generacion.class); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron GENERACIONES");
		}
   	}

   	@Override
   	public List<Generacion> findAllForName(String filter) throws ServicesException {
   		try {
	   		TypedQuery<Generacion> query = em.createQuery("SELECT g FROM Generacion g WHERE g.nombre LIKE :nombre",Generacion.class)
	   				.setParameter("nombre", filter); 
	   		return query.getResultList();
	   	}catch(Exception e) {
			throw new ServicesException("No se encontraron GENERACIONES con ese NOMBRE");
	}
   	}
   	
	@Override
   	public List<Generacion> findAllForYear(BigDecimal filter) throws ServicesException {
		try {
	   		TypedQuery<Generacion> query = em.createQuery("SELECT g FROM Generacion g WHERE g.ano LIKE :ano",Generacion.class)
	   				.setParameter("ano", filter); 
	   		return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron GENERACIONES para ese AÑO");
		}
   	}

	@Override
	public Generacion find(Long idGeneracion) throws ServicesException {
		try{
   			Generacion Generacion = em.find(Generacion.class, idGeneracion);
   			return Generacion;
   		}catch(PersistenceException e){
   			throw new ServicesException("No se pudo obtener la GENERACION");
   		}
	}

}
