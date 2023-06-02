package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TIPO_EVENTO database table.
 * 
 */
@Entity
@Table(name="TIPO_EVENTO")
@NamedQuery(name="TipoEvento.findAll", query="SELECT te FROM TipoEvento te")
public class TipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_TIPO_EVENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TIPO_EVENTO")
	@Column(name="ID_TIPO_EVENTO", unique=true, nullable=false, precision=38)
	private long idTipoEvento;
	
	@Column(nullable=false, unique=true, length=20)
	private String nombre;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="tipo")
	private List<Evento> eventos;

	public TipoEvento() {
	}

	public long getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setTipo(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setTipo(null);

		return evento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}