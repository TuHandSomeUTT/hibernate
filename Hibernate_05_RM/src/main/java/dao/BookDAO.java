package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Book;
import util.HibernateUtil;

public class BookDAO implements DAOInterface<Book>{

	@Override
	public List<Book> selectAll() {
		List<Book> result = new ArrayList<>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			
			String HQL = "FROM Book";
			Query qr = ss.createQuery(HQL);
			result = qr.getResultList();
			
			tr.commit();
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Book selectById(Book t) {
		List<Book> result = new ArrayList<>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				String HQL = "FROM Book AS b WHERE b.book_id = :book_id";
				Query qr = ss.createQuery(HQL);
				qr.setParameter("book_id", t.getBook_id());
				result = qr.getResultList();
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public boolean saveOrUpdate(Book t) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				ss.saveOrUpdate(t);
				
				tr.commit();
				ss.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insert(Book t) {
		// TODO Auto-generated method stub
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Book t) {
		// TODO Auto-generated method stub
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Book t) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				ss.delete(t);
				
				tr.commit();
				ss.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
