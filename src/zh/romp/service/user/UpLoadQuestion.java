package zh.romp.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Imagejian;
import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
import zh.romp.util.GetTime;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
/**
 * 
 * 类名:		UpLoadQuestion
 * 描述:		上传问题的服务类
 * @author 	张煌
 * @date 	2016年4月11日 下午4:38:28
 *
 */
public class UpLoadQuestion extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		
		Request req = null;

		String path="";
		SmartUpload su = new SmartUpload();
		
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
			req = su.getRequest();
			
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		Files fs = su.getFiles();
		for (int i = 0; i < fs.getCount(); i++) {
			File f = fs.getFile(i);
			String fName=new String(f.getFileName().getBytes("gbk"),"gbk");
			String ext=f.getFileExt();
			System.out.println("*********|"+fName+"|************");
			System.out.println("*********|"+ext+"|************");
			 path = "/upload/" +System.currentTimeMillis()+"."+ ext;
			try {
			 	f.saveAs(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		User user=(User) request.getSession().getAttribute("user");
		/*
		 * 
		 * imgpath (图片路径)
		 *uid (图片上传作者 引用users_rompims表主键)
		 *uploadtime(上传时间)
		 *imgdemo(备注 允许空)
		 * */
		String imgdemo=new String (req.getParameter("bz").getBytes(),"gbk");
		Imagejian imageJian=new Imagejian();
		imageJian.setImgpath(path);
		imageJian.setUid(user.getUid());
		imageJian.setUploadtime(GetTime.getTime());
		imageJian.setImgdemo(imgdemo);
		
		IUserBiz userBiz=new UserBiz();
		boolean flag = userBiz.uploadQuestion(imageJian);
		if(flag){
			response.sendRedirect("LoginSuccess");
		}	
	}

}
