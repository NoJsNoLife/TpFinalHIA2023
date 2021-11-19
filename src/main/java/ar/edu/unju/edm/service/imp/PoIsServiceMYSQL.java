package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.PoIs;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.IPoIsDAO;
import ar.edu.unju.edm.repository.ITuristaDAO;
import ar.edu.unju.edm.service.IPoIsService;

@Service
@Qualifier("implementacionMYSQLPoI")
public class PoIsServiceMYSQL implements IPoIsService{

	@Autowired
	PoIs Poi;
@Autowired
 IPoIsDAO IPoIsDAO;
@Autowired
ITuristaDAO iTuristaDAO;
	@Override
	public void guardarPoIs(PoIs PoIGuardado) {
		// TODO Auto-generated method stub
		IPoIsDAO.save(PoIGuardado);
	}

	@Override
	public PoIs crearPoI() {
		// TODO Auto-generated method stub
		return Poi;
	}

	@Override
	public PoIs encontrarUnPoi(Integer codPoI) throws Exception {
		// TODO Auto-generated method stub
		return IPoIsDAO.findBycodPoI(codPoI).orElseThrow(()->new Exception("El punto de interes NO existe"));
	}

	@Override
	public void modificarPoI(PoIs PoIModificado) throws Exception {
		// TODO Auto-generated method stub
		PoIs PoIaModificar = IPoIsDAO.findBycodPoI(PoIModificado.getCodPoI()).orElseThrow(()->new Exception("El punto de interes no fue encontrado"));
		cambiarPoI(PoIModificado, PoIaModificar);
		IPoIsDAO.save(PoIaModificar);
	}
	@Override
	public void eliminarPoI(Integer codPoI) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("entro del eliminar poi service");
		PoIs PoIaEliminar =IPoIsDAO.findBycodPoI(codPoI).orElseThrow(()->new Exception("El punto de interes no fue encontrado"));
		IPoIsDAO.delete(PoIaEliminar);
		System.out.println("salio del eliminar poi service");
	}

	@Override
	public void cambiarPoI(PoIs PoIModificado, PoIs PoIaModificar) {
		// TODO Auto-generated method stub
		PoIaModificar.setDescripcion(PoIModificado.getDescripcion());
		PoIaModificar.setNombre(PoIModificado.getNombre());
		PoIaModificar.setSitio_web(PoIModificado.getSitio_web());
		PoIaModificar.setLocalidad(PoIModificado.getLocalidad());
		PoIaModificar.setEtiqueta(PoIModificado.getEtiqueta());
		PoIaModificar.setLocalizacionLatitud(PoIModificado.getLocalizacionLatitud());
		PoIaModificar.setLocalizacionLongitud(PoIModificado.getLocalizacionLongitud());
		PoIaModificar.setBarrio(PoIModificado.getBarrio());
		PoIaModificar.setCalle(PoIModificado.getCalle());
		PoIaModificar.setNumeroCasa(PoIModificado.getNumeroCasa());
		PoIaModificar.setImagen(PoIModificado.getImagen());
		PoIaModificar.setImagen1(PoIModificado.getImagen1());
		PoIaModificar.setImagen2(PoIModificado.getImagen2());
	}

	@Override
	public ArrayList<PoIs> obtenerTodosPoIs() {
		// TODO Auto-generated method stub
		return (ArrayList<PoIs>) IPoIsDAO.findAll();
	}

	@Override
	public PoIs obtenerUnPoi(String nombrePoi) {
		// TODO Auto-generated method stub
		return Poi;
	}

	@Override
	public PoIs obtenerPoiNuevo() {
		// TODO Auto-generated method stub
		return Poi;
	}

	@Override
	public ArrayList<PoIs> obtenerMisPoIs(Turista turistaAutor) {
		// TODO Auto-generated method stub
		return (ArrayList<PoIs>) IPoIsDAO.findAllByTuristaAutor(turistaAutor);
	
	}

	@Override
	public List<PoIs> getOrdenarPorLaValoracion() {
		// TODO Auto-generated method stub
		return IPoIsDAO.getOrdenarPorLaValoracion();
	}



}
