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
			if(sessionFactory != null) {
				// 1) Open session
				Session session = sessionFactory.openSession();
				// 2) Create transaction
				Transaction transaction = session.beginTransaction();
				// 3) Execute HQL
				String HqlQuery = "FROM Cat"; // tương đương câu lệnh SELECT * FROM CAT
				Query query = session.createQuery(HqlQuery); // Có thể truyền thẳng SQLQuery vào method này cũng OK
				result = query.getResultList();
				// 4) Save changes
				transaction.commit();
				// 5) Close session
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
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				// 1) Open session
				Session session = sessionFactory.openSession();
				
				// 2) Create transaction
				Transaction transaction = session.beginTransaction();
				
				// 3)Execute HQL
				String Hql = "FROM Cat AS C WHERE C.id=:id";
				Query query = session.createQuery(Hql);
				query.setParameter("id", t.getId());
				result = query.getResultList();
				
				// 4) Save changes
				transaction.commit();
				// 5) Close session
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public boolean saveOrUpdate(Cat t) {
		try {
			// 1) getSessionFactory
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				// 2) Open session
				Session session = sessionFactory.openSession();
				// 3) Create transaction and begin transaction
				Transaction transaction = session.beginTransaction();
				// 4) HQL Query and Save
				// save() dùng để lưu 1 đối tượng xuống DB khi nó chưa tồn tại trong DB
				// session.save(t);
				
				// persist() dùng để lưu xuống 1 đối tượng(giống save) nhưng nó lưu xong không trả về ID, không báo lỗi khi sự cố xảy ra
				
				// saveOrUpdate() dùng để lưu 1 đối tượng xuống khi nó chưa tồn tại trong DB. Nếu nó đã tồn tại trong DB rồi thì update
				session.saveOrUpdate(t);
				transaction.commit();
				
				// 5) Close session
				session.close();
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
		// 1) Get session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		try {
			// 2) Open session
			Session session = sessionFactory.openSession();
			// 3) Create and begin transaction
			Transaction transaction = session.beginTransaction();
			// 4) HQL Query and save changes
			// delete() dùng để xóa 1 đối tượng trong DB
			session.delete(t);
			transaction.commit();
			// 5) Close session
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
