package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import utils.JDBC;

public class UserRegistDao {
	public void query() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " select * from t_user ";
		conn = JDBC.getConnection();
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String phone = rs.getString("phone");
			System.out.println(phone);
		}
		JDBC.closeConnection(conn);
	}
	
	public void insert(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into t_user values (?,?,?,?,?)";
		conn = JDBC.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.closeConnection(conn); 
		}
	}
	
	public User selectByNamePasswordAndRole(User user) {
		User u = null;
		Connection con = JDBC.getConnection();
		String sql = "select * from t_user where uname=? and upwd=? and role=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getUname());
			sta.setString(2, user.getUpwd());
			sta.setInt(3, user.getRole());
			res = sta.executeQuery();
			if(res.next()){
				u = new User();
				u.setEmail(res.getString("email"));
				u.setPhone(res.getString("phone"));
				u.setRole(res.getInt("role"));
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBC.closeConnection(con);
		}
		return u;
	}
	
	public void updatePassword(User user , String npwd) {
		Connection con = JDBC.getConnection();
		String sql = "update t_user set upwd=? "
				+ "where uname=? and upwd=? and role=?";
		PreparedStatement sta = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, npwd);
			sta.setString(2, user.getUname());
			sta.setString(3, user.getUpwd());
			sta.setInt(4, user.getRole());
			sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBC.closeConnection(con);
		}
	}
	
	public User selectByUnameAndRole(User user){
		User u = null;
		Connection con = JDBC.getConnection();
		String sql = "select * from t_user  where uname=? and role=?";
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getUname());
			sta.setInt(2, user.getRole());
			res = sta.executeQuery();
			if(res.next()){
				u = new User();
				u.setEmail(res.getString("email"));
				u.setPhone(res.getString("phone"));
				u.setRole(res.getInt("role"));
				u.setUname(res.getString("uname"));
				u.setUpwd(res.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBC.closeConnection(con);
		}
		return u;
	}
	
}
