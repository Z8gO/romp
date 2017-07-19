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

public class PassQuestion extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(PassQuestion.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        User user=(User)request.getSession().getAttribute("user");
			int pid=	Integer.parseInt(request.getParameter("imgid").trim());
			
			IUserBiz userBiz=new UserBiz();
			boolean flag = userBiz.updateQueStatus(pid);
			
			if(flag){
			    logger.info("管理员"+user.getUname()+"审核通过了一条问题信息，该图片的imgid为"+pid);
				response.sendRedirect("FindBlockedQuestion?pc=1");
			}
			
	}

}
