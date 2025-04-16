package test;

import java.sql.Date;
import java.time.LocalDate;

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
				
				/*Hiện thực hóa mối quan hệ n-n bằng cách chia nó ra làm 2 MQH 1-n. 
				 * 1 nhân viên tham gia nhiều cuộc họp, 
				 * 1 cuộc họp chứa nhiều nhân viên*/
				
//				LocalDate ld2 = LocalDate.of(2025, 04, 20);
//				CuocHop ch1 = new CuocHop("Họp Tổng Kết Lợi Nhuận Quý I năm 2025", "Tầng x", Date.valueOf(ld2));
				
//				CuocHop ch1 = new CuocHop();
//				ch1.setId(2);
//				ss.saveOrUpdate(ch1);
				
				LocalDate ld = LocalDate.of(2025, 01, 01);
				NhanVien nv2 = new NhanVien();
				nv2.setId("NV2");
				nv2.setHoVaTen("Van Tu Nguyen");
				nv2.setNgayVaoLam(Date.valueOf(ld));
//				nv2.addCuocHop(ch1);
				ss.saveOrUpdate(nv2);
				
//				LocalDate ld = LocalDate.of(2025, 01, 01);
//				NhanVien nv3 = new NhanVien("NV3", "Van Long Nguyen", Date.valueOf(ld));
//	
//				CuocHop ch3 = new CuocHop();
//				ch3.setId(2);
//				nv3.addCuocHop(ch3);
//				ss.saveOrUpdate(nv3);
				
				tr.commit();
				ss.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
