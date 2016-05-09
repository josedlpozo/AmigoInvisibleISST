package es.upm.isst.amigoinvisible.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mensaje implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String userId;
	private String comunidadId;
	private String mensaje;
	
	public Mensaje(String userId, String comunidadId, String mensaje) {
		super();
		this.userId = userId;
		this.comunidadId = comunidadId;
		this.mensaje = mensaje;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComunidadId() {
		return comunidadId;
	}

	public void setComunidadId(String comunidadId) {
		this.comunidadId = comunidadId;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
