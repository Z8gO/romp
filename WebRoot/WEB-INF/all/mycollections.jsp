<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>我的收藏</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery.min.js"></script>

<script type="text/javascript" src="<%=request.getContextPath() %>/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cuf_run.js"></script>


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
        <li ><a href="javascript:void(0)">尊敬的管理员：${sessionScope.user.uname}，感谢您的管理！</a></li>
         <li><a href="javascript:void(0)">您上次登录的时间是：${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">注销登录</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/zhang.jpg" alt="image" width="343" height="221"  />
      <h2>Manage <span>All</span> Collections</h2>
      <p>在这里由您的收藏，请您认真审核！ </p>
      <div class="clr"></div>
      </div> 
    </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize"  style="width: 990px;">
      <div class="mainbar">
        <div class="article"  style="width: 720px;">
          <h2><span>Manage</span> All Collections</h2>
          <div class="clr"></div>
          <p>收藏起来，随时查看！
          	
          </p>
       <!-- 放在article  这个div里面-->
       <table >
       <tr>
       		<th>植物名称</th>
       		<th  style="width: 230px;">收藏时间</th>
       		<th colspan="2">操作</th>
       </tr>
        <c:forEach  items="${sessionScope.collectionPageBean.list}"  var="collection">
        	<tr>
        	<th style="color: black;">${collection.pname}</th>
        	<th style="color: black;">${collection.cdate}</th>
        	<th>
        	<a href="GetPlant?pid=${collection.pid}"  style="text-align: center;text-decoration: none;color: red;text-align: center;margin-left: 20px;">详细信息</a>
        	</th><th>
        	<a href="DelMyCollection?cid=${collection.cid}"  style="text-align: center;text-decoration: none;color: red;text-align: center;margin-left: 60px;"  onclick="return  del();">删除</a>
        	</th>
        </tr>
        </c:forEach>
        </table>
         </div>
         <div class="page"  style="bottom: -70%;">
	
    	<a href="javascript:void(0)" > 共${sessionScope.collectionPageBean.tp}页</a>
        <a href="javascript:void(0)" > 当前是第${sessionScope.collectionPageBean.pc}页</a>  	
        <c:if test="${sessionScope.collectionPageBean.pc>1}">
        		<a href="AllPlants?pc=${sessionScope.collectionPageBean.pc-1}" > 上一页</a>
        </c:if>
		<c:if test="${sessionScope.collectionPageBean.pc<sessionScope.collectionPageBean.tp}">
        		<a href="AllPlants?pc=${sessionScope.collectionPageBean.pc+1}" > 下一页</a>
        </c:if>
        
       <c:choose>
 	<c:when test="${sessionScope.collectionPageBean.tp <= 6 }">
 		<c:set var="begin" value="1"/>
 		<c:set var="end" value="${sessionScope.collectionPageBean.tp}"/>
 	</c:when>
 	<c:otherwise>
 		<c:set var="begin" value="${sessionScope.collectionPageBean.pc-2 }"/>
 		<c:set var="end" value="${sessionScope.collectionPageBean.pc + 3}"/>
 		<c:if test="${begin < 1 }">
 		  <c:set var="begin" value="1"/>
 		  <c:set var="end" value="6"/>
 		</c:if>
 		<c:if test="${end > sessionScope.collectionPageBean.tp }">
 		  <c:set var="begin" value="${sessionScope.collectionPageBean.tp-5 }"/>
 		  <c:set var="end" value="${sessionScope.collectionPageBean.tp }"/>
 		</c:if> 		
 	</c:otherwise>
 </c:choose>
 
 <c:forEach begin="${begin }" end="${end }" var="i">
   <c:choose>
   	  <c:when test="${i eq sessionScope.collectionPageBean.pc }">
   	    <span ><a href="javascript:void(0)" >${i }</a></span>
   	  </c:when>
   	  <c:otherwise>
   	    <a href="AllPlants?pc=${i}" >${i }</a>
   	  </c:otherwise>
   </c:choose> 	
 </c:forEach>
 
 <c:if test="${end < sessionScope.collectionPageBean.tp }">
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
             <li><a href="AllPlants?pc=1">返回所有药用植物</a></li>
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
	
	function del() {
		return window.confirm("确定删除？");
	}

</script>
</html>
