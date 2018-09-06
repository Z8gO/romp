/*
 * 项目名:      romp系统
 * 文件名:      FusionChartServlet.java
 * 类名:        FusionChartServlet
 *
 * Copyright (c) 2014 杭州时代银通软件有限公司
 * 版权所有
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
import zh.romp.util.PlantNames;
import zh.romp.util.RGBColors;

/**
 * 类名:		FusionChartServlet
 * 描述:		TODO
 * @author 	Administrator
 * @date 	2016年5月6日 下午3:34:54
 *
 */
public class PlantFusionChartServlet extends HttpServlet {

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
		ArrayList<ChartCount> list =new ArrayList<ChartCount>(); 
		PlantNames pn=new PlantNames();
		RGBColors rc=new RGBColors();
		list=(ArrayList<ChartCount>) userBiz.plantChat();
		// 模拟格式化数据
		// 组装数据
		StringBuffer xmlstr = new StringBuffer();
		xmlstr.append("<graph  caption='植物科目统计图'    xAxisName='科' showNames='1'    formatNumberScale='0'>");
		for (int i = 0; i < list.size(); i++) {
			xmlstr.append("<set  name='"+pn.getPlantName(list.get(i).getChartKeys()+"")+"' value='"+list.get(i).getNumber()+"'  color='"+rc.getC(list.get(i).getChartKeys())+"'/>");
        }
				xmlstr.append("</graph>");
				request.getSession().setAttribute("xmlstr", xmlstr);
				response.sendRedirect("PageSkip?page=manager/plantCharts.jsp");
	}

}
