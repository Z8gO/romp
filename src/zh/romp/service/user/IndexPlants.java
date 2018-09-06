/*
 * 项目名:      romp系统
 * 文件名:      IndexPlants.java
 * 类名:        IndexPlants
 */
package zh.romp.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Plant;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

/**
 * 类名:		IndexPlants
 * 描述:		TODO
 * @author 	Administrator
 * @date 	2016年5月4日 上午9:56:29
 *
 */
public class IndexPlants extends HttpServlet {

	/**
	 * 变量名:		serialVersionUID
	 * 描述:			TODO
	 * 取值含义:		TODO
	 */
	private static final long	serialVersionUID	= 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IUserBiz userBiz=new UserBiz();
		
		List<Plant> indexPlants = userBiz.indexPlants();
		
		request.getSession().setAttribute("indexPlants", indexPlants);
		
		response.sendRedirect("index.jsp");
		
	}

}
