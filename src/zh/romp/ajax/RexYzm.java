package zh.romp.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RexYzm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String code=request.getParameter("code").toLowerCase();
		
		String vCode=((String)request.getSession().getAttribute("vCode")).toLowerCase();
		
		PrintWriter out = response.getWriter();
		if(!(code.equals(vCode))){
			out.write("验证码错误");
		}else{
			out.write("验证码正确");
		}
	}

}
