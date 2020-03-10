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
		// 1.��ȡҳ�����Ϣ(isbn)
		String isbn = request.getParameter("isbn");
		//2.����dao��Ĳ�ѯ������ѯ���ݿ�
		TourDao bd = new TourDao();
		Tour tour = bd.selectDarailByIsbn(isbn);
		// 3.��װ��request������
		request.setAttribute("tour", tour);
		// 4.ҳ����ת
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}
}
