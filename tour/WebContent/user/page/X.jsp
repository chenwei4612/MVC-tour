<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="pojo.User" %>
<%@ page import="pojo.Bus"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>修改密码页面</title>
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
            <li><a href="message.jsp">留言版</a><b>|</b></li>
            <li><a href="userLogOutServlet">退出</a><b>|</b></li>
            <li><a href="../page/lookforward.html">帮助</a></li>
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
            <dt onClick="changeImage()">帐号管理<img src="../img/myOrder/myOrder1.png"></dt>
            <dd class="first_dd"><a href="../page/password-change.jsp">公交线路</a></dd>
            <dd class="first_dd"><a href="../page/password-change.jsp">汽车票</a></dd>
            <dd class="first_dd"><a href="../page/password-change.jsp">火车/高铁</a></dd>
        </dl>
    </div>
    <!-- 右边栏-->
    <div class="rightsidebar_box rt" >
        <div class="order_empty">
         <div id="cover" class="rt">
      <%-- <form name="form1" id="fm-changep" method="post" action="BUSQ">
            <div class="txt">
                <p>车票查询 </p>
                <input name="user.uname" id="uname" type="hidden" 
                value="<%=((User)session.getAttribute("user")).getUname() %>" />
                <div class="text">
                    <input  placeholder="出发城市" type="text" name="start" id="textfield" required>
                    <!-- <div id="accountCheck"></div> -->
                </div>
                <div class="text">
                    <input placeholder="到达城市" type="text" name="stop" id="textfield2" required>
                </div>
				<!-- <div class="text">
                    <input type="password" placeholder="请确认新密码" name="cpwd" id="cpwd" required minlength="6" maxlength="15">
                    <div id="pwdValidate"></div>
                </div> -->
                <div class="text">
	                <input class="button_login" type="submit" value="提交" id="bt-changep" />
	                <div id="changeFail"></div>
                </div>
            </div>
        </form> --%>
        <% 
       ArrayList<Bus> buss = (ArrayList<Bus>)request.getAttribute("buss"); 
      /* ArrayList<Mess> messages = (ArrayList<Mess>)request.getAttribute("messages"); */
           out.print("<table border=2>");
           out.print("<tr>");
           out.println("<th>车次班号</th>");
           out.println("<th>出发城市</th>");
           out.println("<th>到达城市</th>");
           out.println("<th>出发时间</th>");
           out.println("<th>到达时间</th>");
           out.println("<th>座位数</th>");
           out.println("<th>票价</th>");
           out.print("</tr>");
           for(int i=0 ;i<buss.size();i++){
	           Bus b=buss.get(i); 
	           out.print("<tr>");
	           out.println("<th>"+b.getBus_id()+"</th>");
	           out.println("<th>"+b.getStart()+"</th>");
	           out.println("<th>"+b.getStop()+"</th>");
	           out.println("<th>"+b.getStart_time()+"</th>");
	           out.println("<th>"+b.getStop_time()+"</th>");
	           out.println("<th>"+b.getPrice()+"</th>");
	           out.println("<th>"+b.getSeat()+"</th>");
	           out.print("</tr>");
         }  
	      out.print("<table>");
    %>
        </div>
        </div>
    </div>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/jquery.page.js"></script>
<script src="../js/order.js"></script>
</html>