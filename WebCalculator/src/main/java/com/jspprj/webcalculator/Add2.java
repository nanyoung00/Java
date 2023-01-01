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

        String[] num_ = req.getParameterValues("num");

        int result = 0;

        for(int i=0; i<num_.length; i++) {
            int num = Integer.parseInt(num_[i]);
            result += num;
        }

        resp.getWriter().printf("Result is %d\n", result);


    }
}
