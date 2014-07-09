package com.epam.am.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Character implements DeepCloneable<Character>, Comparable<Character> {
    private final char character;
    private boolean isVowel;

    public Character(char character) {
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

        Character character1 = (Character) o;

        if (character != character1.character) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) character;
    }

    public Character deepClone() {
        return this;
    }

    public boolean isLowerCase() {
        return java.lang.Character.isLowerCase(character);
    }

    public Character toLowerCase() {
        return isLowerCase() ? this : new Character(java.lang.Character.toLowerCase(character));
    }

    @Override
    public int compareTo(Character o) {
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
}
