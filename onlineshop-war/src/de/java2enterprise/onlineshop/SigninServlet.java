package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		final HttpSession session = req.getSession();
		final Customer customer = (Customer) session.getAttribute("customer");		
		final String customerEmail = customer.getEmail();
		final String customerPassword = customer.getPassword();
		 

		/*String cookieEmail = null;
		String cookiePassword = null;

		ServletOutputStream out = resp.getOutputStream();		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>Cookie-Name</td>");
		out.println("<td>Cookie-Value</td>");
		out.println("</td>");

		Cookie[] cookies = req.getCookies();
		for(Cookie cookie:cookies){
			String name = cookie.getName();
			String value = cookie.getValue();
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");

			if("email".equals(name)) {
				cookieEmail = value;
			} else if("password".equals(name)) {
				cookiePassword = value;
			}
		}
		out.println("</table>");

		if(email.equals(cookieEmail) && password.equals(cookiePassword)
				) {
			out.println(
					"<h1>Benutzer ist valide!</h1>");
		} else {
			out.println(
					"<h1>Benutzer ist nicht valide!</h1>");
		}
		out.println("</body>");
		out.println("</html>");*/

		PrintWriter out = resp.getWriter();	

		if(email.equals(customerEmail) && password.equals(customerPassword))
			out.println("Benutzer ist valide!");
		else
			out.println("Benutzer ist nicht valide");

		out.println("</body>");
		out.println("</html>");
		 	


	}
}
