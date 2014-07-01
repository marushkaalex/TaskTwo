package com.epam.am.entity;

public class PunctuationMark extends SentenceContent {
    private final char mark;

    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    public PunctuationMark(String str) {
        this.mark = str.charAt(0);
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "PunctuationMark{" +
                mark +
                '}';
    }
}
