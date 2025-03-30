package test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				String HQL = "SELECT p.id, p.name, p.spouse.id, p.spouse.name FROM Person AS p";
				List<Object[]> results = ss.createQuery(HQL).list();
				
				for (Object[] rs : results) {
					String id = rs[0]+"";
					String name = rs[1]+"";
					String spouse_id = rs[2]+"";
					String spouseName = rs[3]+"";
					
					System.out.println("ID " + id +" "+ name + " đã kết hôn với " + spouseName + " " + spouse_id);
				}
				
				tr.commit();
				ss.close();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
