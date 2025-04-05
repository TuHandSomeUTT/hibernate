package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // Biểu thị rằng class này sẽ trở thành 1 entity của Hibernate
@Table(name = "tbl_PERSON") // Set name cho database
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment IDentify
	@Column(name = "person_id") // annotation đặt tên cột
	private long id;
	
	private String name;
	
	private Date dateOfBirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "spouse_id")
	private Person spouse;
	
	// Bắt buộc có 1 constructor rỗng thì mới mapping được
	public Person() {
		
	}

	public Person(String name, Date dateOfBirth, Person spouse) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.spouse = spouse;
	}

	public Person(long id, String name, Date dateOfBirth, Person spouse) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", spouse=" + spouse + "]";
	}
}
