package com.jspprj.webcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String x_ = req.getParameter("x");
        String y_ = req.getParameter("y");

        int x = 0;
        int y = 0;

        if(!x_.equals("")) x = Integer.parseInt(x_);
        if(!y_.equals("")) y = Integer.parseInt(y_);

        int result = x+y;

        resp.getWriter().printf("Result is %d\n", result);


    }
}
