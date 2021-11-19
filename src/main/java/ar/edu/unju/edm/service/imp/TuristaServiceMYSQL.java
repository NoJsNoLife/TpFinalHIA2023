package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.repository.ITuristaDAO;
import ar.edu.unju.edm.service.IPoIsService;
import ar.edu.unju.edm.service.ITuristaService;

@Service
@Qualifier("implementacionMYSQLturista")

public class TuristaServiceMYSQL implements ITuristaService {
	@Autowired
	IPoIsService poiService;
	@Autowired
	Turista unTurista;
	@Autowired
	ITuristaDAO iTuristaDAO;
	@Override
	public void guardarTurista(Turista unTurista) {
		// TODO Auto-generated method stub
		//le asignamos un rol ya definido cuando se crea
		unTurista.setPerfil("userNormal");
		String pw = unTurista.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		unTurista.setPassword(bCryptPasswordEncoder.encode(pw));
		
		iTuristaDAO.save(unTurista);
	}
	@Override
	public Turista crearTurista() {
		// TODO Auto-generated method stub
		return unTurista;
	}
	@Override
	public Turista encontrarUnTurista(Integer idTurista) throws Exception {
		// TODO Auto-generated method stub
	    return iTuristaDAO.findByIdTurista(idTurista).orElseThrow(()->new Exception("El turista NO existe"));
	}
	@Override
	public void modificarTurista(Turista turistaModificado) throws Exception {
		// TODO Auto-generated method stub
		Turista turistaAModificar = iTuristaDAO.findByIdTurista(turistaModificado.getIdTurista()).orElseThrow(()->new Exception("El Turista no fue encontrado"));
		cambiarTurista(turistaModificado, turistaAModificar);
		iTuristaDAO.save(turistaAModificar);
	}
	private void cambiarTurista(Turista turistaModificado, Turista turistaAModificar) {
		// TODO Auto-generated method stub
		turistaAModificar.setNombre(turistaModificado.getNombre());
		turistaAModificar.setApellido(turistaModificado.getApellido());
		turistaAModificar.setEmail(turistaModificado.getEmail());
		turistaAModificar.setPaís(turistaModificado.getPaís());
		turistaAModificar.setLocalizacionLatitud(turistaModificado.getLocalizacionLatitud());
		turistaAModificar.setLocalizacionLongitud(turistaModificado.getLocalizacionLongitud());
		turistaAModificar.setPassword(turistaModificado.getPassword());
	}
	@Override
	public void eliminarTurista(Integer idTurista) throws Exception {
		// TODO Auto-generated method stub
		Turista turistaEliminar = iTuristaDAO.findByIdTurista(idTurista).orElseThrow(()->new Exception("El Turista no fue encontrado"));
		iTuristaDAO.delete(turistaEliminar);
	}
	@Override
	public Turista encontrarUnTuristaPorEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return iTuristaDAO.findByEmail(email).orElseThrow(()->new Exception("El Turista no fue encontrado"));
	}
	@Override
	public List<Turista> obtenerTodosTurista() {
		// TODO Auto-generated method stub
		return (List<Turista>) iTuristaDAO.findAll();
	}
	

	
}