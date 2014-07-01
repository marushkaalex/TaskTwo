package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private final List<SentenceContent> words;

    public Sentence(List<SentenceContent> words) {
        this.words = words;
    }

    public Sentence() {
        words = new ArrayList<SentenceContent>();
    }

    public List<SentenceContent> getWords() {
        return words;
    }

    public boolean add(SentenceContent word) {
        return words.add(word);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                '}';
    }
}
