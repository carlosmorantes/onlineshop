package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		log("RegisterServlet init...");
		//super.init();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		//resp.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
		//resp.setHeader("Location", "sigin.html");
		
		
		final String email = req.getParameter("email");
		final String password = req.getParameter("password");		
		final PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<br>Ihre eingegeben:");
		out.println("<br>E-Mail: " + email);
		out.println("<br>Passwort: " + password);
		out.println("</body>");
		out.println("</html>");

	}
}