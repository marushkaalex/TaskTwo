package com.epam.am.entity;

public class WhiteSpace extends SentenceContent{
    private static final char space = ' ';
    private static final WhiteSpace instance = new WhiteSpace();

    private WhiteSpace() {}

    public static WhiteSpace getInstance() {
        return instance;
    }

    public static char getSpace() {
        return space;
    }
}
