<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>植物对比</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />


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
        <li ><a href="javascript:void(0)">尊敬的教员：${sessionScope.user.uname}，欢迎您再次登录</a></li>
         <li><a href="javascript:void(0)">您上次登录的时间是：${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">注销登录</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/jxry.JPG" alt="image" width="233" height="221"  />
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
        <div class="article">
          <h2><span>Compare</span>Plant</h2>
          <div class="clr"></div>
          <p>更加准确的对比，尽在这里</p>
          <div  class="upload">
          <span>您对比的两个植物的信息如下：</span>
         <table id="twoplant">
         <tr>
         <td >药物名称</td>
         <td>${sessionScope.plant1.zwword}</td>
         <td>${sessionScope.plant2.zwword}</td>
         </tr>
         <tr >
         <th >药物图片</th>
         <td><img style="width:210px;height: 200px;" src="<%=request.getContextPath() %>${sessionScope.plant1.picpath}"/></td>
         <td><img style="width:210px;height: 200px;" src="<%=request.getContextPath() %>${sessionScope.plant2.picpath}"/></td>
         </tr>
         <tr>
         <td>科属</td>
         <td>${sessionScope.plant1.ke}</td>
         <td>${sessionScope.plant2.ke}</td>
         </tr>
          <tr>
         <td>性味</td>
        <td>${sessionScope.plant1.xw}</td>
         <td>${sessionScope.plant2.xw}</td>
         </tr>
          <tr>
         <td>归经</td>
         <td>${sessionScope.plant1.gj}</td>
         <td>${sessionScope.plant2.gj}</td>
         </tr>
          <tr>
         <td>用法用量</td>
         <td>${sessionScope.plant1.yfyl}</td>
         <td>${sessionScope.plant2.yfyl}</td>
         </tr>
          <tr>
         <td>主治功能</td>
         <td>${sessionScope.plant1.zzgn}</td>
         <td>${sessionScope.plant2.zzgn}</td>
         </tr>
          <tr>
         <td>药用部位</td>
         <td>${sessionScope.plant1.yybw}</td>
         <td>${sessionScope.plant2.yybw}</td>
         </tr>
       
         </table>
          </div>
        </div>
      </div>
      
      
      
      <!--左边-->
      <div class="sidebar">
        <div class="gadget">
          <h2>Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
          <li><a href="AllPlants?pc=1">查看所有药用植物</a></li>
            <li><a href="PageSkip?page=all/findwithlike.jsp">模糊查找植物</a></li>
            <li><a href="PageSkip?page=tujian/imagehelp.jsp">上传图求鉴定</a></li>
            <li><a href="PageSkip?page=all/findmyquestions.jsp">查看我的问题</a></li><!--已经解决和未解决  -->
            <li><a href="FindMyCollections?cuid=${sessionScope.user.uid}&pc=1">查看我的收藏</a></li>
            <li><a href="PageSkip?page=teacher/compare.jsp">对比两种植物</a></li>
            <li><a href="LoginSuccess">返回我的主页</a></li>
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
