package com.epam.am.entity;

public class Character implements DeepCloneable<Character> {
    private final char character;

    public Character(char character) {
        this.character = character;
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
}
