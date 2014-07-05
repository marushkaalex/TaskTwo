package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart {
    private final List<Character> letters;

    public Word(List<Character> letters) {
        this.letters = letters;
    }

    public Word() {
        letters = new ArrayList<>();
    }

    public Word(String str) {
        letters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            letters.add(new Character(str.charAt(i)));
        }
    }

    public List<Character> getLetters() {
        return letters;
    }

    public boolean add(Character character) {
        return letters.add(character);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character letter : letters) {
            sb.append(letter);
        }
        return "w{" +
                sb.toString() +
                '}';
    }

    @Override
    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (Character letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }

    @Override
    public Word deepClone() {
        Word result = new Word();
        for (Character letter : letters) {
            result.add(letter.deepClone());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (!letters.equals(word.letters)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return letters.hashCode();
    }
}
