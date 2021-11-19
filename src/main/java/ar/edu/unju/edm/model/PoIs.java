package ar.edu.unju.edm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;


@Entity
@Table (name="PoIs")
@Component
public class PoIs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codPoI;
	@Column
	private String email;
	@Column
	@NotBlank (message="Su punto de interes debe tener nombre.")
	private String nombre;
	@Column
	@NotBlank (message="Su punto de interes debe aportar una descripción.")
	private String descripcion;
	@Column
	private String etiqueta;
	@Column
	private String sitio_web;
	@Column
	private String calle;
	@Column
	private int numeroCasa;
	@Column
	private String barrio;
	@Column
	@NotBlank (message="Su punto de interes debe tener una localidad.")
	private String localidad;
	@Column
	@Min(value = 24, message = "La longitud de su punto de interes debe estar entre las medidad de jujuy (24 a 27)")
	@Max(value = 27, message = "La longitud de su punto de interes debe estar entre las medidad de jujuy (24 a 27)")
	private int localizacionLatitud;
	@Column
	@Min(value = 65, message = "La longitud de su punto de interes debe estar entre las medidad de jujuy (65 a 67)")
	@Max(value = 67, message = "La longitud de su punto de interes debe estar entre las medidad de jujuy (65 a 67)")
	private int localizacionLongitud;
	@Column
	private int media;
	@Lob
	@Column(name = "prod_imagen", columnDefinition = "LONGBLOB")
	private String imagen;
	@Lob
	@Column(name = "prod_imagen1", columnDefinition = "LONGBLOB")
	private String imagen1;
	@Lob
	@Column(name = "prod_imagen2", columnDefinition = "LONGBLOB")
	private String imagen2;
	
	@ManyToOne
	@JoinColumn(name = "idTurista")
	private Turista turistaAutor;
	
	@OneToMany(mappedBy = "poiCreador", cascade = CascadeType.REMOVE)
	private List<Valoracion> valoracion;

	
	private double unaValoracion=0;
	
	
	public double getUnaValoracion() {
		return unaValoracion ;
	}
	public void setUnaValoracion(double unaValoracion) {
		this.unaValoracion = unaValoracion;
	}
	public List<Valoracion> getValoracion() {
		return valoracion;
	}
	public void setValoracion(List<Valoracion> valoracion) {
		this.valoracion = valoracion;
	}
	public String getImagen1() {
		return imagen1;
	}
	public void setImagen1(String imagen1) {
		this.imagen1 = imagen1;
	}
	public String getImagen2() {
		return imagen2;
	}
	public void setImagen2(String imagen2) {
		this.imagen2 = imagen2;
	}
	public Integer getCodPoI() {
		return codPoI;
	}
	public void setCodPoI(Integer codPoI) {
		this.codPoI = codPoI;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getSitio_web() {
		return sitio_web;
	}
	public void setSitio_web(String sitio_web) {
		this.sitio_web = sitio_web;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getLocalizacionLatitud() {
		return localizacionLatitud;
	}
	public void setLocalizacionLatitud(int localizacionLatitud) {
		this.localizacionLatitud = localizacionLatitud;
	}
	public int getLocalizacionLongitud() {
		return localizacionLongitud;
	}
	public void setLocalizacionLongitud(int localizacionLongitud) {
		this.localizacionLongitud = localizacionLongitud;
	}
	public int getMedia() {
		return media;
	}
	public void setMedia(int media) {
		this.media = media;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Turista getTuristaAutor() {
		return turistaAutor;
	}
	public void setTuristaAutor(Turista turistaAutor) {
		this.turistaAutor = turistaAutor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barrio == null) ? 0 : barrio.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((codPoI == null) ? 0 : codPoI.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((etiqueta == null) ? 0 : etiqueta.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + localizacionLatitud;
		result = prime * result + localizacionLongitud;
		result = prime * result + media;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroCasa;
		result = prime * result + ((sitio_web == null) ? 0 : sitio_web.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoIs other = (PoIs) obj;
		if (barrio == null) {
			if (other.barrio != null)
				return false;
		} else if (!barrio.equals(other.barrio))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (codPoI == null) {
			if (other.codPoI != null)
				return false;
		} else if (!codPoI.equals(other.codPoI))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (etiqueta == null) {
			if (other.etiqueta != null)
				return false;
		} else if (!etiqueta.equals(other.etiqueta))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (localizacionLatitud != other.localizacionLatitud)
			return false;
		if (localizacionLongitud != other.localizacionLongitud)
			return false;
		if (media != other.media)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroCasa != other.numeroCasa)
			return false;
		if (sitio_web == null) {
			if (other.sitio_web != null)
				return false;
		} else if (!sitio_web.equals(other.sitio_web))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PoIs [codPoI=" + codPoI + ", email=" + email + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", etiqueta=" + etiqueta + ", sitio_web=" + sitio_web + ", calle=" + calle + ", numeroCasa="
				+ numeroCasa + ", barrio=" + barrio + ", localidad=" + localidad + ", localizacionLatitud="
				+ localizacionLatitud + ", localizacionLongitud=" + localizacionLongitud + ", media=" + media
				+ ", imagen=" + imagen + "]";
	}
	
	

	
	}
	