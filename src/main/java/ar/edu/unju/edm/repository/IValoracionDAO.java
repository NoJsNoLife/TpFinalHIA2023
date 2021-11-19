package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.PoIs;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Valoracion;
@Repository
public interface IValoracionDAO extends CrudRepository <Valoracion, Integer> {
	
	public Optional<Valoracion> findByidValoracion(Integer idValoracion);

	public List<Valoracion> findAllByPoiCreador(PoIs poiCreador);
	
	public List<Valoracion> findAllByTuristaCreador(Turista turistaCreador);
	
	@Query(value ="SELECT*FROM valoracion ORDER BY fecha_comentario DESC, hora_comentario DESC",nativeQuery=true)
	public List<Valoracion> findAllByOrdenarValoracion();
	
	@Query(value = "SELECT*FROM valoracion WHERE id_turista =? ORDER BY fecha_comentario DESC, hora_comentario DESC;",nativeQuery=true)
	public List<Valoracion> mostrarValoracionesEnTurista(Integer  idTurista);
	@Query(value = "SELECT*FROM valoracion WHERE cod_poi =? ORDER BY fecha_comentario DESC, hora_comentario DESC;",nativeQuery=true)
	public List<Valoracion> mostrarValoraciones(Integer  codigoPoI);
	


}
