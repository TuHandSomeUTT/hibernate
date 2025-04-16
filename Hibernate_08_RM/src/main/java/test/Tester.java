package test;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ConNguoi;
import model.GiaoVien;
import model.SinhVien;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				LocalDate ld = LocalDate.of(1990, 01, 10);
				GiaoVien gv1 = new GiaoVien("GV01", "Hữu Giang", Date.valueOf(ld), "Toán Cao Cấp");
				
				LocalDate ld2 = LocalDate.of(2003, 03, 01);
				SinhVien sv1 = new SinhVien("SV01", "Van Tu Nguyen", Date.valueOf(ld2), 9.9);
				
				ss.saveOrUpdate(gv1);
				ss.saveOrUpdate(sv1);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
