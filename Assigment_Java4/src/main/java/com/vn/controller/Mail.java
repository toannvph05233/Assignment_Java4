package com.vn.controller;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.cj.util.Util;
import com.vn.model.Product;
import com.vn.utils.Utils;

public class Mail {
	static SessionFactory  factory = Utils.getSessionFactory();
	
	public static void main(String[] args) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product  product = new Product();
		product.setIdSanPham("ph0012");
		product.setIdLoaiSanPham("LSP1");
		product.setNameSP("Toan");
		product.setGiaSP(5000);
		product.setDateNhap(new Date(2020));
		
		session.save(product);
		transaction.commit();
		
	}
}
