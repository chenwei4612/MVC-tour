package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRegistDao;
import pojo.User;

public class UserChangePwdServlet extends HttpServlet{
	UserRegistDao dao = new UserRegistDao();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();// user.uname,user.upwd,npwd,cpwd
		user.setUname(request.getParameter("user.uname"));
		user.setUpwd(request.getParameter("user.upwd"));
		user.setRole(0);
		String npwd = request.getParameter("npwd");
		String cpwd = request.getParameter("cpwd");
		if (npwd.equals(cpwd)) {
			dao.updatePassword(user, npwd);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("password-change.jsp").forward(request, response);
		}
	}
	
}
