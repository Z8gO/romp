	function check() {
		var username=trim($("#reg_username").val());
		var passWord=trim($("#password").val());
		var passWord1=trim($("#password1").val());
		var work=trim($("#work").val());
		var email=trim($("#email").val());
		var mes = trim($("#mes").text());  //获取span中的内容是，看用户名是否可用
		var mes1 = trim($("#mes1").text());
		if ("" == username) {
			alert("请输入用户名！");
			return false;
		}
		if ("" == passWord) {
			alert("请输入密码！");
			return false;
		}
		if ("" == passWord1) {
			alert("请再次输入密码！");
			return false;
		}
		if (passWord != passWord1) {
			alert("两次密码输入不一致");
			return false;
		}
			if ("用户名已存在" == mes) {
				alert("请您重新设定输入用户名！");
				return false;
			}
			if ("" == work) {
				alert("请输入您的工作单位！");
				return false;
			}
			if (!(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(email))) {
				alert("您输入的邮箱格式不正确！");
				return false;
			}
			if ("验证码错误" == mes1) {
				alert("请您输入正确的验证码！");
				return false;
			}
			
			
			 $("#password").val($.md5(passWord1)); 
			 alert("信息已经提交请等待管理员审核!");
			return true;
		}
	
	
	/**
	 * 换一张验证码
	 */
	function yzmhyz(){
		$("#yzm").attr("src","VerifyCodeServlet?a="+new Date().getTime());
	}
	function checkSY(){
	var sy=	trim($("#shuiyin").val());
	if(sy.length >10){
		alert("最多输入10个字哦！");
		return false;
	}
	$.ajax({
		type:"post",   //请求类型
		dateType:"text",  //返回类型
		url:"AddWatermark",  //请求路径
		data:"path="+trim($("#path").val())+"&shuiyin="+sy,
		success:function(data){
			alert(data);
			if('水印添加成功！' ==data){
			window.self.location.reload();
			}
			}
	});
	}
	