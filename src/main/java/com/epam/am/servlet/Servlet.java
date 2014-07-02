package com.epam.am.servlet;

import com.epam.am.entity.Paragraph;
import com.epam.am.helper.TextParser;

import java.io.IOException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Paragraph paragraph = new Paragraph();
        TextParser.readParagraph(request.getParameter("text"), paragraph);
        request.setAttribute("par", paragraph);
        response.getWriter().write(paragraph.toString());
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Paragraph paragraph = new Paragraph();
        TextParser.readParagraph(request.getParameter("text"), paragraph);
        response.getWriter().write(paragraph.toString());
    }
}
