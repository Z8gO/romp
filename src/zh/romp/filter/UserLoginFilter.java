package zh.romp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zh.romp.entity.User;

/**
 * 
 * 类名:		UserLoginFilter
 * 描述:		检验在Session中的是不是叫User类型的，有的话才可以去访问项目
 * @author 	张煌
 * @date 	2016年4月11日 下午5:02:03
 *
 */
public class UserLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		User flag=(User) request2.getSession().getAttribute("user");
		if (flag==null) {
			response2.sendRedirect("IndexPlants");
		}else{
			chain.doFilter(request2, response2);
		}	
	}

	@Override
	public void destroy() {
	}

}
