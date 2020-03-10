package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.BusRoute;
import pojo.Mess;
import pojo.Tour;
import pojo.User;
import utils.JDBC;

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class BusRouteDao {
	// �Զ��巽������ѯȫ����Ϣ������װ�����ϵ���
	public List<BusRoute> selectAll() {
		// ���弯��
		List<BusRoute> list = new ArrayList<BusRoute>();
		// 1.��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from bus_route";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.ִ��sql,��ѯ����
			ResultSet rs = ps.executeQuery();
			// 5.ѭ���������������ȡ�����ݿ���Ϣ������װ��BusRoute����
			while (rs.next()) {
				BusRoute bus = new BusRoute();
				bus.setBus_route_ID(rs.getString("bus_route_ID"));
				bus.setStart(rs.getString("start"));
				bus.setPass(rs.getString("pass"));
				bus.setStop(rs.getString("stop"));
				bus.setStart_time(rs.getString("start_time"));
				bus.setStop_time(rs.getString("stop_time"));
				// ��Book������ӵ����ϵ���
				list.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BusRoute> selectBus(String bus_route_ID) {
		// ����bus����
		List<BusRoute> list = new ArrayList<BusRoute>();
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "Select * from bus_route where bus_route_ID=?";
		try {
			// 3.��ȡ��Ԥ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.ΪԤ�������ֵ
			ps.setString(1, bus_route_ID);
			// 5.ִ��sql���
			ResultSet rs = ps.executeQuery();
			// 6.��������ݷ�װ��BusRoute������
			while(rs.next()) {
				BusRoute bus = new BusRoute();
				bus.setBus_route_ID(rs.getString("bus_route_ID"));
				bus.setStart(rs.getString("start"));
				bus.setPass(rs.getString("pass"));
				bus.setStop(rs.getString("stop"));
				bus.setStart_time(rs.getString("start_time"));
				bus.setStop_time(rs.getString("stop_time"));
				list.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//	public static void main(String[] args) {
//		bDao d=new bDao();
//		List<Bus> b=d.selectBus("տ��", "����");
////		System.out.println(((Bus) b).getBus_id());
////		List<Bus> b=d.selectAll();
////		for(int i=0;i<b.size();i++) {
////			System.out.println(b.get(i));
////		}
//		System.out.println(b.size());
//		
//	}
}
