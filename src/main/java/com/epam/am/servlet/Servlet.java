package com.epam.am.servlet;

import com.epam.am.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.getWriter().write(paragraph.toString());
        String redirect = ActionFactory.getAction(ActionFactory.PARSE).execute(request);
        request.getRequestDispatcher(redirect).forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.service(req, resp);
        String redirect = ActionFactory.getAction(ActionFactory.PARSE).execute(req);
        req.getRequestDispatcher(redirect).forward(req, resp);

    }
}
