package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import pojo.User;

public class UserLogOutServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//移出Session对象中的user用户
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		request.getSession().removeAttribute("user");
		//页面的跳转：重定向
		response.sendRedirect("login.jsp");
	}
}
