<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>��ͼ����</title>
<meta http-equiv="X-UA-Compatible" content="IE=7; charset=gbk">
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
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
        <div class="small">ҩ��ֲ����Դ��Ϣ����ϵͳ</div>
      </div>

      <div class="menu_nav">
       <ul>
        <li ><a href="javascript:void(0)">�𾴵ģ�${sessionScope.user.uname}���������ʾ������ǵ����ʣ�</a></li>
         <li><a href="javascript:void(0)">���ϴε�¼��ʱ���ǣ�${sessionScope.user.lasttime}</a></li>
          <li><a href="LoginOutServlet?uname=${sessionScope.user.uname}"   onclick="return  confirmoper();">ע����¼</a></li>
      </ul>     
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
      <div class="header_img"><img src="images/ytjd.jpg" alt="image" width="336" height="221" />
      <h2>More <span>Valuable</span> Question</h2>
      <p>����������֪����ֲ��������ﴫͼ������ɣ� </p>
      <div class="clr"></div>
      </div>
      
      
    </div>
  </div>
  <div class="clr"></div>
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Up</span>LoadQuestion</h2>
          <div class="clr"></div>
          <p>�������ʣ������ջ�</p>
          <img src="images/img_1.jpg" width="613" height="179" alt="image" />
          <div  class="upload">
          <hr/>
          <span>�����ϴ������ֵ�ֲ����Ƭ��</span><br/><br/>
          <form  enctype="multipart/form-data"  method="post" 
           action="UpLoadQuestion"  name="upload" 
           onsubmit="return checkPlanjian()">
  		 <span>�ϴ�ͼƬ:</span><input name="image" type="file"  
  		  id="image" 	  onchange="fileChange(this);"/><br/><br/>
  		 <span>����ע����</span><input type="text"  id="bz"   name="bz"/><br/><br/><br/>
  		 <input type="submit"  class="upbut" value="ȷ��" />
  		 <input type="reset" class="upbut" value="����" /></form>
          </div>
        </div>
      </div>
      
      
      
      <!--���-->
      <div class="sidebar">
        <div class="gadget">
          <h2>Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li><a href="javascript:void(0)">��ͼ�����</a></li>
            <li><a href="LoginSuccess">�����ҵ���ҳ</a></li>
          </ul>
        </div>
        <div class="gadget">
          <h2><span>MORE</span></h2>
          <div class="clr"></div>
          <ul class="ex_menu">
            <li><a href="javascript:void(0)" >�����ֲ��</a><br />
             ����1000+��ֲ��洢�����ݿ⣡</li>
            <li><a href="javascript:void(0)"  >����ķ���</a><br />
              Ұ�� &amp; ��ֲ��һֱ����̽����</li>
            <li><a href="javascript:void(0)"  >�������Ⱥ</a><br />
              ��������ѧϰ�����о����������ǿ�һ�����������Ƽ�������Ҷ������</li>
            <li><a href="javascript:void(0)"  >����İ���</a><br />
              ��Ҫ�������������и�����˱������ҩ�ģ�</li>
            <li><a href="javascript:void(0)" >����ķ���</a><br />
            ÿһ�춼�����µ�ֲ��������ǵ����ݿ⣡
              </li>
            <li><a href="javascript:void(0)">���и��࣡��</a><br />
              �������ļ��룡����������Ҫʲô����</li>
          </ul>
        </div>
             </div>
      <div class="clr"></div>
    </div>
  </div>
  <!-- ��ҳ����Ĳ��� -->
  <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        <h2><span>Welcome</span></h2>
        <a href="javascript:void(0)"><img src="images/gallery_1.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_2.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_3.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_4.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_5.jpg" width="58" height="58" alt="pix" /></a> <a href="javascript:void(0)"><img src="images/gallery_6.jpg" width="58" height="58" alt="pix" /></a> </div>
      <div class="col c2">
        <h2><span>About System</span></h2>
        <p>�����ṩ�����µĹ��ܣ�����ʹ�ñ�ϵͳ��<br />
          ��ͬ��ݵ���Ⱥ��ͬ�����顢ͼƬ�İ�Ȩˮӡ���ܡ����ֵĲ�ѯ������������Ϣ������ͼƬѰ�Ҷ�ֲ����ˡ��ղ�ֲ����Ҫʱ��ʱ�鿴�����Щ����û�еĶ����е���Ϣ��
          </p>
      </div>
      <div class="col c3">
        <h2><span>Contact</span></h2>
        <p>�����������������Զ���벻������ֲ�������Ҫ�������һ�����������ĸ����ã����ǳ������ļ��룡������и��Ӻõ��뷨�ʹ��⣬������ϵ���ǡ�<br/><a href="javascript:void(0)">zhanghuang_1994@163.com</a><br />
          <a href="javascript:void(0)">+86-183-2997-5053</a></p>
      </div>
      <div class="clr"></div>
    </div>
    <div class="footer">
      <p class="lr">&copy; Copyright <a href="javascript:void(0)">ZhangHuang</a>.</p>
      <p class="lf">�Ż͡�<a href="javascript:void(0)" title="ҩ��ֲ����Դ��Ϣ����ϵͳ" target="_blank">ҩ��ֲ����Դ��Ϣ����ϵͳ</a></p>
      <div class="clr"></div>
    </div>
  </div>
</div>
<!-- ��ҳ������Ĳ��ֽ��� -->
</body>
<script type="text/javascript">
	function confirmoper() {
		return window.confirm("ȷ���˳���");
	}
</script>
</html>
