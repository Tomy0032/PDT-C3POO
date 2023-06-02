package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Estado;

import java.util.List;


/**
 * The persistent class for the MODALIDAD database table.
 * 
 */
@Entity
@Table(name="MODALIDAD")
@NamedQuery(name="Modalidad.findAll", query="SELECT m FROM Modalidad m")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_MODALIDAD")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MODALIDAD")
	@Column(name="ID_MODALIDAD", unique=true, nullable=false, precision=38)
	private long idModalidad;

	@Column(nullable=false, unique=true, length=20)
	private String nombre;
	
	@Column(nullable=false)	
	private Estado estado;
	
	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="modalidad")
	private List<Evento> eventos;

	public Modalidad() {
	}

	public long getIdModalidad() {
		return this.idModalidad;
	}

	public void setIdModalidad(long idModalidad) {
		this.idModalidad = idModalidad;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setModalidad(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setModalidad(null);

		return evento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}