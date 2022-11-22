package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ConvocatoriaAsistencia;
import com.exception.ServicesException;

@Remote
public interface ConvocatoriaAsistenciaBeanRemote {
	
	void create(ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException;
	void update(ConvocatoriaAsistencia convocatoriaAsistencia) throws ServicesException;
	void drop(Long idConvocatoriaAsistencia) throws ServicesException;
	List<ConvocatoriaAsistencia> findAll();
	List<ConvocatoriaAsistencia> findAll(String filter);
	ConvocatoriaAsistencia find(Long idConvocatoriaAsistencia) throws ServicesException;

}
