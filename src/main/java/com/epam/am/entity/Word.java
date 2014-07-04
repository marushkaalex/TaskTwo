package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentenceContent {
    private final List<Character> letters;

    public Word(List<Character> letters) {
        this.letters = letters;
    }

    public Word() {
        letters = new ArrayList<Character>();
    }

    public Word(String str) {
        letters = new ArrayList<Character>();
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
}
