package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class SinhVien extends ConNguoi{
	private double diemTrungBinh;

	public SinhVien() {
	}

	public SinhVien(String id, String fullName, Date dateOfBirth, double diemTrungBinh) {
		super(id, fullName, dateOfBirth);
		this.diemTrungBinh = diemTrungBinh;
	}

	public double getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public void setDiemTrungBinh(double diemTrungBinh) {
		this.diemTrungBinh = diemTrungBinh;
	}
	
}
