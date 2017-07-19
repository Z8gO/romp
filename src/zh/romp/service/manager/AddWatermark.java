package zh.romp.service.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.dao.IPlantDao;
import zh.romp.dao.impl.PlantDao;
import zh.romp.entity.Plant;
import zh.romp.entity.User;
import zh.romp.util.Watermark;

public class AddWatermark extends HttpServlet {
/**
	 * 
	 */
	private static Logger logger =  Logger.getLogger(AddWatermark.class);
	private static final long serialVersionUID = 1L;

/**
 * 
 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	@SuppressWarnings("deprecation")
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    User user=(User)request.getSession().getAttribute("user");
        if(user.getIid()!=2){
            logger.info(user.getUname()+
                    "在非正常访问的路径上发出增加水印信息的请求，已经拦截"
                    +"对方IP:"+request.getRemoteAddr());
            response.sendRedirect("LoginSuccess");
            return;
        }
		 
		
		 Watermark imageObj = new Watermark(); 
	        //源图片路径 
		 String path=request.getParameter("path");
		 
		
		String srcImagePath=request.getRealPath(path);
		 
		 
	 
	        // ---- 宋体 普通字体 77号字 蓝色 透明度0.4" 
	        float alpha = 1F; 
	        String  font = "";
	        int fontStyle = Font.PLAIN; 
	        int fontSize = 50; 
	        Color color = Color.WHITE; 
	         
	        BufferedImage sourceImg =ImageIO.read(new FileInputStream(srcImagePath)); 
	        
	        String inputWords =request.getParameter("shuiyin");
	        
	        //下面两个参数是水印文字的时候的数字
	         int x = 0; 
	        int y = sourceImg.getHeight()-20;  

	        
	        String imageFormat =path.substring(path.lastIndexOf('.')+1, path.length()) ; 
	        //水印文字后的存储路径 
	        String wToPath = srcImagePath; 

	        imageObj.WordsToImage(srcImagePath, alpha, font, fontStyle, 
	                fontSize, color, inputWords, x, y, imageFormat, wToPath);  
	        
	        Plant plant=(Plant)request.getSession().getAttribute("plant");
	        IPlantDao plantDao=new PlantDao();
	        boolean flag= plantDao.shuiYinSuccess(plant.getPid());
	      	PrintWriter out = response.getWriter();
	        if(!flag){
	        	out.write("水印添加失败！");
	        	logger.info("管理员 "+user.getUname()+"为植物编号为"+plant.getPid()+"添加水印后，水印状态更改失败");
	        }else{
	        	plant.setShuiyinstatus("yes");
	        	out.write("水印添加成功！");
	        	logger.info("管理员 "+user.getUname()+"为植物编号为"+plant.getPid()+"添加水印成功，水印状态改变成功，水印的内容是"+inputWords);
	        }
	        
	        
	     //   response.sendRedirect("PageSkip?page=all/plant.jsp");
		
		
	}

}
