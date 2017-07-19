<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>依图帮助</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/trim.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cuf_run.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/imageRex.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadRex.js"></script>

<!-- CuFon ends -->
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
      <h1><a href="LoginSuccess">resources <span>of</span>  medicinal plants</a></h1>
        <div class="small">药用植物资源信息管理系统</div>
      </div>

      <div class="menu_nav">
       <ul>
        <li ><a href="javascript:void(0)">尊敬的：${sessionScope.user.uname}，感谢您的答疑！</a></li>
         <li><a href="javascript:void(0)">您上次登录的时间是：${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">注销登录</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/ytjd.jpg" alt="image" width="336" height="221" />
      <h2>More <span>Valuable</span> Answer</h2>
      <p>看看下面有您认识的药物？快来帮助大家吧！ </p>
      <div class="clr"></div>
      </div> 
    </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize"  style="width: 990px;">
      <div class="mainbar">
        <div class="article"  style="width: 720px;">
          <h2><span>Find</span> You Know</h2>
          <div class="clr"></div>
          <p>更多疑问，更多收获！</p>
       <!-- 放在article  这个div里面-->
        <c:forEach  items="${sessionScope.pageBean.list}"  var="question">
        	<div  style="float: left;margin-left: 10px;margin-bottom: 10px;">
 				<ul style="list-style:none;padding-bottom: 30px;">
        	<li ><img style="width:205px;height: 200px;box-shadow: 5px 15px 15px #000;" src="<%=request.getContextPath() %>${question.imgpath}" alt="${question.imgpath}" ></li>
        	<li>　</li>
        	<!--当时管理员时才显示此部分 -->
        	<c:if  test="${4==user.iid}">
        	<li><a href="GetQuestion?imgid=${question.imgid}" 
        	 style="text-align: center;
        	 text-decoration: none;color: red;">我认识它，我来补充!</a></li>
        	</c:if>
        </ul>
        </div>
        </c:forEach>
         </div>
         <div class="page"  style="bottom: -75%;">
	
    	<a href="javascript:void(0)" > 共${sessionScope.pageBean.tp}页</a>
        <a href="javascript:void(0)" > 当前是第${sessionScope.pageBean.pc}页</a>  	
        <c:if test="${sessionScope.pageBean.pc>1}">
        <!-- NotPassQue?pc=1&uid=${sessionScope.user.uid} -->
        		<a href="AllQuestion?pc=${sessionScope.pageBean.pc-1}" > 上一页</a>
        </c:if>
		<c:if test="${sessionScope.pageBean.pc<sessionScope.pageBean.tp}">
        		<a href="AllQuestion?pc=${sessionScope.pageBean.pc+1}" > 下一页</a>
        </c:if>
        
       <c:choose>
 	<c:when test="${sessionScope.pageBean.tp <= 6 }">
 		<c:set var="begin" value="1"/>
 		<c:set var="end" value="${sessionScope.pageBean.tp}"/>
 	</c:when>
 	<c:otherwise>
 		<c:set var="begin" value="${sessionScope.pageBean.pc-2 }"/>
 		<c:set var="end" value="${sessionScope.pageBean.pc + 3}"/>
 		<c:if test="${begin < 1 }">
 		  <c:set var="begin" value="1"/>
 		  <c:set var="end" value="6"/>
 		</c:if>
 		<c:if test="${end > sessionScope.pageBean.tp }">
 		  <c:set var="begin" value="${sessionScope.pageBean.tp-5 }"/>
 		  <c:set var="end" value="${sessionScope.pageBean.tp }"/>
 		</c:if> 		
 	</c:otherwise>
 </c:choose>
 
 <c:forEach begin="${begin }" end="${end }" var="i">
   <c:choose>
   	  <c:when test="${i eq sessionScope.pageBean.pc }">
   	    <span ><a href="javascript:void(0)" >${i }</a></span>
   	  </c:when>
   	  <c:otherwise>
   	    <a href="AllQuestion?pc=${i}" >${i }</a>
   	  </c:otherwise>
   </c:choose> 	
 </c:forEach>
 
 <c:if test="${end < sessionScope.pageBean.tp }">
      <span ><a href="javascript:void(0)" >...</a></span>
    </c:if> 
 
 
      </div>
      </div>
  
      
      <!--左边-->
      <div class="sidebar">
        <div class="gadget">
          <h2>Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li><a href="javascript:void(0)">未解决的问题</a></li>
            <li><a href="LoginSuccess">返回我的首页</a></li>
          </ul>
        </div>
        <div class="gadget">
           <h2><span>MORE</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="javascript:void(0)" >更多的植物</a><br />
             超过1000+的植物存储于数据库！</li>
            <li><a href="javascript:void(0)"  >更多的发现</a><br />
              野外 &amp; 种植地一直都在探索！</li>
            <li><a href="javascript:void(0)"  >更多的人群</a><br />
              无论你是学习还是研究，无论你是看一看还是想治疗疾病，大家都在这里！</li>
            <li><a href="javascript:void(0)"  >更多的帮助</a><br />
              需要帮助？！这里有更多的人比你更懂药材！</li>
            <li><a href="javascript:void(0)" >更多的分享</a><br />
            每一天都会有新的植物进入我们的数据库！
              </li>
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
<script type="text/javascript">
	function confirmoper() {
		return window.confirm("确定退出？");
	}
</script>
</html>
