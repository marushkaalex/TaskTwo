package com.epam.am.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements SentencePart, Comparable<Word> {
    private final List<Character> letters;
    private boolean isLow = true;
    private float vowelPerLetter;

    public Word(List<Character> letters) {
        this.letters = letters;
        calculateVowelPerLetter();
    }

    public Word() {
        letters = new ArrayList<>();
    }

    public Word(String str) {
        letters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = new Character(str.charAt(i));
            if (!character.isLowerCase()) isLow = false;
            letters.add(character);
        }
        calculateVowelPerLetter();
    }

    public int length() {
        return letters.size();
    }

    public List<Character> getLetters() {
        return letters;
    }

    public String getAsString() {
        StringBuilder sb = new StringBuilder();
        for (Character letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }

    public void add(Character character) {
        letters.add(character);
        calculateVowelPerLetter();
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

//        if (!letters.equals(word.letters)) return false;
        if (!ignoreCaseEquals(word)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return letters.hashCode();
    }

    public boolean ignoreCaseEquals(Word word) {
        return getAsString().toLowerCase().equals(word.getAsString().toLowerCase());
    }

    public boolean isLowerCase() {
        return isLow;
    }

    public void toLowerCase() {
        if (isLow) return;
        for (int i = 0; i < letters.size(); i++) {
            if (letters.get(i).isLowerCase()) continue;
            letters.set(i, letters.get(i).toLowerCase());
        }
        isLow = true;
    }

    @Override
    public int compareTo(Word o) {
        int max = length() <= o.length() ? length() : o.length();
        for (int i = 0; i < max; i++) {
            int compare = letters.get(i).toLowerCase().compareTo(o.letters.get(i).toLowerCase());
            switch (compare) {
                case 0:
                    continue;
                case 1:
                    return 1;
                case -1:
                    return -1;
            }
        }
        return 0;
    }

    public float vowelPerLetter() {
        return vowelPerLetter;
    }

    public void calculateVowelPerLetter() {
        int vowels = 0;
        for (Character letter : letters) {
            if (letter.isVowel()) {
                vowels++;
            }
        }
        vowelPerLetter = (float) vowels / letters.size();
    }
}
