package zh.romp.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 类名:		PageSkip
 * 描述:		页面跳转时用到的Servlet，因为跳转进的是WEB-INF中的页面
 * @author 	Administrator
 * @date 	2016年4月11日 下午4:18:32
 */
public class PageSkip extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	/** page参数是目标页面的路径名称，通过请求跳转访问目标资源*/
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
			String page=request.getParameter("page");
			request.getRequestDispatcher("WEB-INF/"
			+page).forward(request, response);
	}
}
