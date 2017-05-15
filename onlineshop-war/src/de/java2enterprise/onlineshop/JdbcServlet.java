package de.java2enterprise.onlineshop;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		final String driver = getInitParameter("driver");
		final String url = getInitParameter("url");
		final String username =	getInitParameter("username");
		final String password =	getInitParameter("password");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println(
				"<br>driver: " + driver);
		out.println(
				"<br>url: " + url);
		out.println(
				"<br>username: " + username);
		out.println(
				"<br>password: " + password);
		out.println("</body>");
		out.println("</html>");
	}
}