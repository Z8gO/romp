package zh.romp.service.user;

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
/**
 * 
 * 类名:		GetPlant
 * 描述:		通过ID 获取植物信息
 * @author 	张煌
 * @date 	2016年4月11日 下午4:36:25
 *
 */
public class GetPlant extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(GetPlant.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				IUserBiz userBiz=new UserBiz();
				int pid=Integer.parseInt(request.getParameter("pid"));
				
				
				
				Plant plant = userBiz.getOnePlant(pid);
				if(plant==null){
				    User user=(User) request.getSession().getAttribute("user");
				    logger.info("用户"+user.getUname()+"查询了一个不存在的植物！该植物的id为："+pid);
				    logger.info("出现这样情况的原因的可能是：用户在查询该植物时，管理员已经将该植物删除掉了！可以在日志中找到该植物的信息！");
					response.sendRedirect("PageSkip?page=all/nothave.jsp");
					return;
				}
				request.getSession().setAttribute("plant",plant);
				
				response.sendRedirect("PageSkip?page=all/plant.jsp");
				
	}

}
