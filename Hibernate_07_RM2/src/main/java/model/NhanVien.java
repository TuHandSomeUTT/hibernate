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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(// Tưởng tượng đây là table trung gian chứa id của cả nhanvien và cuochop
			name = "nhanvien_cuochop",
			joinColumns = {@JoinColumn(name = "nhanvien_id")},// FK đến entity hiện tại (NhanVien)
			inverseJoinColumns = {@JoinColumn(name = "cuochop_id")}// FK đến entity bên kia (CuocHop)
			)
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

	public void addCuocHop(CuocHop ch) {
		this.danhSachCuocHop.add(ch);
	}
	
	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", hoVaTen=" + hoVaTen + ", ngayVaoLam=" + ngayVaoLam + "]";
	}

	/*
	 * Đảo vị trí joinColumns và inverseJoinColumns = đảo chiều mối quan hệ →
	 * Hibernate sẽ hiểu sai hoàn toàn.
	 * Có thể dẫn đến lỗi hoặc lưu sai dữ liệu.
	 * Hãy luôn dùng joinColumns để chỉ tới bảng của entity hiện tại, và
	 * inverseJoinColumns cho bảng bên kia.
	 */
}
