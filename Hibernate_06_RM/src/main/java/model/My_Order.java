package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class My_Order {
	@Id
	private String order_id;
	private String address;
	
	/*Khi gặp One To Many Relational ta cần cấu hình cả 2 phía 1 và N. Mặc dù đang học One To Many nhưng ta vẫn dùng Annotation @ManyToOne nhé*/
	@ManyToOne
	@JoinColumn(name = "customer_id") // FK với customer_id
	private Customer customer;

	public My_Order() {
	}

	public My_Order(String order_id, String address, Customer customer) {
		this.order_id = order_id;
		this.address = address;
		this.customer = customer;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "My_Order [order_id=" + order_id + ", address=" + address + ", customer=" + customer + "]";
	}
}
