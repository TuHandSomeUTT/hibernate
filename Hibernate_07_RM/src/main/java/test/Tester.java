package test;

import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			if (sf != null) {
				Session ss = sf.openSession();
				Transaction tr = ss.beginTransaction();
				
				LocalDate localdate = LocalDate.of(2025, 8, 05);
				NhanVien nv1 = new NhanVien("NV1", "Example", Date.valueOf(localdate));
				
//				ss.saveOrUpdate(nv1);
				CuocHop ch1 = new CuocHop("Kỳ họp tổng kết lợi nhuận quý 1", "Tầng x", Date.valueOf(localdate));
				ch1.addNhanVien(nv1);
				
				ss.saveOrUpdate(ch1);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
