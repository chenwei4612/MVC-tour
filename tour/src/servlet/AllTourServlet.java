package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.TourDao;
import dao.UserDao;

import pojo.Tour;
import pojo.User;

public class AllTourServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// 创建TourDao层对象，调用查询所有的方法
		TourDao dao = new TourDao();
		List<Tour> list=dao.selectAll();
		//把获取到的list集合封装到request对象中
		request.setAttribute("tours", list);
		// 页面跳转
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
