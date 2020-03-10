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
import pojo.Train;
import pojo.User;
import utils.JDBC;

// 数据访问层,提供访问数据库信息的一系列方法
public class TrainDao {
	// 自定义方法，查询全部信息，并封装到集合当中
	public List<Train> selectAll() {
		// 定义集合
		List<Train> list = new ArrayList<Train>();
		// 1.获取数据库连接
		Connection con = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "select * from tran";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.执行sql,查询数据
			ResultSet rs = ps.executeQuery();
			// 5.循环遍历结果集，获取到数据库信息，并封装成Train对象
			while (rs.next()) {
				Train tran = new Train();
				tran.setTran_id(rs.getString("tran_id"));
				tran.setStart(rs.getString("start"));
				tran.setStop(rs.getString("stop"));
				tran.setStart_time(rs.getString("start_time"));
				tran.setStop_time(rs.getString("stop_time"));
				tran.setSeat(rs.getInt("seat"));
				tran.setPrice(rs.getDouble("price"));
				tran.setPass(rs.getString("pass"));
				// 把Book对象添加到集合当中
				list.add(tran);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Train> selectBus(String start,String stop) {
		// 创建bus对象
		List<Train> list = new ArrayList<Train>();
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "Select * from train where start=? and stop=?";
		try {
			// 3.获取与预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.为预编译对象赋值
			ps.setString(1, start);
			ps.setString(2, stop);
			// 5.执行sql语句
			ResultSet rs = ps.executeQuery();
			// 6.结果集数据封装到Train对象中
			while(rs.next()) {
				Train train = new Train();
				train.setTran_id(rs.getString("train_id"));
				train.setStart(rs.getString("start"));
				train.setStop(rs.getString("stop"));
				train.setStart_time(rs.getString("start_time"));
				train.setStop_time(rs.getString("stop_time"));
				train.setSeat(rs.getInt("seat"));
				train.setPrice(rs.getDouble("price"));
				train.setPass(rs.getString("pass"));
				list.add(train);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//	public static void main(String[] args) {
//		TranDao d=new TranDao();
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
