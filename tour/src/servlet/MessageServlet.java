package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Message;
import dao.TourDao;
import dao.UserDao;

import pojo.Mess;
import pojo.User;
import utils.JDBC;

public class MessageServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// ����BookDao����󣬵��ò�ѯ���еķ���
		Message mess = new Message();
		List<Mess> messages=mess.selectAll();
		//�ѻ�ȡ����list���Ϸ�װ��request������
		request.setCharacterEncoding("gb2312");
		request.setAttribute("messages", messages);
		// ҳ����ת
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

	public static void main(String[] args) {
		Message mess = new Message();
		List<Mess> list=mess.selectAll();
		System.out.println(list.size());
	}
}
