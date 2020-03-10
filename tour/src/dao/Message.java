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

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class Message {
	// �Զ��巽������ѯȫ����Ϣ������װ�����ϵ���
	public List<Mess> selectAll() {
		// ���弯��
		List<Mess> list = new ArrayList<Mess>();
		// 1.��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from t_message";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.ִ��sql,��ѯ����
			ResultSet rs = ps.executeQuery();
			// 5.ѭ���������������ȡ�����ݿ���Ϣ������װ��Message����
			while (rs.next()) {
				Mess message = new Mess();
				message.setUname(rs.getString("name"));
				message.setTime(rs.getString("time"));
				message.setMessage(rs.getString("message"));
				// ��Book������ӵ����ϵ���
				list.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(Mess message) {
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "insert into t_message(name,time,message) values (?,?,?)";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.��Ԥ�������ֵ
			ps.setString(1, message.getUname());
			ps.setString(2, message.getTime());
			ps.setString(3, message.getMessage());
			// 5.ִ��sql�������ݿ�,�������ݿ�
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
