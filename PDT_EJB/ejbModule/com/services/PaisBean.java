package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Pais;
import com.exception.ServicesException;

/**
 * Session Bean implementation class PaisBean
 */
@Stateless
@LocalBean
public class PaisBean implements PaisBeanRemote {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PaisBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Pais pais) throws ServicesException {
		try{
			em.persist(pais);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo crear el PAIS");
		}		
	}

	@Override
	public void update(Pais pais) throws ServicesException {
		try{
			em.merge(pais);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo actualizar el PAIS");
		}		
	}

	@Override
	public void drop(Long idPais) throws ServicesException {
		try{
			Pais pais = em.find(Pais.class, idPais);
			em.remove(pais);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo eliminar el PAIS");
		}
	}

	@Override
	public List<Pais> findAll() throws ServicesException {
		try {
			TypedQuery<Pais> query = em.createQuery("SELECT p FROM Pais p",Pais.class); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron PAISES");
	}
	}

	@Override
	public List<Pais> findAll(String filter) throws ServicesException {
		try {
			TypedQuery<Pais> query = em.createQuery("SELECT p FROM Pais p WHERE p.nombre LIKE :nombre",Pais.class)
					.setParameter("nombre", filter); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron PAISES con ese NOMBRE");
		}
	}

	@Override
	public Pais find(Long idPais) throws ServicesException {
		try{
			Pais pais = em.find(Pais.class, idPais);
			return pais;
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo obtener el PAIS");
		}
	}

}
