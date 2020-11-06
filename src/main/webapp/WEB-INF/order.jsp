<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<% String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<base href="<%= path %>">
    <meta charset="utf-8">
    <title>briup-电子商务</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/estore.js"></script>
</head>

<body>
    <a href="#top" alt="回到顶部" class="toTop">
        <button class="btn btn-top"><span class="glyphicon glyphicon-chevron-up"></span></button>
    </a>
    <div class="top" id="top">
        <div class="herf">
            <span><a href="toIndex">首页</a></span>
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
            <div class="col-md-3 column">
                <img src="images/logo.png" class="logo">
            </div>
            <div class="col-md-6 column">
                <div class="input-group search">
                    <input type="text" class="form-control" placeholder="请输入你要检索的书名" style="padding: 20px">
                    <span class="input-group-btn">
                        <button class="btn btn-estore" type="button" onclick="searchbook()"><span
                                class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </div>
            <div class="col-md-3 column bag">
                <a href="shopCar.html">
                    <button class="btn btn-estore">
                        <span class="glyphicon glyphicon-briefcase"> </span>&nbsp;我的书包
                    </button>
                </a>
            </div>
        </div>
    </div>
    <div class="nav">
        <div class="col-md-2 column  type" data-toggle="collapse" href="#typeMenu">
            <span class="glyphicon glyphicon-tasks"></span>&nbsp;&nbsp;&nbsp;我的订单</div>

        <div class="col-md-10 column marquee">
            <marquee scrollamount="3"><span class="glyphicon glyphicon-bullhorn"> 系统公告：本系统今晚十点进行系统升级，带来不便敬请谅解！</span>
            </marquee>
        </div>
    </div>
    <div class="body">
        <div class="row orders">
            <ul class="order" id="#order">
                <li class="order-table-head">
                    <p>
                        编号
                    </p>
                    <p>
                        订单编号
                    </p>
                    <p>
                        订单时间
                    </p>
                    <p>
                        商品数量
                    </p>
                    <p>
                        订单金额
                    </p>
                    <p>操作</p>
                </li>
                <c:set var="seq" value="0" ></c:set>
                <c:forEach items="${orderMaps }" var="map">
                <li>
                    <p>
		                <c:set var="seq" value = "${seq+1 }" />
                        ${seq }
                    </p>
                    <p>
                        ${map.key.id }
                    </p>
                    <p>
                       	${map.key.orderDate }
                    </p>
                    <p>
                    	<c:set var="sum" value = "0"></c:set>
                        <c:forEach items="${map.value }" var="line">
                    	<c:set var="sum" value = "${sum + line.num }"></c:set>
                        </c:forEach>
                        ${sum }
                    </p>
                    <p>
                        ${map.key.total }
                    </p>
                    <p>
                        <a data-target="#ul${seq }" class="showBtn">
                            <button class="btn btn-primary btn-sm"><span
                                    class="glyphicon glyphicon-eye-open"></span></button></a>

                        <button class="btn btn-danger btn-sm" onclick="delOrder('${map.key.id }',this,'ul${seq }')"><span
                                class="glyphicon glyphicon-trash"></span></button>

                    </p>
                </li>
                <li class="orderLine" id="ul${seq }">
                    <ul>
                        <li class="bg-warning orderline-head">
                            <p>商品名称</p>
                            <p>数量</p>
                            <p>单价</p>
                            <p>小计</p>
                        </li>
                        <c:forEach items="${map.value }" var="line">
                        <li>
                            <p>${line.book.name }</p>
                            <p>${line.num }</p>
                            <p>${line.book.price }</p>
                            <p>${line.book.price * line.num }</p>
                        </li>
                        </c:forEach>
                    </ul>
                </li>
                </c:forEach>
                
            </ul>
        </div>
    </div>
    <div class="footer">
        <div class="row clearfix icons">
            <div class="col-md-3 column">
                <img src="images/icons/icon_1_17.png">
                品目繁多 愉悦购物
            </div>
            <div class="col-md-3 column">
                <img src="images/icons/icon_1_20.png">
                正品保障 天天低价
            </div>
            <div class="col-md-3 column">
                <img src="images/icons/icon_1_23.png">
                极速物流 特色定制
            </div>
            <div class="col-md-3 column">
                <img src="images/icons/icon_1_25.png">
                优质服务 以客为尊
            </div>
        </div>
        <div class="links">
            <p>
                <span>关于我们</span>|
                <span>联系我们</span>|
                <span>加我我们</span>|
                <span>友情链接</span>
            </p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司</p>
            <img src="images/police.png">
        </div>
    </div>
    </div>
</body>

</html>
<script type="text/javascript">
    $('.orderLine').css('display', 'none');

    $('.showBtn').click(function () {
        var orderlineGroup = $('.orderLine');

        var show = $(this).attr('data-target');
        for (var i = orderlineGroup.length - 1; i >= 0; i--) {
            if (orderlineGroup[i] != $(show)) {
                var dom = $(orderlineGroup[i])

                var style = dom.css('display', 'none');

            }
        }
        var display = $(show).css('display')
        console.log(display)
        if (display == 'none') {
            $(show).css('display', 'list-item');
            var display = $(show).css('display')
            console.log(display)
        } else {
            $(show).css('display', 'none');
        }

    })
/*     $('.btn-danger').click(function(){
        if(confirm("您确定要删除这个订单吗？")){
            console.log( $(this).parents('.orderLine'))
            $(this).parents('li').hide();
        }
       
    }) */
    
	function delOrder(id,btn,lid){
		if(confirm("确定删除？")){
			$.ajax({
				type:"get",
				url:"delOrder?id="+id,
				success:function(){
					$(btn).parents('li').remove();
					/*$("#'lid'").remove();  */
				}
			})
		}
	}
</script>