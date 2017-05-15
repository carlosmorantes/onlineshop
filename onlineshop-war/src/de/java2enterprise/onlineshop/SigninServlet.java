package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.java2enterprise.onlineshop.model.Customer;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
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
		
		final PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		
		if(email.equals(customerEmail) && password.equals(customerPassword))
			out.println("Benutzer ist valide!");
		else
			out.println("Benutzer ist nicht valide");
		
		out.println("</body>");
		out.println("</html>");		
			
		
	}
}
