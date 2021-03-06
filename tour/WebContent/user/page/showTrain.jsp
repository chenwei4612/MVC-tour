<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="pojo.User" %>
<%@ page import="pojo.Train"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>火车/高铁</title>
    <link href="../css/my.order.css" rel="stylesheet" />
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/set.css" rel="stylesheet" />
</head>
<body>
<div id="header">
    <!-- 头部-->
    <header id="top">
        <div id="logo" class="lf">
            <img class="animated jello" src="../img/header/logo.png" alt="logo"/>
        </div>
        <div id="top_input" class="lf">
            <input id="input" type="text" placeholder="请输入您要搜索的内容"/>
            <a href="../page/search.html?title=Java" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
        </div>
        <div class="rt">
	        <ul class="lf">
	            <li><a href="AllTourServlet" >首页</a><b>|</b></li>
            <li><a href="../page/password-change.jsp">设置</a><b>|</b></li>
            <li><a href="MessageServlet">留言版</a><b>|</b></li>
            <li><a href="userLogOutServlet">退出</a><b>|</b></li>
            <li><a href="../page/lookforward.jsp">帮助</a></li>
	        </ul>
        </div>
    </header>
</div>
<!--我的订单内容区域 #container-->
<div id="container" class="clearfix">
    <!-- 左边栏-->
    <div id="leftsidebar_box" class="lf">
        <div class="line"></div>
        <dl class="my_order">
            <dt onClick="changeImage()">出行选择<img src="../img/myOrder/myOrder1.png"></dt>
            <dd class="first_dd"><a href="../page/b.jsp">公交线路</a></dd>
            <dd class="first_dd"><a href="../page/Bus.jsp">汽车票</a></dd>
            <dd class="first_dd"><a href="../page/Train.jsp">火车/高铁</a></dd>
        </dl>
    </div>
    <!-- 右边栏-->
    <div class="rightsidebar_box rt" >
        <div class="order_emptyC">
        <% 
       ArrayList<Train> trains = (ArrayList<Train>)request.getAttribute("trains"); 
           out.print("<table border=2>");
           out.print("<tr>");
           out.println("<th>车次班号</th>");
           out.println("<th>出发城市</th>");
           out.println("<th>到达城市</th>");
           out.println("<th>出发时间</th>");
           out.println("<th>到达时间</th>");
           out.println("<th>座位数</th>");
           out.println("<th>票价</th>");
           out.println("<th>途径</th>");
           out.print("</tr>");
           for(int i=0 ;i<trains.size();i++){
        	   Train b=trains.get(i); 
	           out.print("<tr>");
	           out.println("<th>"+b.getTrain_id()+"</th>");
	           out.println("<th>"+b.getStart()+"</th>");
	           out.println("<th>"+b.getStop()+"</th>");
	           out.println("<th>"+b.getStart_time()+"</th>");
	           out.println("<th>"+b.getStop_time()+"</th>");
	           out.println("<th>"+b.getPrice()+"</th>");
	           out.println("<th>"+b.getSeat()+"</th>");
	           out.println("<th>"+b.getPass()+"</th>");
	           out.print("</tr>");
         }  
	      out.print("<table>");
    %>
       </div>
    </div>
</div>
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../img/footer/icon1.png" alt=""/>
    </div>
    <div class="icon2 lf">
        <img src="../img/footer/icon2.png" alt=""/>
    </div>
    <div class="icon3 lf">
        <img src="../img/footer/icon3.png" alt=""/>
    </div>
    <div class="icon4 lf">
        <img src="../img/footer/icon4.png" alt=""/>
    </div>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script src="../js/order.js"></script>
</html>