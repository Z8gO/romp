package zh.romp.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.dao.IPlantDao;
import zh.romp.dao.impl.PlantDao;

public class RexPlanname extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String zwword=request.getParameter("planname").trim();
		if("".equals(zwword)){
			out.write("请输入中文名称");
			return;
		}
		IPlantDao plantDao=new PlantDao();
		boolean flag = plantDao.getPlantByName(zwword);
		if(flag){
			out.write("感谢您数据库中现在不存在该植物");
		}else{
			out.write("抱歉，该中文名的植物已经存在");
		}
					
	}

}
