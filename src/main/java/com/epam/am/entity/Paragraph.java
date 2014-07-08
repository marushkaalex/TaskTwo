package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements DeepCloneable<Paragraph> {
    private final List<Sentence> sentences;

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Paragraph() {
        sentences = new ArrayList<>();
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public boolean add(Sentence sentence) {
        return sentences.add(sentence);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append("\n" + sentence);
        }
        return "\n\nParagraph{" +
                "sentences=" + sb.toString() +
                '}';
    }

    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toOriginal());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paragraph paragraph = (Paragraph) o;

        if (!sentences.equals(paragraph.sentences)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sentences.hashCode();
    }

    @Override
    public Paragraph deepClone() {
        Paragraph result = new Paragraph();
        for (Sentence sentence : sentences) {
            result.add(sentence.deepClone());
        }
        return result;
    }

    public Text asText() {
        Text result = new Text();
        result.add(this);
        return result;
    }
}
