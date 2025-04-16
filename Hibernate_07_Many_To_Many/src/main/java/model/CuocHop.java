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

@Entity
public class CuocHop {
	@Id
	@GeneratedValue
	private int id;
	private String tenCuocHop;
	private String diaDiem;
	private Date thoiGian;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "cuochop_nhanvien", //tức là tạo ra 1 bảng trung gian có tên là cuochop_nhanvien, cái này ta có thể bắt đầu từ bảng NhanVien hay CuocHop trước đều OK
			joinColumns = {@JoinColumn(name = "cuochop_id")}, //FK của bảng trung gian này 1 là cuochop_id
			inverseJoinColumns = {@JoinColumn(name = "nhanvien_id")} // FK thứ 2. MQH many to many hiện thực hóa bằng cách tạo 1 bảng trung gian rồi chia thành 2 mối quan hệ 1-N
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
		danhSachNhanVien.add(nv);
	}
	
	@Override
	public String toString() {
		return "CuocHop [id=" + id + ", tenCuocHop=" + tenCuocHop + ", diaDiem=" + diaDiem + ", thoiGian=" + thoiGian
				+ "]";
	}
	
}
