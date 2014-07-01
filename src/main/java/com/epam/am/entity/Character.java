package com.epam.am.entity;

public class Character {
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
}
