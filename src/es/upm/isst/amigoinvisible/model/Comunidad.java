package es.upm.isst.amigoinvisible.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comunidad implements Serializable{
	
	@Id
	private String id;
	
	@Basic
	private String nombre;
	@Basic
	private String gestorId;
	@Basic
	private String password;
	@Basic
	private List<String> usuariosId;
	@Basic
	private HashMap<String, String> sorteo;
	
	public Comunidad(String nombre, String gestorId, String password, List<String> usuariosId) {
		super();
		this.nombre = nombre;
		this.gestorId = gestorId;
		this.password = password;
		this.usuariosId = usuariosId;
		this.sorteo = new HashMap<>();
	}
	
	public Comunidad(String nombre, String gestorId, String password, List<String> usuariosId, String comunidadId) {
		super();
		this.nombre = nombre;
		this.gestorId = gestorId;
		this.password = password;
		this.usuariosId = usuariosId;
		this.id = comunidadId;
		this.sorteo = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGestorId() {
		return gestorId;
	}

	public void setGestor(String gestorId) {
		this.gestorId = gestorId;
	}

	public List<String> getUsuariosId() {
		return usuariosId;
	}

	public void setUsuarios(List<String> usuariosId) {
		this.usuariosId = usuariosId;
	}
	
	public String getComunidadId() {
		return id;
	}

	public void setComunidadId(String id) {
		this.id = id;
	}

	public HashMap<String, String> getSorteo() {
		return sorteo;
	}

	public void setSorteo(HashMap<String, String> sorteo) {
		this.sorteo = sorteo;
	}
	
}
