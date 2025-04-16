package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class NhanVien {
	@Id
	private String id;
	private String hoVaTen;
	private Date ngayVaoLam;
	
	/*Ta đã cấu hình tất cả ở biến danhSachNhanVien ở class CuocHop rồi. Khi gặp Set danhSachCuocHop nó sẽ truy ngược lại biến danhSachNhanVien để ánh xạ*/
	@ManyToMany(mappedBy = "danhSachNhanVien")
	private Set<CuocHop> danhSachCuocHop = new HashSet<>();
	
	public NhanVien() {
	}

	public NhanVien(String id, String hoVaTen, Date ngayVaoLam) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.ngayVaoLam = ngayVaoLam;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", hoVaTen=" + hoVaTen + ", ngayVaoLam=" + ngayVaoLam + "]";
	}
	
}
