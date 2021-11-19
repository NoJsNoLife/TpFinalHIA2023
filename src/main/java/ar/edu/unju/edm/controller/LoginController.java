package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.model.Login;

@Controller
public class LoginController {
	
	@Autowired
	Login login;

   
	@GetMapping({"/","/login", "/index","/login?error=true"})


	public String cargarLogin(Model model) {
		return "login";
	}
	
}


