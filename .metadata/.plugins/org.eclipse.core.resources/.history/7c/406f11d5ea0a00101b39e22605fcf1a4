package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // hiểu rằng đây là ta muốn mapping class này thành table trong db
public class Cat {
	private Integer id;
	private String name;
	private Date dateOfBirth;
	private Boolean sex;
	
	public Cat() {
	}

	public Cat(Integer id, String name, Date dateOfBirth, Boolean sex) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	@Id // Primary Key
	@GeneratedValue // Auto Increment
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
}
