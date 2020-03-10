package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import pojo.User;

public class UserLoginServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.��ȡҳ���е���Ϣ
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		int role = 0;
		// 2.����dao���select����,�����ݿ��в�������
		UserDao dao = new UserDao();
		User user = dao.selectAllUser(uname, upwd, role);
		// 3.ҳ����ת
		if (user != null) { // �����ݿ��в����д��û�
			// ��¼�Ự(���û���Ϣ)
			HttpSession session =request.getSession(true);
			session.setAttribute("user", user);
//			request.getSession().setAttribute("user", user);  // ???����������?
			request.getRequestDispatcher("AllTourServlet").forward(request, response);
		} else { // ���ݿ���û�и��û���Ϣ
			response.sendRedirect("login.jsp");
		}
	}
}
