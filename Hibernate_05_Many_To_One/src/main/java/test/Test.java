package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Books;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
//				Author a1 = new Author("A01", "Van Tu Nguyen", new Date(System.currentTimeMillis()));
//				Books b1 = new Books("B01", "Take me to your heart", 50, a1);
//				Books b2 = new Books("B02", "Util you", 50, a1);
//				Books b3 = new Books("B03", "I lay my love on you", 50, a1);
//				
//				ss.saveOrUpdate(a1);
//				ss.saveOrUpdate(b1);
//				ss.saveOrUpdate(b2);
//				ss.saveOrUpdate(b3);
				
				Author a2 = new Author("A02", "Westlife", new Date(System.currentTimeMillis()));
				Books b4 = new Books("B04", "My love", 50, a2);
				Books b5 = new Books("B05", "Up town girl", 50, a2);
				Books b6 = new Books("B06", "Fool Again", 50, a2);
				
				ss.saveOrUpdate(a2);
				ss.saveOrUpdate(b4);
				ss.saveOrUpdate(b5);
				ss.saveOrUpdate(b6);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
