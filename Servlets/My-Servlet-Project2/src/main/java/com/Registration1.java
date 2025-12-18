package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Registration1 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Do Post Method");
		String ans1=req.getParameter("name");
		String ans2=req.getParameter("phno");
		String ans3=req.getParameter("email");
		resp.setContentType("Text/Html");
		PrintWriter w = resp.getWriter();
		w.println("<h1>Name:"+ans1+"</h1>");
		w.println("<h1>Phno:"+ans2+"</h1>");
		w.println("<h1>email:"+ans3+"</h1>");
	}
	
	

}
