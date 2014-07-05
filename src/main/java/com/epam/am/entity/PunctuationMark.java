package com.epam.am.entity;

public class PunctuationMark implements SentencePart {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PunctuationMark that = (PunctuationMark) o;

        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mark != null ? mark.hashCode() : 0;
    }

    @Override
    public PunctuationMark deepClone() {
        return new PunctuationMark(getMark());
    }
}
