package zh.romp.service.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

public class UpdateUserStatus extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger =  Logger.getLogger(UpdateUserStatus.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			User user=(User)request.getSession().getAttribute("user");
			if(user.getIid()!=2){
				response.sendRedirect("LoginSuccess");
				return;
			}
				IUserBiz userBiz=new UserBiz();
				int uid=	Integer.parseInt(request.getParameter("uid"));
				
				boolean flag = userBiz.updateUserStatus(uid);
				if(flag){
				    logger.info("管理员"+user.getUname()+"刚刚改变了一个用户的状态！该用户的ID为："+uid);
					response.sendRedirect("LoginSuccess");
				}
	}

}
