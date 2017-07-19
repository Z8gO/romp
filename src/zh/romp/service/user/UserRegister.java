package zh.romp.service.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
import zh.romp.util.GetTime;

public class UserRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			String work=request.getParameter("work");
			String email=request.getParameter("email");
			int identity=Integer.parseInt(request.getParameter("identity"));
			String regdemo=request.getParameter("regdemo");
			String time=GetTime.getTime();
			
			User user=new User();
			user.setUname(userName);
			user.setPassword(password);
			user.setWorkunit(work);
			user.setEmail(email);
			user.setIid(identity);
			user.setUdemo(regdemo);
			user.setLasttime(time);

			IUserBiz userBiz=new UserBiz();
			boolean flag = userBiz.userRegister(user);
			if(flag){
				response.sendRedirect("index.jsp");
			}	
	}

}
