package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class CuocHop {
	@Id
	@GeneratedValue
	private int id;
	private String tenCuocHop;
	private String diaDiem;
	private Date thoiGian;

	/*
	 * Muốn tạo mối quan hệ n-n cần có 1 bảng trung gian để chia thành 2 MQH 1-n. Ta
	 * muốn tạo bảng trung gian là cuochop_nhanvien hay nhanvien_cuochop thì ta sẽ
	 * đứng ở bên mà ta nói trước, chẳng hạn ta nói là 1 cuochop có n nhanvien thì
	 * ta sẽ cấu hình ở cuochop trước. Trong class nào viết @JoinTable, thì
	 * joinColumns phải là FK trỏ đến bảng của class đó. Nếu đảo ngược thứ tự của
	 * joinColumns và inverseJoinColumns có thể dẫn đến lỗi logic, truy vấn, ... Hãy
	 * luôn dùng joinColumns để chỉ tới bảng của entity hiện tại, và
	 * inverseJoinColumns cho bảng bên kia.
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(// Tưởng tượng nó là cái table trung gian chứa id của cả nhanvien và cuochop
			name = "cuochop_nhanvien", 
			joinColumns = { @JoinColumn(name = "cuochop_id") }, // FK đến entity hiện tại (CuocHop)
			inverseJoinColumns = { @JoinColumn(name = "nhanvien_id") } // FK đến entity bên kia (NhanVien)
	)
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

	public void addNhanVien(NhanVien nv) {
		this.danhSachNhanVien.add(nv);
	}
	
	@Override
	public String toString() {
		return "CuocHop [id=" + id + ", tenCuocHop=" + tenCuocHop + ", diaDiem=" + diaDiem + ", thoiGian=" + thoiGian
				+ "]";
	}

}
