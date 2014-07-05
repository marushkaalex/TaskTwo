package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements DeepCloneable<Sentence> {
    private final List<SentencePart> sentenceParts;

    public Sentence(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public Sentence() {
        sentenceParts = new ArrayList<>();
    }

    public List<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

    public List<Word> getWords() {
        List<Word> result = new ArrayList<>();
        for (SentencePart sentencePart : sentenceParts) {
            if (sentencePart.getClass() == Word.class) {
                result.add((Word) sentencePart);
            }
        }
        return result;
    }

    public boolean add(SentencePart word) {
        return sentenceParts.add(word);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentenceParts=" + sentenceParts +
                '}';
    }

    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (SentencePart word : sentenceParts) {
            sb.append(word.toOriginal());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (!sentenceParts.equals(sentence.sentenceParts)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sentenceParts.hashCode();
    }

    @Override
    public Sentence deepClone() {
        Sentence result = new Sentence();
        for (SentencePart word : sentenceParts) {
            result.add(word.deepClone());
        }
        return result;
    }
}
