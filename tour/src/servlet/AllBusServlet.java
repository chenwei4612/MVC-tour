package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BusDao;
import dao.Message;
import dao.TourDao;
import dao.UserDao;

import pojo.Bus;
import pojo.Mess;
import pojo.Tour;
import pojo.User;

public class AllBusServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		// 1.��ȡҳ�����Ϣ()
		String start = request.getParameter("start");
		String stop = request.getParameter("stop");
		//  2.����dao��Ĳ�ѯ������ѯ���ݿ�
		BusDao bd = new BusDao();
		List<Bus> buss = bd.selectBus(start, stop);
		// 3.��װ��request������
		request.setAttribute("buss", buss);
		// 4.ҳ����ת
		request.getRequestDispatcher("showBus.jsp").forward(request, response);
	}
	public static void main(String[] args) {
		BusDao bus = new BusDao();
//		List<Bus> list=bus.selectAll();
//		System.out.println(list.size());
//		ArrayList<Bus> lis=(ArrayList<Bus>) bus.selectAll();
		ArrayList<Bus> lis=(ArrayList<Bus>) bus.selectBus("տ��", "����");
		System.out.println(lis.size());
//		 for(int i=0 ;i<lis.size();i++){
//	          Bus b=lis.get(i);
//	          System.out.println(b.getBus_id());
//	          System.out.println(b.getStart());
//	          System.out.println(b.getStop());
//	          System.out.println(b.getStart_time());
//	          System. out.println(b.getStop_time());
//	          System.out.println(b.getPrice());
//	          System. out.println(b.getSeat());
//        } 
	}
}
