package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL,
//			   fetch = FetchType.EAGER)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.PERSIST)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.MERGE)
//	@OneToMany(mappedBy = "donHang", cascade = CascadeType.REMOVE)
	private List<ChiTietDonHang> chiTietDonHang = new ArrayList<>();

	public DonHang() {
	}

	public DonHang(String tenKhachHang, Date ngayMua, List<ChiTietDonHang> chiTietDonHang) {
		this.tenKhachHang = tenKhachHang;
		this.ngayMua = ngayMua;
		this.chiTietDonHang = chiTietDonHang;
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

	public List<ChiTietDonHang> getChiTietDonHang() {
		return chiTietDonHang;
	}

	public void setChiTietDonHang(List<ChiTietDonHang> chiTietDonHang) {
		this.chiTietDonHang = chiTietDonHang;
	}

	public void addChiTietDonHang(ChiTietDonHang detail) {
		this.chiTietDonHang.add(detail);
	}
	
	@Override
	public String toString() {
		return "DonHang [id=" + id + ", tenKhachHang=" + tenKhachHang + ", ngayMua=" + ngayMua + "]";
	}
	
	
}
