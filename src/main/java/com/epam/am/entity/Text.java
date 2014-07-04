package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private final List<Paragraph> paragraphs;

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Text() {
        paragraphs = new ArrayList<Paragraph>();
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public boolean add(Paragraph paragraph) {
        return paragraphs.add(paragraph);
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + paragraphs +
                '}';
    }

    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            sb.append(paragraph.toOriginal());
        }
        return sb.toString();
    }
}
