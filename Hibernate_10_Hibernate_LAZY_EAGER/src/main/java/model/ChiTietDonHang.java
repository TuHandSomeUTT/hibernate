package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChiTietDonHang {
	@Id
	@GeneratedValue
	private int id;
	private String tenSanPham;
	private double soLuong;
	private double giaBan;
	private double thanhTien;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "donHang_id")
	private DonHang donHang;

	public ChiTietDonHang() {
	}

	public ChiTietDonHang(String tenSanPham, double soLuong, double giaBan, double thanhTien, DonHang donHang) {
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.thanhTien = thanhTien;
		this.donHang = donHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [id=" + id + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", giaBan=" + giaBan
				+ ", thanhTien=" + thanhTien + ", donHang=" + donHang + "]";
	}
	
	
}
