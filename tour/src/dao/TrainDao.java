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

// ���ݷ��ʲ�,�ṩ�������ݿ���Ϣ��һϵ�з���
public class TrainDao {
	// �Զ��巽������ѯȫ����Ϣ������װ�����ϵ���
	public List<Train> selectAll() {
		// ���弯��
		List<Train> list = new ArrayList<Train>();
		// 1.��ȡ���ݿ�����
		Connection con = JDBC.getConnection();
		// 2.��дsql���
		String sql = "select * from tran";
		try {
			// 3.��ȡԤ�������
			PreparedStatement ps = con.prepareStatement(sql);
			// 4.ִ��sql,��ѯ����
			ResultSet rs = ps.executeQuery();
			// 5.ѭ���������������ȡ�����ݿ���Ϣ������װ��Train����
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
				// ��Book������ӵ����ϵ���
				list.add(tran);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Train> selectBus(String start,String stop) {
		// ����bus����
		List<Train> list = new ArrayList<Train>();
		// 1.��ȡ���ݿ�����
		Connection conn = JDBC.getConnection();
		// 2.��дsql���
		String sql = "Select * from train where start=? and stop=?";
		try {
			// 3.��ȡ��Ԥ�������
			PreparedStatement ps = conn.prepareStatement(sql);
			// 4.ΪԤ�������ֵ
			ps.setString(1, start);
			ps.setString(2, stop);
			// 5.ִ��sql���
			ResultSet rs = ps.executeQuery();
			// 6.��������ݷ�װ��Train������
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
