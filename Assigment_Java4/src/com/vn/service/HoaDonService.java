package com.vn.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.model.HoaDon;
import com.vn.model.NguoiDungEntity;
import com.vn.utils.Utils;

public class HoaDonService {
	static SessionFactory factory = Utils.getSessionFactory();
	

	public void saveHoaDon(HoaDon hoaDon) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. save
			session.save(hoaDon);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<HoaDon> findHoaDonBy(String name) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			// query
			TypedQuery<HoaDon> q = session.createQuery("select c from HoaDon c where  c.name=:name", HoaDon.class);
			q.setParameter("name", name);
			
			List<HoaDon> lisNguoiDung = q.getResultList();
			
			transaction.commit();
			session.close();
			return lisNguoiDung;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
