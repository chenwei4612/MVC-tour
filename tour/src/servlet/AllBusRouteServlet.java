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
		// 1.��ȡҳ�����Ϣ()
		String bus_route_ID = request.getParameter("bus_route_ID");
//		System.out.println(bus_route_ID);
		// 2.����dao��Ĳ�ѯ������ѯ���ݿ�
		BusRouteDao bd = new BusRouteDao();
		List<BusRoute> buss = bd.selectBus(bus_route_ID);
		// 3.��װ��request������
		request.setAttribute("buss", buss);
		// 4.ҳ����ת
		request.getRequestDispatcher("showb.jsp").forward(request, response);
	}
	public static void main(String[] args) {
		BusRouteDao bus = new BusRouteDao();
		ArrayList<BusRoute> lis=(ArrayList<BusRoute>) bus.selectBus("01·");
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
