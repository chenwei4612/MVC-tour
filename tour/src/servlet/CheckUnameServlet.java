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

public class CheckUnameServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡҳ�����Ϣ
		String uname=request.getParameter("uname");
		//2.����dao��ķ����������ݿ���Ҹ��û���
		UserDao dao=new UserDao();
		User user =dao.ajaxCheckUname(uname, 0);
		//3.��������ʽ����������һ�����
		Writer out =response.getWriter();
		//�ж��Ƿ���ڸ��û�
		if(user==null) {//û������û������û������ã�
			out.write("no");
		}else {
			out.write("yes");
		}
		//�ر������
		out.close();
	}
}
