package com.entities;

import java.io.Serializable;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import javax.transaction.Transactional;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.entities.Modalidad;
import com.entities.TipoEvento;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EVENTO database table.
 * 
 */
@Entity
@Table(name="EVENTO")
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_EVENTO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_EVENTO")
	@Column(name="ID_EVENTO", unique=true, nullable=false, precision=38)
	private long idEvento;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_FINAL", nullable=false)
	private Date fechaHoraFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA_INICIO", nullable=false)
	private Date fechaHoraInicio;

	@Column(nullable=false, length=20)
	private String nombre;
	
	@Column(length=50)
	private String localizacion;
	
	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@ManyToOne
	@JoinColumn(name="ID_MODALIDAD", nullable=false)
	private Modalidad modalidad;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTADO", nullable=false)
	private EstadoEvento estado;
	
	@ManyToOne
	@JoinColumn(name="ID_ITR", nullable=false)
	private Itr itr;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_EVENTO", nullable=false)
	private TipoEvento tipo;

	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="evento")
	private List<Constancia> constancias;

	//bi-directional many-to-one association to ConvocatoriaAsistencia
	@OneToMany(mappedBy = "evento")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ConvocatoriaAsistencia> convocatoriasAsistencias;

	//bi-directional many-to-one association to Gestion
	@OneToMany(mappedBy="evento")
	private List<Gestion> gestiones;

	//bi-directional many-to-one association to Justificacion
	@OneToMany(mappedBy="evento")
	private List<Justificacion> justificaciones;

	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="evento")
	private List<Reclamo> reclamos;

	//bi-directional many-to-one association to Responsabilidad
	@OneToMany(mappedBy="evento")
	private List<Responsabilidad> responsabilidades;
	
	//bi-directional many-to-many association to Usuario
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "evento_tutores", 
		joinColumns = @JoinColumn(name = "ID_EVENTO"),
		inverseJoinColumns = @JoinColumn(name = "ID_USUARIO")
	)
	private List<Usuario> tutores;

	public Evento() {
	}

	public long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public Date getFechaHoraFinal() {
		return fechaHoraFinal;
	}

	public void setFechaHoraFinal(Date fechaHoraFinal) {
		this.fechaHoraFinal = fechaHoraFinal;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Constancia> getConstancias() {
		return constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

	public List<ConvocatoriaAsistencia> getConvocatoriasAsistencias() {
		return convocatoriasAsistencias;
	}

	public void setConvocatoriasAsistencias(List<ConvocatoriaAsistencia> convocatoriasAsistencias) {
		this.convocatoriasAsistencias = convocatoriasAsistencias;
	}

	public List<Gestion> getGestiones() {
		return gestiones;
	}

	public void setGestiones(List<Gestion> gestiones) {
		this.gestiones = gestiones;
	}

	public List<Justificacion> getJustificaciones() {
		return justificaciones;
	}

	public void setJustificaciones(List<Justificacion> justificaciones) {
		this.justificaciones = justificaciones;
	}

	public List<Reclamo> getReclamos() {
		return reclamos;
	}

	public void setReclamos(List<Reclamo> reclamos) {
		this.reclamos = reclamos;
	}

	public List<Responsabilidad> getResponsabilidades() {
		return responsabilidades;
	}

	public void setResponsabilidades(List<Responsabilidad> responsabilidades) {
		this.responsabilidades = responsabilidades;
	}
	
	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public EstadoEvento getEstado() {
		return estado;
	}

	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}

	public List<Usuario> getTutores() {
		return tutores;
	}

	public void setTutores(List<Usuario> tutores) {
		this.tutores = tutores;
	}

	public Itr getItr() {
		return itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}
	
	public Usuario addTutor(Usuario usuario) {
		getTutores().add(usuario);
		return usuario;
	}

	public Usuario removeTutor(Usuario usuario) {
		getTutores().remove(usuario);
		return usuario;
	}
	
}