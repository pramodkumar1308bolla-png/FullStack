package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mul")

public class MulServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a=Integer.parseInt(req.getParameter("a"));
		int b=Integer.parseInt(req.getParameter("b"));
		int mul=a*b;
		resp.setContentType("text/html");
		PrintWriter w=resp.getWriter();
		System.out.println("Value:"+req.getAttribute("sum"));
		w.println("<h1 style =\"text-align: center;color:red;\"> Sum:" + req.getAttribute("sum")+"</h1>");
		w.println("<h1 style =\"text-align: center;color:red;\"> Mul:" + mul+"</h1>");
	}
	
	

}
