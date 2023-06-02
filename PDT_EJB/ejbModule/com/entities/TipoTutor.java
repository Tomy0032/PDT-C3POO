package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO database table.
 * 
 */
@Entity
@Table(name="TIPO_TUTOR")
@NamedQuery(name="TipoTutor.findAll", query="SELECT t FROM TipoTutor t")
public class TipoTutor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_TIPO_TUTOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TIPO_TUTOR")
	@Column(name="ID_TIPO_TUTOR", unique=true, nullable=false, precision=38)
	private long idTipo;

	@Column(nullable=false, unique=true, length=20)
	private String nombre;

	//bi-directional many-to-one association to Tutor
	@OneToMany(mappedBy="tipo")
	private List<Usuario> tutores;

	public TipoTutor() {
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

	public List<Usuario> getTutores() {
		return this.tutores;
	}

	public void setTutores(List<Usuario> tutores) {
		this.tutores = tutores;
	}

	public Usuario addTutor(Usuario tutor) {
		getTutores().add(tutor);
		tutor.setTipoTutor(this);

		return tutor;
	}

	public Usuario removeTutor(Usuario tutor) {
		getTutores().remove(tutor);
		tutor.setTipoTutor(null);

		return tutor;
	}

}