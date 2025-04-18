package test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Dog;
import util.HibernateUtil;

public class TestDog {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) { // tức là nó connect được đến DB
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					Dog dog1 = new Dog();
					dog1.setName("Husky");
					dog1.setSex(true);
					session.save(dog1);
					tr.commit();
				} finally {
					session.close();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
