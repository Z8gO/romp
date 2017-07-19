package zh.romp.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Collection;
import zh.romp.pager.Expression;
import zh.romp.pager.PageBean;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
/**
 * 
 * 类名:		FindMyCollections
 * 描述:		查询用户的所有收藏的服务类
 * @author 	张煌
 * @date 	2016年4月11日 下午4:37:21
 *
 */
public class FindMyCollections extends HttpServlet {

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

			String cuid=request.getParameter("cuid");
			IUserBiz userBiz=new UserBiz();
			int pc=Integer.parseInt(request.getParameter("pc"));
			List<Expression> exprList=new ArrayList<Expression>();
			exprList.add(new Expression("cuid","=",cuid));
			exprList.add(new Expression("pid","> 0",null));
			PageBean<Collection> pageBean = userBiz.myCollections(exprList, pc);
			
			request.getSession().setAttribute("collectionPageBean", pageBean);
			
			response.sendRedirect("PageSkip?page=all/mycollections.jsp");
	}

}
