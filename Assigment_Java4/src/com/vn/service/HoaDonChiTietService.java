package com.vn.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.model.HoaDonChiTiet;
import com.vn.utils.Utils;

public class HoaDonChiTietService {
static SessionFactory factory = Utils.getSessionFactory();
	

	public void saveHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. save
			session.save(hoaDonChiTiet);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
