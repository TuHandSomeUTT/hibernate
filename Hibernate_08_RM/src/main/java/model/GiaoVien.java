package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class GiaoVien extends ConNguoi{
	private String monGiangDay;

	public GiaoVien() {
	}

	public GiaoVien(String id, String fullName, Date dateOfBirth, String monGiangDay) {
		super(id, fullName, dateOfBirth);
		this.monGiangDay = monGiangDay;
	}

	public String getMonGiangDay() {
		return monGiangDay;
	}

	public void setMonGiangDay(String monGiangDay) {
		this.monGiangDay = monGiangDay;
	}

	@Override
	public String toString() {
		return "GiaoVien [monGiangDay=" + monGiangDay + "]";
	}
	
	
}
