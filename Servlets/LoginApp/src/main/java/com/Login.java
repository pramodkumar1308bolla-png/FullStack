package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	RequestDispatcher rd;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("uid");
		String pswd = req.getParameter("password");
		if ((value.equals("abcd") || value.equals("abcd@gmail.com")) && pswd.equals("abc@123")) {
			rd = req.getRequestDispatcher("/home");
			Cookie c1= new Cookie("uid",value);
			c1.setMaxAge(20);
			resp.addCookie(c1);
			resp.sendRedirect("home");	
//			resp.setContentType("text/html");
//			resp.getWriter().println("<a href=\"home\">Home Page</a>");
			} 
		else {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1>Invalid Username And Password</h1>");
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}

	}

}
