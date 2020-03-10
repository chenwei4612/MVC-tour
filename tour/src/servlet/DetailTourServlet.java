package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TourDao;
import pojo.Tour;

public class DetailTourServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取页面的信息(isbn)
		String isbn = request.getParameter("isbn");
		//2.调用dao层的查询方法查询数据库
		TourDao bd = new TourDao();
		Tour tour = bd.selectDarailByIsbn(isbn);
		// 3.封装到request对象中
		request.setAttribute("tour", tour);
		// 4.页面跳转
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
