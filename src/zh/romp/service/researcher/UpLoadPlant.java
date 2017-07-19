package zh.romp.service.researcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.dao.IPlantDao;
import zh.romp.dao.impl.PlantDao;
import zh.romp.entity.Plant;
import zh.romp.entity.User;
import zh.romp.util.GetTime;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
/**
 * 类名:		UpLoadPlant
 * 描述:		上传植物的服务类
 * @author 	张煌
 * @date 	2016年4月11日 下午4:40:52
 */
public class UpLoadPlant extends HttpServlet {

	private static Logger logger =  Logger.getLogger(UpLoadPlant.class);  
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user=(User) request.getSession().getAttribute("user");
		  if(user.getIid()!=4){
		      if(user.getIid()==0){
		      logger.info("IP为"+request.getRemoteAddr()+"的用户非法上传植物信息！已经拦截！");}
		      else{ logger.info("ID为"+user.getIid()+"的用户非法上传植物信息！已经拦截！");}
		      return;
		  }
		  request.setCharacterEncoding("utf-8");
	       response.setCharacterEncoding("utf-8");
	       
		Request req = null;
		String path="";
		//创建一个smartupload对象
		SmartUpload su = new SmartUpload();
		//初始化对象
		su.initialize(this.getServletConfig(), request, response);
		try {//执行上传
			su.upload();
			//得到request对象
			req = su.getRequest();
		} catch (SmartUploadException e) {e.printStackTrace();}
		Files fs = su.getFiles();
		for (int i = 0; i < fs.getCount(); i++) {
			File f = fs.getFile(i);
			//设置图片路径
			String fName=new String(f.getFileName().getBytes("utf-8"),"utf-8");
			 path = "/upload/" +System.currentTimeMillis()+""
			+ fName.substring(fName.length()-4,fName.length());
			try {
				//保存
			f.saveAs(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String zwword=new String (req.getParameter("zwword").trim().getBytes(),"utf-8");
	    String ywword=new String (req.getParameter("ywword").trim().getBytes(),"utf-8");
		 String ldword=new String (req.getParameter("ldword").trim().getBytes(),"utf-8");
		 String picpath=path;
		 String xw=new String (req.getParameter("xw").trim().getBytes(),"utf-8");
		 String ke=new String (req.getParameter("ke").trim().getBytes(),"utf-8");
		 String gj=new String (req.getParameter("xw").trim().getBytes(),"utf-8");
		 String zzgn=new String (req.getParameter("zzgn").trim().getBytes(),"utf-8");
		 String usage=new String (req.getParameter("yfyl").trim().getBytes(),"utf-8");
		 String yybw=new String (req.getParameter("yybw").trim().getBytes(),"utf-8");
		 int pimguid =user.getUid();
		 int perfectuid=user.getUid();
		 String uploadtime=GetTime.getTime();
		 String pdemo=new String (req.getParameter("bz").trim().getBytes(),"utf-8");
		
		Plant plant=new Plant();
		
		plant.setZwword(zwword);
		plant.setYwword(ywword);
		plant.setLdword(ldword);
		plant.setXw(xw);
		plant.setKe(ke);
		plant.setGj(gj);
		plant.setZzgn(zzgn);
		plant.setYfyl(usage);
		plant.setYybw(yybw);
		plant.setPdemo(pdemo);
		plant.setPimguid(pimguid);
		plant.setPerfectuid(perfectuid);
		plant.setUploadtime(uploadtime);
		plant.setPicpath(picpath);
		IPlantDao  plantDao=new PlantDao();
		boolean flag = plantDao.insert(plant);
		if(flag){
			logger.info("用户名为"+user.getUname()+"的研究员添加了一个植物，植物详细信息："+plant.toString());
			response.sendRedirect("LoginSuccess");
		}
	}

}
