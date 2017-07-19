<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<link rel="icon" href="images/zh.png" type="image/x-icon" />

<title>网站首页</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.md5.js"></script>
<script type="text/javascript" src="js/trim.js"></script>
<script type="text/javascript" src="js/registerrex.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<script  type="text/javascript" >
			function login(){
				var username=trim($("#username").val());
				var password=trim($("#password").val());
				if(username==''){
					alert('请输入用户名');
					return false;
				}else if(password==''){
					alert('请输入密码');
					return false;
				}
				$.ajax({
					type:"post",   	//请求类型
					dateType:"text",  //返回类型
					url:"UserLogin",  //请求路径
					data:"username="+trim($("#username").val())+"&password="+$.md5(trim($("#password").val())),
					success: function(data){
						if("用户名与密码不匹配"==data ||"该用户正在审核中，请耐心等待"==data){
							$("#mes2").html(data);
						}else{
							window.location.href="LoginSuccess";
						}
					}
				});
			}
	</script>

<!-- CuFon ends -->
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
      <h1><a href="index.jsp">resources <span>of</span>  medicinal plants</a></h1>
        <div class="small">药用植物资源信息管理系统</div>
      </div>
      <div class="menu_nav">
       <ul>
        <li class="active"><a href="index.jsp">首页</a></li>
          <li><a href="register.jsp">注册</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/zhang.jpg" alt="image" width="343" height="221" />
      <h2>More <span>Valuable</span> Plant</h2>
      <p>秦岭是我国重要的野生中药资源宝库。仅陕西省秦岭地区有3210种天然药用植物，占全国药用植物的30%。 </p>
      <div class="clr"></div>
      </div>
 </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article" style="cursor: pointer; " onclick="javascript:alert('请您登录！登录后可查看详细信息！');">
          <h2><span>NEW </span> INFOS</h2>
           <c:forEach  items="${sessionScope.indexPlants}"  var="plants">
           	<div  style="float: left;margin: 5 30;margin-bottom: 30px;">
 				<ul style="list-style:none;padding-bottom: 30px;">
        	<li style="color:red;text-align: center;">植物名称：${plants.zwword}</li>
        	<li style="color:blue;text-align: center;">英文名称：${plants.ywword}</li>
        	
        	<li ><img style="width:225px;height: 220px;box-shadow: 5px 15px 15px #668B8B;" src="<%=request.getContextPath() %>${plants.picpath}" alt="${plants.picpath}" ></li>
        	</ul>
        	</div>
           </c:forEach>
        </div>
        
      </div>
      <div class="sidebar">
        <div class="gadget">
          <h2>Login</h2>
          <div class="clr"></div>
          <form  class="loginform">
          <ul class="sb_menu">
            <li>用户名：</li>
            <!-- 用户名输入框 -->
            <li><input type="text"   id="username" name="username"/></li>
            <li>密　码：</li>
            <!-- 密码输入框 -->
            <li><input type="password"   id="password"  name="password"/></li>
            <li><input type="button"  class="loginbut"  value="登录"   onclick="login()"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a href="register.jsp">注册新账号</a></span></li>
            <li><span  id="mes2"></span><br/></li>
          </ul>
          </form>
        </div>
        <div class="gadget">
          <h2><span>MORE</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="javascript:void(0)"  >更多的发现</a><br />
              野外 &amp; 种植地一直都在探索！</li>
            <li><a href="javascript:void(0)"  >更多的人群</a><br />
              无论你是学习还是研究，无论你是看一看还是想治疗疾病，大家都在这里！</li>
            <li><a href="javascript:void(0)"  >更多的帮助</a><br />
              需要帮助？！这里有更多的人比你更懂药材！</li>
            <li><a href="javascript:void(0)">还有更多！！</a><br />
              诚邀您的加入！告诉我你想要什么？！</li>
          </ul>
        </div>
             </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <!-- 网页下面的部分 -->
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Welcome</span></h2>
        <a href="javascript:void(0)"><img src="images/gallery_1.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_2.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_3.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_4.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_5.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_6.jpg" width="58" height="58" alt="pix" /></a> </div>
      <div class="col c2">
        <h2><span>About System</span></h2>
        <p>我们提供了以下的功能，让您使用本系统：<br />
          不同身份的人群不同的体验、图片的版权水印加密、各种的查询帮助您搜所信息、发布图片寻找懂植物的人、收藏植物需要时及时查看、填补那些我们没有的而您有的信息！
          </p>
      </div>
      <div class="col c3">
        <h2><span>Contact</span></h2>
        <p>我相信人类的生活永远都离不开珍贵的植物，我们需要你和我们一起把这件事做的更美好！我们诚邀您的加入！如果您有更加好的想法和创意，请您联系我们。<br/><a href="javascript:void(0)">zhanghuang_1994@163.com</a><br />
          <a href="javascript:void(0)">+86-183-2997-5053</a></p>
      </div>
      <div class="clr"></div>
    </div>
    <div class="footer">
      <p class="lr">&copy; Copyright <a href="javascript:void(0)">ZhangHuang</a>.</p>
      <p class="lf">张煌—<a href="javascript:void(0)" title="药用植物资源信息管理系统" target="_blank">药用植物资源信息管理系统</a></p>
      <div class="clr"></div>
    </div>
  </div>
</div>
<!-- 网页最下面的部分结束 -->
</body>
</html>
