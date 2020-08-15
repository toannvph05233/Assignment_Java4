package com.vn.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.vn.model.Product;
import com.vn.utils.Utils;

public class ProductService {
	static SessionFactory factory = Utils.getSessionFactory();

	public List<Product> getAllProduct() {
		try {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			// query
			Query q = session.createQuery("FROM Product");
			List<Product> lisProducts = q.getResultList();
			transaction.commit();
			session.close();
			return lisProducts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveProduct(Product product) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. save
			session.save(product);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(Product product) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			session.delete(product);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Product product) {
		try {
			// 1. create session
			Session session = factory.openSession();

			// 2. begin transaction
			Transaction tx = session.beginTransaction();

			// 3. delete
			session.update(product);

			// 4. transaction commit
			tx.commit();

			// 5. close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
