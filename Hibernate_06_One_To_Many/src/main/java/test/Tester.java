package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.Orders;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
//				Customer c1 = new Customer("C01", "Van Tu Nguyen", "vantudev88@gmail.com");
//				Orders o1 = new Orders("1", "Teddy Bear", c1);
//				Orders o2 = new Orders("2", "Rayban Sunglasses", c1);
//				Orders o3 = new Orders("3", "Vanson Leather Jacket", c1);
//				Orders o4 = new Orders("4", "Pants", c1);
//				
//				List<Orders> list = new ArrayList<>();
//				list.add(o1);
//				list.add(o2);
//				list.add(o3);
//				list.add(o4);
//				
//				c1.setOrders(list);
//				
//				ss.saveOrUpdate(c1);
//				ss.saveOrUpdate(o1);
//				ss.saveOrUpdate(o2);
//				ss.saveOrUpdate(o3);
//				ss.saveOrUpdate(o4);
//				
//				Customer c2 = new Customer("C02", "Van Tu", "vantudev19@gmail.com");
//				ss.saveOrUpdate(c2);
				
				String HQL = "FROM Customer AS c WHERE size(c.orders) > 0";
				
				List<Customer> results = ss.createQuery(HQL).list();
				for(Customer c2 : results) {
					System.out.println(c2.toString());
				}
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
