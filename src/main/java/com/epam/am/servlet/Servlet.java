package com.epam.am.servlet;

import com.epam.am.action.ActionFactory;
import com.epam.am.entity.Paragraph;
import com.epam.am.helper.TextParser;

import java.io.IOException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.getWriter().write(paragraph.toString());
        String redirect = ActionFactory.getAction(ActionFactory.PARSE).execute(request);
        request.getRequestDispatcher(redirect).forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Paragraph paragraph = new Paragraph();
        TextParser.readParagraph(request.getParameter("text"), paragraph);
        response.getWriter().write(paragraph.toString());
    }
}
