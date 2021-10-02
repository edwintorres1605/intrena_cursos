package co.intrena.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private Integer cursoId;
	
	@Column (name = "fecha_inicre")
	private Date fechaInicrea;
	
	@Column (name = "fecha_fincrea")
	private Date fechaFincrea;
	
	@Column (name = "fecha_iniact")
	private Date fechaIniact;
	
	@Column (name = "fecha_finACT")
	private Date fechaFinact;
	
	@ManyToOne
	@JoinColumn (name = "area_id")
	private Integer areaId;
	
	@Column (name = "estado")
	private String estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
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

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", cursoId=" + cursoId + ", fechaInicrea=" + fechaInicrea + ", fechaFincrea="
				+ fechaFincrea + ", fechaIniact=" + fechaIniact + ", fechaFinact=" + fechaFinact + ", areaId=" + areaId
				+ ", estado=" + estado + "]";
	}
	

	

	
	
	
	
	
}
