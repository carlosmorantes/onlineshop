package de.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(
		urlPatterns={"/example"},
		filterName="Example filter",
		description="This is a example filter"
		)
public class FilterExample implements Filter {

	@Override
	public void destroy() {
		System.out.println("Destroy filter...");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String code = request.getParameter("code");
		
		if ("loca123".equals(code)){
			chain.doFilter(request, response);
		}else{
			String ip = request.getRemoteAddr();
			final HttpServletRequest httpServletRequest = (HttpServletRequest) request; 
			String uri = httpServletRequest.getRequestURI();
			ServletContext sc = request.getServletContext();
			sc.log("Prohibited access to: " +ip +" when requesting "+uri);
			//choose where to redirect
			RequestDispatcher dispatcher = request.getRequestDispatcher("errorCode.jsp");
			//activate the redirection
			dispatcher.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init filter...");

	}



}
