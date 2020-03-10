<%@ page contentType="text/html; charset=utf-8" language="java"  errorPage="" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="pojo.Tour"%>
<%@ page import="pojo.User"%>
<%@ page import="pojo.Mess"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>旅游留言</title>
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/footer.css" rel="stylesheet" />
<style type="text/css">
.ck-slide {
	text-align: center;
}
</style>
</head>
<body>
	<!-- 页面顶部-->
	<header id="top">
		<div id="logo" class="lf">
			<img src="../img/header/logo.png" alt="logo" />
		</div>
		<div id="top_input" class="lf">
			<input id="input" type="text" placeholder="请输入您要搜索的内容" /> <a
				href="../page/search.html?title=Java" class="rt"><img
				id="search" src="../img/header/search.png" alt="搜索" /> </a>
		</div>
 		<%User user = (User)request.getSession().getAttribute("user"); %>
		<span>欢迎:[<%=user.getUname() %>]登录</span> 
		<div class="rt">
			<ul class="lf">
				<li><a href="AllTourServlet">首页</a><b>|</b></li>
				<li><a href="../page/password-change.jsp">设置</a><b>|</b></li>
				<li><a href="MessageServlet">留言版</a><b>|</b></li>
				<li><a href="userLogOutServlet">退出</a><b>|</b></li>
				<li><a href="../page/lookforward.jsp">帮助</a></li>
			</ul>
		</div>
	</header>
	<!-- nav主导航-->
	<div>&nbsp;</div>
	<!-- banner部分-->
<div class="ck-slide">
		<form id="form1" name="form1" method="post" action="NewMessage">
			<p>
				<input type="text" name="name" id="name" readonly="readonly" value="<%=user.getUname() %>" />
				<%
		          Date d = new Date();
		          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		          String now = df.format(d);
	            %>
			    <input type="text" name="time" id="time" readonly="readonly" value="<%=now %>" />
				
			<h2 for="textarea">Message:<br /></h2>
			    <textarea name="message" id="message" cols="45" rows="3"></textarea>
			<input type="submit" name="button" id="button" value="提交" />
			
			</p>
		</form>
			<textarea name="mess" id="mess" cols="150" rows="25" readonly="readonly">
			<%
			ArrayList<Mess> messages = (ArrayList<Mess>)request.getAttribute("messages");
			for(int i=0 ;i<messages.size();i++){
				Mess mess=messages.get(i);
				out.append("\n");
				out.append("Name: "+mess.getUname()+" ");
				out.append("Time: "+mess.getTime()+" ");
				out.append("Message: "+mess.getMessage()+"\n");
			}
			%>
			</textarea>
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
</html>
 