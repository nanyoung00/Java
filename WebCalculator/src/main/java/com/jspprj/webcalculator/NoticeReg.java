package com.jspprj.webcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        // req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        out.println(title);
        out.println(content);
        }
    }

