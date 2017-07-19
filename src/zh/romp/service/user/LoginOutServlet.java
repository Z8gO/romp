package zh.romp.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
import zh.romp.util.GetTime;
/**
 * 
 * 类名:		LoginOutServlet
 * 描述:		注销登录的服务类
 * @author 	张煌
 * @date 	2016年4月11日 下午4:38:07
 *
 */
public class LoginOutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(LoginOutServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String uname=request.getParameter("uname");
			String key="lasttime";
			IUserBiz userBiz=new UserBiz();
			userBiz.userLoginOut(uname, key, GetTime.getTime());
			request.getSession().setAttribute("user", null);
			logger.info("用户"+uname+"注销登录，时间是："+GetTime.getTime());
			response.sendRedirect("IndexPlants");
	}

}
