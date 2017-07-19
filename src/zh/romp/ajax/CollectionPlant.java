package zh.romp.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Collection;
import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
import zh.romp.util.GetTime;

public class CollectionPlant extends HttpServlet {

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
		String planname=request.getParameter("planname");
		
		
		User user =(User)request.getSession().getAttribute("user");
		if(user==null){
		    response.sendRedirect("LoginSuccess");
		}
		
		PrintWriter out = response.getWriter();
		Collection coll;
		if(user!=null){
		 coll = userBiz.findCollectionByNameAndUid(planname,user.getUid()+"");
		if(coll!=null){
			out.write("您已经收藏过这种植物了！");
			return;
		}
	}
		Collection collection=new Collection();
		int pid=Integer.parseInt(request.getParameter("pid"));
		collection.setCdate(GetTime.getTime());
		collection.setCuid(user.getUid());
		collection.setPname(planname);
		collection.setPid(pid);
		boolean flag = userBiz.addCollection(collection);
		
		if(flag){
			out.write("收藏成功！");
		}else{
			out.write("收藏失败！");
		}
	}

}
