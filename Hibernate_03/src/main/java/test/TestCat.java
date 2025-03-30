package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDAO;
import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		// Transient
		Cat c1 = new Cat();
		c1.setId(1);
		
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tran = ss.beginTransaction();
				
				// Detached -> Persistent
				c1 = ss.get(Cat.class, 1);
				
				
				
				// Sau khi Commit tất cả các câu lệnh ở trạng thái Transient -> Persistent
				tran.commit();
				// Khi session.close() được gọi, tất cả các entity được lấy từ session sẽ chuyển sang trạng thái DETACHED.
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// cái c1 này sau chạy dòng sử dụng hàm get() nó đã được hibernate quản lý trong session rồi
		// khi ss.close thì nó trở thành trạng thái detached nhé.
		System.out.println(c1);
	}
}
