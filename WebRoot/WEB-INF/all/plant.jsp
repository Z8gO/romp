<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>plant</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache">
<link href="css/style.css" rel="stylesheet" type="text/css" />


<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/trim.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cuf_run.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/registerrex.js"></script>
<script  type="text/javascript" >
			function shoucang(){
				$.ajax({
					type:"post",   //请求类型
					dateType:"text",  //返回类型
					url:"CollectionPlant",  //请求路径
					data:"planname="+trim($("#yymc").val())+"&pid="+trim($("#yyid").val()),
					success:function(data){
						alert(data);
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
      <h1><a href="LoginSuccess">resources <span>of</span>  medicinal plants</a></h1>
        <div class="small">药用植物资源信息管理系统</div>
      </div>

      <div class="menu_nav">
       <ul>
        <li ><a href="javascript:void(0)">尊敬的：${sessionScope.user.uname}，感谢您的管理！</a></li>
         <li><a href="javascript:void(0)">您上次登录的时间是：${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">注销登录</a></li>
      </ul>  
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/zhang.jpg" alt="image" width="343" height="221"  />
      <h2>One <span>Plant</span> Info</h2>
      <p>更多信息都在这里！ </p>
      <div class="clr"></div>
      </div> 
    </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize"  style="width: 990px;">
      <div class="mainbar">
        <div class="article"  style="width: 720px;">
          <h2><span>One</span> Plant Info</h2>
          <div class="clr"></div>
          <p>这里有植物详细的信息！</p>
       <!-- 放在article  这个div里面-->
       
        		<img style="width:210px;height: 200px;box-shadow: 5px 15px 15px #000;" src="<%=request.getContextPath() %>${plant.picpath}" alt="${plant.picpath}" >
        	<div style="color: black;margin-left: 290px;width: 600px;height: auto;" >
        		植物名称：${plant.zwword}<br/><br/>
        		
        		植物英文名：${plant.ywword}<br/><br/>
        		
        		植物拉丁文名：${plant.ldword}<br/><br/>
        		
        		性味：${plant.xw}　　　　　
        		归经：${plant.gj}<br/><br/>
        		主治功能：<input type="text" id="a1" readOnly="true"  value="${plant.zzgn}" class="reads"  name="zzgn"/><br/><br/>
        		用法用量：<input type="text" id="a2" readOnly="true"  value="${plant.yfyl}" class="reads" name="yfyl"/><br/><br/>
        		
        		图片上传者ID：${plant.pimguid}<br/><br/>
        		
        		图片上传时间：${plant.uploadtime}<br/><br/>
        		
        		备注：<input type="text" id="a3" readOnly="true"  value="${plant.pdemo}" class="reads" name="pdemo"/> <br/><br/>
        		
        		水印：		
        		<c:if test="${'no' eq plant.shuiyinstatus}">
        			<c:if test="${2==user.iid}">
        			无水印<br/><br/>
        			<!-- AddWatermark   AJAX请求，在registerrex.js里面写着-->
        						为图片添加水印：<input type="text" name="shuiyin"  id="shuiyin"  placeholder="最多输入10个字"/>
        						<input type="button" value="添加"  onclick="checkSY()"/>
        						<input type="text"  value="${plant.picpath}"  name="path"  style="visibility:hidden;" id="path"/>
        					</c:if>
        				<c:if test="${2!=user.iid}">
        					管理员未添加水印
        				</c:if>	
        		</c:if>
        			<c:if test="${'yes' eq plant.shuiyinstatus}">
        			已经添加
        		</c:if>
        		<br/><br/>
        		<c:if test="${2!=user.iid}">
        					<a  onclick="shoucang()" style="cursor: pointer;">收藏这个药用植物</a><br/>
        					<input type="text"  id="yymc"  value="${plant.zwword}"  style="visibility: hidden;"/>
        					<input type="text"  id="yyid"  value="${plant.pid}"  style="visibility: hidden;"/>
        				</c:if>
        				<br/><br/>
        				<c:if test="${4==user.iid}">
        						<input type="button" onclick="javascript:a();" value="修改信息"  class="readbut"  id="redupdbut"/> 
								<input  id="redsubbut" type="hidden" onclick="javascript:b();"  value="提交"  class="readbut"/> 
        				</c:if>
        </div>
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
	
	//修改
	function a(){ 
			var flag=confirm("确定修改信息？（目前只提供修改主治功能、用法用量和备注的修改）");
			if(!flag){
				return false;
			}
			document.getElementById("a1").removeAttribute("readOnly");
			document.getElementById("a1").setAttribute("style","border:1px solid 	#7A378B;background-color:#fff;");
			document.getElementById("a2").removeAttribute("readOnly");
			document.getElementById("a2").setAttribute("style","border:1px solid 	#7A378B;background-color:#fff;");
			document.getElementById("a3").removeAttribute("readOnly");
			document.getElementById("a3").setAttribute("style","border:1px solid 	#7A378B;background-color:#fff;");
			document.getElementById("redsubbut").setAttribute("type","button");
			document.getElementById("redupdbut").setAttribute("type","hidden");
			} 
			function b(){ 
			var a1=trim(document.getElementById("a1").value);
			var a2=trim(document.getElementById("a2").value);
			if(''==a1 || ''==a2){
			alert("性味和归经不能为空！");
			return false;
			}
			var flag1=confirm("确定提交修改？");
			if(!flag1){
				return false;
			}
				$.ajax({
				type:"post",   //请求类型
				dateType:"text",  //返回类型
				url:"UpdatePlant",  //请求路径
				data:"zzgn="+trim($("#a1").val())+"&yfyl="+trim($("#a2").val())+"&pdemo="+trim($("#a3").val())+"&pid="+trim($("#yyid").val()),
				success:function(data){
					alert(data);
					window.self.location.reload();
					}
			});
			}
</script>
</html>
