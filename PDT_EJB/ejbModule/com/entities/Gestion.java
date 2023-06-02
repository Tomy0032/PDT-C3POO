package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GESTION database table.
 * 
 */
@Entity
@Table(name="GESTION")
@NamedQuery(name="Gestion.findAll", query="SELECT g FROM Gestion g")
public class Gestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_GESTION" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GESTION")
	@Column(name="ID_GESTION", unique=true, nullable=false, precision=38)
	private long idGestion;

	//bi-directional many-to-one association to Analista
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario analista;

	//bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name="ID_EVENTO", nullable=false)
	private Evento evento;

	public Gestion() {
	}

	public long getIdGestion() {
		return this.idGestion;
	}

	public void setIdGestion(long idGestion) {
		this.idGestion = idGestion;
	}

	public Usuario getAnalista() {
		return this.analista;
	}

	public void setAnalista(Usuario analista) {
		this.analista = analista;
	}

	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}