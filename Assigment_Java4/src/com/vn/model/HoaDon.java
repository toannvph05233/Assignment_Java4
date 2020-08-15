package com.vn.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "hoadon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHoaDon;
	private String idUser;
	private String name;
	private Date DateLap;
	public HoaDon() {
		super();
	}
	public HoaDon(Long idHoaDon, String idUser, String name, Date dateLap) {
		super();
		this.idHoaDon = idHoaDon;
		this.idUser = idUser;
		this.name = name;
		DateLap = dateLap;
	}
	public Long getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(Long idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateLap() {
		return DateLap;
	}
	public void setDateLap(Date dateLap) {
		DateLap = dateLap;
	}
	
	
	

}
