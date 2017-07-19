package zh.romp.service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

public class UserLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(UserLogin.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建输出对象
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		IUserBiz userBiz=new UserBiz();
		//调用登录业务
		User user = userBiz.userLogin(userName, passWord);
		if(null==user){
			out.write("用户名与密码不匹配");
		}else if("no".equals(user.getStatus())){
			out.write("该用户正在审核中，请耐心等待");
		}else{
		    logger.info("登录成功！将用户信息存入Session中。。。");
			request.getSession().setAttribute("user", user);
			 logger.info("将用户信息存入Session成功。");
		}
	}

}
