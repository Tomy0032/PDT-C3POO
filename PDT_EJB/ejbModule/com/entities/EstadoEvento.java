package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.Estado;

import java.util.List;


/**
 * The persistent class for the ESTADO_EVENTO database table.
 * 
 */
@Entity
@Table(name="ESTADO_EVENTO")
@NamedQuery(name="EstadoEvento.findAll", query="SELECT e FROM EstadoEvento e")
public class EstadoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ESTADO_EVENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ESTADO_EVENTO")
	@Column(name="ID_ESTADO_EVENTO", unique=true, nullable=false, precision=38)
	private long idEstadoEvento;
	
	@Column(nullable=false, unique=true, length=20)
	private String nombre;
	
	@Column(nullable=false)
	private Estado estado;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="estado")
	private List<Evento> eventos;

	public EstadoEvento() {
	}

	public long getIdEstadoEvento() {
		return idEstadoEvento;
	}

	public void setIdEstadoEvento(long idEstadoEvento) {
		this.idEstadoEvento = idEstadoEvento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setEstado(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setEstado(null);

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