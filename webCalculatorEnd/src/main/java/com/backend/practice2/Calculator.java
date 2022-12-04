package com.backend.practice2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		
			Cookie[] cookies = request.getCookies(); // 쿠키를 배열로 받아냄
		
			// 쿠키를 읽어내는 코드
			String exp = "0"; // expression, 쿠키에 저장되는 것은 연산식. 그대로 읽어와서 구현하는 방식. null 인 경우 0을 반환
			if(cookies != null) { // 쿠키가 null인 경우를 생각해 아닐 경우에만 실행하도록 함
				for(Cookie c : cookies) { // 쿠키 변수를 선언 -> 갯수만큼 반복한다
					if(c.getName().equals("exp")) {
						exp = c.getValue();
						break;
					}
				}
			}
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>Web Calculator</title>");
			
			out.write("<style>");
			out.write("input{");
			out.write("	width:50px;");
			out.write("	height:50px;");
			out.write("}");
			out.write(".output{");
			out.write("	height:50px;");
			out.write("	background: #e9e9e9;");
			out.write("	font-size:24px;");
			out.write("	font-weight:bold;");
			out.write("	text-align:right;");
			out.write("	padding:0px 5px;");
			out.write("}");
			out.write("</style>");
			out.write("</head>");
			out.write("<body>");
			out.write("	<form  method=\"post\">");
			out.write("<table>");
			out.write("<tr>");
			out.printf("	<td class=\"output\" colspan=\"4\">%s</td>", exp); // 출력할땐 문자열로 출력함
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"CE\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"C\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"BS\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"/\"></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"7\"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"8\"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"9\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"*\"></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"4\"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"5\"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"6\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"1\"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"2\"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"3\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
			out.write("</tr>");
			out.write("<tr>");
			out.write("<td><input type=\"submit\" name=\"empty\" value=\" \"></td>");
			out.write("<td><input type=\"submit\" name=\"value\" value=\"0\"></td>");
			out.write("<td><input type=\"submit\" name=\"dot\" value=\".\"></td>");
			out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
			out.write("</tr>");
			out.write("</table>");
			out.write("</form>");
			out.write("</body>");
			out.write("</html>");
			
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		String dot = request.getParameter("dot");
		
		// 값들을 읽어옴
		String exp = ""; // 초기값
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
			}
		}
		// 조건검사(계산)
		if(operator != null && operator.equals("=")) {
			
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn"); // 문제인 부분
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch(ScriptException e) {
				e.printStackTrace();
			}
			} else if (operator != null && operator.equals("C")) {
				exp = "";
			} else {
			// 덧붙이는 작업(누적)
			exp += (value == null) ? "" : value;
			exp += (operator == null) ? "" : operator;
			exp += (dot == null) ? "" : dot;
		}
					
		
		// 쿠키를 저장함
		Cookie expCookie = new Cookie("exp", exp);
		if(operator != null && operator.equals("C")) {
			expCookie.setMaxAge(0); // 쿠키가 남지 않고 바로 없어짐
		}
		expCookie.setPath("/calculator"); // 전역범위 내에서만 받을 수 있게 함
		response.addCookie(expCookie);
		response.sendRedirect("calculator"); // 자기가 자기페이지로 바꿀 수 있게
		
	}
	
}
