package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;
	
	private String name;
	
	private Date weddingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "spouse_id") // cột mà ta muốn kết nối. one to one nên là tự join với chính mình :)))
	private Person spouse;

	public Person() {
	}

	public Person(String name, Date weddingDate, Person spouse) {
		this.name = name;
		this.weddingDate = weddingDate;
		this.spouse = spouse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", weddingDate=" + weddingDate + ", spouse=" + spouse + "]";
	}
}
