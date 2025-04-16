package test;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietDonHang;
import model.DonHang;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		if (sf != null) {
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			
			DonHang dh1 = new DonHang();
			dh1.setTenKhachHang("Đổ Thánh");
			LocalDate ld = LocalDate.of(2025, 04, 15);
			dh1.setNgayMua(Date.valueOf(ld));
			
			ChiTietDonHang detail1 = new ChiTietDonHang();
			detail1.setTenSanPham("Bộ Bài Tây Mạ Vàng");
			detail1.setGiaBan(5000);
			detail1.setSoLuong(1);
			detail1.setThanhTien(5000);
			detail1.setDonHang(dh1);
			
			ChiTietDonHang detail2 = new ChiTietDonHang();
			detail2.setTenSanPham("Vinamilk");
			detail2.setGiaBan(5000);
			detail2.setSoLuong(3);
			detail2.setThanhTien(3*5000);
			detail2.setDonHang(dh1);
			
			dh1.addChiTietDonHang(detail1);
			dh1.addChiTietDonHang(detail2);
			
//			ss.saveOrUpdate(dh1);
//			ss.saveOrUpdate(detail1);
			
			DonHang dh = ss.load(DonHang.class, 2);
			ss.remove(dh);
			
			tr.commit();
			ss.close();
		}
	}
}
/*
 * CascadeType.ALL là các entity liên quan đến entity chính cũng bị ảnh hưởng theo: add, remove, merge, thấy code bên trên ta không hề save chi tiết đơn hàng chỉ save mỗi đơn hàng nhưng nó vẫn lưu vào... 
 * PERSITS: thì mình gọi save() đối tượng nào thì nó lưu đối tượng đó, không như ALL là lưu hết
 * REMOVE: Khi ta xóa entity chính thì nó cũng xóa luôn các entity phụ thuộc vào nó
 */