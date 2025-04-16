package test;

import java.sql.Date;
import java.time.LocalDate;

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
				
				LocalDate ld = LocalDate.of(2025, 04, 04);
				DonHang dh1 = new DonHang();
				dh1.setTenKhachHang("Ngọc Thụ Lâm Phong");
				dh1.setNgayMua(Date.valueOf(ld));
				
				ChiTietDonHang detail1 = new ChiTietDonHang();
				detail1.setTenSanPham("Bộ Bài Tây Mạ Vàng");
				detail1.setGiaBan(5000);
				detail1.setSoLuong(1);
				detail1.setThanhTien(5000);
				detail1.setDonHang(dh1);
				
				dh1.addChiTietDonHang(detail1);
				
				ss.saveOrUpdate(dh1);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
