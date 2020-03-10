package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Mess;
import pojo.Tour;
import pojo.User;
import utils.JDBC;

// 数据访问层,提供访问数据库信息的一系列方法
public class Message {
	// 自定义方法，查询全部信息，并封装到集合当中
	public List<Mess> selectAll() {
		// 定义集合
		List<Mess> list = new ArrayList<Mess>();
		// 1.获取数据库连接
		Connection con = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from t_message";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.执行sql,查询数据
			ResultSet rs = ps.executeQuery();
			// 5.循环遍历结果集，获取到数据库信息，并封装成Message对象
			while (rs.next()) {
				Mess message = new Mess();
				message.setUname(rs.getString("name"));
				message.setTime(rs.getString("time"));
				message.setMessage(rs.getString("message"));
				// 把Book对象添加到集合当中
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(Mess message) {
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "insert into t_message(name,time,message) values (?,?,?)";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.给预编译对象赋值
			ps.setString(1, message.getUname());
			ps.setString(2, message.getTime());
			ps.setString(3, message.getMessage());
			// 5.执行sql插入数据库,更新数据库
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
