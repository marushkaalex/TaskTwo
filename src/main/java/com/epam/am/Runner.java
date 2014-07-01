package com.epam.am;

import com.epam.am.entity.Paragraph;
import com.epam.am.helper.TextParser;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        Paragraph paragraph = new Paragraph();
        TextParser.readParagraph(TextParser.getAsString(TextParser.TEXT), paragraph);
        System.out.println(paragraph);
    }
}
