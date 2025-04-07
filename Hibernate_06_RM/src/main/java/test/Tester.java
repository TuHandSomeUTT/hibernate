package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.My_Order;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
//				Customer c1 = new Customer("C1", "Adam", "testemail@gmail.com");
//
//				My_Order o1 = new My_Order("1", "Hải Hưng", c1);
//				My_Order o2 = new My_Order("2", "Vĩnh Phú", c1);
//				My_Order o3 = new My_Order("3", "Hà Nam Ninh", c1);
//				My_Order o4 = new My_Order("4", "Hà Nội", c1);
//				
//				List<My_Order> list = new ArrayList<>();
//				list.add(o1);
//				list.add(o2);
//				list.add(o3);
//				list.add(o4);
//				
//				c1.setMy_order(list);
//				
//				ss.saveOrUpdate(c1);
//				ss.saveOrUpdate(o1);
//				ss.saveOrUpdate(o2);
//				ss.saveOrUpdate(o3);
//				ss.saveOrUpdate(o4);
//				
//				Customer c2 = new Customer("C2", "Test2", "unknownemail@gmail.com");
//				ss.saveOrUpdate(c2);
				
				String HQL = "FROM Customer AS c WHERE size(c.my_order) > 0";
				List<Customer> result = ss.createQuery(HQL).list();
				for(Customer c : result) {
					System.out.println(c.toString());
				}
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
