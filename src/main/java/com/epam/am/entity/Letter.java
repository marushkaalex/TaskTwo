package com.epam.am.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Letter implements TextPart, DeepCloneable<Letter>, Comparable<Letter> {
    private final char character;
    private boolean isVowel;

    public Letter(char character) {
        this.character = character;
        checkIsVowel();
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return character + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter1 = (Letter) o;

        if (character != letter1.character) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) character;
    }

    public Letter deepClone() {
        return this;
    }

    public boolean isLowerCase() {
        return java.lang.Character.isLowerCase(character);
    }

    public Letter toLowerCase() {
        return isLowerCase() ? this : new Letter(java.lang.Character.toLowerCase(character));
    }

    @Override
    public int compareTo(Letter o) {
        return character == o.character ? 0 : character > o.character ? 1 : -1;
    }

    /**
     * checks only English and Russian languages
     *
     * @return true if vowel, false if consonant
     */
    public boolean isVowel() {
        return isVowel;
    }

    private void checkIsVowel() {
        Matcher matcher = Pattern.compile("[aiuoeуеыаоэяию]", Pattern.UNICODE_CHARACTER_CLASS)
                .matcher(String.valueOf(character).toLowerCase());
        isVowel = matcher.matches();
    }

    @Override
    public String toOriginal() {
        return String.valueOf(character);
    }
}
