package com.jspprj.webcalculator;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext application = req.getServletContext();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String v_ = req.getParameter("v");
        String op = req.getParameter("operator");

        int v = 0;
        if(!v_.equals("")) v = Integer.parseInt(v_);

        // 계산
        if(op.equals("=")) {

            int x = (Integer)application.getAttribute("value");
            int y = v;
            String operator = (String)application.getAttribute("op");

            int result = 0;

            if (operator.equals("+"))
                result = x + y;
            else
                result = x - y;
            resp.getWriter().printf("Result is %d\n", result);
        }
        else{
            // 저장
            application.setAttribute("value", v);
            application.setAttribute("op", op);
        }
    }
}
