$(function () {
    //订单列表折叠
  $(".carousel").carousel({
    interval: 3000,
  });
  $(".collapse").first().removeClass("on");
  $(".collapse").first().addClass("in");

  $(".body .menu ul li").click(function () {
    $(".collapse").removeClass("in");
    var text = $(this).attr("herf");
    $(text).addClass("in");
  });
  


  $(".viewbook .book-message #box dd").click(function () {
    $(".viewbook .book-message #box dd").removeClass("active");
    $(this).addClass("active");
  });
  $("#typeMenu").collapse("hide");
  $(".col-md-3").addClass("col-sm-3 col-xs-3");
  $(".col-md-6").addClass("col-sm-6 col-xs-6");
  $(".col-md-9").addClass("col-sm-9 col-xs-9");
  $(".col-md-2").addClass("col-sm-2 col-xs-2");
  $(".col-md-8").addClass("col-sm-8 col-xs-8");
  var twoDiv = $(".bigDiv").children();
  twoDiv.each(function () {
    $(this).css("border-bottom", "1px solid var(--color)");
  });
  twoDiv.last().css("border-bottom", "none");
});
function searchbook() {
  var name = $("#bookname").val();
  console.log($("#bookname").val());
//  window.location.href = "searchBook?bookname="+name;
  $("body").load("searchBook?bookname="+name)
//  window.location.href = ""; 
  //	$.ajax({
  //	type:"post",
  //	url:"SearchBook",
  //	data:{
  //	'bookname':$("#bookname").val()
  //	},
  //	success:function(data){
  //	alert('success')
  //	$("html").html(data);
  //	},
  //	error:function(){
  //	alert('error')
  //	}

  //	})
}
function AddShopCar(user, bookid) {
  console.log(user);
  if (user == "") {
    alert("请您先登录！");
  } else {
    $.ajax({
      type: "post",
      url: "addShopCar?bookid=" + bookid,
      success: function () {
        alert("添加购物车成功！");
      },
      error: function () {
        alert("添加购物车失败！");
      },
    });
  }
}

function checkLogin() {
  console.log("this is  check login");
  var username = $("#username").val();
  var password = $("#password").val();
  if (username == "") {
    alert("用户名不能为空！");
    return false;
  }
  if (password == "") {
    alert("密码不能为空！");
    return false;
  }
  return true;
}
function checkReg() {
  if ($("#reg-name").val() == "") {
    alert("用户名不能为空");
    return false;
  }
  if ($("#reg-pwd").val() == "") {
    alert("密码不能为空");
    return false;
  }
  if ($("#reg-zip").val() == "") {
    alert("邮编不能为空");
    return false;
  }
  if ($("#reg-address").val() == "") {
    alert("地址不能为空");
    return false;
  }
  if ($("#reg-tel").val() == "") {
    alert("电话不能为空");
    return false;
  }
  if ($("#reg-emial").val() == "") {
    alert("邮箱不能为空");
    return false;
  }
  if (!$("#tip-box").is(":checked")) {
    alert("请先同意隐私协议");
    return false;
  }

  return checkPwd();
}
function checkPwd() {
  console.log($("#reg-pwd").val());
  if ($("#reg-pwd").val() != $("#reg-againpwd").val()) {
    $("#tip").text("两次密码输入不一致");
    $("#tip").show();
    return false;
  } else {
    $("#tip").hide();
    return true;
  }
}

