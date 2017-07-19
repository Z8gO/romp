


	function  _checkPlansName(){
		var zwword=trim($("#zwword").val());
		var zwword2=trim($("#zwword2").val());
		var mes2 = trim($("#mes2").text());
		var mes1 = trim($("#mes1").text());
		if ("" == zwword) {
			alert("请输入植物一！");
			return false;
		}
		if ("" == zwword2) {
			alert("请输入植物二！");
			return false;
		}
		if (zwword2 == zwword) {
			alert("两种名称一样，请不要输入相同的植物");
			return false;
		}
		if ("抱歉，数据库不存这种植物" == mes2) {
			alert("您输入的第一种植物不存在！");
			return false;
		}
		if ("抱歉，数据库不存这种植物" == mes1) {
			alert("您输入的第二种植物不存在！");
			return false;
		}
		return true;
		
}
    function fileChange(target){
		str= target.value; //判断文件格式
		strs=str.toLowerCase(); 
		lens=strs.length; 
		extname=strs.substring(lens-4,lens); 
		if(extname!=".jpg" && extname!=".png"&& extname!=".gif"
			&& extname!=".bmp") 
		{ alert("请选择jpg或gif或png或bmp格式的文件!"); 
		document.upload.image.value="";
		return (false); } 
	    var isIE = /msie/i.test(navigator.userAgent) && !window.opera;//接下来判断文件大小
        var fileSize = 0;
        if (isIE && !target.files) {    // IE浏览器
            var filePath = target.value; // 获得上传文件的绝对路径
            var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
            var file = fileSystem.GetFile(filePath); // GetFile(path) 方法从磁盘获取一个文件并返回。
            fileSize = file.Size;    // 文件大小，单位：b
        }
        else { fileSize = target.files[0].size;} // 非IE浏览器
        var size = fileSize / 1024 / 1024 ;
        if (size > 5) {
            alert("图片不能大于5M");
			document.upload.image.value="";}
    }