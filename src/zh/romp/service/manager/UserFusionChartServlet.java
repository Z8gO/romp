/*
 * 项目名:      romp系统
 * 文件名:      FusionChartServlet.java
 * 类名:        FusionChartServlet
 *
 */
package zh.romp.service.manager;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.ChartCount;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;
import zh.romp.util.RGBColors;
import zh.romp.util.UserRoles;

/**
 * 类名:		FusionChartServlet
 * 描述:		TODO
 * @author 	Administrator
 * @date 	2016年5月6日 下午3:34:54
 */
public class UserFusionChartServlet extends HttpServlet {

	/**
	 * 变量名:		serialVersionUID
	 * 描述:			TODO
	 * 取值含义:		TODO
	 */
	private static final long	serialVersionUID	= 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		this.doPost(request, response);
	}

			public void doPost(HttpServletRequest request,
					HttpServletResponse response) 
			throws ServletException, IOException {
				IUserBiz userBiz=new UserBiz();
				ArrayList<ChartCount> list =new ArrayList<ChartCount>(); 
				UserRoles ur=new UserRoles();
				RGBColors rc=new RGBColors();
				list=(ArrayList<ChartCount>) userBiz.userChart();
				// 模拟格式化数据// 组装数据
				StringBuffer xmlstr = new StringBuffer();
				xmlstr.append("<graph  caption='系统未冻结状态账号角色数量统计图' "
				+"   xAxisName='角色' showNames='1'  "
						+"  formatNumberScale='0'>");
				for (int i = 0; i < list.size(); i++) {
			    xmlstr.append("<set  name='"+ur.getR(list.get(i).getChartKeys())
							+"' value='"+list.get(i).getNumber()+
							"'  color='"+rc.getC(list.get(i).getChartKeys())+"'/>");
               }
				xmlstr.append("</graph>");
				request.getSession().setAttribute("xmlstr", xmlstr);
				response.sendRedirect("PageSkip?page=manager/userCharts.jsp");
	}
}
