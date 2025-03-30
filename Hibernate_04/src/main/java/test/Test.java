package test;

import java.sql.Date;

import org.hibernate.HibernateException;
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
				
//				Person p1 = new Person("My Love", new Date(System.currentTimeMillis()), null);
//				ss.save(p1);
				
				// Moi p1 từ detached lên persistant
//				Person p1 = ss.find(Person.class, 1L);
//				Person p2 = new Person("Tạ Thị Hòa", new Date(System.currentTimeMillis()), p1);
//				ss.save(p2);
				
				Person p1 = ss.find(Person.class, 1L); //Cái số 1 này là id của p1 trong DB, L là để ép thành kiểu long
				Person p2 = ss.find(Person.class, 2L);
				p1.setSpouse(p2);
				ss.saveOrUpdate(p1);
				
				tr.commit();
				ss.close();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
