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
		//获取请求数据
		String email=request.getParameter("email");
		//调用dao层
		UserDao dao=new UserDao();
		User user =dao.ajaxCheckEmail(email, 0);
		//定义流输出验证信息到前端页面显示
		Writer out =response.getWriter();
		//判断是否存在该用户
		if(user==null) {
			out.write("no");
		}else {
			out.write("yes");
		}
		//关闭输出流
		out.close();
	}
}
