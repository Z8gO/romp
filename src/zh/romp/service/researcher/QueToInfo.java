package zh.romp.service.researcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.dao.IPlantDao;
import zh.romp.dao.ITuJianPlantDao;
import zh.romp.dao.impl.PlantDao;
import zh.romp.dao.impl.TuJianPlantDao;
import zh.romp.entity.Plant;
import zh.romp.entity.User;
import zh.romp.util.GetTime;

public class QueToInfo extends HttpServlet {

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
		User user=(User) request.getSession().getAttribute("user");
		
		String zwword=request.getParameter("zwword");
		String ywword=request.getParameter("ywword");
		String ldword=request.getParameter("ldword");
		String ke=request.getParameter("ke");
		String xw=request.getParameter("xw");
		String gj=request.getParameter("gj");
		String zzgn=request.getParameter("zzgn");
		String usage=request.getParameter("yfyl");
		String yybw=request.getParameter("yybw");
		String pdemo=request.getParameter("bz");
		String picpath=request.getParameter("imagepath");
		int pimguid=Integer.parseInt(request.getParameter("pimguid"));
		int imgid=Integer.parseInt(request.getParameter("imgid"));
		Plant plant=new Plant();
		
		plant.setZwword(zwword);
		plant.setYwword(ywword);
		plant.setLdword(ldword);
		plant.setXw(xw);
		plant.setKe(ke);
		plant.setGj(gj);
		plant.setZzgn(zzgn);
		plant.setYfyl(usage);
		plant.setYybw(yybw);
		plant.setPdemo(pdemo);
		plant.setPimguid(pimguid);
		plant.setPerfectuid(user.getIid());
		plant.setUploadtime(GetTime.getTime());
		plant.setPicpath(picpath);
		IPlantDao  plantDao=new PlantDao();
		ITuJianPlantDao tuJian=new TuJianPlantDao();
		boolean flag = plantDao.insert(plant);
		flag=tuJian.delQue(imgid);
		if(flag){
			response.sendRedirect("LoginSuccess");
		}
	}

}
