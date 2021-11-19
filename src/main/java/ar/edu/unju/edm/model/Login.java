package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

@Component 
public class Login {

	private String usuario;
	private String contraseña;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
