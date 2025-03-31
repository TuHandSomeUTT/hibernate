package test;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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
				
				String HQL = "SELECT p.id, p.name, p.spouse.name, p.spouse.id, p.spouse.weddingDate FROM Person AS p";
				System.out.println(HQL);
				List<Object[]> result = ss.createQuery(HQL).list();
				for (Object[] rs : result) {
					String id = rs[0]+"";
					String name = rs[1]+"";
					String spouse_name = rs[2]+"";
					String spouse_id = rs[3]+"";
					String spouse_weddingDate = rs[4]+"";
					
					 System.out.println(name + " (" + id + ") đã kết hôn với " + spouse_name + " (" + spouse_id + ") vào ngày " + spouse_weddingDate);
				}
//				for (Object[] rs : result) {
//				    System.out.println(Arrays.toString(rs)); // Xem thử dữ liệu trong rs[] ra sao
//				}
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
