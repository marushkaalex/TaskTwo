package com.epam.am.entity;

public class PunctuationMark extends SentenceContent {
    private final char mark;

    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    public PunctuationMark(String str) {
        char tmp = '@';
        for (int i = 0; i < str.length(); i++) {
            if (!" ".equals(str.charAt(i))) {
                tmp = str.charAt(i);
            }
        }
        this.mark = tmp;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "{" +
                mark +
                '}';
    }
}
