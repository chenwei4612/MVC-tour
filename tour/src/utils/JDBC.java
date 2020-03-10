package utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//�򿪺͹ر����ݿ�����
//������ ���ݿ�� �û��� �� ����
//      ���ݿ�ķ���·��
//      ���ݿ������
public class JDBC {
	//�����ݿ�����
	public static Connection getConnection() {
		//1.����һ������
		Connection conn = null;
		//2.����һ��properties�Ķ���
		Properties pro = new Properties();
		//3.��ȡ�����ļ�����Ϣ
		try {
			pro.load(JDBC.class.getClassLoader().getResourceAsStream("db.properties"));
			//4.��ȡ�����ļ��Ĳ���
			String driver = pro.getProperty("jdbc.driver");
			String username = pro.getProperty("jdbc.username");
			String password = pro.getProperty("jdbc.password");
			//5.��������
			Class.forName(driver);
			//6.��ȡ���ݿ������"&characterEncoding=gb2312"
			String url="jdbc:mysql://localhost:3306/cjcxt?"+"user="+username+"&password="+password+"&characterEncoding=gb2312";
			conn = DriverManager.getConnection(url);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ�����
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		//��ȡ����
		Connection conn = JDBC.getConnection();
		//�ж��Ƿ�ر�
		boolean flag = conn.isClosed();
		System.out.println(flag);
	}
}
