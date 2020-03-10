package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Tour;
import utils.JDBC;

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class TourDao {
	// �Զ��巽������ѯȫ����Ϣ������װ�����ϵ���
	public List<Tour> selectAll() {
		// ���弯��
		List<Tour> list = new ArrayList<Tour>();
		// 1.��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from t_tour";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.ִ��sql,��ѯ����
			ResultSet rs = ps.executeQuery();
			// 5.ѭ���������������ȡ�����ݿ���Ϣ������װ��Tour����
			while (rs.next()) {
				Tour tour = new Tour();
				tour.setIsbn(rs.getString("isbn"));
				tour.setTitle(rs.getString("title"));
				tour.setLocation(rs.getString("location"));
				tour.setChara(rs.getString("chara"));
				tour.setTxt(rs.getString("txt"));
				// ��Tour������ӵ����ϵ���
				list.add(tour);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// ҳ�����飨�Զ��巽�������ݵ�ǰ������Ȿ���isbn�������ݿ���t_Tour����ѯ�� �Ȿ�飩
	public Tour selectDarailByIsbn(String isbn) {
		// ����book����
		Tour tour = null;
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "Select * from t_tour where isbn=?";
		try {
			// 3.��ȡ��Ԥ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.ΪԤ�������ֵ
			ps.setString(1, isbn);
			// 5.ִ��sql���
			ResultSet rs = ps.executeQuery();
			// 6.��������ݷ�װ��book������
			if (rs.next()) {
				tour = new Tour();
				tour.setIsbn(rs.getString("isbn"));
				tour.setTitle(rs.getString("title"));
				tour.setLocation(rs.getString("location"));
				tour.setChara(rs.getString("chara"));
				tour.setTxt(rs.getString("txt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tour;
	}
	public static void main(String[] args) {
		TourDao d=new TourDao();
		Tour b=d.selectDarailByIsbn("001");
		System.out.println(b.getTitle());
		List<Tour> b1=d.selectAll();
		for(int i=0;i<b1.size();i++) {
			System.out.println(b1.get(i));
		}
		
	}
}
