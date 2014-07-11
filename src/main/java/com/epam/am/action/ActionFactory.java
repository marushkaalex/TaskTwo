package com.epam.am.action;

import com.epam.am.entity.Text;
import com.epam.am.helper.TextLogic;
import com.epam.am.parser.SimpleTextParser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    public static final String PARSE = "parse";
    private static final Map<String, Action> actions = new HashMap<>();

    static {
        actions.put(PARSE, request -> {
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Text text = SimpleTextParser.parseText(request.getParameter("text"));
            request.setAttribute("text", text);
            request.setAttribute("logic", new TextLogic());
            return "/result.jsp";
        });
    }

    private ActionFactory() {
    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
