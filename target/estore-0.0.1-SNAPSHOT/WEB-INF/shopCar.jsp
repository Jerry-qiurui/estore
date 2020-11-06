<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
%>
<base href="<%=path%>">
<meta charset="utf-8">
<title>briup-电子商务-购物车</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/estore.js"></script>
</head>

<body>
	<a href="#top" alt="回到顶部" class="toTop">
		<button class="btn btn-top">
			<span class="glyphicon glyphicon-chevron-up"></span>
		</button>
	</a>
	<div class="top" id="top">
		<div class="herf">
			<span ><a href="toIndex">首页</a></span>
			<c:if test="${empty sessionScope.cus}">
				<span><a href="toLogin">登录</a></span>
				<span><a href="register">注册</a></span>
			</c:if>
			<c:if test="${!empty sessionScope.cus}">
				<span><a href="toOrder">我的订单</a></span>
				<span><a href="logout">退出</a></span>
			</c:if>
		</div>
	</div>

	<div class="head">
		<div class="row clearfix">
			<div class="col-md-6 column">
				<img src="images/logo.png" class="logo">
			</div>
			<div class="col-md-6 column">
				<img src="images/play_01.png" alt="">
			</div>
		</div>
	</div>
	<div class="nav">
		<div class="col-md-2 column  type">
			<span class="glyphicon glyphicon-briefcase"></span>&nbsp;&nbsp;&nbsp;我的书包
		</div>

		<div class="col-md-10 column marquee">
			<marquee scrollamount="3">
				<span class="glyphicon glyphicon-bullhorn">
					系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span>
			</marquee>
		</div>
	</div>
	<div class="body">
		<div class="table-shopCar">
			<div class="table_head row ">
				<span class="col-md-4 column">商品</span> <span
					class="col-md-2 column">单价(元)</span> <span class="col-md-3 column">数量</span>
				<span class="col-md-2 column">小计(元)</span> <span
					class="col-md-1 column">操作</span>
			</div>

			<div class="table_body ">
				<c:forEach items="${shopCar }" var="car">
					<div class="row">
						<div class="col-md-4 column">
							<img class="col-md-4 img-thumbnail"
								src="images/book_shopCart/${car.book.image }">
							<p class="col-md-8 bookname">${car.book.name }</p>
						</div>
						<div class="col-md-2 column book-price">${car.book.price }</div>
						<div class="col-md-3 column booknum">
							<button class="btn btn-primary btn-sm add">
								<span class="glyphicon glyphicon-plus"></span>
							</button>
							<span class="btn value">${car.num }</span>
							<button class="btn btn-primary btn-sm sub">
								<span class="glyphicon glyphicon-minus"></span>
							</button>
						</div>
						<div class="col-md-2 column book-price-sum">${car.num * car.book.price }</div>
						<div class="col-md-1 column">
							<button class="btn btn-danger" onclick="delShopCar(${car.book.id},this)">
								<span class=" 	glyphicon glyphicon-trash"></span>
							</button>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="allButtom">
			<p class="caozuo">
				<a href="toConfirm">去结算</a>
			</p>
			<span>已选择<font id="book-num" style="color: #b11e22;">2</font>
				件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：¥<font
				id="price-num" style="color: #b11e22;"> 199.0 </font>元
			</span>
		</div>
	</div>

	<div class="footer">
		<div class="row clearfix icons">
			<div class="col-md-3 column">
				<img src="images/icons/icon_1_17.png"> 品目繁多 愉悦购物
			</div>
			<div class="col-md-3 column">
				<img src="images/icons/icon_1_20.png"> 正品保障 天天低价
			</div>
			<div class="col-md-3 column">
				<img src="images/icons/icon_1_23.png"> 极速物流 特色定制
			</div>
			<div class="col-md-3 column">
				<img src="images/icons/icon_1_25.png"> 优质服务 以客为尊
			</div>
		</div>
		<div class="links">
			<p>
				<span>关于我们</span>| <span>联系我们</span>| <span>加我我们</span>| <span>友情链接</span>
			</p>
			<p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司</p>
			<img src="images/police.png">
		</div>
	</div>
	</div>
</body>
<script>

    function init(){
    var rows= $('.table-shopCar .table_body .row');
    console.log(rows)
    rows.each(function(){
       var price= parseInt( $(this).children('.book-price').text());
       console.log(price)
       var num= parseInt( $(this).children('.booknum').children('.value').text());
       $(this).children('.book-price-sum').text(num*price)
       console.log(num)
    })
    var brs = $(".book-price-sum");
    var vls = $('.value');

    var sum = 0;
    var booknum = 0;
    brs.each(function () {
        sum += parseInt($(this).text());
    });
    vls.each(function () {
        booknum += parseInt($(this).text());
    })
    $("#price-num").text(sum);
    $("#book-num").text(booknum);
}   
 init();
    //购物车数量加载
    $(".add").click(function () {
        var p = $(this).parents(".row");
        var value = p.children(".booknum").children(".value");
        if (parseInt(value.text()) < 10) {
            value.text(parseInt(value.text()) + 1);
        }
        init()
    });
    $(".sub").click(function () {
        var p = $(this).parents(".row");
        var value = p.children(".booknum").children(".value");
        if (parseInt(value.text()) > 1) {
            value.text(parseInt(value.text()) - 1);
        } 
        init()
    });
   function delShopCar(id,btn){
    if(confirm("确定删除?")){
 　　//点击确定后操作
	   	 $.ajax({
	         type:"get",
	         url:"deleteShopCar?id=" + id,
	         success:function(){
	        	$(btn).parents(".row").remove();
	        	init();
	         }

	       })
		}
   }   

</script>

</html>