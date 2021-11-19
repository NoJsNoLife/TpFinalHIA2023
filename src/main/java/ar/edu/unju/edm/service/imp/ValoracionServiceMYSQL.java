
package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.PoIs;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Valoracion;
import ar.edu.unju.edm.repository.IValoracionDAO;
import ar.edu.unju.edm.service.IValoracionService;

@Service
@Qualifier("implementacionMYSQLValoracion")
public class ValoracionServiceMYSQL implements IValoracionService {
	@Autowired
	Valoracion unaValoracion;
	@Autowired
	IValoracionDAO valoracionDAO;
	@Override
	public Valoracion crearUnaValoracion() {
		// TODO Auto-generated method stub
		return unaValoracion;
	}

	@Override
	public void guardarValoracion(Valoracion unaValoracion) {
		// TODO Auto-generated method stub
		valoracionDAO.save(unaValoracion);
	}

	@Override
	public void eliminarValoracion(Integer idValoracion) throws Exception {
		// TODO Auto-generated method stub
		//Valoracion valoracionEliminar=valoracionDAO.findByIdValoracion(idValoracion).orElseThrow(()->new Exception("Valoracion no encontrada"));
		/*Valoracion valoracionEliminar = valoracionDAO.findById(idValoracion).orElseThrow(()->new Exception("Valoracion no encontrada"));
	    valoracionDAO.delete(valoracionEliminar);*/
		System.out.println("entroooooooooaservice");
		valoracionDAO.deleteById(idValoracion);
	}

	@Override
	public void modificarValoracion(Valoracion valModificado) throws Exception {
		// TODO Auto-generated method stub
		//Valoracion valoracionModi=valoracionDAO.findByIdValoracion(valModificado.getIdValoracion()).orElseThrow(()->new Exception("Turista no encontrado"));
		Valoracion valoracionModi=valoracionDAO.findByidValoracion(valModificado.getIdValoracion()).orElseThrow(()->new Exception("Turista no encontrado"));
	    cambiarValoracion(valModificado, valoracionModi);
	    valoracionDAO.save(valoracionModi);
	}
	
	private void cambiarValoracion (Valoracion desde, Valoracion hacia) {
		hacia.setComentario(desde.getComentario());
		hacia.setUnaValoracion(desde.getUnaValoracion());
	}
	
	@Override
	public List<Valoracion> obtenerTodasValoracion() {
		// TODO Auto-generated method stub
		return (List<Valoracion>) valoracionDAO.findAll();
	}

	@Override
	public Valoracion encontrarValoracionId(int idValoracion) throws Exception {
		// TODO Auto-generated method stub
		return valoracionDAO.findById(idValoracion).orElseThrow(()-> new Exception ("esta valoracion no existe"));
		//return valoracionDAO.findByIdValoracion(idValoracion).orElseThrow(()-> new Exception ("esta valoracion no existe"));
	}


	@Override
	public List<Valoracion> obtenerMisValoraciones(PoIs codPoI) {
		// TODO Auto-generated method stub
		return valoracionDAO.mostrarValoraciones(codPoI.getCodPoI());
	}

	@Override
	public List<Valoracion> obtenerMioValoraciones(Turista turistaCreador) {
		// TODO Auto-generated method stub
		return valoracionDAO.mostrarValoracionesEnTurista(turistaCreador.getIdTurista());
	}

	@Override
	public List<Valoracion> findAllByOrdenarValoracion() {

		// TODO Auto-generated method stub
		return valoracionDAO.findAllByOrdenarValoracion();
	}

	

	






}

