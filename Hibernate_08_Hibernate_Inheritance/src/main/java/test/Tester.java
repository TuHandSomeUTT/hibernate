package test;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.SinhVien;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		if (sf != null) {
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			
			LocalDate ld = LocalDate.of(1999, 05, 06);
			GiaoVien gv = new GiaoVien("GV01", "Đạt Zăn Tây", Date.valueOf(ld), "Khoa Học Tự Nhiên");
			
			LocalDate ld1 = LocalDate.of(2000, 01, 06);
			SinhVien sv = new SinhVien("SV01", "Như Hoa", Date.valueOf(ld1), 9);
			
			ss.saveOrUpdate(gv);
			ss.saveOrUpdate(sv);
			
			tr.commit();
			ss.close();
		}
	}
}
