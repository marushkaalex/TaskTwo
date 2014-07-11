package com.epam.am.entity;

import java.util.Iterator;
import java.util.List;

public class Word extends AbstractCompoundText<Letter> implements SentencePart, Comparable<Word>, Iterable<Letter> {
    private boolean isLow = true;
    private float vowelPerLetter;

    public Word(List<Letter> letters) {
        super(letters);
        calculateVowelPerLetter();
    }

    public Word() {
        super();
    }

    public Word(String str) {
        super();
        for (int i = 0; i < str.length(); i++) {
            Letter letter = new Letter(str.charAt(i));
            if (!letter.isLowerCase()) isLow = false;
            components.add(letter);
        }
        calculateVowelPerLetter();
    }

    public int length() {
        return components.size();
    }

    public List<Letter> getLetters() {
        return components;
    }

    public String getAsString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : components) {
            sb.append(letter);
        }
        return sb.toString();
    }

    private void addLetter(Letter letter) {
        components.add(letter);
        calculateVowelPerLetter();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : components) {
            sb.append(letter);
        }
        return "w{" +
                sb.toString() +
                '}';
    }

    @Override
    public String toOriginal() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : components) {
            sb.append(letter);
        }
        return sb.toString();
    }

    @Override
    public Word deepClone() {
        Word result = new Word();
        for (Letter letter : components) {
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
        return components.hashCode();
    }

    public boolean ignoreCaseEquals(Word word) {
        return getAsString().toLowerCase().equals(word.getAsString().toLowerCase());
    }

    public boolean isLowerCase() {
        return isLow;
    }

    public void toLowerCase() {
        if (isLow) return;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).isLowerCase()) continue;
            components.set(i, components.get(i).toLowerCase());
        }
        isLow = true;
    }

    @Override
    public int compareTo(Word o) {
        int max = length() <= o.length() ? length() : o.length();
        for (int i = 0; i < max; i++) {
            int compare = components.get(i).toLowerCase().compareTo(o.components.get(i).toLowerCase());
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
        for (Letter letter : components) {
            if (letter.isVowel()) {
                vowels++;
            }
        }
        vowelPerLetter = (float) vowels / components.size();
    }

    @Override
    public Iterator<Letter> iterator() {
        return new WordIterator();
    }

    public class WordIterator implements Iterator<Letter> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            return currentIndex != components.size();
        }

        @Override
        public Letter next() {
            return components.get(currentIndex++);
        }

        public boolean hasNextVowel() {

            if (currentIndex == components.size()) return false;
            for (int i = currentIndex; i < components.size(); i++) {
                if (components.get(i).isVowel()) return true;
            }
            return false;
        }

        public Letter nextVowel() {
            for (int i = currentIndex; i < components.size(); i++) {
                if (components.get(i).isVowel()) {
                    currentIndex = i + 1;
                    return components.get(i);
                }
            }
            return null;
        }

        public boolean hasNextConsonant() {
            if (currentIndex == components.size()) return false;
            for (int i = currentIndex; i < components.size(); i++) {
                if (!components.get(i).isVowel()) return true;
            }
            return false;
        }

        public Letter nextConsonant() {
            for (int i = currentIndex; i < components.size(); i++) {
                if (!components.get(i).isVowel()) {
                    currentIndex = i + 1;
                    return components.get(i);
                }
            }
            return null;
        }

        public Letter nextLetter(boolean isVowel) {
            return isVowel ? nextVowel() : nextConsonant();
        }
    }
}
