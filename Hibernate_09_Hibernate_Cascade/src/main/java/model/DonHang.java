package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DonHang {
	@Id
	@GeneratedValue
	private int id;
	private String tenKhachHang;
	private Date ngayMua;
	
	// 1 đơn hàng có nhiều chi tiết đơn hàng
	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.REMOVE)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.PERSIST)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.MERGE)
	List<ChiTietDonHang> danhSachChiTiet = new ArrayList<>();

	public DonHang() {
	}

	public DonHang(int id, String tenKhachHang, Date ngayMua, List<ChiTietDonHang> danhSachChiTiet) {
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.ngayMua = ngayMua;
		this.danhSachChiTiet = danhSachChiTiet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public List<ChiTietDonHang> getDanhSachChiTiet() {
		return danhSachChiTiet;
	}

	public void setDanhSachChiTiet(List<ChiTietDonHang> danhSachChiTiet) {
		this.danhSachChiTiet = danhSachChiTiet;
	}

	@Override
	public String toString() {
		return "DonHang [id=" + id + ", tenKhachHang=" + tenKhachHang + ", ngayMua=" + ngayMua + ", danhSachChiTiet="
				+ danhSachChiTiet + "]";
	}
	
	public void addChiTietDonHang(ChiTietDonHang detail) {
		this.danhSachChiTiet.add(detail);
	}
}
