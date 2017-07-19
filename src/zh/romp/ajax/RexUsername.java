package zh.romp.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.dao.IUserDao;
import zh.romp.dao.impl.UserDao;
/**
 * 
 * 类名:		RexUsername
 * 描述:		AJAX进行检验用户名是否可用
 * @author 	张煌
 * @date 	2016年4月11日 下午5:10:20
 *
 */
public class RexUsername extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		if("".equals(username)){
			out.write("用户名不能为空");
			return;
		}
		IUserDao dao=new UserDao();
		boolean f=dao.findUser(username);
		if(f){
			out.write("恭喜您用户名可用");
		}else{
			out.write("用户名已存在");
		}
	}
}
