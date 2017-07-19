<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="icon" href="images/zh.png" type="image/x-icon" />
<title>注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.md5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/registerrex.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/trim.js"></script>
<script  type="text/javascript" >
			function rexusername(){
				$.ajax({
					type:"post",   //请求类型
					dateType:"text",  //返回类型
					url:"RexUsername",  //请求路径
					data:"username="+trim($("#reg_username").val()),
					success:function(data){
						if("用户名已存在"==data){
							$("#mes").html(data);
						}else{
							$("#mes").html(data);
						}
					}
				});
			}
			
			
			//校验验证码的AJAX
			function rexyzm(){
				$.ajax({
					type:"post",   //请求类型
					dateType:"text",  //返回类型
					url:"RexYzm",  //请求路径
					data:"code="+trim($("#verifycode").val()),
					success:function(data){
						if("验证码错误"==data){
							$("#mes1").html(data);
						}else{
							$("#mes1").html(data);
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
        <li ><a href="<%=request.getContextPath() %>/index.jsp">首页</a></li>
         <li class="active"><a href="javascript:void(0)">注册</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="<%=request.getContextPath() %>/images/zhang.jpg" alt="image" width="343" height="221" />
      <h2>welcome to <span>register</span>  </h2>
      <p >请您务必填写真实信息 </p>
      <div class="clr"></div>
      </div>
             </div>
             <br/><br/>
             <div class="register" >
             <form  onsubmit="return check()" action="UserRegister"  method="post">
             <span>用户名　:</span><input  type="text"   id="reg_username"  name="username"  onblur="rexusername()"/><span  id="mes" style="width: auto;"></span><br/>
             <span>密　　码:</span><input  id="password"  name="password"  type="password"  /><br/>
           	<span>确认密码:</span><input id="password1"  type="password" /><br/>
             <span>工作单位:</span><input  id="work"  name="work" type="text"/><br/>
             <span>邮　　箱:</span><input  id="email"  name="email"  type="text"/><br/>
             <span>我　　是:</span><select  id="identity"   name="identity">
             								<option value="1">感兴趣的人</option>
             								<option value="2">管理员</option>
             								<option value="3">教学人员</option>
             								<option value="4">研究人员</option>
             								</select><br/>
             	 <span>备　　注:</span><input  id="regdemo"  name="regdemo" type="text"/><br/>					
             	 <span>验证码　:</span><input  id="verifycode"  name="verifycode" type="text"  onblur="rexyzm()"/><span  id="mes1"></span><br/><br/>
             	 　<img  id="yzm"  src="<c:url  value='/VerifyCodeServlet'/>"  width="70"  height="35"><a  href="javascript:yzmhyz()">　　　换一张</a>
             	 <br/><br/>	
             	<input type="submit"  class="rebut" value="确定" /><input type="reset" class="rebut" value="重填" />
             	
             </form>
             
             </div>
             
      <div class="clr"></div>
    </div>
  </div>
  <br/><br/>
   <!-- 网页下面的部分 -->
  <div class="fbg"  style="margin-top: 170px;">
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
<!-- 网页最下面的部分结束 -->
</body>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>

</html>
