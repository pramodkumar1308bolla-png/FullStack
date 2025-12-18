package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 @WebServlet("/logout")
public class Logout extends HttpServlet{
	RequestDispatcher rd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] arr=req.getCookies();
		if(arr!=null && arr.length>0 && arr[0] != null) {
			arr[0].setMaxAge(0);
			resp.addCookie(arr[0]);
			resp.sendRedirect("index.html");
		}
		else {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1>Your Sesssion had expired</h1>");
			rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}
	
	

}
