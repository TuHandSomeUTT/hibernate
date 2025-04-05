package test;

import java.util.List;
import dao.BookDAO;
import model.Author;
import model.Book;

public class TestBook {
	public static void main(String[] args) {
		BookDAO bd1 = new BookDAO();
//		List<Book> list = bd1.selectAll();
//		for(Book b : list) {
//			System.out.println(b.toString());
//		}
		
//		Book b1 = new Book();
//		b1.setBook_id("B01");
//		Book b2 = bd1.selectById(b1);
//		System.out.println(b2);
		
		Author a1 = new Author();
		a1.setAuthor_id("A02");
//		Book b1 = new Book("B04", "Thép đã tôi thế đấy!", 100, a1);
//		bd1.saveOrUpdate(b1);
		Book b1 = new Book("B05", "Test delete", 100, a1);
//		bd1.saveOrUpdate(b1);
		bd1.delete(b1);
	}
}
