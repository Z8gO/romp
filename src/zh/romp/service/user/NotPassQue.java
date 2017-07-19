package zh.romp.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Imagejian;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

public class NotPassQue extends HttpServlet {

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
		String uid=request.getParameter("uid");
		List<Expression> exprList=new ArrayList<Expression>();
		exprList.add(new Expression("uid","=",uid));
		exprList.add(new Expression("imgid","> 0",null));
		PageBean<Imagejian> pageBean = userBiz.findAllQuestion(exprList, pc);
		
		request.getSession().setAttribute("pageBean", pageBean);
		response.sendRedirect("PageSkip?page=all/helpwithimage.jsp");
	}

}
