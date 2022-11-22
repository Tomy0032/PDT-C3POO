package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO database table.
 * 
 */
@Entity
@Table(name="TIPO")
@NamedQuery(name="Tipo.findAll", query="SELECT t FROM Tipo t")
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_TIPO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TIPO")
	@Column(name="ID_TIPO", unique=true, nullable=false, precision=38)
	private long idTipo;

	@Column(nullable=false, length=20)
	private String nombre;

	//bi-directional many-to-one association to Tutor
	@OneToMany(mappedBy="tipo")
	private List<Tutor> tutores;

	public Tipo() {
	}

	public long getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(long idTipo) {
		this.idTipo = idTipo;
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

	public void setTutores(List<Tutor> tutores) {
		this.tutores = tutores;
	}

	public Tutor addTutor(Tutor tutor) {
		getTutores().add(tutor);
		tutor.setTipo(this);

		return tutor;
	}

	public Tutor removeTutor(Tutor tutor) {
		getTutores().remove(tutor);
		tutor.setTipo(null);

		return tutor;
	}

}