package com.backend.practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/simpleCalc")
public class SimpleCalculator extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
							throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=utf-8>");
		out.println("<title>Servlet Web Calculator</title>");
		out.println("</head>");
		out.println("<body>");
			out.println("<h1>Put in Number</h1>");
			out.println("<form action=\"simpleCalc\" method=\"post\">");
				out.println("<div>");
					out.println("<input type=\"text\" name=\"val1\" />");
				out.println("</div>");
				out.println("<div>");
					out.println("<input type=\"text\" name=\"val2\" />");
				out.println("</div>");
				out.println("<div>");
					out.println("<input type=\"submit\" name=\"submit\" value=\"plus\" />");
				out.println("</div>");
				out.println("<div>");
					out.println("<input type=\"submit\" name=\"submit\" value=\"sub\" />");
				out.println("</div>");
				out.println("<div>");
					out.println("<input type=\"submit\" name=\"submit\" value=\"mul\" />");
				out.println("</div>");
				out.println("<div>");
					out.println("<input type=\"submit\" name=\"submit\" value=\"divide\" />");
				out.println("</div>");
			out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
								throws ServletException, IOException {
		String x_ = request.getParameter("val1");
		String y_ = request.getParameter("val2");
		String result_ = request.getParameter("submit");
		
		int x = 0;
		int y = 0;
		int result = 0;
		
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		if(result_.equals("plus")) result = x+y;
		if(result_.equals("sub")) result = x-y;
		if(result_.equals("mul")) result = x*y;
		if(result_.equals("divide")) result = x/y;
		
		PrintWriter outRe = response.getWriter();
		outRe.println("<html><title>Calculate Result</title>");
		outRe.println("<body><h1>Result is</h1>");
		outRe.println(result);
		outRe.println("</body></html>");
		
		

		}
		
	}
	
	

