package de.example;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


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
		ServletContext sc = request.getServletContext();
		sc.log("Forward request...");
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init filter...");

	}



}
