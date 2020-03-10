package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

public class UserRegistServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取页面的信息
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		int role = 0;//用户
		// 3.调用dao层的insert方法,把数据保存到数据库
		UserDao dao = new UserDao();
		
		User user = new User();
		user.setUname(uname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setUpwd(upwd);
		user.setRole(role);
		
		dao.insert(user);
		
		// 4.页面跳转
		response.sendRedirect("login.jsp");
		
	}

}
