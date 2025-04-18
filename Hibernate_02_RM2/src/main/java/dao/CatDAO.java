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
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				String HQL = "FROM Cat";
				Query query = session.createQuery(HQL);
				result = query.getResultList();
				transaction.commit();
				session.close();
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
			if(sf != null) {
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				String HQL = "FROM Cat AS C WHERE C.id = :id";
				Query query = session.createQuery(HQL);
				query.setParameter("id", t.getId());
				result = query.getResultList();
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.size()>0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public boolean saveOrUpdate(Cat t) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();
				session.saveOrUpdate(t);
				transaction.commit();
				session.close();
			}
			return true;
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
				Session session = sf.openSession();
				Transaction tr = session.beginTransaction();
				session.delete(t);
				tr.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
