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
/**
 * 
 * 类名:		LikeQueryWithPlant
 * 描述:		模糊查询的服务类
 * @author 	张煌
 * @date 	2016年4月11日 下午4:37:51
 *
 */
public class LikeQueryWithPlant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String zwword=	request.getParameter("zwword");
			String  ywword=request.getParameter("ywword");
			String  ldword=request.getParameter("ldword");
			String  ke=request.getParameter("ke");
			String xw =request.getParameter("xw");
			String  gj=request.getParameter("gj");
			String  zzgn=request.getParameter("zzgn");
			String  yfyl=request.getParameter("yfyl");
			String  yybw=request.getParameter("yybw");
			int pc=Integer.parseInt(request.getParameter("pc"));
			
			IUserBiz userBiz=new UserBiz();
			List<Expression> exprList=new ArrayList<Expression>();
			exprList.add(new Expression("zwword","like","%"+zwword+"%"));
			exprList.add(new Expression("ywword","like","%"+ywword+"%"));
			exprList.add(new Expression("ldword","like","%"+ldword+"%"));
			exprList.add(new Expression("ke","like","%"+ke+"%"));
			exprList.add(new Expression("xw","like","%"+xw+"%"));
			exprList.add(new Expression("gj","like","%"+gj+"%"));
			exprList.add(new Expression("zzgn","like","%"+zzgn+"%"));
			exprList.add(new Expression("yfyl","like","%"+yfyl+"%"));
			exprList.add(new Expression("yybw","like","%"+yybw+"%"));
			exprList.add(new Expression("pid","> 0",null));
			PageBean<Plant> pageBean = userBiz.findAllPlant(exprList, pc);
			request.getSession().setAttribute("plantPageBean", pageBean);
			response.sendRedirect("PageSkip?page=all/allplants.jsp");
	}

}
