package com.vn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaiacout")
public class Role {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoaiAcout;
	private String idUser;
	private String loaiacout;
	
	public Role() {
		super();
	}

	public Role(Long idLoaiAcout, String idUser, String loaiacout) {
		super();
		this.idLoaiAcout = idLoaiAcout;
		this.idUser = idUser;
		this.loaiacout = loaiacout;
	}

	public Long getIdLoaiAcout() {
		return idLoaiAcout;
	}

	public void setIdLoaiAcout(Long idLoaiAcout) {
		this.idLoaiAcout = idLoaiAcout;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getLoaiacout() {
		return loaiacout;
	}

	public void setLoaiacout(String loaiacout) {
		this.loaiacout = loaiacout;
	}
	
	
}
