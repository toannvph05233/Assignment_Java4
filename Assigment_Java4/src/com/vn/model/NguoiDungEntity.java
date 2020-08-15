package com.vn.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "nguoidung")
public class NguoiDungEntity {
	
	@Id
	private String idUser;
	private String password;
	private String fullName;
	private int Sdt;
	private int idLoaiAcout;
	
	public NguoiDungEntity(String idUser, String password, String fullName, int sdt, int idLoaiAcout) {
		super();
		this.idUser = idUser;
		this.password = password;
		this.fullName = fullName;
		Sdt = sdt;
		this.idLoaiAcout = idLoaiAcout;
	}

	public NguoiDungEntity() {
		super();
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getSdt() {
		return Sdt;
	}

	public void setSdt(int sdt) {
		Sdt = sdt;
	}

	public int getIdLoaiAcout() {
		return idLoaiAcout;
	}

	public void setIdLoaiAcout(int idLoaiAcout) {
		this.idLoaiAcout = idLoaiAcout;
	}
	
	
	

}
