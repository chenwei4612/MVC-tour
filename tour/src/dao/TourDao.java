package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Tour;
import utils.JDBC;

// 数据访问层,提供访问数据库信息的一系列方法
public class TourDao {
	// 自定义方法，查询全部信息，并封装到集合当中
	public List<Tour> selectAll() {
		// 定义集合
		List<Tour> list = new ArrayList<Tour>();
		// 1.获取数据库连接
		Connection con = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from t_tour";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.执行sql,查询数据
			ResultSet rs = ps.executeQuery();
			// 5.循环遍历结果集，获取到数据库信息，并封装成Tour对象
			while (rs.next()) {
				Tour tour = new Tour();
				tour.setIsbn(rs.getString("isbn"));
				tour.setTitle(rs.getString("title"));
				tour.setLocation(rs.getString("location"));
				tour.setChara(rs.getString("chara"));
				tour.setTxt(rs.getString("txt"));
				// 把Tour对象添加到集合当中
				list.add(tour);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 页面详情（自定义方法，根据当前点击到这本书的isbn，从数据库中t_Tour，查询该 这本书）
	public Tour selectDarailByIsbn(String isbn) {
		// 创建book对象
		Tour tour = null;
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "Select * from t_tour where isbn=?";
		try {
			// 3.获取与预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.为预编译对象赋值
			ps.setString(1, isbn);
			// 5.执行sql语句
			ResultSet rs = ps.executeQuery();
			// 6.结果集数据封装到book对象中
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
