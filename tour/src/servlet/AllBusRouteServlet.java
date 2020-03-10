package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusRouteDao;
import pojo.Bus;
import pojo.BusRoute;

public class AllBusRouteServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		// 1.获取页面的信息()
		String bus_route_ID = request.getParameter("bus_route_ID");
//		System.out.println(bus_route_ID);
		// 2.调用dao层的查询方法查询数据库
		BusRouteDao bd = new BusRouteDao();
		List<BusRoute> buss = bd.selectBus(bus_route_ID);
		// 3.封装到request对象中
		request.setAttribute("buss", buss);
		// 4.页面跳转
		request.getRequestDispatcher("showb.jsp").forward(request, response);
	}
	public static void main(String[] args) {
		BusRouteDao bus = new BusRouteDao();
		ArrayList<BusRoute> lis=(ArrayList<BusRoute>) bus.selectBus("01路");
		System.out.println(lis.size());
		for(int i=0 ;i<lis.size();i++){
     	   BusRoute b=lis.get(i);
     	   System.out.println(b.getBus_route_ID());
     	   System.out.println(b.getStart());
     	   System.out.println(b.getPass());
     	   System.out.println(b.getStart_time());
		}
	}
}
