package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Localidad;
import com.exception.ServicesException;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
@LocalBean
public class DepartamentoBean implements DepartamentoBeanRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void create(Departamento departamento) throws ServicesException {
		try{
			em.persist(departamento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo crear el DEPARTAMENTO");
		}		
	}

	@Override
	public void update(Departamento departamento) throws ServicesException {
		try{
			em.merge(departamento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo actualizar el DEPARTAMENTO");
		}		
	}

	@Override
	public void drop(Long idDepartamento) throws ServicesException {
		try{
			Departamento departamento = em.find(Departamento.class, idDepartamento);
			em.remove(departamento);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo eliminar el DEPARTAMENTO");
		}
	}
	
	@Override
	public void addLocalidad(Long idDepartamento, Localidad localidad) throws ServicesException {
		try{
			Departamento departamento = em.find(Departamento.class, idDepartamento);
			departamento.getLocalidades().add(localidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo agregar la LOCALIDAD al DEPARTAMENTO");
		}		
	}
	
	@Override
	public void removeLocalidad(Long idDepartamento, Long idLocalidad) throws ServicesException {
		try{
			Departamento departamento = em.find(Departamento.class, idDepartamento);
			Localidad localidad = em.find(Localidad.class, idLocalidad);
			departamento.getLocalidades().remove(localidad);
			em.flush();
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo remover la LOCALIDAD del DEPARTAMENTO");
		}		
	}

	@Override
	public List<Departamento> findAll() throws ServicesException {
		try{
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d order by d.idDepartamento asc",Departamento.class); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron DEPARTAMENTOS");
		}
	}

	@Override
	public List<Departamento> findAll(String filter) throws ServicesException {
		try {
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d WHERE d.nombre LIKE :nombre",Departamento.class)
					.setParameter("nombre", filter); 
			return query.getResultList();
		}catch(Exception e) {
			throw new ServicesException("No se encontraron DEPARTAMENTOS con ese NOMBRE");
		}
	}

	@Override
	public Departamento find(Long idDepartamento) throws ServicesException {
		try{
			Departamento departamento = em.find(Departamento.class, idDepartamento);
			return departamento;
		}catch(PersistenceException e){
			throw new ServicesException("No se pudo obtener el DEPARTAMENTO");
		}
	}

}
