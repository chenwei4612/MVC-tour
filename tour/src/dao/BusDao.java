package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Bus;
import pojo.Mess;
import pojo.Tour;
import pojo.User;
import utils.JDBC;

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class BusDao {
	// �Զ��巽������ѯȫ����Ϣ������װ�����ϵ���
	public List<Bus> selectAll() {
		// ���弯��
		List<Bus> list = new ArrayList<Bus>();
		// 1.��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from bus";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.ִ��sql,��ѯ����
			ResultSet rs = ps.executeQuery();
			// 5.ѭ���������������ȡ�����ݿ���Ϣ������װ��Bus����
			while (rs.next()) {
				Bus bus = new Bus();
				bus.setBus_id(rs.getString("bus_id"));
				bus.setStart(rs.getString("start"));
				bus.setStop(rs.getString("stop"));
				bus.setStart_time(rs.getString("start_time"));
				bus.setStop_time(rs.getString("stop_time"));
				bus.setSeat(rs.getInt("seat"));
				bus.setPrice(rs.getDouble("price"));
				bus.setBus_station(rs.getString("bus_station"));
				// ��Book������ӵ����ϵ���
				list.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Bus> selectBus(String start,String stop) {
		// ����bus����
		List<Bus> list = new ArrayList<Bus>();
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "Select * from bus where start=? and stop=?";
		try {
			// 3.��ȡ��Ԥ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.ΪԤ�������ֵ
			ps.setString(1, start);
			ps.setString(2, stop);
			// 5.ִ��sql���
			ResultSet rs = ps.executeQuery();
			// 6.��������ݷ�װ��bus������
			while(rs.next()) {
				Bus bus = new Bus();
				bus.setBus_id(rs.getString("bus_id"));
				bus.setStart(rs.getString("start"));
				bus.setStop(rs.getString("stop"));
				bus.setStart_time(rs.getString("start_time"));
				bus.setStop_time(rs.getString("stop_time"));
				bus.setSeat(rs.getInt("seat"));
				bus.setPrice(rs.getDouble("price"));
				bus.setBus_station(rs.getString("bus_station"));
				list.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		BusDao d=new BusDao();
		List<Bus> b=d.selectBus("տ��", "����");
//		System.out.println(((Bus) b).getBus_id());
//		List<Bus> b=d.selectAll();
//		for(int i=0;i<b.size();i++) {
//			System.out.println(b.get(i));
//		}
		System.out.println(b.size());
		
	}
}
