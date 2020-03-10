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
		//1.获取页面的信息
		String uname=request.getParameter("uname");
		//2.调用dao层的方法（从数据库查找该用户）
		UserDao dao=new UserDao();
		User user =dao.ajaxCheckUname(uname, 0);
		//3.用流的形式向浏览器输出一个结果
		Writer out =response.getWriter();
		//判断是否存在该用户
		if(user==null) {//没有这个用户（该用户名可用）
			out.write("no");
		}else {
			out.write("yes");
		}
		//关闭输出流
		out.close();
	}
}
