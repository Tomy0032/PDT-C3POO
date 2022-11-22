package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTAMENTO database table.
 * 
 */
@Entity
@Table(name="DEPARTAMENTO")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_DEPARTAMENTO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEPARTAMENTO")
	@Column(name="ID_DEPARTAMENTO", unique=true, nullable=false, precision=38)
	private long idDepartamento;

	@Column(nullable=false, length=16)
	private String nombre;

	//bi-directional many-to-one association to Localidad
	@OneToMany(mappedBy="departamento")
	private List<Localidad> localidades;

	public Departamento() {
	}

	public long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Localidad> getLocalidades() {
		return this.localidades;
	}

	public void setLocalidadss(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	public Localidad addLocalidad(Localidad localidad) {
		getLocalidades().add(localidad);
		localidad.setDepartamento(this);

		return localidad;
	}

	public Localidad removeLocalidad(Localidad localidad) {
		getLocalidades().remove(localidad);
		localidad.setDepartamento(null);

		return localidad;
	}

}