package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import util.HibernateUtil;

public class AuthorDAO implements DAOInterface<Author>{

	@Override
	public List<Author> selectAll() {
		List<Author> result = new ArrayList<>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				String HQL = "FROM Author";
				Query qr = ss.createQuery(HQL);
				result = qr.getResultList();
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Author selectById(Author t) {
		List<Author> result = new ArrayList<>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				String HQL = "FROM Author AS a WHERE a.author_id = :author_id";
				Query qr = ss.createQuery(HQL);
				qr.setParameter("author_id", t.getAuthor_id());
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

	public boolean saveOrUpdate(Author t) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			
			ss.saveOrUpdate(t);
			
			tr.commit();
			ss.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insert(Author t) {
		// TODO Auto-generated method stub
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Author t) {
		// TODO Auto-generated method stub
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Author t) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				ss.delete(t);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
