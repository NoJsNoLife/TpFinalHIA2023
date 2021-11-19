package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.model.Turista;


public interface ITuristaService {

	public void guardarTurista(Turista turistaGuardado);
	public Turista crearTurista();
	public Turista encontrarUnTurista(Integer idTurista) throws Exception;
	public List<Turista> obtenerTodosTurista();
	public void modificarTurista(Turista turistaModificado) throws Exception;
	public void eliminarTurista(Integer idTurista) throws Exception;
	public Turista encontrarUnTuristaPorEmail(String email) throws Exception;


}
