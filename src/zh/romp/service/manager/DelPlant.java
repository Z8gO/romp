package zh.romp.service.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.entity.Plant;
import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

public class DelPlant extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger =  Logger.getLogger(DelPlant.class);  
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user=(User)request.getSession().getAttribute("user");
		  if(user.getIid()!=2){
		      logger.info(user.getUname()+
		              "在非正常访问的路径上发出删除了一条植物信息的请求，已经拦截"
		              +"对方IP:"+request.getRemoteAddr());
              response.sendRedirect("LoginSuccess");
              return;
          }
		IUserBiz userBiz=new UserBiz();
		int pid=Integer.parseInt(request.getParameter("pid"));
		logger.info("进入到删除植物的服务类，获取到的植物ID为："+pid);
		Plant plant = userBiz.getOnePlant(pid);
		boolean flag = userBiz.delPlant(pid);
		if(flag){
				logger.info(user.getUname()+"删除了一条植物信息");
				logger.info("删除掉的信息是"+plant.toString());
				response.sendRedirect("AllPlants?pc=1");
		}else{
			logger.info("代码出现问题，请您注意！"+user.getUname()+"删除植物信息时失败。");
		}
	}

}
