package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Sentence extends AbstractCompoundText<SentencePart> implements TextPart, DeepCloneable<Sentence> {

    public Sentence(List<SentencePart> components) {
        super(components);
    }

    public Sentence() {
        super();
    }

    public List<SentencePart> getSentenceParts() {
        return components;
    }

    public List<Word> getWords() {
        List<Word> result = new ArrayList<>();
        for (SentencePart sentencePart : components) {
            if (sentencePart.getClass() == Word.class) {
                result.add((Word) sentencePart);
            }
        }
        return result;
    }

    public boolean add(SentencePart word) {
        return components.add(word);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "components=" + components +
                '}';
    }

    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (SentencePart word : components) {
            sb.append(word.toOriginal());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sentence sentence = (Sentence) o;

        if (!components.equals(sentence.components)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return components.hashCode();
    }

    @Override
    public Sentence deepClone() {
        Sentence result = new Sentence();
        for (SentencePart word : components) {
            result.add(word.deepClone());
        }
        return result;
    }
}
