package test;

import java.sql.Date;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO cd1 = new CatDAO();
		
//		List<Cat> list = cd1.selectAll();
//		for (Cat c : list) {
//			System.out.println(c.toString());
//		}
		
//		Cat c1 = new Cat();
//		c1.setId(1);
//		c1 = cd1.selectById(c1);
//		System.out.println(c1.toString());
		
		Cat c2 = new Cat("Moon Moon", new Date(System.currentTimeMillis()), true);
		c2.setId(5);
//		cd1.insert(c2);
		cd1.delete(c2);
	}
}
