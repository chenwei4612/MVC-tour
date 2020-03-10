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
		// ����TourDao����󣬵��ò�ѯ���еķ���
		TourDao dao = new TourDao();
		List<Tour> list=dao.selectAll();
		//�ѻ�ȡ����list���Ϸ�װ��request������
		request.setAttribute("tours", list);
		// ҳ����ת
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
