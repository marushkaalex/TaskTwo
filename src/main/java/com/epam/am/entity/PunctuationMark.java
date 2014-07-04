package com.epam.am.entity;

public class PunctuationMark implements SentenceContent {
    private final String mark;

    public PunctuationMark(char mark) {
        this.mark = String.valueOf(mark);
    }

    public PunctuationMark(String str) {
        this.mark = str;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "p{" +
                mark +
                '}';
    }

    @Override
    public String toOriginal() {
        return String.valueOf(mark);
    }
}
