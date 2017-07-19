<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理冻结账户</title>
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
       	 	<li><a href="javascript:void(0)">尊敬的管理员，${sessionScope.user.uname}，感谢您的管理</a></li>
           <li><a href="javascript:void(0)">您上次登录的时间是：${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">注销登录</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/gly.jpg" alt="image" width="233" height="221" />
      <h2>Effective  <span>Project </span> Management</h2>
      <p>因为有了管理员辛勤的管理才有了系统正常的运作，感谢您的辛勤付出！</p>
      <div class="clr"></div>
      </div>
    </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize"  style="width: 990px;">
      <div class="mainbar">
        <div class="article"  style="width: 720px;">
          <h2><span>Manager</span> Blocked User</h2>
          <div class="clr"></div>
          <p>激活某个账号后，请在管理正常状态账号页面查看！</p>
       <!-- 放在article  这个div里面-->
       <table  id="usertable">
       <tr><th>用户名</th>
       <th>工作单位</th>
       <th>邮箱</th>
       <th>角色</th>
       <th>操作</th>
       </tr>
        <c:forEach  items="${sessionScope.blockedUserPageBean.list}"  var="users">
        	
 			<tr>
				<td>${users.uname}</td>
				<td>${users.workunit}</td>
				<td>${users.email}</td>
				<td>
						<c:if test="${users.iid==1}">
								感兴趣
						</c:if>
						<c:if test="${users.iid==2}">
								管理员
						</c:if>
						<c:if test="${users.iid==3}">
								教员
						</c:if>
						<c:if test="${users.iid==4}">
								研究员
						</c:if>
				</td>
				<td>
						<a  href="UpdateUserStatus?uid=${users.uid}"  onclick="return  active();">激活账号</a>				
				</td>
 				</tr>
    
        </c:forEach>
         </table>
         </div>
         <div class="page"  style="bottom: -80%;">
	
    	<a href="javascript:void(0)" > 共${sessionScope.blockedUserPageBean.tp}页</a>
        <a href="javascript:void(0)" > 当前是第${sessionScope.blockedUserPageBean.pc}页</a>  	
        <c:if test="${sessionScope.blockedUserPageBean.pc>1}">
        		<a href="FindSuccessUser?pc=${sessionScope.blockedUserPageBean.pc-1}" > 上一页</a>
        </c:if>
		<c:if test="${sessionScope.blockedUserPageBean.pc<sessionScope.blockedUserPageBean.tp}">
        		<a href="FindSuccessUser?pc=${sessionScope.blockedUserPageBean.pc+1}" > 下一页</a>
        </c:if>
        
       <c:choose>
 	<c:when test="${sessionScope.blockedUserPageBean.tp <= 6 }">
 		<c:set var="begin" value="1"/>
 		<c:set var="end" value="${sessionScope.blockedUserPageBean.tp}"/>
 	</c:when>
 	<c:otherwise>
 		<c:set var="begin" value="${sessionScope.blockedUserPageBean.pc-2 }"/>
 		<c:set var="end" value="${sessionScope.blockedUserPageBean.pc + 3}"/>
 		<c:if test="${begin < 1 }">
 		  <c:set var="begin" value="1"/>
 		  <c:set var="end" value="6"/>
 		</c:if>
 		<c:if test="${end > sessionScope.blockedUserPageBean.tp }">
 		  <c:set var="begin" value="${sessionScope.blockedUserPageBean.tp-5 }"/>
 		  <c:set var="end" value="${sessionScope.blockedUserPageBean.tp }"/>
 		</c:if> 		
 	</c:otherwise>
 </c:choose>
 
 <c:forEach begin="${begin }" end="${end }" var="i">
   <c:choose>
   	  <c:when test="${i eq sessionScope.blockedUserPageBean.pc }">
   	    <span ><a href="javascript:void(0)" >${i }</a></span>
   	  </c:when>
   	  <c:otherwise>
   	    <a href="FindSuccessUser?pc=${i}" >${i }</a>
   	  </c:otherwise>
   </c:choose> 	
 </c:forEach>
 
 <c:if test="${end < sessionScope.blockedUserPageBean.tp }">
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
           <li><a href="FindSuccessUser?pc=1">管理正常状态的用户</a></li>
            <li><a href="javascript:void(0)">审核冻结状态的用户</a></li>
            <li><a href="FindBlockedQuestion?pc=1">审核用户提交的问题</a></li><!-- managequestion.jsp -->
            <li><a href="AllPlants?pc=1">显示所有的药用植物</a></li>
           <li><a href="LoginSuccess">返回我的管理员首页</a></li>
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
	function active() {
		return window.confirm("确定激活账户？");
	}
</script>
</html>
