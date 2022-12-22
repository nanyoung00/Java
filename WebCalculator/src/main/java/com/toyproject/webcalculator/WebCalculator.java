package com.toyproject.webcalculator;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/")
public class WebCalculator extends HttpServlet {
    /* 우선 직렬화 */
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.write("<!DOCTYPE html>");
        out.write("<html>");
        out.write("<head>");
        out.write("<meta charset=\"utf-8\">");
        out.write("<title>Web Calculator</title>");
        out.write("<Style>");
        out.write("body {");
        out.write("background-color: #f6f9fc;");
        out.write("display: flex;");
        out.write("justify-content: center;");
        out.write("align-items: center;");
        out.write("}");
        out.write("input{");
        out.write("	width:50px;");
        out.write("	height:50px;");
        out.write("}");
        out.write("table {");
        out.write("background: white;");
        out.write("}");
        out.write(".output{");
        out.write("	height:50px;");
        out.write("	backgroud-color: #e9e9e9;");
        out.write("	font-size:24px;");
        out.write("	font-width:bold;");
        out.write("	text-align:right;");
        out.write("	padding:0px 5px;");
        out.write("}");

        out.write("</Style>");
        out.write("</head>");
        out.write("<body>");
        out.write("<form action=\"calc\" method=\"post\">");
        out.write("<table>");
        /* output */
        out.write("<tr>");
        out.printf("<td class=\"output\" colspan=\"4\">%s</td>", 1+2);
        out.write("</tr>");
        /* (,),%,AC */
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"(\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\")\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"%\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"AC\"></td>");
        out.write("</tr>");
        /* 7,8,9,÷ */
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"7\"></td>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"8\"></td>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"9\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"÷\"></td>");
        out.write("</tr>");
        /* 4,5,6,x */
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"4\"></td>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"5\"></td>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"6\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"x\"></td>");
        out.write("</tr>");
        /* 1,2,3,- */
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"1\"></td>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"2\"></td>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"3\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"-\"></td>");
        out.write("</tr>");
        /* 0,.,=,+ */
        out.write("<tr>");
        out.write("<td><input type=\"submit\" name=\"number\" value=\"0\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\".\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"=\"></td>");
        out.write("<td><input type=\"submit\" name=\"operator\" value=\"+\"></td>");
        out.write("</tr>");
        out.write("</table>");
        out.write("</body>");
        out.write("</html>");
    }

}