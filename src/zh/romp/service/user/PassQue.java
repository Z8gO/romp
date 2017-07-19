package zh.romp.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Plant;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

public class PassQue extends HttpServlet {

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

		IUserBiz userBiz=new UserBiz();
		int pc=Integer.parseInt(request.getParameter("pc"));
	
		String pimguid=request.getParameter("pimguid");
		List<Expression> exprList=new ArrayList<Expression>();
		
		exprList.add(new Expression("pimguid","=",pimguid));
		exprList.add(new Expression("perfectuid","!=",pimguid));
		exprList.add(new Expression("pid","> 0",null));
		PageBean<Plant> pageBean = userBiz.findAllPlant(exprList, pc);
		request.getSession().setAttribute("plantPageBean", pageBean);
		response.sendRedirect("PageSkip?page=all/allplants.jsp");
	}

}
