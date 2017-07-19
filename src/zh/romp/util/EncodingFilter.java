package zh.romp.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class EncodingFilter implements Filter {

	private FilterConfig config;
	private Logger logger=Logger.getLogger(EncodingFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	//    logger.info("开始对请求和响应的资源进行编码拦截过滤！");
		HttpServletRequest request1 = (HttpServletRequest) request;
		HttpServletResponse response1 = (HttpServletResponse) response;
		String encoding = config.getInitParameter("ENCODING");
		if (encoding.equals("")){
			encoding = "UTF-8";
		  logger.info(
		 "在WEB.XML中没有编码设置，编码拦截器设置编码为"+encoding);
		  }
		request1.setCharacterEncoding(encoding);
		response1.setCharacterEncoding(encoding);
		chain.doFilter(request1, response1);
	}

	@Override
	public void destroy() {
	}

}
