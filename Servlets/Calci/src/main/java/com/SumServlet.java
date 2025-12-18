package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class SumServlet extends HttpServlet{
	RequestDispatcher requestdispatcher;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int a=Integer.parseInt(req.getParameter("a"));
			int b=Integer.parseInt(req.getParameter("b"));
			int sum=a+b;
			req.setAttribute("sum", sum);
			requestdispatcher=req.getRequestDispatcher("/mul");
			requestdispatcher.forward(req, resp);
		}catch(Exception e) {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1>Invalid Data.Date is Invalid</h1>");
			requestdispatcher=req.getRequestDispatcher("/index.html");
			requestdispatcher.include(req, resp);
			
			
		}
		
			
		
	}
	
	

}
