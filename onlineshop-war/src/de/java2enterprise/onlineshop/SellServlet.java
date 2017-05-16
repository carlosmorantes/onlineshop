package de.java2enterprise.onlineshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/sell")
@MultipartConfig
public class SellServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		final Part part = req.getPart("foto");
		final PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE HTML>");
		out.println("Content-Type: " +part.getContentType() +"<br>");
		out.println("Size: "+part.getSize() + "<br>");
		out.println("Name: " +part.getName() + "<br>");
		out.println("Filename: " +part.getSubmittedFileName() + "<br>");
	}
}
