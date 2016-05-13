package es.upm.isst.amigoinvisible.model;

import java.io.Serializable;
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
public class Usuario implements Serializable{

	@Id
	private String id;

	@Basic
	private String username;
	@Basic
	private String email;
	@Basic
	private String password;
	@Basic
	private List<String> deseos;

	public Usuario(String username, String email, String userId) {
		this.username = username;
		this.email = email;
		this.id = userId;
		
	}
	
	public Usuario(String username, String email, String userId, List<String> deseos) {
		this.username = username;
		this.email = email;
		this.id = userId;
		this.deseos = deseos;
	}

	public Usuario(String username, String email, String password, String userId) {
		this.username = username;
		this.email = email;
		this.id = userId;
		this.password = password;
		this.deseos = deseos;
	}

	public String getPassword(){
		return this.password;
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
	public void setDeseo(String deseo){
		this.deseos.add(deseo);
	}

	public void setId(String userId){
		this.id = userId;
	}

	public String getUserId(){
		return this.id;
	}

	public void setPassword(String newPassword){
		this.password = newPassword;
	}
}
