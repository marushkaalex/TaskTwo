package com.epam.am;

import com.epam.am.helper.SimpleTextParser;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        System.out.println(SimpleTextParser.parseText(SimpleTextParser.getAsString(SimpleTextParser.TEXT)));
    }
}
