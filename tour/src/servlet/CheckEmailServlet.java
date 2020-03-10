package servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;
import sun.print.resources.serviceui;

public class CheckEmailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��������
		String email=request.getParameter("email");
		//����dao��
		UserDao dao=new UserDao();
		User user =dao.ajaxCheckEmail(email, 0);
		//�����������֤��Ϣ��ǰ��ҳ����ʾ
		Writer out =response.getWriter();
		//�ж��Ƿ���ڸ��û�
		if(user==null) {
			out.write("no");
		}else {
			out.write("yes");
		}
		//�ر������
		out.close();
	}
}
