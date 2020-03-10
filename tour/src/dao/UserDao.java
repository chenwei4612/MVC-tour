package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import utils.JDBC;

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class UserDao {
	public void insert(User user) {
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "insert into t_user(phone,uname,upwd,email,role) values (?,?,?,?,?)";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.��Ԥ�������ֵ
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getUname());
			ps.setString(3, user.getUpwd());
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getRole());
			// 5.ִ��sql�������ݿ�,�������ݿ�
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��½��ѯ���ݿ�
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
	//�Զ��巽��������У��ע��ҳ�����û��Ƿ����
	public User ajaxCheckUname(String uname,int role) {
		//����һ��User����
		User user=null;
		//1.��ȡ���ݿ������
		Connection conn=JDBC.getConnection();
		//2.��дsql���
		String sql="select * from t_user where uname=? and role=?";
		try {
			//3.��ȡԤ�������
			PreparedStatement ps=conn.prepareStatement(sql);
			//4.��Ԥ�������ֵ
			ps.setString(1, uname);
			ps.setInt(2,role);
			//5.ִ��sql���
			ResultSet rs=ps.executeQuery();
			//6.��װ��user����
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
	//�Զ��巽��������У��ע��ҳ���������ַ�Ƿ����
	public User ajaxCheckEmail(String email,int role) {
		//����һ��User����
		User user=null;
		//1.��ȡ���ݿ�����
		Connection conn=JDBC.getConnection();
		//2.��дsql���
		String sql="select * from t_user where email=? and role=?";
		try {
			//3.��ȡԤ�������
			PreparedStatement ps=conn.prepareStatement(sql);
			//4.ΪԤ�������ֵ
			ps.setString(1, email);
			ps.setInt(2,role);
			//5.ִ��sql���
			ResultSet rs=ps.executeQuery();
			//6.�ѽ������װ��user������
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
	//�Զ��巽��������У��ע��ҳ�����ֻ������Ƿ����
	public User ajaxCheckPhone(String phone,int role) {
		//����һ��User����
		User user=null;
		//1.��ȡ���ݿ�����
		Connection conn=JDBC.getConnection();
		//2.��дsql���
		String sql="select * from t_user where phone=? and role=?";
		try {
			//3.��ȡԤ�������
			PreparedStatement ps=conn.prepareStatement(sql);
			//4.ΪԤ�������ֵ
			ps.setString(1, phone);
			ps.setInt(2,role);
			//5.ִ��sql���
			ResultSet rs=ps.executeQuery();
			//6.�ѽ������װ��user������
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
	
	//�Զ��巽��������У���½ҳ�����û��Ƿ����
		public User ajaxUnameCheck(String uname,int role) {
			//����һ��User����
			User user=null;
			//1.��ȡ���ݿ������
			Connection conn=JDBC.getConnection();
			//2.��дsql���
			String sql="select * from t_user where uname=? and role=?";
			try {
				//3.��ȡԤ�������
				PreparedStatement ps=conn.prepareStatement(sql);
				//4.��Ԥ�������ֵ
				ps.setString(1, uname);
				ps.setInt(2,role);
				//5.ִ��sql���
				ResultSet rs=ps.executeQuery();
				//6.��װ��user����
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
		/**�����û�����**/
		public void updateupwd(String upwd,String uname,int role ) {
			User user = null;
			Connection conn = JDBC.getConnection();
			String sql = "update t_user set upwd=? where uname=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				// 4.Ϊ��丳ֵ
				ps.setString(1, upwd);
				ps.setInt(2, role);
				// 5.ִ��sql���,��ȡ�����
				ResultSet res = ps.executeQuery();
				// 6.�ѽ����װ��user������
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
