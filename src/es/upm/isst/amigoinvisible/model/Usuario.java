package es.upm.isst.amigoinvisible.model;

import java.util.List;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic
	private String nombre;
	@Basic
	private String apellidos;
	@Basic
	private String username;
	@Basic
	private String email;
	@Basic
	private String contrasena;
	@Basic
	private List<String> deseos;

	public Usuario(String nombre, String apellidos, String username,
			String email, String contrasena) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.username = username;
		this.email = email;
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String nuevosApellidos) {
		this.apellidos = nuevosApellidos;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String nuevaContrasena) {
		this.contrasena = nuevaContrasena;
	}

	public List<String> getDeseos() {
		return this.deseos;
	}

}
