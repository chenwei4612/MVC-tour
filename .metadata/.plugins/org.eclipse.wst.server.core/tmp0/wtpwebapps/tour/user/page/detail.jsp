<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="pojo.Tour"%>
<%@ page import="pojo.User" %>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>旅游推荐详情页</title>
<link href="../css/header.css" rel="stylesheet" />
<link href="../css/pro.details.css" rel="stylesheet" />
<link href="../css/animate.css" rel="stylesheet" />
<link href="../css/footer.css" rel="stylesheet" />
</head>
<body>
	<!-- 页面顶部-->
	<header id="top">
		<div id="logo" class="lf">
			<img class="animated jello" src="../img/header/logo.png" alt="logo" />
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
				<li><a href="AllTourServlet">首页</a><b>|</b>
				</li>
				<li><a href="../page/password-change.jsp">设置</a><b>|</b>
				</li>
				<li><a href="MessageServlet">留言版</a><b>|</b></li>
				<li><a href="userLogOutServlet">退出</a><b>|</b>
				</li>
				<li><a href="../page/lookforward.jsp">帮助</a>
				</li>
			</ul>
		</div>
	</header>
	<!-- nav主导航-->
	<div>&nbsp;</div>
	<!-- 内容-->
	<%
		Tour tour = (Tour) request.getAttribute("tour");
		/* out.print(game); */
	%>
	<!--细节导航-->
	<div id="nav_detail">
		<h5><%=tour.getTitle()%></h5>
	</div>
	<!--产品预览-->
	<div id="shop_detail">
		<!-- 左侧-->
		<div id="preview" class="lf">
			<div id="mediumDiv">
				<img id="mImg"
					src="../img/goods/<%=tour.getIsbn()%>/detail1big.jpg" />
			</div>
			<div id="icon_all">
				<ul id="icon_list">
					<li class="i1"><img
						src="../img/goods/<%=tour.getIsbn()%>/detail1.jpg" />
					</li>
					<li class="i1"><img
						src="../img/goods/<%=tour.getIsbn()%>/detail2.jpg"
						onerror="this.style.display='none'" />
					</li>
					<li class="i1"><img
						src="../img/goods/<%=tour.getIsbn()%>/detail3.jpg"
						onerror="this.style.display='none'" />
					</li>
					<li class="i1"><img
						src="../img/goods/<%=tour.getIsbn()%>/detail4.jpg"
						onerror="this.style.display='none'" />
					</li>
					<li class="li"><img
						src="../img/goods/<%=tour.getIsbn()%>/detail5.jpg"
						onerror="this.style.display='none'" />
					</li>
				</ul>
			</div>
		</div>
		<!-- 右侧-->
		<div class="right_detail lf">
			<!-- 景点名称-->
			<h1><%=tour.getTitle()%></h1>
			<!-- 景点/特色 -->
			<h2>景点/特色：</h2>
			<h3><%=tour.getChara()%></h3>
			<!-- 位置 -->
			<p class="style" id="choose_color">
				<s class="color">位置：</s> <span><%=tour.getLocation()%></span>
			</p>
			<!-- 简介 -->
			<p>
				<s>简介：</s> <span><%=tour.getTxt()%></span>
			</p>
		</div>
	</div>
	<!--为你推荐-->
	<div id="recommended">
		<p>为你推荐</p>
		<div id="demo" style="width: 1000px; overflow: hidden;">
			<div id="indemo" style="float: left; width: 200%;">
				<div id="demo1" style="float: left">
					<!-- 第一个宽度显示 -->
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="DetailTourServlet?isbn=001"><img
								src="../img/recommend/recommend_img1.jpg" border="0"> </a>
						</div>
						<p>东海岛</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="DetailTourServlet?isbn=002"><img
								src="../img/recommend/recommend_img2.jpg" border="0"> </a>
						</div>
						<p>湖光岩</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="DetailTourServlet?isbn=003"><img
								src="../img/recommend/recommend_img3.jpg" border="0"> </a>
						</div>
						<p>金沙湾</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="DetailTourServlet?isbn=004"><img
								src="../img/recommend/recommend_img4.jpg" border="0"> </a>
						</div>
						<p>孔子文化城</p>
					</div>
					<div class="detail_1 lf">
						<div class="detail_img1">
							<a href="DetailTourServlet?isbn=005"><img
								src="../img/recommend/recommend_img5.jpg" border="0"> </a>
						</div>
						<p>硇洲岛</p>
					</div>
					<!--</div>-->
				</div>
				<div id="demo2" style="float: left"></div>
			</div>
			<!-- 宽度超大 -->
		</div>
		<!-- 外面大框 -->
	</div>
	<!--商品详情-->
	<div id="iteminfo">
		<div id="tab">
			<div class="tab lf">
				<div class="cat">
					<span class="active"><a href="">景点详情</a> </span>
				</div>
			</div>
			<div class="cart rt">
			<a href="Bus.jsp">
				<img src="../img/product_detail/product_detail_img9.png" alt="" />
			</a>
			</div>
		</div>
		<div class="left lf">
			<div class="all">
				<div id="parm">
					<div id="specification_parameter">
						<p>
							景点简介 <img src="../img/product_detail/product_detail_icon_1.png"alt="" class="ys5" />
						</p>
					</div>
					<ul>
						<li><a href="#">景点编号：<%=tour.getIsbn()%></a></li>
						<li><a href="#">景点名称：<%=tour.getTitle()%></a></li>
						<li><a href="#">景点位置：<%=tour.getLocation()%></a></li>
						<li><a href="#">景点特色：<%=tour.getChara()%></a></li>
						<li><a href="#">景点简介：<%=tour.getTxt()%></a></li>
					</ul>
				</div>
				<div id="product_introduction">
					<p>
						景点介绍 <img src="../img/product_detail/product_detail_icon_4.png"
							alt="" class="ys5" />
					</p>
					<img src="../img/goods/<%=tour.getIsbn()%>/intro.jpg" alt="" />
				</div>
			</div>
		</div>
		<div class="right rt">
			<div class="aside_nav">
				<p>
					<i><img src="../img/product_detail/product_detail_icon_g_1.png"
						alt="" /> </i><a href="#specification_parameter">景点简介</a>
				</p>
				<p>
					<i><img src="../img/product_detail/product_detail_icon_t_1.png"
						alt="" /> </i><a href="#product_introduction">景点详情</a>
				</p>
				<p>
					<i><img
						src="../img/product_detail/product_detail_icon_up_1.png" alt="" />
					</i><a href="#">回到顶部</a>
				</p>
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
	<script src="../js/jquery-3.1.1.min.js"></script>
	<script src="../js/index.js"></script>
	<!--图片轮播悬停进入详情页效果-->
	<script>
    var speed = 20;
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;
    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }
    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function () {
        clearInterval(MyMar)
    };
    tab.onmouseout = function () {
        MyMar = setInterval(Marquee, speed)
    };

    $(function () {
        var nav = $("#tab"); //得到导航对象
        var aside = $(".aside_nav");//右侧导航
        var win = $(window); //得到窗口对象
        var sc = $(document);//得到document文档对象。
        win.scroll(function () {
            if (sc.scrollTop() >= 1000) {
                nav.addClass("fixed_tab");
                aside.addClass("fixed_aside");
            }
            else {
                nav.removeClass("fixed_tab");
                aside.removeClass("fixed_aside");
            }
        })

        win.scroll(function () {
            if (sc.scrollTop() >= 60 && sc.scrollTop() < 1000){
                $("#top").addClass("fixed_nav");
            }
            else {
                $("#top").removeClass("fixed_nav");
            }
        })
        //介绍区域右侧导航
        $("#iteminfo .right p").click(function () {
            $(this).css("background-color", "#0AA1ED").siblings().css("background-color", "#e8e8e8");
            $(this).find("a").css("color", "#fff").parent().siblings().find("a").css("color", "#828282")
        })
        /**选择商品进行添加 悬停效果**/
        $(".avenge").mouseover(function () {
            $(this).css({"border": "1px solid #0AA1ED", "color": "#0AA1ED"});
        }).mouseout(function () {
            $(this).css({"border": "1px solid #666", "color": "#666"})
        })

        /**添加到收藏**/
        $("#collect").click(function (){
           	console.log("collect");
           	$.ajax({
                type: "post",
                url: 'cancelCollect.htm',
                data: "userId=12345678901&product=9787115435101",//params,
                success: function (data) {
                    if (data == 'yes') {
                    	alert("操作完成！");
                    	window.location.href = "../page/detail.html?isbn=9787115435101";
                    } else {
                        alert("操作失败！");
                    }
                },
                error: function (data) {
                    alert("系统异常！");
                }
            });
        });
        /**数量添加**/
        var n = $("#buy-num").val() * 1;
        $(".numberMinus").click(function () {
            if (n >= 1) {
                $("#buy-num").val(n -= 1);
            }
        })
        $(".numberAdd").click(function () {
            $("#buy-num").val(n += 1);
        })

        /**ajax提交**/
        //数量选择
        $(".accountChose").click(function () {
            var buyAccount = $("#buy-num").val();
            console.log(buyAccount);
        })

        /*立即购买*/
        $("#buy_now").click(function (e) {
            var num = $("#buy-num").val();
            // 后台需要的参数
            var url = "../page/order-confirm.html?product=9787115435101&count="+num;
            window.location.href = url;
        })
    });

		// 图片效果
		$("#mImg").hover(function() {
			$(this).addClass("animated pulse");
		}, function() {
			$(this).removeClass("animated pulse");
		});

		$('#icon_list>li').click(function() {
			$(this).children('img').css('border', '1px solid #CECFCE');
			var address = $(this).children().attr('src');
			console.log(address);
			var newaddress = address.slice(0, -4);
			var bigaddress = newaddress + 'big.jpg';
			$('#mImg').attr('src', bigaddress);
			$(this).siblings().children('img').css('border', '');
		})
	</script>
</body>
</html>
