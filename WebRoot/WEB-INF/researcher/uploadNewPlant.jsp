<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>上传新植物</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/trim.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cufon-yui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/arial.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/cuf_run.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/imageRex.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadRex.js"></script>

<script  type="text/javascript" >
			function rexplanname(){
				$.ajax({
					type:"post",   //请求类型
					dateType:"text",  //返回类型
					url:"RexPlanname",  //请求路径
					data:"planname="+trim($("#zwword").val()),
					success:function(data){
						if("抱歉，该中文名的植物已经存在"==data){
							$("#mes2").html(data);
							}else{
								$("#mes2").html(data);
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
      <div class="header_img"><img src="images/yjy.JPG" alt="image" width="256" height="221" />
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
          <h2><span>Up</span>Load</h2>
          <div class="clr"></div>
          <p>感谢您的分享，请您尽量提交更详细的信息!</p>
          <img src="images/img_1.jpg" width="613" height="179" alt="image" />
          <div  class="upload">
          <hr/>
          <span>请您录入以下信息：</span>
          <form  enctype="multipart/form-data"  method="post"  action="UpLoadPlant"  name="upload"  onsubmit="return checkPlan()">
         <span>中文名　：</span><input type="text"  onblur="rexplanname()"  id="zwword"   name="zwword"/><span  id="mes2"></span><br/>
  		 <span>英文名　：</span><input type="text"  id="ywword"   name="ywword"/>
  		 <span>拉丁文名：</span><input type="text"  id="ldword"   name="ldword"/><br/>
  		 
  		 <!--
  		 	其实可以写成这样，在业务逻辑里面判断后进行赋值
  		 	<option value="1">木麻黄科</option>  
  		 	<option value="豆">豆科</option>
  		 -->
  		 <span>科　属　：</span><select  id="ke"   name="ke">
             								<option value="1">杨柳科</option>
											<option value="2">桦木科</option>
											<option value="3">壳斗科</option>
											<option value="4">马尾树科</option>
											<option value="5">榆科</option>
											<option value="6">杜仲科</option>
											<option value="7">桑科</option>
											<option value="8">荨麻科</option>
											<option value="9">十齿花科</option>
											<option value="10">檀香科</option>
											<option value="11">桑寄生科</option>
											<option value="12">蓼科</option>
											<option value="13">商陆科</option>
											<option value="14">马齿苋科</option>
											<option value="15">石松科</option>
											<option value="16">苋科</option>
											<option value="17">木兰科</option>
											<option value="18">五味子科</option>
											<option value="19">樟科</option>
											<option value="20">毛茛科</option>
											<option value="21">小檗科</option>
											<option value="22">木通科</option>
											<option value="23">防己科</option>
											<option value="24">睡莲科</option>
											<option value="25">三白草科</option>
											<option value="26">金粟兰科</option>
											<option value="27">马兜铃科</option>
											<option value="28">芍药科</option>
											<option value="29">藤黄科</option>
											<option value="30">罂粟科</option>
											<option value="31">十字花科</option>
											<option value="32">金缕梅科</option>
											<option value="33">景天科</option>
											<option value="34">虎耳草科</option>
											<option value="35">蔷薇科</option>
											<option value="36">豆科</option>
											<option value="37">蒺藜科</option>
											<option value="38">亚麻科</option>
											<option value="39">大戟科</option>
											<option value="40">芸香科</option>
											<option value="41">苦木科</option>
											<option value="42">橄榄科</option>
											<option value="43">楝科</option>
											<option value="44">远志科</option>
											<option value="45">漆树科</option>
											<option value="46">无患子科</option>
											<option value="47">凤仙花科</option>
											<option value="48">冬青科</option>
											<option value="49">卫矛科</option>
											<option value="50">省沽油</option>
											<option value="51">鼠李科</option>
											<option value="52">葡萄科</option>
											<option value="53">锦葵科</option>
											<option value="54">椴树科</option>
											<option value="55">木棉科</option>
											<option value="56">梧桐科</option>
											<option value="57">瑞香科</option>
											<option value="58">胡颓子科</option>
											<option value="59">堇菜科</option>
											<option value="60">葫芦科</option>
											<option value="61">桃金娘科</option>
											<option value="62">使君子科</option>
											<option value="63">锁阳科</option>
											<option value="64">五加科</option>
											<option value="65">山茱萸科</option>
											<option value="66">伞形科</option>
											<option value="67">杜鹃花科</option>
											<option value="68">紫金牛科</option>
											<option value="69">报春花科</option>
											<option value="70">柿树科</option>
											<option value="71">安息香科</option>
											<option value="72">马钱科</option>
											<option value="73">龙胆科</option>
											<option value="74">夹竹桃科</option>
											<option value="75">萝藦科</option>
											<option value="76">茜草科</option>
											<option value="77">旋花科</option>
											<option value="78">紫草科</option>
											<option value="79">马鞭草科</option>
											<option value="80">唇形科</option>
											<option value="81">茄科</option>
											<option value="82">玄参科</option>
											<option value="83">紫葳科</option>
											<option value="84">爵床科</option>
											<option value="85">胡麻科</option>
											<option value="86">苦苣苔科</option>
											<option value="87">车前草</option>
											<option value="88">忍冬科</option>
											<option value="89">败酱科</option>
											<option value="90">桔梗科</option>
											<option value="91">菊科</option>
											<option value="92">泽泻科</option>
											<option value="93">百合科</option>
											<option value="94">百部科</option>
											<option value="95">仙茅科</option>
											<option value="96">石蒜科</option>
											<option value="97">薯蓣科</option>
											<option value="98">鸢尾科</option>
											<option value="99">灯心草科</option>
											<option value="100">凤梨科</option>
											<option value="101">鸭跖草科</option>
											<option value="102">禾本科</option>
											<option value="103">棕榈科</option>
											<option value="104">天南星科</option>
											<option value="105">黑三棱科</option>
											<option value="106">香蒲科</option>
											<option value="107">莎草科</option>
											<option value="108">姜科</option>
											<option value="109">兰科</option>
											<option value="110">柏科</option>
											<option value="111">胡椒科</option>
             								</select><br/>
  		 <span>性　味　：</span><input type="text"  id="xw"   name="xw"/>
  		 <span>归　经　：</span><input type="text"  id="gj"   name="gj"/><br/>
  		 <span>主治功能：</span><input type="text"  id="zzgn"   name="zzgn" />
  		 <span>用法用量：</span><input type="text"  id="yfyl"   name="yfyl" /><br/>
  		 <span>药用部位：</span><input type="text"   id="yybw"   name="yybw"/><br/>
  		 <span>备　注　：</span><input type="text"  id="bz"   name="bz"/><br/>
  		 <span>上传图片:</span><input name="image" type="file"   id="image"  onchange="fileChange(this);"/><br/><br/>
  		 <input type="submit"  class="upbut" value="确定" /><input type="reset" class="upbut" value="重填" />
  		 </form>
          </div>
        </div>
      </div>
      
      
      
      <!--左边-->
      <div class="sidebar">
        <div class="gadget">
          <h2>Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
             <li><a href="AllPlants?pc=1">查看所有植物</a></li>
            <li  ><a href="javascript:void(0)">上传新的植物</a></li>
            <li><a href="PageSkip?page=tujian/imagehelp.jsp">上传图求鉴定</a></li>
            <li><a href="AllQuestion?pc=1">依图帮助鉴定</a></li>
           <li><a href="PageSkip?page=all/findmyquestions.jsp">查看我的问题</a></li><!--已经解决和未解决  -->
            <li><a href="FindMyCollections?cuid=${sessionScope.user.uid}&pc=1">查看我的收藏</a></li>
           <li><a href="PageSkip?page=all/findwithlike.jsp">模糊查找植物</a></li>
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
