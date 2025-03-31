package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
//				Person p1 = new Person("Van Tu Nguyen", new Date(System.currentTimeMillis()), null);
//				ss.save(p1);
				Person p1 = ss.load(Person.class, 1L);
				Person p2 = new Person("Ta Minh Hoa", new Date(System.currentTimeMillis()), p1);
				ss.save(p2);
				
				// Cách 1: Gán luôn
				p1.setSpouse(p2);
				ss.saveOrUpdate(p1);
				
				/* Cách 2:
				Person p1 = ss.load(Person.class, 1L);
				Person p2 = ss.load(Person.class, 2L);
				
				p1.setSpouse(p2);
				ss.saveOrUpdate(p1);
				*/
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
