package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESPONSABILIDAD database table.
 * 
 */
@Entity
@Table(name="RESPONSABILIDAD")
@NamedQuery(name="Responsabilidad.findAll", query="SELECT r FROM Responsabilidad r")
public class Responsabilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_RESPONSABILIDAD" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_RESPONSABILIDAD")
	@Column(name="ID_RESPONSABILIDAD", unique=true, nullable=false, precision=38)
	private long idResponsabilidad;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", nullable=false)
	private Evento evento;

	//bi-directional many-to-one association to Tutor
	@ManyToOne
	@JoinColumn(name="ID_TUTOR", nullable=false)
	private Tutor tutor;

	public Responsabilidad() {
	}

	public long getIdResponsabilidad() {
		return this.idResponsabilidad;
	}

	public void setIdResponsabilidad(long idResponsabilidad) {
		this.idResponsabilidad = idResponsabilidad;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Tutor getTutor() {
		return this.tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

}