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
import dao.TrainDao;
import dao.UserDao;

import pojo.Bus;
import pojo.Mess;
import pojo.Tour;
import pojo.Train;
import pojo.User;

public class AllTrainServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		// 1.获取页面的信息()
		String start = request.getParameter("start");
		String stop = request.getParameter("stop");
		// 2.调用dao层的查询方法查询数据库
		TrainDao bd = new TrainDao();
		List<Train> trains = bd.selectBus(start, stop);
		// 3.封装到request对象中
		request.setAttribute("trains", trains);
		// 4.页面跳转
		request.getRequestDispatcher("showTrain.jsp").forward(request, response);
	}
//	public static void main(String[] args) {
//		BusDao bus = new BusDao();
////		List<Bus> list=bus.selectAll();
////		System.out.println(list.size());
////		ArrayList<Bus> lis=(ArrayList<Bus>) bus.selectAll();
//		ArrayList<Bus> lis=(ArrayList<Bus>) bus.selectBus("湛江", "阳春");
//		System.out.println(lis.size());
////		 for(int i=0 ;i<lis.size();i++){
////	          Bus b=lis.get(i);
////	          System.out.println(b.getBus_id());
////	          System.out.println(b.getStart());
////	          System.out.println(b.getStop());
////	          System.out.println(b.getStart_time());
////	          System. out.println(b.getStop_time());
////	          System.out.println(b.getPrice());
////	          System. out.println(b.getSeat());
////        } 
//	}
}
