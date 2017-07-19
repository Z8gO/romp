function checkPlan() {
		var zwword=trim($("#zwword").val());
		var ywword=trim($("#ywword").val());
		var ldword=trim($("#ldword").val());
		var ke=trim($("#ke").val());
		var gj=trim($("#gj").val());
		var xw=trim($("#xw").val());
		var zzgn=trim($("#zzgn").val());
		var yfyl=trim($("#yfyl").val());
		var yybw=trim($("#yybw").val());
		var image=trim($("#image").val());
		var mes = trim($("#mes2").text());//获取span中的内容是，看植物名是否可用
		if ("" == zwword) {
			alert("请输入中文名称");
			return false;
		}
		if ("暂无" == zwword) {
			alert("如果不知道中文名，输入英文名也可");
			return false;
		}
		if ("" == ywword) {
			alert("请输入英文名称");
			return false;
		}
		if ("" == ldword) {
			alert("请输入拉丁文名称");
			return false;
		}
		if ("" == ke) {
			alert("请输入植物科属");
			return false;
		}
		if ("" == gj) {
			alert("请输入植物归经");
			return false;
		}
		if ("" == xw) {
			alert("请输入植物性味");
			return false;
		}
		if ("" == zzgn) {
			alert("请输入主治功能");
			return false;
		}
		if ("" == yfyl) {
			alert("请输入用法用量");
			return false;
		}
		if ("" == yybw) {
			alert("请输入药用部位");
			return false;
		}
		if ("" == image) {
			alert("请选择图片");
			return false;
		}
		if ("抱歉，该中文名的植物已经存在" == mes) {
			alert("抱歉，该中文名的植物已经存在");
			return false;
		}
		
		
		 alert("新的植物已经上传感谢您的分享！！");
			return true;
		}

function  checkPlanjian(){
	var image=trim($("#image").val());
	if ("" == image) {
		alert("请选择图片");
		return false;
	}
	
	alert("感谢您的分享！管理员需要审核您的问题，请等待答案。。。");
	return true;
}

