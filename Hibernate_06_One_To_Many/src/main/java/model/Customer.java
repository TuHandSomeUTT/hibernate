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
	@OneToMany(mappedBy = "customer")
	private List<Orders> orders;
	
	
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


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", orders = " + orders.size() + "]";
	}
}
