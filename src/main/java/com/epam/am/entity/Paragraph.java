package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private final List<Sentence> sentences;

    public Paragraph(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Paragraph() {
        sentences = new ArrayList<Sentence>();
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
        return "Paragraph{" +
                "sentences=" + sb.toString() +
                '}';
    }
}
