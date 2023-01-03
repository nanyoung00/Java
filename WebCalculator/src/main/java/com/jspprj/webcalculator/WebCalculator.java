package com.jspprj.webcalculator;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


@WebServlet("/webCalc")
public class WebCalculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();


        // 입력 인자들을 가져옴
        String value = req.getParameter("value");
        String op = req.getParameter("operator");
        String dot = req.getParameter("dot");

        String exp = "";

        // 쿠키에 저장한 계산식 가지고옴
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("exp")) {
                    exp = c.getValue();
                    break;
                }
            }
        }

        // = -> 계산
        if (op != null && op.equals("=")) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
            try {
                engine.eval(exp);
            } catch (ScriptException e) {
                throw new RuntimeException(e);
            }
        }
        // = 아니면 계산식 연결
        else {
            exp += (value == null) ? "" : value;
            exp += (op == null) ? "" : op;
            exp += (dot == null) ? "" : dot;
        }
        Cookie expCookie = new Cookie("exp", exp);
        if (op != null && (op.equals("CE") || op.equals("C"))) {
            expCookie.setMaxAge(0);
        }
        expCookie.setPath("/webCalc");
        resp.addCookie(expCookie);
        resp.sendRedirect("/webCalc");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String exp = "0";
        // 계산식 쿠키 가지고옴
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("exp")) {
                    exp = c.getValue();
                    break;
                }
            }
        }
       PrintWriter out = resp.getWriter();

        out.write("<!DOCTYPE html");
        out.write("<html>");
        out.write("<head>");
        out.write("<meta charset=\"UTF-8\">");
        out.write("<title>calc</title>");
        out.write("<style>");
        out.write("input {");
        out.write("width: 50px;");
        out.write("height: 50px;");
        out.write("}");
        out.write(".output{");
        out.write("height: 50px;");
        out.write("background: #e9e9e9;");
        out.write("font-size: 24px;");
        out.write("font-weight: bold;");
        out.write("text-align: right;");
        out.write("padding: 0px, 5px;");

        out.write("}");
        out.write("</style>");
        out.write("</head>");
        out.write("<body>");
        out.write("<form method=\"post\">");
        out.write("<table>");
        out.write("<tr>");
        out.printf("<td class = \"output\" colspan=\"4\">%s</td>",exp);
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"CE\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"C\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"BS\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"/\"></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"7\"></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"8\"></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"9\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"*\"></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"4\"></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"5\"></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"6\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"-\"></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"1\"></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"2\"></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"3\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"+\"></td>");
        out.write("</tr>");
        out.write("<tr>");
        out.write("<td></td>");
        out.write("<td><input type=\"submit\" name = \"value\" value=\"0\"></td>");
        out.write("<td><input type=\"submit\" name = \"dot\" value=\".\"></td>");
        out.write("<td><input type=\"submit\" name = \"operator\" value=\"=\"></td>");
        out.write("</tr>");
        out.write("</table>");
        out.write("</form>");
        out.write("</body>");
        out.write("</html>");
    }
}

