package com.epam.am.action;

import com.epam.am.entity.Text;
import com.epam.am.helper.TextLogic;
import com.epam.am.parser.RegexTextParser;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public class ParseAction implements Action {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Text text = new RegexTextParser().parseText(request.getParameter("text"));
        request.setAttribute("text", text);
        request.setAttribute("logic", new TextLogic());
        return "/result.jsp";
    }
}
