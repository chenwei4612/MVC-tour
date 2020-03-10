package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import utils.JDBC;

// 数据访问层,提供访问数据库信息的一系列方法
public class UserDao {
	public void insert(User user) {
		// 1.获取数据库连接
		Connection conn = JDBC.getConnection();
		// 2.编写sql语句
		String sql = "insert into t_user(phone,uname,upwd,email,role) values (?,?,?,?,?)";
		try {
			// 3.获取预编译对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.给预编译对象赋值
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			// 5.执行sql插入数据库,更新数据库
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//登陆查询数据库
	public User selectAllUser(String uname,String upwd,int role) {
		User user=null;
		Connection conn = JDBC.getConnection();
		String sql = "select * from t_user where uname= ? and upwd = ? and role = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.setInt(3, role);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user =new User();
				user.setRole(rs.getInt("role"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//自定义方法，用来校验注册页面中用户是否存在
	public User ajaxCheckUname(String uname,int role) {
		//定义一个User对象
		User user=null;
		//1.获取数据库的连接
		Connection conn=JDBC.getConnection();
		//2.编写sql语句
		String sql="select * from t_user where uname=? and role=?";
		try {
			//3.获取预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//4.给预编译对象赋值
			ps.setString(1, uname);
			ps.setInt(2,role);
			//5.执行sql语句
			ResultSet rs=ps.executeQuery();
			//6.封装成user对象
			if(rs.next()) {
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) { e.printStackTrace();}
		finally { JDBC.closeConnection(conn);}
		return user;
	}
	//自定义方法，用来校验注册页面中邮箱地址是否存在
	public User ajaxCheckEmail(String email,int role) {
		//定义一个User对象
		User user=null;
		//1.获取数据库连接
		Connection conn=JDBC.getConnection();
		//2.编写sql语句
		String sql="select * from t_user where email=? and role=?";
		try {
			//3.获取预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//4.为预编译对象赋值
			ps.setString(1, email);
			ps.setInt(2,role);
			//5.执行sql语句
			ResultSet rs=ps.executeQuery();
			//6.把结果集封装到user对象中
			if(rs.next()) {
				user=new User();
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	//自定义方法，用来校验注册页面中手机号码是否存在
	public User ajaxCheckPhone(String phone,int role) {
		//定义一个User对象
		User user=null;
		//1.获取数据库连接
		Connection conn=JDBC.getConnection();
		//2.编写sql语句
		String sql="select * from t_user where phone=? and role=?";
		try {
			//3.获取预编译对象
			PreparedStatement ps=conn.prepareStatement(sql);
			//4.为预编译对象赋值
			ps.setString(1, phone);
			ps.setInt(2,role);
			//5.执行sql语句
			ResultSet rs=ps.executeQuery();
			//6.把结果集封装到user对象中
			if(rs.next()) {
				user=new User();
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.closeConnection(conn);
		}
		return user;
	}
	
	//自定义方法，用来校验登陆页面中用户是否存在
		public User ajaxUnameCheck(String uname,int role) {
			//定义一个User对象
			User user=null;
			//1.获取数据库的连接
			Connection conn=JDBC.getConnection();
			//2.编写sql语句
			String sql="select * from t_user where uname=? and role=?";
			try {
				//3.获取预编译对象
				PreparedStatement ps=conn.prepareStatement(sql);
				//4.给预编译对象赋值
				ps.setString(1, uname);
				ps.setInt(2,role);
				//5.执行sql语句
				ResultSet rs=ps.executeQuery();
				//6.封装成user对象
				if(rs.next()) {
					user = new User();
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRole(rs.getInt("role"));
					user.setUname(rs.getString("uname"));
					user.setUpwd(rs.getString("upwd"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBC.closeConnection(conn);
			}
			return user;
		}
		/**更新用户密码**/
		public void updateupwd(String upwd,String uname,int role ) {
			User user = null;
			Connection conn = JDBC.getConnection();
			String sql = "update t_user set upwd=? where uname=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				// 4.为语句赋值
				ps.setString(1, upwd);
				ps.setInt(2, role);
				// 5.执行sql语句,获取结果集
				ResultSet res = ps.executeQuery();
				// 6.把结果封装到user对象中
				if (res.next()) {
					user = new User();
					user.setEmail(res.getString("email"));
					user.setPhone(res.getString("phone"));
					user.setRole(res.getInt("role"));
					user.setUname(res.getString("uname"));
					user.setUpwd(res.getString("upwd"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBC.closeConnection(conn);
			}
			return;
		}
}
