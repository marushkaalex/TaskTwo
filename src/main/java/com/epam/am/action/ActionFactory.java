package com.epam.am.action;

import com.epam.am.entity.Paragraph;
import com.epam.am.helper.TextParser;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private ActionFactory() {}

    public static final String PARSE = "parse";

    private static final Map<String, Action> actions = new HashMap<String, Action>();
    static {
        actions.put(PARSE, new Action() {
            @Override
            public String execute(HttpServletRequest request) {
                try {
                    request.setCharacterEncoding("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Paragraph paragraph = new Paragraph();
                TextParser.readParagraph(request.getParameter("text"), paragraph);
                request.setAttribute("par", paragraph);
                return "/result.jsp";
            }
        });
    }

    public static Action getAction(String actionName){
        return actions.get(actionName);
    }
}
