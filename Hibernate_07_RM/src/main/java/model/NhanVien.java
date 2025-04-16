package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class NhanVien {
	@Id
	private String id;
	private String hoVaTen;
	private Date ngaySinh;

	/*
	 * Hibernate chỉ cần 1 bên định nghĩa cấu trúc bảng trung gian, bên còn lại chỉ
	 * cần biết nó là quan hệ được ánh xạ ngược lại, không cần viết lại toàn bộ.Vậy
	 * mappedBy là cái gì? mappedBy = "tên_biến_bên_kia" Nó có nghĩa là:
	 * "Tôi không chịu trách nhiệm tạo bảng trung gian, bên kia lo rồi, tôi chỉ là người tham gia thôi!"
	 * Nói cách khác, mappedBy là chỉ điểm cho Hibernate biết: Mối quan hệ này đã
	 * được ánh xạ bên kia, tôi chỉ cần ăn theo thôi, đừng tạo lại. Nếu không dùng
	 * mappedBy, Hibernate sẽ tạo thêm một bảng trung gian mới → dư thừa → lỗi
	 */
	@ManyToMany(mappedBy = "danhSachNhanVien")
	private Set<CuocHop> danhSachCuocHop = new HashSet<>();

	public NhanVien() {
	}

	public NhanVien(String id, String hoVaTen, Date ngaySinh) {
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
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

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", hoVaTen=" + hoVaTen + ", ngaySinh=" + ngaySinh + "]";
	}

}
