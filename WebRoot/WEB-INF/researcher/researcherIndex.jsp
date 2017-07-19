<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页——研究人员</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

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
        <li ><a href="javascript:void(0)">尊敬的研究人员：${sessionScope.user.uname}，欢迎您再次登录</a></li>
         <li><a href="javascript:void(0)">您上次登录的时间是：${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">注销登录</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="<%=request.getContextPath() %>/images/yjy.JPG" alt="image" width="256" height="221" />
      <h2>More <span>Valuable</span> information</h2>
      <p>研究人员是本系统中特别重要的一部分，承担着对药物信息的发布，非常感谢您的分享！ </p>
      <div class="clr"></div>
      </div>
      
      
    </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article"  style="cursor: pointer; ">
            <h2><span>NEW </span> INFOS</h2>
           <c:forEach  items="${sessionScope.indexPlants}"  var="plants">
           	<div  style="float: left;margin: 5 30;margin-bottom: 30px;">
 				<ul style="list-style:none;padding-bottom: 30px;">
        	<li style="color:#6E6E6E;text-align: center;" onclick="javascript:alert('请点击图片查看植物详细信息!');">植物名称：${plants.zwword}</li>
        	<li style="color:#6E6E6E;text-align: center;"onclick="javascript:alert('请点击图片查看植物详细信息!');">英文名称：${plants.ywword}</li>
        	<li ><a  href="GetPlant?pid=${plants.pid}"><img style="width:225px;height: 220px;box-shadow: 5px 15px 15px #668B8B;"  src="<%=request.getContextPath() %>${plants.picpath}" alt="${plants.picpath}" /></a></li>
        	</ul>
        	</div>
           </c:forEach>
        </div>
        
        
      </div>
      <div class="sidebar">
      
      <!--/search -->
        <div class="gadget">
          <h2>Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
          			<!-- 各个功能处理请求的Servlet -->
            <li>	<a href="AllPlants?pc=1">查看所有植物</a>                                                                      </li>
            <li>	<a href="PageSkip?page=researcher/uploadNewPlant.jsp">
            		上传新的植物</a>        																						       </li>
            <li>	<a href="PageSkip?page=tujian/imagehelp.jsp">上传图求鉴定</a>                              </li>
            <li>	<a href="AllQuestion?pc=1">依图帮助鉴定</a></li>
            		<!--我的问题分为已经解决和未解决  -->
           <li>	<a href="PageSkip?page=all/findmyquestions.jsp">查看我的问题</a>                          </li>
            <li>	<a href="FindMyCollections?cuid=${sessionScope.user.uid}&pc=1">
           						 查看我的收藏</a>																							</li>
           <li>	<a href="PageSkip?page=all/findwithlike.jsp">模糊查找植物</a>                                    </li>
            
          </ul>
        </div>
        <div class="gadget">
           <h2><span>MORE</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="javascript:void(0)"  >更多的发现</a><br />
              野外 &amp; 种植地一直都在探索！</li>
            <li><a href="javascript:void(0)"  >更多的人群</a><br />
              无论你是学习还是研究，无论你是看一看还是想治疗疾病，大家都在这里！</li>
            <li><a href="javascript:void(0)" >更多的分享</a><br />
            每一天都会有新的植物进入我们的数据库！
              </li>
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
