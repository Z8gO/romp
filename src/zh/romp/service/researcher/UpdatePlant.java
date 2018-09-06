/*
 * 项目名:      **系统
 * 文件名:      UpdatePlant.java
 * 类名:        UpdatePlant
 *
 */
package zh.romp.service.researcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.Plant;
import zh.romp.userBiz.IUserBiz;
import zh.romp.userBiz.impl.UserBiz;

/**
 * 类名:		UpdatePlant
 * 描述:		TODO
 * @author 	Administrator
 * @date 	2016年4月15日 下午3:37:16
 *
 */
public class UpdatePlant extends HttpServlet {

    /**
	 * 变量名:		serialVersionUID
	 * 描述:			TODO
	 * 取值含义:		TODO
	 */
	private static final long	serialVersionUID	= 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Plant p1=new Plant();
        int pid=Integer.parseInt(request.getParameter("pid"));
        
        p1.setPid(pid);
        p1.setZzgn(request.getParameter("zzgn"));
        p1.setYfyl(request.getParameter("yfyl"));
        p1.setPdemo(request.getParameter("pdemo"));
        IUserBiz userBiz=new UserBiz();
        boolean updatePlant = userBiz.updatePlant(p1);
        PrintWriter out = response.getWriter();
        if(updatePlant){
            Plant p=(Plant)request.getSession().getAttribute("plant");
            p.setZzgn(request.getParameter("zzgn"));
            p.setYfyl(request.getParameter("yfyl"));
            p.setPdemo(request.getParameter("pdemo"));
         //request.getSession().setAttribute("plant", p);
            //System.out.println(p.toString());
            out.write("修改成功！");
        }
                else{
            out.write("修改失败！");
            }
    }

}
