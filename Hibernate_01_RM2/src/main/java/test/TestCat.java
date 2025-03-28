package test;

import java.sql.Date;
import java.util.List;

import dao.CatDAO;
import model.Cat;

public class TestCat {
	public static void main(String[] args) {
		CatDAO cd = new CatDAO();
		
//		List<Cat> list = cd.selectAll();
//		for(Cat c: list) {
//			System.out.println(c.toString());
//		}
		
//		Cat c1 = new Cat();
//		c1.setId(1);
//		c1 = cd.selectById(c1);
//		System.out.println(c1);
		
		Cat c2 = new Cat("Tom Cat Server", new Date(System.currentTimeMillis()), false);
		c2.setId(3);
		cd.delete(c2);
		
	}
}
