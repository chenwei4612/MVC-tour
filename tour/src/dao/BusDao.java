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

// 数据访问层,提供访问数据库信息的一系列方法
public class BusDao {
	// 自定义方法，查询全部信息，并封装到集合当中
	public List<Bus> selectAll() {
		// 定义集合
		List<Bus> list = new ArrayList<Bus>();
		// 1.获取数据库连接
		Connection con = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from bus";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.执行sql,查询数据
			ResultSet rs = ps.executeQuery();
			// 5.循环遍历结果集，获取到数据库信息，并封装成Bus对象
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
				// 把Book对象添加到集合当中
				list.add(bus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Bus> selectBus(String start,String stop) {
		// 创建bus对象
		List<Bus> list = new ArrayList<Bus>();
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "Select * from bus where start=? and stop=?";
		try {
			// 3.获取与预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.为预编译对象赋值
			ps.setString(1, start);
			ps.setString(2, stop);
			// 5.执行sql语句
			ResultSet rs = ps.executeQuery();
			// 6.结果集数据封装到bus对象中
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
		List<Bus> b=d.selectBus("湛江", "阳春");
//		System.out.println(((Bus) b).getBus_id());
//		List<Bus> b=d.selectAll();
//		for(int i=0;i<b.size();i++) {
//			System.out.println(b.get(i));
//		}
		System.out.println(b.size());
		
	}
}
