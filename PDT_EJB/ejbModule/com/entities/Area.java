package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AREA database table.
 * 
 */
@Entity
@Table(name="AREA")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_AREA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_AREA")
	@Column(name="ID_AREA", unique=true, nullable=false, precision=38)
	private long idArea;

	@Column(nullable=false, length=20)
	private String nombre;

	//bi-directional many-to-one association to Tutor
	@OneToMany(mappedBy="area")
	private List<Tutor> tutores;

	public Area() {
	}

	public long getIdArea() {
		return this.idArea;
	}

	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tutor> getTutores() {
		return this.tutores;
	}

	public void setTutores(List<Tutor> tutors) {
		this.tutores = tutors;
	}

	public Tutor addTutor(Tutor tutor) {
		getTutores().add(tutor);
		tutor.setArea(this);

		return tutor;
	}

	public Tutor removeTutor(Tutor tutor) {
		getTutores().remove(tutor);
		tutor.setArea(null);

		return tutor;
	}

}