package com.epam.am.action;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    public static final String PARSE = "parse";
    private static final Map<String, Action> actions = new HashMap<>();

    static {
        actions.put(PARSE, new ParseAction());
    }

    private ActionFactory() {
    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
