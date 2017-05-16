package de.java2enterprise.onlineshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/sell")
//max. size per file and total size
//save in disk if the memory is full
@MultipartConfig(
		location="/tmp",
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*10, 
		maxRequestSize=1024*1024*30)
public class SellServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		final String title = req.getParameter("title");
		final String description = req.getParameter("description");
		final String price = req.getParameter("price");

		final Part part = req.getPart("foto");
		OutputStream os = null;
		InputStream is = null;

		try {
			//path to save the picture
			String path = "/tmp/"
					+ part.getSubmittedFileName();
			File file = new File(path);
			os = new FileOutputStream(file);
			byte[] b = new byte[1024];
			int i = 0;
			is = part.getInputStream();
			while ((i = is.read(b)) != -1) {
				os.write(b, 0, i);
			}
		} catch (Exception ex) {
			throw new ServletException(
					ex.getMessage());
		} finally {
			os.close();
			is.close();
		}

		final PrintWriter out = resp.getWriter();

		out.println("<!DOCTYPE HTML>");
		out.println("Content-Type: " +part.getContentType() +"<br>");
		out.println("Size: "+part.getSize() + "<br>");
		out.println("Name: " +part.getName() + "<br>");
		out.println("Filename: " +part.getSubmittedFileName() + "<br>");
	}
}
