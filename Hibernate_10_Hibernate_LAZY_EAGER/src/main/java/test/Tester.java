package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietDonHang;
import model.DonHang;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
//				LocalDate ld = LocalDate.of(2025, 04, 04);
//				DonHang dh1 = new DonHang();
//				dh1.setTenKhachHang("Ngọc Thụ Lâm Phong");
//				dh1.setNgayMua(Date.valueOf(ld));
//				
//				for(int i=0; i<10000; i++) {
//					ChiTietDonHang detail1 = new ChiTietDonHang();
//					detail1.setTenSanPham( i + " ");
//					detail1.setGiaBan(5000);
//					detail1.setSoLuong(1);
//					detail1.setThanhTien(5000);
//					detail1.setDonHang(dh1);
//					dh1.addChiTietDonHang(detail1);
//				}
//				
//				ss.saveOrUpdate(dh1);
				
				long batDau = System.currentTimeMillis();
				DonHang dh = ss.load(DonHang.class, 1);
				long ketThuc = System.currentTimeMillis();
				System.out.println(dh.toString());
				List<ChiTietDonHang> ds = dh.getChiTietDonHang();
				for (ChiTietDonHang detail : ds) {
					System.out.println(detail.toString());
				}
				System.out.println("Thời gian thực hiện câu lệnh là: " + (ketThuc-batDau));
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * Hiểu đơn giản EAGER là load tất cả dữ liệu lên ngay lập tức, load entity 1
 * thì load luôn cả entity n lên 
 * LAZY là dùng đến đâu load đến đó 
 * Khi nào dùng gì? 
 * Lazy: dùng khi dữ liệu con KHÔNG phải lúc nào cũng cần. Default, tiết
 * kiệm. 
 * Eager: dùng khi chắc chắn sẽ cần dữ liệu con, tránh query nhiều lần.
 * Immediate: Hibernate lo. Cứ biết nó tồn tại là được 😎. 
 * chốt lại : Hibernate có 3 chiến lược loading: Lazy (trì hoãn), Eager (tải
 * ngay), và Immediate (bắt buộc tải ngay lập tức - nội bộ Hibernate quyết
 * định). Khi dùng annotation @OneToMany, @ManyToOne... chỉ có thể set Lazy hoặc
 * Eager thông qua fetch = FetchType.X.
 */