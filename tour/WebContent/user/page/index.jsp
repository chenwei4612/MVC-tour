<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Tour" %>
<%@ page import="pojo.User" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>旅游推荐首页</title>
    <link href="../css/item.food.css" rel="stylesheet" />
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/slide.css" rel="stylesheet" />
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img src="../img/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

        <a href="../page/search.html?title=Java" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
    </div>
    <%User user = (User)request.getSession().getAttribute("user"); %>
    <span>欢迎:[<%=user.getUname() %>]登录</span>
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
<!-- nav主导航-->
<div>&nbsp;</div>
<!-- banner部分-->
<div class="ck-slide">
    <ul class="ck-slide-wrapper">
        <li>
            <a href="DetailTourServlet?isbn=001"><img src="../img/banner/banner1.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="DetailTourServlet?isbn=002"><img src="../img/banner/banner2.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="DetailTourServlet?isbn=003"><img src="../img/banner/banner3.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="DetailTourServlet?isbn=004"><img src="../img/banner/banner4.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="DetailTourServlet?isbn=005"><img src="../img/banner/banner5.png" alt=""></a>
        </li>
         <li style="display:none">
            <a href="DetailTourServlet?isbn=006"><img src="../img/banner/banner6.png" alt=""></a>
        </li> 
    </ul>
    <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> 
    <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
    <div class="ck-slidebox">
        <div class="slideWrap">
            <ul class="dot-wrap">
                <li class="current"><em>1</em></li>
                <li><em>2</em></li>
                <li><em>3</em></li>
                <li><em>4</em></li>
                <li><em>5</em></li>
                <li><em>6</em></li>
            </ul>
        </div>
    </div>
</div>
<!-- 特推部分-->
<!--商品-->
<div class="store">
    <div class="store_top">
        <img src="../img/banner/icon.png" alt=""/>
        热搜排行
    </div>
    <%
    ArrayList<Tour> tours = (ArrayList<Tour>)request.getAttribute("tours");
    /* System.out.println(tours.size()); */
    for(int i=0;i<tours.size();i++){
    	Tour tour = tours.get(i);
      if (i % 4 == 0) {
    %>
    	<div class="store_content">
      <%
      }
      %>
<div>
  <a href="DetailTourServlet?isbn=<%=tour.getIsbn()%>">
  <img src="../img/goods/<%=tour.getIsbn() %>/index.jpg" alt=""/></a>
  <p class="one"><%=tour.getTitle() %></p>
  <p class="three">
    <span>
    位置：<span><%=tour.getLocation() %></span>
    </span>
  </p>
</div>
		<%
		if (i % 4 == 3) {
		%>
		</div>
		<%	
		}
		%>	
	<%
	}
	%>
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
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/slide.js"></script>
<script>
    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒
    });
</script>
</body>
</html>
 