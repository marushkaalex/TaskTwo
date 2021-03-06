package com.epam.am.entity;

public class WhiteSpace implements SentencePart {
    private static final char space = ' ';
    private static final WhiteSpace instance = new WhiteSpace();

    private WhiteSpace() {
    }

    public static WhiteSpace getInstance() {
        return instance;
    }

    public static char getSpace() {
        return space;
    }

    @Override
    public String toString() {
        return "{ }";
    }

    @Override
    public String toOriginal() {
        return " ";
    }

    @Override
    public WhiteSpace deepClone() {
        return getInstance();
    }
}
