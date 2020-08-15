package com.vn.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "hoadonchitiet")
public class HoaDonChiTiet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHoaDonChiTiet;
	private String idSanPham;
	private int SoLuong;
	private Float GiaSP;
	private Long idHoaDon;
	public HoaDonChiTiet() {
		super();
	}
	public HoaDonChiTiet(Long idHoaDonChiTiet, String idSanPham, int soLuong, Float giaSP, Long idHoaDon) {
		super();
		this.idHoaDonChiTiet = idHoaDonChiTiet;
		this.idSanPham = idSanPham;
		SoLuong = soLuong;
		GiaSP = giaSP;
		this.idHoaDon = idHoaDon;
	}
	public Long getIdHoaDonChiTiet() {
		return idHoaDonChiTiet;
	}
	public void setIdHoaDonChiTiet(Long idHoaDonChiTiet) {
		this.idHoaDonChiTiet = idHoaDonChiTiet;
	}
	public String getIdSanPham() {
		return idSanPham;
	}
	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public Float getGiaSP() {
		return GiaSP;
	}
	public void setGiaSP(Float giaSP) {
		GiaSP = giaSP;
	}
	public Long getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(Long idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	
	
}
