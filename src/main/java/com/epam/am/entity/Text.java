package com.epam.am.entity;

import java.util.List;

public class Text extends AbstractCompoundText<Paragraph> implements DeepCloneable<Text> {

    public Text(List<Paragraph> paragraphs) {
        super(paragraphs);
    }

    public Text() {
        super();
    }

    public List<Paragraph> getParagraphs() {
        return components;
    }

    public boolean add(Paragraph paragraph) {
        return components.add(paragraph);
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphs=" + components +
                '}';
    }

    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (Paragraph paragraph : components) {
            sb.append(paragraph.toOriginal());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text = (Text) o;

        if (!components.equals(text.components)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    @Override
    public Text deepClone() {
        Text result = new Text();
        for (Paragraph paragraph : components) {
            result.add(paragraph.deepClone());
        }
        return result;
    }
}
