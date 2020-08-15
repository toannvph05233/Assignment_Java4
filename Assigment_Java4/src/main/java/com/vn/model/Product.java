package com.vn.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class Product {
	
	@Id
	private String idSanPham;
    private String idLoaiSanPham;
    private String nameSP;
    private float giaSP;
    private Date dateNhap;
    private String imgSP;
    
	public Product() {
		super();
	}

	public Product(String idSanPham, String idLoaiSanPham, String nameSP, float giaSP, Date dateNhap, String imgSP) {
		super();
		this.idSanPham = idSanPham;
		this.idLoaiSanPham = idLoaiSanPham;
		this.nameSP = nameSP;
		this.giaSP = giaSP;
		this.dateNhap = dateNhap;
		this.imgSP = imgSP;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getIdLoaiSanPham() {
		return idLoaiSanPham;
	}

	public void setIdLoaiSanPham(String idLoaiSanPham) {
		this.idLoaiSanPham = idLoaiSanPham;
	}

	public String getNameSP() {
		return nameSP;
	}

	public void setNameSP(String nameSP) {
		this.nameSP = nameSP;
	}

	public float getGiaSP() {
		return giaSP;
	}

	public void setGiaSP(float giaSP) {
		this.giaSP = giaSP;
	}

	public Date getDateNhap() {
		return dateNhap;
	}

	public void setDateNhap(Date dateNhap) {
		this.dateNhap = dateNhap;
	}

	public String getImgSP() {
		return imgSP;
	}

	public void setImgSP(String imgSP) {
		this.imgSP = imgSP;
	}
    
    

}
