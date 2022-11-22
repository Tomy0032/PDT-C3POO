package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Itr;
import com.entities.Localidad;
import com.entities.Usuario;
import com.exception.ServicesException;

/**
 * Session Bean implementation class LocalidadBean
 */
@Stateless
@LocalBean
public class LocalidadBean implements LocalidadBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public LocalidadBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void create(Localidad localidad) throws ServicesException {
		try{
			em.persist(localidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo crear el LOCALIDAD");
		}		
	}

	@Override
	public void update(Localidad localidad) throws ServicesException {
		try{
			em.merge(localidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo actualizar el LOCALIDAD");
		}		
	}

	@Override
	public void drop(Long idLocalidad) throws ServicesException {
		try{
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			em.remove(localidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo eliminar el LOCALIDAD");
		}
	}
	
	@Override
	public void addItr(Long idLocalidad, Itr itr) throws ServicesException {
		try{
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			localidad.getItrs().add(itr);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar el ITR a la LOCALIDAD");
		}		
	}
	
	@Override
	public void removeItr(Long idLocalidad, Long idItr) throws ServicesException {
		try{
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			Itr itr = em.find(Itr.class, idItr);
			localidad.getItrs().remove(itr);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover el ITR de la LOCALIDAD");
		}		
	}
	
	@Override
	public void addUsuario(Long idLocalidad, Usuario usuario) throws ServicesException {
		try{
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			localidad.getUsuarios().add(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar el USUARIO a la LOCALIDAD");
		}		
	}
	
	@Override
	public void removeUsuario(Long idLocalidad, Long idUsuario) throws ServicesException {
		try{
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			Usuario usuario = em.find(Usuario.class, idUsuario);
			localidad.getItrs().remove(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover el USUARIO de la LOCALIDAD");
		}		
	}

	@Override
	public List<Localidad> findAll() {
		TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l",Localidad.class); 
		return query.getResultList();
	}

	@Override
	public List<Localidad> findAll(String filter) {
		TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l WHERE m.nombre LIKE :nombre",Localidad.class)
				.setParameter("nombre", filter); 
		return query.getResultList();
	}

	@Override
	public Localidad find(Long idLocalidad) throws ServicesException {
		try{
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			return localidad;
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo obtener el LOCALIDAD");
		}
	}

}
