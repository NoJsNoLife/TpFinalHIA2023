package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.edm.model.PoIs;
import ar.edu.unju.edm.model.Turista;



public interface IPoIsService {
	public void guardarPoIs(PoIs poiGuardado);
	public PoIs crearPoI();
	public PoIs obtenerPoiNuevo();
	public PoIs obtenerUnPoi(String nombrePoi);
	public ArrayList<PoIs> obtenerTodosPoIs();
	public PoIs encontrarUnPoi(Integer codPoI) throws Exception;
	public void modificarPoI(PoIs PoIModificado) throws Exception;
	public void eliminarPoI(Integer codPoI) throws Exception;
	public void cambiarPoI( PoIs poModificado, PoIs PoIaModificar);
	public ArrayList<PoIs> obtenerMisPoIs(Turista turistaAutor);
	public List<PoIs> getOrdenarPorLaValoracion();
}
