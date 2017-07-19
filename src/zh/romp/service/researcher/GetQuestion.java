package zh.romp.service.researcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Imagejian;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

public class GetQuestion extends HttpServlet {

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
		
			IUserBiz  userBiz=new UserBiz();
			int id=	Integer.parseInt(request.getParameter("imgid"));
			
			Imagejian imagejian = userBiz.fiandImagejianById(id);
			
			request.getSession().setAttribute("onequestion", imagejian);
			
			response.sendRedirect("PageSkip?page=researcher/questionplant.jsp");
	}

}
