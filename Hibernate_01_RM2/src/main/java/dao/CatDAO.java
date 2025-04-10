package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements DAOInterface<Cat>{

	@Override
	public List<Cat> selectAll() {
		List<Cat> result = new ArrayList<>();
		try {
			SessionFactory fs = HibernateUtil.getSessionFactory();
			if (fs != null) {
				Session ss = fs.openSession();
				Transaction tr = ss.beginTransaction();
				String HQL = "FROM Cat";
				Query query = ss.createQuery(HQL);
				result = query.getResultList();
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Cat selectById(Cat t) {
		List<Cat> result = new ArrayList<>();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				String HQL = "FROM Cat WHERE id = :id";
				Query q = ss.createQuery(HQL);
				q.setParameter("id", t.getId());
				result = q.getResultList();
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

	public boolean saveOrUpdate(Cat t) {
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
	public boolean insert(Cat t) {
		
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Cat t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Cat t) {
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
