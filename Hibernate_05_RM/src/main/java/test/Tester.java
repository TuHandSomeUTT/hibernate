package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				Author a1 = new Author("A01", "Nguyen Nhat Anh", new Date(System.currentTimeMillis()));
				Book b1 = new Book("B01", "Tui Thay Hoa Vang Tren Co Xanh", 50, a1);
				Book b2 = new Book("B02", "Mat Biec", 80, a1);
				Book b3 = new Book("B03", "Tui La Beto", 70, a1);
				
				ss.saveOrUpdate(a1);
				ss.saveOrUpdate(b1);
				ss.saveOrUpdate(b2);
				ss.saveOrUpdate(b3);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
