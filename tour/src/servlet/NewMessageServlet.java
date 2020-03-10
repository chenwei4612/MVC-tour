package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Message;
import dao.UserDao;
import pojo.Mess;
import pojo.User;

public class NewMessageServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1.��ȡҳ�����Ϣ
		String uname = request.getParameter("name");
		String time = request.getParameter("time");
		String message = request.getParameter("message");
		int role = 0;//�û�
		// 3.����dao���insert����,�����ݱ��浽���ݿ�
		Message dao = new Message();
		Mess mess=new Mess();
		mess.setUname(uname);
		mess.setTime(time);
		mess.setMessage(message);
		dao.insert(mess);
		// 4.ҳ����ת
		response.sendRedirect("MessageServlet");
	}
}
