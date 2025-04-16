package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class CuocHop {
	/*
	 * Hibernate chỉ cần 1 bên định nghĩa cấu trúc bảng trung gian, bên còn lại chỉ
	 * cần biết nó là quan hệ được ánh xạ ngược lại, không cần viết lại toàn bộ.Vậy
	 * mappedBy là cái gì? mappedBy = "tên_biến_bên_kia" Nó có nghĩa là:
	 * "Tôi không chịu trách nhiệm tạo bảng trung gian, bên kia lo rồi, tôi chỉ là người tham gia thôi!"
	 * Nói cách khác, mappedBy là chỉ điểm cho Hibernate biết: Mối quan hệ này đã
	 * được ánh xạ bên kia, tôi chỉ cần ăn theo thôi, đừng tạo lại. Nếu không dùng
	 * mappedBy, Hibernate sẽ tạo thêm một bảng trung gian mới → dư thừa → lỗi
	 */
	@Id
	@GeneratedValue
	private int id;
	private String tenCuocHop;
	private String diaDiem;
	private Date thoiGian;
	
	@ManyToMany(mappedBy = "danhSachCuocHop")
	private Set<NhanVien> danhSachNhanVien = new HashSet<>();
	
	public CuocHop() {
	}

	public CuocHop(String tenCuocHop, String diaDiem, Date thoiGian) {
		this.tenCuocHop = tenCuocHop;
		this.diaDiem = diaDiem;
		this.thoiGian = thoiGian;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenCuocHop() {
		return tenCuocHop;
	}

	public void setTenCuocHop(String tenCuocHop) {
		this.tenCuocHop = tenCuocHop;
	}

	public String getDiaDiem() {
		return diaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	@Override
	public String toString() {
		return "CuocHop [id=" + id + ", tenCuocHop=" + tenCuocHop + ", diaDiem=" + diaDiem + ", thoiGian=" + thoiGian
				+ "]";
	}
	
}
