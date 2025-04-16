package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Tester {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		if (sf != null) {
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
			
			NhanVien nv1 = new NhanVien("NV1", "Van Tu Nguyen", new Date(2020-1900, 05-1, 01));
//			ss.saveOrUpdate(nv1);
			
			CuocHop ch1 = new CuocHop("Họp HĐQT", "Tầng x", new Date(2025-1900, 05-1, 05));
			ch1.addNhanVien(nv1);
			
			ss.saveOrUpdate(ch1);
			
			tr.commit();
			ss.close();
		}
	}
}
