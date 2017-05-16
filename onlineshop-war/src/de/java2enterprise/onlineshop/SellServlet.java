package de.java2enterprise.onlineshop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(
		urlPatterns={"/sell"},
		asyncSupported=true)
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
		
		final AsyncContext ac = req.startAsync();
		ac.start(new FotoService(ac));		
	}
}
