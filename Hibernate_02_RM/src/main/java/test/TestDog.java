package test;

import java.sql.Date;
import java.util.List;

import dao.DogDAO;
import model.Dog;

public class TestDog {
	public static void main(String[] args) {
		DogDAO dogDAO = new DogDAO();
		
//		List<Dog> list = dogDAO.selectAll();
//		for (Dog d1 : list) {
//			System.out.println(d1.toString());
//		}
		
//		Dog d2 = new Dog();
//		d2.setId(1);
//		d2 = dogDAO.selectById(d2);
//		System.out.println(d2.toString());
		
//		Dog d3 = new Dog("Ngao", new Date(System.currentTimeMillis()), true);
//		dogDAO.insert(d3);
//		d3.setId(2);
//		dogDAO.update(d3);
		
		Dog d4 = new Dog();
		d4.setId(2);
		dogDAO.delete(d4);
	}
}
