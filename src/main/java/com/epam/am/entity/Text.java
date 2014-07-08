package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Text implements DeepCloneable<Text> {
    private final List<Paragraph> paragraphs;

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Text() {
        paragraphs = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (!paragraphs.equals(text.paragraphs)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return paragraphs.hashCode();
    }

    @Override
    public Text deepClone() {
        Text result = new Text();
        for (Paragraph paragraph : paragraphs) {
            result.add(paragraph.deepClone());
        }
        return result;
    }
}
