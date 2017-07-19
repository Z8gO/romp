package zh.romp.service.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Plant;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
import zh.romp.util.PlantNames;
/**
 * 
 * 类名:		Compare
 * 描述:		教师用作比较两个植物信息的服务类
 * @author 	Administrator
 * @date 	2016年4月11日 下午4:28:58
 *
 */
@SuppressWarnings("serial")
public class Compare extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取到用户输入的植物名称
		String zwword=	request.getParameter("zwword");
		String zwword2=	request.getParameter("zwword2");
		IUserBiz  userBiz=new UserBiz();
		PlantNames plantName=new PlantNames();
		Plant plant1 = userBiz.getPlantByname(zwword);
		//调用查询方法
		plant1.setKe(plantName.getPlantName(plant1.getKe()));
		Plant plant2 = userBiz.getPlantByname(zwword2);
		plant2.setKe(plantName.getPlantName(plant2.getKe()));
		//存入Session
		request.getSession().setAttribute("plant1", plant1);
		request.getSession().setAttribute("plant2", plant2);
		response.sendRedirect("PageSkip?page=teacher/towplant.jsp");
		
	}

}
