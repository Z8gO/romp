package zh.romp.service.researcher;

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
/**
 * 
 * 类名:		AllQuestion
 * 描述:		获取所有的问题的服务类——研究人员专用
 * @author 	张煌
 * @date 	2016年4月11日 下午5:14:04
 *
 */
public class AllQuestion extends HttpServlet {

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
				List<Expression> exprList=new ArrayList<Expression>();
				exprList.add(new Expression("status","=","yes"));
				exprList.add(new Expression("imgid","> 0",null));
				PageBean<Imagejian> pageBean = userBiz.findAllQuestion(exprList, pc);
				request.getSession().setAttribute("pageBean", pageBean);
				response.sendRedirect("PageSkip?page=researcher/helpwithimage.jsp");
				
	}

}
