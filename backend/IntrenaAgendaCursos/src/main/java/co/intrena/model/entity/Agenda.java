package co.intrena.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agenda")
public class Agenda {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn (name = "curso_id")
	private Curso curso;
	
	@Column (name = "fecha_inicrea")
	private Date fechaInicrea;
	
	
	@Column (name = "fecha_fincrea")
	private Date fechaFincrea;
	
	@Column (name = "fecha_iniact")
	private Date fechaIniact;
	
	@Column (name = "fecha_finACT")
	private Date fechaFinact;
	
	@ManyToOne
	@JoinColumn (name = "area_id")
	private Area area;
	
	@Column (name = "estado")
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getFechaInicrea() {
		return fechaInicrea;
	}

	public void setFechaInicrea(Date fechaInicrea) {
		this.fechaInicrea = fechaInicrea;
	}

	public Date getFechaFincrea() {
		return fechaFincrea;
	}

	public void setFechaFincrea(Date fechaFincrea) {
		this.fechaFincrea = fechaFincrea;
	}

	public Date getFechaIniact() {
		return fechaIniact;
	}

	public void setFechaIniact(Date fechaIniact) {
		this.fechaIniact = fechaIniact;
	}

	public Date getFechaFinact() {
		return fechaFinact;
	}

	public void setFechaFinact(Date fechaFinact) {
		this.fechaFinact = fechaFinact;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", curso=" + curso + ", fechaInicrea=" + fechaInicrea + ", fechaFincrea="
				+ fechaFincrea + ", fechaIniact=" + fechaIniact + ", fechaFinact=" + fechaFinact + ", areaId=" + area
				+ ", estado=" + estado + "]";
	}
	

	

	
	
	
	
	
}
