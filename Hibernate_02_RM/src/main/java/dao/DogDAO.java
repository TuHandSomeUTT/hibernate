package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Dog;
import util.HibernateUtil;

public class DogDAO implements DAOInterface<Dog>{

	@Override
	public List<Dog> selectAll() {
		List<Dog> result = new ArrayList<>();
		try {
			// 1) Get SF
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				// 2) Open session
				Session session = sessionFactory.openSession();
				// 3) Create and begin transaction
				Transaction transaction = session.beginTransaction();
				// 4) HQL and execute
				String HQL = "FROM Dog";
				Query query = session.createQuery(HQL);
				result = query.getResultList();
				// 5) Save changes
				transaction.commit();
				// 6) Close session
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Dog selectById(Dog t) {
		List<Dog> result = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				String HQL = "FROM Dog WHERE id = :id";
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

	private boolean saveOrUpdate(Dog t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.saveOrUpdate(t);
				transaction.commit();
				session.close();
				return true;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean insert(Dog t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Dog t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Dog t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				session.delete(t);
				transaction.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
