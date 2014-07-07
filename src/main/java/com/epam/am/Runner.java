package com.epam.am;

import com.epam.am.entity.Sentence;
import com.epam.am.helper.SimpleTextParser;
import com.epam.am.helper.TextLogic;

import java.io.IOException;


//TODO 1
//TODO 2 X
//TODO 3 X
//TODO 4 X
//TODO 5 X
//TODO 6
//TODO 7
//TODO 8
//TODO 9
//TODO 10
//TODO 11
//TODO 12
//TODO 13
//TODO 14
//TODO 15
//TODO 16

public class Runner {
    public static void main(String[] args) throws IOException {
//        System.out.println(SimpleTextParser.parseText(SimpleTextParser.getAsString(SimpleTextParser.TEXT)));
        TextLogic textLogic = new TextLogic();
        Sentence sentence = SimpleTextParser.parseSentence("The sentence, that has the first and the last words.");
        System.out.println(sentence.toOriginal());
        textLogic.swapFirtsAndLastWord(sentence);
        System.out.println(sentence.toOriginal());
    }
}
