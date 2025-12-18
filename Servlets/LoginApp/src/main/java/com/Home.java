package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	RequestDispatcher rd;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] arr=req.getCookies();
		if(arr!=null && arr.length>0 && arr[0] != null) {
			resp.setContentType("text/html");
			PrintWriter w=resp.getWriter();
			w.println("<h1>"+arr[0].getValue()+"  Meow....Meow.....!!</h1>");
			w.println("<a href=\"logout\">LogOut</a>");
		}
		else {
			resp.setContentType("text/html");
			resp.getWriter().println("<h1>Your Sesssion had expired</h1>");
			rd=req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}

}
