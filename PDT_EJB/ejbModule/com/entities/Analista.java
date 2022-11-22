package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ANALISTA database table.
 * 
 */
@Entity
@Table(name="ANALISTA")
@NamedQuery(name="Analista.findAll", query="SELECT a FROM Analista a")
public class Analista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ANALISTA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ANALISTA")
	@Column(name="ID_ANALISTA", unique=true, nullable=false, precision=38)
	private long idAnalista;

	@Column(nullable=false, length=16)
	private String caracteres;

	//bi-directional many-to-one association to AccionConstancia
	@OneToMany(mappedBy="analista")
	private List<AccionConstancia> accionesConstancias;

	//bi-directional many-to-one association to AccionGJustificacion
	@OneToMany(mappedBy="analista")
	private List<AccionJustificacion> accionesJustificaciones;

	//bi-directional many-to-one association to AccionReclamo
	@OneToMany(mappedBy="analista")
	private List<AccionReclamo> accionesReclamos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO", nullable=false)
	private Usuario usuario;

	//bi-directional many-to-one association to Gestion
	@OneToMany(mappedBy="analista")
	private List<Gestion> gestiones;

	public Analista() {
	}

	public long getIdAnalista() {
		return idAnalista;
	}

	public void setIdAnalista(long idAnalista) {
		this.idAnalista = idAnalista;
	}

	public String getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(String caracteres) {
		this.caracteres = caracteres;
	}

	public List<AccionConstancia> getAccionesConstancias() {
		return accionesConstancias;
	}

	public void setAccionesConstancias(List<AccionConstancia> accionesConstancias) {
		this.accionesConstancias = accionesConstancias;
	}

	public List<AccionJustificacion> getAccionesJustificaciones() {
		return accionesJustificaciones;
	}

	public void setAccionesJustificaciones(List<AccionJustificacion> accionesJustificaciones) {
		this.accionesJustificaciones = accionesJustificaciones;
	}

	public List<AccionReclamo> getAccionesReclamos() {
		return accionesReclamos;
	}

	public void setAccionesReclamos(List<AccionReclamo> accionesReclamos) {
		this.accionesReclamos = accionesReclamos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Gestion> getGestiones() {
		return gestiones;
	}

	public void setGestiones(List<Gestion> gestiones) {
		this.gestiones = gestiones;
	}

}