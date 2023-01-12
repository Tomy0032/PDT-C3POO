package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the GENERACION database table.
 * 
 */
@Entity
@Table(name="GENERACION")
@NamedQuery(name="Generacion.findAll", query="SELECT g FROM Generacion g")
public class Generacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_GENERACION" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GENERACION")
	@Column(name="ID_GENERACION", unique=true, nullable=false, precision=38)
	private long idGeneracion;

	@Column(nullable=false, unique=true, precision=38)
	private BigDecimal ano;

	@Column(nullable=false, unique=true, length=20)
	private String nombre;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="generacion")
	private List<Estudiante> estudiantes;

	public Generacion() {
	}

	public long getIdGeneracion() {
		return this.idGeneracion;
	}

	public void setIdGeneracion(long idGeneracion) {
		this.idGeneracion = idGeneracion;
	}

	public BigDecimal getAno() {
		return this.ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setGeneracion(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setGeneracion(null);

		return estudiante;
	}

}