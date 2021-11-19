package ar.edu.unju.edm.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.PoIs;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Valoracion;
import ar.edu.unju.edm.service.IPoIsService;
import ar.edu.unju.edm.service.ITuristaService;
import ar.edu.unju.edm.service.IValoracionService;

@Controller
public class TuristaController {
	private static final Log LOGGER = LogFactory.getLog(TuristaController.class);
	
	@Autowired
	@Qualifier("implementacionMYSQLturista")
	ITuristaService turistaService;
	@Autowired
	@Qualifier("implementacionMYSQLValoracion")
	IValoracionService valoracionService;
	@Autowired
	@Qualifier("implementacionMYSQLPoI")
	IPoIsService poiService;
	@GetMapping("/turista/mostrar")
	public String cargarTurista(Model model) {
		model.addAttribute("unTurista", turistaService.crearTurista());
		return("turista");
	}
	
	@PostMapping("/turista/guardar")
	public String guardarNuevoTurista(@Valid @ModelAttribute("unTurista") Turista nuevoTurista, BindingResult resultado ,Model model) {
		List<Turista> tur=turistaService.obtenerTodosTurista();
		if(tur.size()==0) {
			LOGGER.info("METHOD: ingresando el metodo Guardar");
			turistaService.guardarTurista(nuevoTurista);
		}
		boolean band=true;
		if (resultado.hasErrors()) 
		{
			model.addAttribute("unTurista", nuevoTurista);
			return("turista");
		}
		else 
		{
			for(int i=0;i<tur.size();i++) {
				
				//if(tur.get(i).getEmail()!=nuevoTurista.getEmail()) 
				if(tur.get(i).getEmail().compareTo(nuevoTurista.getEmail()) == 0) {
					
					return  "mensajeturi";
				}else {
					band=false;
				}
				
			}
			if(band==false) {
				System.out.println("entro a guardar");
				LOGGER.info("METHOD: ingresando el metodo Guardar");
				turistaService.guardarTurista(nuevoTurista);
		
			}
			
			
			return "redirect:/index";
		}
	}
	@GetMapping({"/mensaje/error/tur"})
	public String error(Model model){
		
		return "menasajeturi";
	}
	@GetMapping("/turista/perfiles")
	public String cargarPerfilTuristas(Model model){
		model.addAttribute("turistas", turistaService.obtenerTodosTurista());
		return("perfiles");
	}
	
	@GetMapping("/turista/perfil")
	public String cargarPerfilTurista(Model model, Authentication authentication) throws Exception {
		UserDetails userTurista = (UserDetails) authentication.getPrincipal();
		model.addAttribute("unTurista", turistaService.encontrarUnTuristaPorEmail(userTurista.getUsername()));
		return ("perfil");
	}
	
	@GetMapping("/turista/editar/{idTurista}")
	public String editarTurista(Model model, @PathVariable(name="idTurista") Integer idTurista) throws Exception {
		try {
			Turista turistaEncontrado = turistaService.encontrarUnTurista(idTurista);
			model.addAttribute("unTurista", turistaEncontrado);	
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unCliente", turistaService.crearTurista());
			model.addAttribute("editMode", "false");
		}
		return("modificar");
	}
	
	@PostMapping("/turista/modificar")
	public String modificarTurista(@ModelAttribute("unTurista") Turista turistaModificado, Model model) {
		try {
			System.out.println("turista modificad:"+turistaModificado.getIdTurista());
			turistaService.modificarTurista(turistaModificado);
			model.addAttribute("unTurista", new Turista());				
			model.addAttribute("editMode", "false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unTurista", turistaModificado);
			model.addAttribute("editMode", "true");
		}
		return("redirect:/turista/perfil");
	}

	@GetMapping("/turista/eliminarTurista/{idTurista}")
	public String eliminarTurista(Model model, @PathVariable(name="idTurista") Integer idTurista) {
		LOGGER.info("METHOD: ingresando el metodo Eliminar");
		List<PoIs> pois=poiService.obtenerTodosPoIs();
		List<Valoracion> val=valoracionService.obtenerTodasValoracion();
	    
		try {
			
			for(int i=0;i<val.size();i++) {
				System.out.println("entro a i");
				if(val.get(i).getTuristaCreador().getIdTurista()==idTurista) {
					for(int o=0;o<pois.size();o++) {
						System.out.println("entro a o");
						if(pois.get(o).getCodPoI()==val.get(i).getPoiCreador().getCodPoI()) {
							pois.get(o).setUnaValoracion(pois.get(o).getUnaValoracion()-val.get(i).getUnaValoracion());
							
						}
						
						
					}
					
					
				}
					
				}
			turistaService.eliminarTurista(idTurista);		
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/login";
	}
}
