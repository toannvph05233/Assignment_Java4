package com.vn.service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.model.NguoiDungEntity;
import com.vn.utils.Utils;

public class NguoiDungService {
	static SessionFactory factory = Utils.getSessionFactory();

	public List<NguoiDungEntity> getAllNguoiDung() {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			// query
			Query q = session.createQuery("FROM NguoiDungEntity");
			List<NguoiDungEntity> lisNguoiDung = q.getResultList();
			
			transaction.commit();
			session.close();
			return lisNguoiDung;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<NguoiDungEntity> loginNguoiDung(String user,String pass) {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			// query
			TypedQuery<NguoiDungEntity> q = session.createQuery("select c from NguoiDungEntity c where  c.idUser=:user and password=:pass", NguoiDungEntity.class);
			q.setParameter("user", user);
			q.setParameter("pass", pass);
			List<NguoiDungEntity> lisNguoiDung = q.getResultList();
			
			transaction.commit();
			session.close();
			return lisNguoiDung;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveNguoiDung(NguoiDungEntity nguoiDung) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. save
			session.save(nguoiDung);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteNguoiDung(NguoiDungEntity nguoiDung) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			session.delete(nguoiDung);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateNguoiDung(NguoiDungEntity nguoiDung) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			session.update(nguoiDung);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

