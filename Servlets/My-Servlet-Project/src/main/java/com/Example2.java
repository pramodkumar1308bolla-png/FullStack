package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Example2 implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("3.Destroyed...........!!!!!!!");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("1.create and drop info.......!!!!!!!!");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2.Running Service..........");
		
		res.setContentType("Text/HTML");
		PrintWriter w=res.getWriter();
		w.println("<h1>Hello Hi Bye</h1>");
		w.println("<h1>J sPiders</h1>");

	}

}
