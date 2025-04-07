package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private String id;
	private String name;
	private String email;
	
	/*Customer phải có trước rồi mới sinh ra các orders. Mapped by này nói cho Hibernate
	 * hiểu rằng phải có customer thì mới sinh ra orders được*/
	@OneToMany(mappedBy = "customer") // cái này liên kết với trường customer bên class My_Order để tạo ra MQH One to many
	/*Lỗi sai ngớ ngẩn :)))
	 * Khi dùng mappedBy, luôn luôn soi lại tên biến bên class còn lại. 
	 * Không phải tên class, không phải tên cột DB, mà tên cái biến mình khai báo.*/
	List<My_Order> my_order;
	
	public Customer() {
	}

	public Customer(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<My_Order> getMy_order() {
		return my_order;
	}

	public void setMy_order(List<My_Order> my_order) {
		this.my_order = my_order;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", my_order = " + my_order.size() + "]";
	}
}
