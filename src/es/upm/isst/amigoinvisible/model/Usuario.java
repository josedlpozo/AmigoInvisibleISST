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
	private String id;
	
	@Basic
	private String username;
	@Basic
	private String email;
	@Basic
	private String contraseña;
	@Basic
	private List<String> deseos;

	public Usuario(String username, String email, String userId) {
		this.username = username;
		this.email = email;
		this.id = userId;
	}
	
	public Usuario(String username, String email, String contraseña, String userId) {
		this.username = username;
		this.email = email;
		this.id = userId;
		this.contraseña = contraseña;
	}
	
	public String getContraseña(){
		return this.contraseña;
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

	public List<String> getDeseos() {
		return this.deseos;
	}
	
	public void setId(String userId){
		this.id = userId;
	}
	
	public String getUserId(){
		return this.id;
	}
}
