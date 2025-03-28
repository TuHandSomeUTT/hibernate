package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO catDAO = new CatDAO();
		
//		List<Cat> list = catDAO.selectAll();
//		for(Cat cat : list) {
//			System.out.println(cat.toString());
//		}
		
		// Test select by ID
//		Cat c = new Cat();
//		c.setId(1);
//		Cat c1 = catDAO.selectById(c);
//		System.out.println(c1.toString());
		
		// Test insert
		Cat c2 = new Cat("Qoàng Sượng", new Date(System.currentTimeMillis()), true);
		c2.setId(4);
		
//		catDAO.insert(c2);
		catDAO.delete(c2);
	}
}
