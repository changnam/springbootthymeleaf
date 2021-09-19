package com.honsoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServlet extends HttpServlet {
	private static Logger logger = LoggerFactory.getLogger(MyServlet.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info(Thread.currentThread().getName());
		PrintWriter writer = resp.getWriter();
		writer.write("This is output from MyServlet");
	}

}
