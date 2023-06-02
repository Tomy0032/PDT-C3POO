package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enums.EstadoUsuario;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO")
	@Column(name="ID_USUARIO", unique=true, nullable=false, precision=38)
	private long idUsuario;
	
	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="ID_TIPO_USUARIO", nullable=true)
	private TipoUsuario tipoUsuario;

	@Column(nullable=false, length=20)
	private String apellido1;

	@Column(length=20)
	private String apellido2;

	@Column(nullable=false, length=16)
	private String contrasena;

	@Column(name="CORREO_INSTITUCIONAL", unique=true, nullable=false, length=60)
	private String correoInstitucional;

	@Column(name="CORREO_PERSONAL", unique=true, length=30)
	private String correoPersonal;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO", nullable=false)
	private Date fechaNacimiento;

	@Column(name="NOMBRE_USUARIO", unique=true, nullable=false, length=40)
	private String nombreUsuario;

	@Column(nullable=false, length=20)
	private String nombre1;

	@Column(length=20)
	private String nombre2;

	@Column(unique=true, length=10)
	private String telefono;
	
	@Column(nullable=false)	
	private EstadoUsuario estado;

	//bi-directional many-to-one association to Documento
	@ManyToOne
	@JoinColumn(name="ID_DOCUMENTO", nullable=false)
	private Documento documento;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="ID_GENERO", nullable=true)
	private Genero genero;

	//bi-directional many-to-one association to Itr
	@ManyToOne
	@JoinColumn(name="ID_ITR", nullable=false)
	private Itr itr;

	//bi-directional many-to-one association to Localidad
	@ManyToOne
	@JoinColumn(name="ID_LOCALIDAD", nullable=false)
	private Localidad localidad;
	
	
	//ESTUDIANTE
	
	//bi-directional many-to-one association to Constancia
	@OneToMany(mappedBy="estudiante")
	private List<Constancia> constancias;
	
	//bi-directional many-to-one association to ConvocatoriaAsistencia
	@OneToMany(mappedBy="estudiante")
	private List<ConvocatoriaAsistencia> convocatoriasAsistencias;
	
	//bi-directional many-to-one association to Generacion
	@ManyToOne
	@JoinColumn(name="ID_GENERACION", nullable=true)
	private Generacion generacion;
		
	//bi-directional many-to-one association to Justificacion
	@OneToMany(mappedBy="estudiante")
	private List<Justificacion> justificaciones;
	
	//bi-directional many-to-one association to Reclamo
	@OneToMany(mappedBy="estudiante")
	private List<Reclamo> reclamos;

	
	//TUTOR
	
	
	//bi-directional many-to-one association to Responsabilidad
	@OneToMany(mappedBy="tutor")
	private List<Responsabilidad> responsabilidades;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="ID_AREA", nullable=true)
	private Area area;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="ID_TIPO", nullable=true)
	private TipoTutor tipo;
	
	//ANALISTA
	
	//bi-directional many-to-one association to AccionConstancia
	@OneToMany(mappedBy="analista")
	private List<AccionConstancia> accionesConstancias;

	//bi-directional many-to-one association to AccionGJustificacion
	@OneToMany(mappedBy="analista")
	private List<AccionJustificacion> accionesJustificaciones;

	//bi-directional many-to-one association to AccionReclamo
	@OneToMany(mappedBy="analista")
	private List<AccionReclamo> accionesReclamos;

	//bi-directional many-to-one association to Gestion
	@OneToMany(mappedBy="analista")
	private List<Gestion> gestiones;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreoInstitucional() {
		return this.correoInstitucional;
	}

	public void setCorreoInstitucional(String correoInstitucional) {
		this.correoInstitucional = correoInstitucional;
	}

	public String getCorreoPersonal() {
		return this.correoPersonal;
	}

	public void setCorreoPersonal(String correoPersonal) {
		this.correoPersonal = correoPersonal;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Itr getItr() {
		return this.itr;
	}

	public void setItr(Itr itr) {
		this.itr = itr;
	}

	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public EstadoUsuario getEstado() {
		return estado;
	}

	public void setEstado(EstadoUsuario estado) {
		this.estado = estado;
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

	public Generacion getGeneracion() {
		return generacion;
	}

	public void setGeneracion(Generacion generacion) {
		this.generacion = generacion;
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public TipoTutor getTipoTutor() {
		return tipo;
	}

	public void setTipoTutor(TipoTutor tipo) {
		this.tipo = tipo;
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

	public List<Gestion> getGestiones() {
		return gestiones;
	}

	public void setGestiones(List<Gestion> gestiones) {
		this.gestiones = gestiones;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}