package ar.edu.unju.edm.model;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity  
@Table(name="Valoracion")

public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idValoracion;
	@Column(nullable = false)
	@NotNull (message="Debe valorar")
	private Integer unaValoracion;
	@Column(nullable = false)
	@NotBlank (message="Debe contener un comentario")
	private String comentario;
	@ManyToOne
	@JoinColumn(name="idTurista")
	private Turista turistaCreador;
	@Column
	private String email;
	@ManyToOne
	@JoinColumn(name="codPoI")
	private PoIs poiCreador;
	
	@Column
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaComentario;
	@Column
	@DateTimeFormat(pattern = "hh:mm:ss")
	private LocalTime horaComentario;

	
	
	public LocalTime getHoraComentario() {
		return horaComentario;
	}
	public void setHoraComentario(LocalTime horaComentario) {
		this.horaComentario = horaComentario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getFechaComentario() {
		return fechaComentario;
	}
	public void setFechaComentario(LocalDate fechaComentario) {
		this.fechaComentario = fechaComentario;
	}
	public Integer getIdValoracion() {
		return idValoracion;
	}
	public void setIdValoracion(Integer idValoracion) {
		this.idValoracion = idValoracion;
	}
	
	public Integer getUnaValoracion() {
		return unaValoracion;
	}
	public void setUnaValoracion(Integer unaValoracion) {
		this.unaValoracion = unaValoracion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Turista getTuristaCreador() {
		return turistaCreador;
	}
	public void setTuristaCreador(Turista turistaCreador) {
		this.turistaCreador = turistaCreador;
	}
	public PoIs getPoiCreador() {
		return poiCreador;
	}
	public void setPoiCreador(PoIs poiCreador) {
		this.poiCreador = poiCreador;
	}

	

	
	
	
	
}
