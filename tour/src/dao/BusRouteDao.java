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

// 数据访问层,提供访问数据库信息的一系列方法
public class BusRouteDao {
	// 自定义方法，查询全部信息，并封装到集合当中
	public List<BusRoute> selectAll() {
		// 定义集合
		List<BusRoute> list = new ArrayList<BusRoute>();
		// 1.获取数据库连接
		Connection con = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from bus_route";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.执行sql,查询数据
			ResultSet rs = ps.executeQuery();
			// 5.循环遍历结果集，获取到数据库信息，并封装成BusRoute对象
			while (rs.next()) {
				BusRoute bus = new BusRoute();
				bus.setBus_route_ID(rs.getString("bus_route_ID"));
				bus.setStart(rs.getString("start"));
				bus.setPass(rs.getString("pass"));
				bus.setStop(rs.getString("stop"));
				bus.setStart_time(rs.getString("start_time"));
				bus.setStop_time(rs.getString("stop_time"));
				// 把Book对象添加到集合当中
				list.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BusRoute> selectBus(String bus_route_ID) {
		// 创建bus对象
		List<BusRoute> list = new ArrayList<BusRoute>();
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "Select * from bus_route where bus_route_ID=?";
		try {
			// 3.获取与预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.为预编译对象赋值
			ps.setString(1, bus_route_ID);
			// 5.执行sql语句
			ResultSet rs = ps.executeQuery();
			// 6.结果集数据封装到BusRoute对象中
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
//		List<Bus> b=d.selectBus("湛江", "阳春");
////		System.out.println(((Bus) b).getBus_id());
////		List<Bus> b=d.selectAll();
////		for(int i=0;i<b.size();i++) {
////			System.out.println(b.get(i));
////		}
//		System.out.println(b.size());
//		
//	}
}
