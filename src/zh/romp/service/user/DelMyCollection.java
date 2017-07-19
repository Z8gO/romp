package zh.romp.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.User;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
/**
 * 
 * 类名:		DelMyCollection
 * 描述:		用户删除自己的收藏的服务类
 * @author 	张煌
 * @date 	2016年4月11日 下午4:36:54
 *
 */
public class DelMyCollection extends HttpServlet {

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
		int cid=Integer.parseInt(request.getParameter("cid"));
		
		User u=(User)request.getSession().getAttribute("user");
		int cuid=u.getUid();
		userBiz.delCollection(cid);
		
		response.sendRedirect("FindMyCollections?pc=1&cuid="+cuid);
	}

}
