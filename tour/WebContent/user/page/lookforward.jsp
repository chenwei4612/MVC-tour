<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ page import="pojo.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <style>
        #forward{
            width: 1000px;
            height: 500px;
            margin:0px auto;
            padding-top: 30px;
            text-align: center;
            vertical-align: middle;
            /*background: #f00;*/
        }
        #forward img{
            position: relative;
            top: 40px;
        }
        #forward p {
            font-size: 20px;
            position: relative;
            top: 80px;
            font-weight: inherit;
            opacity: 0.3;
        }
    </style>
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img class="animated jello" src="../img/header/logo.png" alt="logo"/>
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

<!--敬请期待页面-->
<div id="forward">
    <img src="../img/lookforward/lookforward_img1.png" alt="" class="animated bounce"/>
    <p class="animated slideInDown">请关注寸金出行通微信公众号</p>
    <p class="animated slideInDown">服务暂未上线 敬请期待!!</p>
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
</body>
</html>