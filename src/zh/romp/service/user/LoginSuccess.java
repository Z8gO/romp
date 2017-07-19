package zh.romp.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import zh.romp.entity.User;

public class LoginSuccess extends HttpServlet {
	 private static Logger logger =  Logger.getLogger(LoginSuccess.class);  

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
				User user = (User) request.getSession().getAttribute("user");
				logger.info(user.getUname()+"登录");
		//		1	感兴趣的人员   interester
		//		2	管理员			manager
		//		3	教学人员		teacher
		//		4	研究人员		researcher1
				int iid=user.getIid();
				if(iid==1){
					request.getRequestDispatcher("WEB-INF/interester/interesterindex.jsp").forward(request, response);
				}
				
				if(iid==2){
					request.getRequestDispatcher("WEB-INF/manager/managerindex.jsp").forward(request, response);
				}
				if(iid==3){
					request.getRequestDispatcher("WEB-INF/teacher/teacherindex.jsp").forward(request, response);
				}
				if(iid==4){
					request.getRequestDispatcher("WEB-INF/researcher/researcherIndex.jsp").forward(request, response);
				}

	}

}
